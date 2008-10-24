/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.Checkable;

/**
 * Implementation of MEState.
 * 
 * @author helming
 * 
 */
public class MEStateImpl implements MEState {

	private ModelElement modelElement;

	private HashSet<ModelElement> effectiveOpeners = new HashSet<ModelElement>();

	private HashSet<ModelElement> effectiveBlocker = new HashSet<ModelElement>();

	/**
	 * default constructor.
	 * 
	 * @param modelElement
	 *            The modelelement this state is related to.
	 */
	public MEStateImpl(ModelElement modelElement) {
		this.modelElement = modelElement;
		// Initially fill opener
		updateEffectiveOpeners();
		// Initially fill blocker
		updateEffectiveBlockers();
		modelElement.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if (!(msg.getFeatureID(ModelElement.class) == ModelPackage.MODEL_ELEMENT__STATE)) {
					recursivlyUpdateStatus(getStatus());
				}
				// super.notifyChanged(msg);
			}

		});
	}

	private void updateEffectiveBlockers() {
		Set<ModelElement> blockers = TaxonomyAccess.getInstance()
				.getBlockingLinkTaxonomy().getBlockers(modelElement);

		for (ModelElement blocker : blockers) {
			try {
				if (blocker.getMEState().getStatus().equals(OPEN)
						| blocker.getMEState().getStatus().equals(BLOCKED)) {
					effectiveBlocker.add(blocker);
				}
			} catch (CircularDependencyException e) {
				// JH: log Exception
			}
		}

	}

	private void updateEffectiveOpeners() {
		Set<ModelElement> openers = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpeners(modelElement);

		for (ModelElement opener : openers) {
			try {
				if (opener.getMEState().getStatus().equals(OPEN)
						| opener.getMEState().getStatus().equals(BLOCKED)) {
					effectiveOpeners.add(opener);
				}
			} catch (CircularDependencyException e) {
				// JH: log Exception
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void addBlocker(ModelElement me) {
		if(me==modelElement){
			return;
		}
		effectiveBlocker.add(me);
		if (effectiveBlocker.size() == 1) {
			recursivlyUpdateStatus(getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addModifiedChild(ModelElement me) {
		throw new UnsupportedOperationException();

	}

	/**
	 * {@inheritDoc}
	 */
	public void addOpener(ModelElement me) {
		if(me==modelElement){
			return;
		}
		effectiveOpeners.add(me);
		if (effectiveOpeners.size() == 1) {
			recursivlyUpdateStatus(getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getStatus() {
		// If there is a blocker, every me is blocked
		if (effectiveBlocker.size() > 0) {
			return BLOCKED;
		}
		// For all other Modelelements look if there is an openener
		if (effectiveOpeners.size() > 0) {
			return OPEN;
		}

		if(modelElement instanceof Checkable){
			if(((Checkable) modelElement).isChecked()){
				return CLOSED;
			}
			return OPEN;
		}

		// If the me is a FunctionalRequirement the reviewed attribute is
		// effective.
		if (modelElement instanceof FunctionalRequirement) {
			FunctionalRequirement fr = (FunctionalRequirement) modelElement;
			if (!fr.isReviewed()) {
				return OPEN;
			}
		}
	
		// Else the me is closed
		
			return CLOSED;
		
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isRecursivlyModified() {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean removeBlocker(ModelElement me) {
		boolean ret = effectiveBlocker.remove(me);
		if (effectiveBlocker.size() == 0) {
			recursivlyUpdateStatus(getStatus());
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean removeModifiedChild(ModelElement me) {
		throw new UnsupportedOperationException();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean removeOpener(ModelElement me) {
		boolean ret = effectiveOpeners.remove(me);
		if (effectiveOpeners.size() == 0) {
			recursivlyUpdateStatus(getStatus());
		}
		return ret;
	}

	private void recursivlyUpdateStatus(String status) {
//		
		ENotificationImpl notificationImpl = new ENotificationImpl(
				(InternalEObject) modelElement, Notification.RESOLVE,
				ModelPackage.MODEL_ELEMENT__STATE, OPEN, OPEN);

		modelElement.eNotify(notificationImpl);

		ArrayList<ModelElement> opened = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpened(modelElement);
		ArrayList<ModelElement> blocked = TaxonomyAccess.getInstance()
				.getBlockingLinkTaxonomy().getBlocked(modelElement);
		try {
			if (status.equals(OPEN) | status.equals(BLOCKED)) {
				for (ModelElement open : opened) {
					open.getMEState().addOpener(modelElement);
				}
				for (ModelElement block : blocked) {
					block.getMEState().addBlocker(modelElement);
				}
			}
			if (status.equals(CLOSED)) {
				for (ModelElement open : opened) {
					open.getMEState().removeOpener(modelElement);
				}
				for (ModelElement block : blocked) {
					block.getMEState().removeBlocker(modelElement);
				}
			}
		} catch (CircularDependencyException e) {
			//JH: insert proper exception handlin
			e.printStackTrace();
		}

	}
}
