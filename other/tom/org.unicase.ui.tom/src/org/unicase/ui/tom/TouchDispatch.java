package org.unicase.ui.tom;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Control;
import org.unicase.ui.tom.notifications.MultiTouchNotification;
import org.unicase.ui.tom.notifications.MultiTouchNotificationImpl;
import org.unicase.ui.tom.notifications.MultiTouchNotifierImpl;
import org.unicase.ui.tom.notifications.SingleTouchNotification;
import org.unicase.ui.tom.notifications.SingleTouchNotificationImpl;
import org.unicase.ui.tom.notifications.TouchNotifierImpl;
import org.unicase.ui.tom.tools.TouchUtility;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;
import org.unicase.ui.tom.touches.Touch;
import org.unicase.ui.unicasecommon.diagram.part.ModelDiagramEditor;

/**
 * @author schroech
 * 
 */
public abstract class TouchDispatch {

	private final List<MultiTouch> claimedTouches = new ArrayList<MultiTouch>();
	private final List<MultiTouch> activeMultiTouches = new ArrayList<MultiTouch>();
	private final List<MultiTouch> removedMultiTouches = new ArrayList<MultiTouch>();

	private final List<SingleTouch> activeSingleTouches = new ArrayList<SingleTouch>();
	private final List<SingleTouch> removedSingleTouches = new ArrayList<SingleTouch>();

	private Viewport canvasViewport;

	private ModelDiagramEditor activeEditor;
	private ControlListener controlListener = new ControlListener();

	private Rectangle editorBounds = new Rectangle();
	private Dimension screenSize;
	private Point viewportOffset = new Point();

	private ViewportOffsetListener viewportOffsetListener = new ViewportOffsetListener();

	private final TouchNotifierImpl singleTouchNotifier = new TouchNotifierImpl();
	private final MultiTouchNotifierImpl multiTouchNotifier = new MultiTouchNotifierImpl();

	/**
	 * Singleton instance.
	 */
	protected static TouchDispatch instance;

	private class ViewportOffsetListener implements PropertyChangeListener {

		public void propertyChange(PropertyChangeEvent evt) {
			updateViewportOffset();
			for (SingleTouch touch : getActiveSingleTouches()) {
				updateTouch(touch);
			}
		}

	}

	/**
	 * @author schroech
	 * 
	 */
	private class ControlListener implements
			org.eclipse.swt.events.ControlListener {

		public void controlMoved(ControlEvent e) {
			updateEditorLocation();
		}

		public void controlResized(ControlEvent e) {
			ModelDiagramEditor editor = getActiveEditor();
			if (editor == null) {
				return;
			}
			Control editorControl = editor.getDiagramGraphicalViewer()
					.getControl();
			if (e.widget != editorControl) {
				return;
			}
			updateEditorSize();
		}

	}

	/**
	 * Default constructor.
	 */
	protected TouchDispatch() {
		super();
	}

	/**
	 * Adds a touch to the list of activeTouches and notifies adapters listening
	 * for TouchAdded events.
	 * 
	 * @param touch
	 *            The touch to add
	 */
	void addTouch(SingleTouch touch) {
		Point position = touch.getPosition().getCopy();
		translateToAbsolute(position);
		if (!getEditorBounds().contains(position)) {
			System.out.println("Touch out of client area");
			System.out.println("Client area:" + getEditorBounds());
			System.out.println("Touch position:" + touch.getPosition());
			return;
		}
		touch.setTouchDownDate(new Date());

		assignMultiTouch(touch);

		getActiveSingleTouches().add(touch);

		singleTouchNotifier.notifyAdapters(new SingleTouchNotificationImpl(
				touch, SingleTouchNotification.touchAdded));
		singleTouchNotifier.notifyAdapters(new SingleTouchNotificationImpl(
				touch, SingleTouchNotification.touchPropagated));
	}

	private void assignMultiTouch(SingleTouch touch) {
		Set<Touch> directNeighbors = TouchUtility.findDirectNeighbors(touch,
				getActiveSingleTouches());

		if (directNeighbors.size() == 0) {
			MultiTouch multiTouch = new MultiTouch();
			multiTouch.addTouch(touch);

			getActiveMultiTouches().add(multiTouch);
		} else {
			for (Touch neighbor : directNeighbors) {
				MultiTouch multiTouch = neighbor.getMultiTouch();
				if (multiTouch != null && !multiTouch.isClaimed()) {
					multiTouch.addTouch(touch);
					break;
				}
			}
		}
	}

	/**
	 * Removes a touch from the list of activeTouches, adds it to the list of
	 * removed touches and notifies adapters listening for TouchAdded events.
	 * 
	 * @param touch
	 *            The touch to remove
	 */
	void removeTouch(SingleTouch touch) {
		boolean remove = getActiveSingleTouches().remove(touch);
		if (!remove) {
			return;
		}

		touch.setTouchUpDate(new Date());

		getRemovedTouches().add(touch);

		MultiTouch multiTouch = touch.getMultiTouch();
		multiTouch.removeTouch(touch);

		List<SingleTouch> activeTouches = multiTouch.getActiveTouches();
		if (activeTouches.size() == 0) {
			getActiveMultiTouches().remove(multiTouch);
			getRemovedMultiTouches().add(multiTouch);
		}

		singleTouchNotifier.notifyAdapters(new SingleTouchNotificationImpl(
				touch, SingleTouchNotification.touchRemoved));
		singleTouchNotifier.notifyAdapters(new SingleTouchNotificationImpl(
				touch, SingleTouchNotification.touchPropagated));
		
		if (activeTouches.size() == 0) {
			getClaimedTouches().remove(multiTouch);
		}
	}

	/**
	 * Updates a touch and it's group if necessary.
	 * 
	 * @param touch
	 *            The {@link Touch} to update
	 */
	void updateTouch(SingleTouch touch) {
		if (!getActiveSingleTouches().contains(touch)) {
			return;
		}

		Point position = touch.getPosition().getCopy();
		translateToAbsolute(position);

		if (!getEditorBounds().contains(position)) {
			System.out.println("Touch out of client area");
			System.out.println("Client area:" + getEditorBounds());
			System.out.println("Touch position:" + touch.getPosition());
			return;
		}

		MultiTouch multiTouch = touch.getMultiTouch();
		List<SingleTouch> activeTouches = multiTouch.getActiveTouches();
		if (activeTouches.size() > 1) {
			Set<Touch> directMultiTouchNeighbors = TouchUtility
					.findDirectNeighbors(touch, activeTouches);
			if (directMultiTouchNeighbors.size() == 0) {
				assignMultiTouch(touch);
			}
		}

		singleTouchNotifier.notifyAdapters(new SingleTouchNotificationImpl(
				touch, SingleTouchNotification.touchChanged));
		singleTouchNotifier.notifyAdapters(new SingleTouchNotificationImpl(
				touch, SingleTouchNotification.touchPropagated));
	}

	/**
	 * @return The singleton instance
	 */
	public static TouchDispatch getInstance() {
		return instance;
	}

	public List<SingleTouch> getActiveSingleTouches() {
		return activeSingleTouches;
	}

	public List<SingleTouch> getRemovedTouches() {
		return removedSingleTouches;
	}

	public List<MultiTouch> getActiveMultiTouches() {
		return activeMultiTouches;
	}

	public List<MultiTouch> getRemovedMultiTouches() {
		return removedMultiTouches;
	}

	public void translateToEditor(Point point) {
		point.x = (point.x - TouchDispatch.getInstance().getViewportOffset().x);

		point.y = (point.y - TouchDispatch.getInstance().getViewportOffset().y);
	}

	public void translateToAbsolute(Point point) {
		point.x = (point.x + TouchDispatch.getInstance().getEditorBounds().x - TouchDispatch
				.getInstance().getViewportOffset().x);

		point.y = (point.y + TouchDispatch.getInstance().getEditorBounds().y - TouchDispatch
				.getInstance().getViewportOffset().y);
	}

	public void setActiveEditor(ModelDiagramEditor activeEditor) {

		if (this.activeEditor != activeEditor) {
			getActiveMultiTouches().clear();
			getActiveSingleTouches().clear();

			getRemovedMultiTouches().clear();
			getRemovedTouches().clear();
		}

		this.activeEditor = activeEditor;

		if (activeEditor == null) {
			canvasViewport = null;
			getActiveMultiTouches().clear();
			getActiveSingleTouches().clear();
			getClaimedTouches().clear();

		} else {
			FigureCanvas canvas;
			ModelDiagramEditor activeModelDiagramEditor;
			GraphicalViewer graphicalViewer;

			activeModelDiagramEditor = (ModelDiagramEditor) getActiveEditor();
			graphicalViewer = (GraphicalViewer) activeModelDiagramEditor
					.getAdapter(GraphicalViewer.class);
			if (graphicalViewer != null) {
				canvas = (FigureCanvas) graphicalViewer.getControl();

				registerControlListener(canvas);

				if (canvas != null) {
					canvasViewport = canvas.getViewport();
				}

				updateEditorBounds();
				updateViewportOffset();

				canvasViewport
						.addPropertyChangeListener(
								Viewport.PROPERTY_VIEW_LOCATION,
								viewportOffsetListener);
			}
		}
	}

	private void registerControlListener(FigureCanvas canvas) {
		Control control = canvas;
		while (control != null) {
			control.addControlListener(controlListener);
			control = control.getParent();
		}
	}

	private void updateEditorBounds() {
		updateEditorLocation();
		updateEditorSize();
	}

	private void updateEditorLocation() {
		Point controlOrigin = new Point();
		ModelDiagramEditor editor = getActiveEditor();
		if (editor == null) {
			return;
		}

		Control control = editor.getDiagramGraphicalViewer().getControl();
		while (control != null) {
			org.eclipse.swt.graphics.Rectangle bounds = control.getBounds();
			controlOrigin.x += bounds.x;
			controlOrigin.y += bounds.y;
			control = control.getParent();
		}

		controlOrigin.x -= 16;
		controlOrigin.y += 25;
		if (controlOrigin.x < 0) {
			controlOrigin.x += getScreenSize().width;
		}

		Rectangle bounds = getEditorBounds();
		bounds.x = controlOrigin.x;
		bounds.y = controlOrigin.y;
		setEditorBounds(bounds);
	}

	private void updateViewportOffset() {
		Rectangle viewportBounds = canvasViewport.getClientArea();
		Point location = viewportBounds.getLocation();
		if (location.x < 0) {
			location.x = 0;
		}
		if (location.y < 0) {
			location.y = 0;
		}

		System.out.println(location);

		setViewportOffset(location);
	}

	private void updateEditorSize() {

		ModelDiagramEditor editor = getActiveEditor();
		if (editor == null) {
			return;
		}
		Control editorControl = editor.getDiagramGraphicalViewer().getControl();
		org.eclipse.swt.graphics.Rectangle bounds = editorControl.getBounds();

		Rectangle newEditorBounds = getEditorBounds();
		newEditorBounds.width = bounds.width;
		newEditorBounds.height = bounds.height;
		setEditorBounds(newEditorBounds);
	}

	public ModelDiagramEditor getActiveEditor() {
		return activeEditor;
	}

	public Dimension getScreenSize() {
		if (screenSize == null) {

			GraphicsEnvironment ge = GraphicsEnvironment
					.getLocalGraphicsEnvironment();
			GraphicsDevice[] gs = ge.getScreenDevices();

			int i;
			if (gs.length > 1) {
				i = 1;
			} else {
				i = 0;
			}

			DisplayMode dm = gs[i].getDisplayMode();

			int screenWidth = dm.getWidth();
			int screenHeight = dm.getHeight();

			screenSize = new Dimension(screenWidth, screenHeight);
		}
		return screenSize;
	}

	private void setEditorBounds(Rectangle editorBounds) {
		this.editorBounds = editorBounds;
	}

	public Rectangle getEditorBounds() {
		return editorBounds;
	}

	public Point getEditorOffset() {
		return editorBounds.getLocation();
	}

	private void setViewportOffset(Point viewportOffset) {
		this.viewportOffset = viewportOffset;
	}

	public Point getViewportOffset() {
		return viewportOffset;
	}

	public TouchNotifierImpl getSingleTouchNotifier() {
		return singleTouchNotifier;
	}

	public MultiTouchNotifierImpl getMultiTouchNotifier() {
		return multiTouchNotifier;
	}

	public boolean claimTouch(MultiTouch touch) {
		if (touch.isClaimed()) {
			return false;
		}

		touch.setClaimed(true);
		getClaimedTouches().add(touch);
		multiTouchNotifier.notifyAdapters(new MultiTouchNotificationImpl(touch,
				MultiTouchNotification.touchClaimed));

		return true;
	}

	public List<MultiTouch> getClaimedTouches() {
		return claimedTouches;
	}

}
