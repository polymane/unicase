/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.leapmotion.leap.CircleGesture;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Gesture.Type;
import com.leapmotion.leap.KeyTapGesture;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Pointable;
import com.leapmotion.leap.ScreenTapGesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Tool;
import com.leapmotion.leap.Vector;

/**
 * A {@link Listener} extension that provides the possibility to convert leap motion input data into cursor movement.
 * Also, any captured fingers or tools can be displayed. Any occurring gestures are forwarded to the corresponding
 * {@link ILeapActionHandler}s.
 * 
 * @author mharut
 */
public class LeapInputListener extends Listener {

	/**
	 * The {@link Image} used for a disabled cursor.
	 */
	private static final Image CURSOR_DISABLED_IMAGE = new Image(Display.getDefault(),
		LeapInputListener.class.getResourceAsStream("red.png"));
	/**
	 * The {@link Image} used for a {@link Finger} and {@link Tool} visualizations.
	 */
	private static final Image VISUALIZATION_IMAGE = new Image(Display.getDefault(),
		LeapInputListener.class.getResourceAsStream("blue.png"));
	/**
	 * The size of {@link Pointable} visualizations.
	 */
	private static final Point VISUALIZATION_SIZE = new Point(22, 21);
	/**
	 * The default {@link Cursor} used before the cursor has been changed by this listener.
	 */
	private static final Cursor DEFAULT_CURSOR = new Cursor(Display.getDefault(), SWT.CURSOR_ARROW);
	/**
	 * A disabled {@link Cursor} which is used to keep track of the current main {@link Pointable}.
	 */
	private static final Cursor DISABLED_CURSOR = new Cursor(Display.getDefault(),
		CURSOR_DISABLED_IMAGE.getImageData(), 10, 10);
	/**
	 * The leap motion {@link Controller} tracking sensor data.
	 */
	private final Controller controller;
	/**
	 * Flag indicating whether {@link Finger} input should be listened to or not.
	 */
	private final boolean fingersEnabled;
	/**
	 * Flag indicating whether {@link Tool} input should be listened to or not.
	 */
	private final boolean toolsEnabled;
	/**
	 * Flag indicating whether all {@link Pointable} input should be visualized (instead of only the first pointable to
	 * enter the tracking area).
	 */
	private final boolean visualizeAll;
	/**
	 * Mapping from IDs of {@link Pointable}s to the shell used to visualize their input.
	 */
	private final Map<Integer, Shell> pointableToVisual = new HashMap<Integer, Shell>();
	/**
	 * Collection of {@link ILeapActionHandler handlers} used to process {@link ScreenTapGesture}s.
	 */
	private final Set<ILeapActionHandler> screenTapHandlers = new HashSet<ILeapActionHandler>();
	/**
	 * Collection of {@link ILeapActionHandler handlers} used to process {@link KeyTapGesture}s.
	 */
	private final Set<ILeapActionHandler> keyTapHandlers = new HashSet<ILeapActionHandler>();
	/**
	 * Collection of {@link ILeapActionHandler handlers} used to process {@link SwipeGesture}s.
	 */
	private final Set<ILeapActionHandler> swipeHandlers = new HashSet<ILeapActionHandler>();
	/**
	 * Collection of {@link ILeapActionHandler handlers} used to process {@link CircleGesture}s.
	 */
	private final Set<ILeapActionHandler> circleHandlers = new HashSet<ILeapActionHandler>();
	/**
	 * The {@link LeapHelper} used for computations on leap motion sensor data.
	 */
	private final LeapHelper helper;
	/**
	 * {@link Thread} used to process {@link Cursor} movement asynchronously whenever new leap motion sensor data has
	 * been tracked.
	 */
	private final Thread moveCursorThread;
	/**
	 * The ID of the main {@link Pointable} that is being captured by the leap motion {@link Controller}. This is the
	 * pointable that was tracked first by the controller and is still valid. Once the main pointable is invalid, it
	 * will be replaced by the next valid pointable.
	 */
	private int mainPointableId = -1;
	/**
	 * Flag to indicate whether or not {@link Gesture}s are enabled.
	 */
	private boolean gesturesEnabled;

	/**
	 * Constructs a new leap listener for a {@link Controller} tracking sensor data and flags used for configuration.
	 * 
	 * @param leapController the leap motion controller tracking sensor data
	 * @param toolsEnabled whether or not {@link Tool} tracking should be enabled
	 * @param fingersEnabled whether or not {@link Finger} tracking should be enabled
	 * @param visualizeAll whether or not all {@link Pointable}s should be visualized (instead of just the main
	 *            pointable)
	 */
	public LeapInputListener(Controller leapController, boolean toolsEnabled, boolean fingersEnabled,
		boolean visualizeAll) {
		this.controller = leapController;
		this.fingersEnabled = fingersEnabled;
		this.toolsEnabled = toolsEnabled;
		this.visualizeAll = visualizeAll;
		this.helper = new LeapHelper(controller);
		this.moveCursorThread = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean isDefault = true;
				while (!moveCursorThread.isInterrupted()) {
					final int id = mainPointableId;
					if (id >= 0) {
						if (isDefault) {
							setCursor(DISABLED_CURSOR);
							isDefault = false;
						}
						Pointable pointable = controller.frame().pointable(id);
						moveMouseToPointable(pointable);
					} else if (!isDefault) {
						setCursor(DEFAULT_CURSOR);
						isDefault = true;
					}
				}
			}

		});
	}

	/**
	 * Moves the mouse cursor to the tip of a specified {@link Pointable}.
	 * 
	 * @param pointable the {@link Pointable} to move the mouse to
	 */
	private void moveMouseToPointable(Pointable pointable) {
		if (pointable.isValid()) {
			try {
				Robot robot = new Robot();
				Vector leapPosition = helper.getTip(pointable);
				Vector screenPosition = helper.convert(leapPosition, pointable);
				if (screenPosition != null && screenPosition.isValid()) {
					robot.mouseMove((Math.round(screenPosition.getX())), (Math.round(screenPosition.getY())));
				}
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Starts this listener by adding it to the {@link Controller}. If either {@link Finger} or {@link Tool} tracking is
	 * enabled, the thread responsible for mouse movement is being started.
	 */
	public void start() {
		controller.addListener(this);
		if (fingersEnabled || toolsEnabled) {
			moveCursorThread.start();
		}
	}

	/**
	 * Stops this listener by removing it from the {@link Controller}. If the {@link Thread} responsible for mouse
	 * movement is still alive, it is being interrupted
	 */
	public void stop() {
		if (moveCursorThread.isAlive()) {
			moveCursorThread.interrupt();
		}
		controller.removeListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onConnect(Controller controller) {
		setCursor(DISABLED_CURSOR);
	}

	/**
	 * {@inheritDoc}
	 */
	public void onDisconnect(Controller controller) {
		setCursor(DEFAULT_CURSOR);
	}

	/**
	 * Sets the {@link Cursor} of the currently active {@link Shell} to a new value.
	 * 
	 * @param cursor the new {@link Cursor}
	 */
	private void setCursor(Cursor cursor) {
		final Display display = Display.getDefault();
		display.asyncExec(new Runnable() {

			@Override
			public void run() {
				Shell shell = display.getActiveShell();
				if (shell != null && !shell.isDisposed()) {
					shell.setCursor(DISABLED_CURSOR);
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	public void onFrame(Controller controller) {
		Frame frame = controller.frame();
		if (fingersEnabled) {
			processFingers(frame);
		}
		if (toolsEnabled) {
			// TODO
		}
		if (gesturesEnabled) {
			processGestures(frame);
		}
	}

	/**
	 * Processes tracking data regarding {@link Finger}s for a single {@link Frame}. If no {@link Pointable} is used for
	 * moving the mouse cursor, the first valid finger will be put as the main pointable responsible for cursor
	 * movement. If {@link #visualizeAll} is set to true, every other finger will be visualized using a {@link Shell}.
	 * 
	 * @param frame the {@link Frame} containing leap motion tracking data
	 */
	private void processFingers(Frame frame) {

		if (mainPointableId >= 0) {
			Finger finger = frame.finger(mainPointableId);
			if (!finger.isValid()) {
				mainPointableId = -1;
			}
		}

		if (mainPointableId < 0 || visualizeAll) {
			for (final Finger finger : frame.fingers()) {
				if (!finger.isValid()) {
					System.out.println("INVALID");
				}
				final int id = finger.id();
				if (mainPointableId < 0) {
					mainPointableId = id;
					if (!visualizeAll) {
						break;
					}
				} else if (id != mainPointableId) {
					final Vector leapPosition = helper.getTip(finger);
					final Vector screenPosition = helper.convert(leapPosition, finger);
					if (screenPosition != null && screenPosition.isValid()) {
						addVisualization(id, Math.round(screenPosition.getX()), Math.round(screenPosition.getY()));
					}
				}
			}
		}

		if (visualizeAll) {
			Set<Integer> copiedEntries = new HashSet<Integer>(pointableToVisual.keySet());
			for (Integer id : copiedEntries) {
				Finger finger = frame.finger(id);
				if (!finger.isValid()) {
					removeVisualization(id);
				}
			}
		}
	}

	/**
	 * Processes {@link Gesture}s of a single {@link Frame}. A gesture of a certain {@link Type} will be forwarded to
	 * all specified {@link ILeapActionHandler handlers} of the same type.
	 * 
	 * @param frame the {@link Frame} containing the gesture sensor data
	 */
	private void processGestures(Frame frame) {
		for (Gesture gesture : frame.gestures()) {
			switch (gesture.type()) {
			case TYPE_SCREEN_TAP:
				for (ILeapActionHandler handler : screenTapHandlers) {
					handler.processGesture(gesture);
				}
				break;
			case TYPE_KEY_TAP:
				for (ILeapActionHandler handler : keyTapHandlers) {
					handler.processGesture(gesture);
				}
				break;
			case TYPE_SWIPE:
				for (ILeapActionHandler handler : swipeHandlers) {
					handler.processGesture(gesture);
				}
				break;
			case TYPE_CIRCLE:
				for (ILeapActionHandler handler : circleHandlers) {
					handler.processGesture(gesture);
				}
				break;
			case TYPE_INVALID:
				// don't process invalid gestures
				break;
			default:
				throw new IllegalArgumentException("Invalid gesture type!");
			}
		}
	}

	/**
	 * Adds a visualiztaion for a {@link Pointable}, identified by its ID. The visualization will be a small image in a
	 * new {@link Shell}. The new shell is required to make it possible for the visualization to be moved to any place
	 * in the screen. If a shell already exists for the specified pointable, it will simply be updated instead of
	 * creating a new one.
	 * 
	 * @param id the ID of the {@link Pointable} to add the visualization for
	 * @param x the x-coordinate of the visualization to add
	 * @param y the y-coordinate of the visualization to add
	 */
	public void addVisualization(final int id, final int x, final int y) {
		final Display display = Display.getDefault();
		final Shell existingShell = pointableToVisual.get(id);
		if (existingShell == null) {
			display.syncExec(new Runnable() {

				@Override
				public void run() {
					Shell shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
					shell.setSize(VISUALIZATION_SIZE);
					shell.setBackgroundImage(VISUALIZATION_IMAGE);
					shell.setLocation(x, y);
					pointableToVisual.put(id, shell);
					shell.open();
				}
			});
		} else {
			display.syncExec(new Runnable() {

				@Override
				public void run() {
					if (!existingShell.isDisposed()) {
						existingShell.setLocation(x, y);
					}
				}
			});
		}
	}

	/**
	 * Removes a visualization of a {@link Pointable} specified by an ID. This will close the corresponding
	 * {@link Shell} and dispose it.
	 * 
	 * @param id the ID of the {@link Pointable} to remove
	 */
	public void removeVisualization(final int id) {
		final Shell shell = pointableToVisual.get(id);
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				if (shell != null && !shell.isDisposed()) {
					shell.close();
					shell.dispose();
				}
				pointableToVisual.remove(id);
			}

		});
	}

	/**
	 * Adds a new {@link ILeapActionHandler handler} for {@link ScreenTapGesture}s. If no handler for this type of
	 * gesture has been defined yet, screen tap gestures will be enabled for the leap motion {@link Controller}.
	 * 
	 * @param handler the {@link ILeapActionHandler} used to process screen tap gestures
	 */
	public void addScreenTapHandler(ILeapActionHandler handler) {
		if (handler != null) {
			if (screenTapHandlers.isEmpty()) {
				gesturesEnabled = true;
				controller.enableGesture(Type.TYPE_SCREEN_TAP);
			}
			screenTapHandlers.add(handler);
		}
	}

	/**
	 * Adds a new {@link ILeapActionHandler handler} for {@link KeyTapGesture}s. If no handler for this type of gesture
	 * has been defined yet, key tap gestures will be enabled for the leap motion {@link Controller}.
	 * 
	 * @param handler the {@link ILeapActionHandler} used to process key tap gestures
	 */
	public void addKeyTapHandler(ILeapActionHandler handler) {
		if (handler != null) {
			if (keyTapHandlers.isEmpty()) {
				gesturesEnabled = true;
				controller.enableGesture(Type.TYPE_KEY_TAP);
			}
			keyTapHandlers.add(handler);
		}
	}

	/**
	 * Adds a new {@link ILeapActionHandler handler} for {@link SwipeGesture}s. If no handler for this type of gesture
	 * has been defined yet, swipe gestures will be enabled for the {@link Controller}.
	 * 
	 * @param handler the {@link ILeapActionHandler} used to process swipe gestures
	 */
	public void addSwipeHandler(ILeapActionHandler handler) {
		if (handler != null) {
			if (swipeHandlers.isEmpty()) {
				gesturesEnabled = true;
				controller.enableGesture(Type.TYPE_SWIPE);
			}
			swipeHandlers.add(handler);
		}
	}

	/**
	 * Adds a new {@link ILeapActionHandler handler} for {@link CircleGesture}s. If no handler for this type of gesture
	 * has been defined yet, circle gestures will be enabled for the {@link Controller}.
	 * 
	 * @param handler the {@link ILeapActionHandler} used to process circle gestures
	 */
	public void addCircleHandler(ILeapActionHandler handler) {
		if (handler != null) {
			if (circleHandlers.isEmpty()) {
				gesturesEnabled = true;
				controller.enableGesture(Type.TYPE_CIRCLE);
			}
			circleHandlers.add(handler);
		}
	}

}
