/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.gestures;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.unicase.ui.common.diagram.util.EditPartUtility;
import org.unicase.ui.tom.TouchDispatch;
import org.unicase.ui.tom.actions.MoveCanvasAction;
import org.unicase.ui.tom.tools.TouchConstants;
import org.unicase.ui.tom.touches.MultiTouch;
import org.unicase.ui.tom.touches.SingleTouch;

/**
 * @author schroech
 * 
 */
public class MoveCanvasGesture extends AbstractMoveGesture {

	private MoveCanvasAction moveCanvasAction;
	private Set<SingleTouch> candidateTouches = new HashSet<SingleTouch>();

	/**
	 * Default constructor.
	 * 
	 * @param dispatch
	 *            The {@link TouchDispatch} at which the gesture will register
	 *            for touch events
	 * @param diagramEditPart
	 *            The {@link DiagramEditPart}
	 */
	public MoveCanvasGesture(TouchDispatch dispatch) {
		super(dispatch);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchAdded(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchAdded(SingleTouch touch) {
		if (!(acceptsAdditionalTouches())) {
			return;
		}

		EditPart touchedEditPart = findTouchedEditPart(touch.getPosition());

		if (touchedEditPart == getDiagramEditPart()) {
			getCandidateTouches().add(touch);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchChanged(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchChanged(SingleTouch touch) {

		// BEGIN SANITY CHECKS
		if (!(touch instanceof SingleTouch)) {
			return;
		}

		// END SANITY CHECKS

		if (isExecuting()) {
			if (touch == getMoveTouch()) {
				Point point = touch.getAbsolutePosition().getCopy();
				getMoveCanvasAction().updateMove(point);
			}
			return;
		}

		if (getExecutingMoveGesture() != null) {
			return;
		}

		if (!getCandidateTouches().contains(touch)) {
			return;
		}

		if (!touchMoved(touch, TouchConstants.TOUCH_MOVEMENT_THRESHOLD)) {
			return;
		}

		EditPart touchedEditPart = findTouchedEditPart(touch.getPosition());
		if (touchedEditPart != getDiagramEditPart()) {
			return;
		}

		MultiTouch multiTouch = touch.getMultiTouch();
		if (multiTouch.getActiveTouches().size() > 1) {
			return;
		}

		if (getMoveCanvasAction().couldExecute()) {
			setMoveTouch(touch);
			getCandidateTouches().remove(touch);
			setCanExecute(true);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.AbstractGesture#handleSingleTouchRemoved(org.unicase.ui.tom.touches.SingleTouch)
	 */
	@Override
	public void handleSingleTouchRemoved(SingleTouch touch) {
		if (isExecuting()) {
			if (touch == getMoveTouch()) {
				setMoveTouch(null);

				setExecuting(false);
				setCanExecute(false);
				setAcceptsAdditionalTouches(true);
				setExecutingMoveGesture(null);
			}
		}
		getCandidateTouches().remove(touch);

	}

	/**
	 * @return The {@link MoveCanvasAction} used by this gesture
	 */
	public MoveCanvasAction getMoveCanvasAction() {
		if (moveCanvasAction == null) {
			moveCanvasAction = new MoveCanvasAction(getDiagramEditPart());
		}
		return moveCanvasAction;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.MomentaryGesture#finish()
	 */
	public void execute() {
		if (!(canExecute())) {
			return;
		}

		setExecuting(true);

		Point firstPoint = ((SingleTouch) getMoveTouch()).getAbsolutePath()
				.getFirstPoint().getCopy();
		getMoveCanvasAction().prepareMove(firstPoint);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.tom.gestures.Gesture#getMandatoryTouches()
	 */
	public List<MultiTouch> getMandatoryTouches() {
		if (getMoveTouch() == null) {
			return Collections.emptyList();
		} else {
			return Collections.singletonList(getMoveTouch().getMultiTouch());
		}
	}

	public void setCandidateTouches(Set<SingleTouch> candidateTouches) {
		this.candidateTouches = candidateTouches;
	}

	public Set<SingleTouch> getCandidateTouches() {
		return candidateTouches;
	}
}
