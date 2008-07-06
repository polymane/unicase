package org.unicase.model.task.util;

import java.util.ArrayList;
import java.util.HashSet;

import org.unicase.model.ModelElement;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.task.ActionItem;

public class MEStateImpl implements MEState {

	private ModelElement modelElement;

	private HashSet<ModelElement> modifiedChilds = new HashSet<ModelElement>();

	private HashSet<ModelElement> effectiveOpeners = new HashSet<ModelElement>();

	private HashSet<ModelElement> effectiveBlocker = new HashSet<ModelElement>();

	public MEStateImpl(ModelElement modelElement) {
		this.modelElement = modelElement;
		// Initially fill opener
		updateEffectiveOpeners();
		// Initially fill blocker
		updateEffectiveBlockers();
	}

	private void updateEffectiveBlockers() {
		// TODO Auto-generated method stub

	}

	private void updateEffectiveOpeners() {
		ArrayList<ModelElement> openers = TaxonomyAccess.getInstance()
				.getOpeningLinkTaxonomy().getOpeneners(modelElement);

		for (ModelElement opener : openers) {
			try {
				if (opener.getMEState().getStatus().equals(OPEN)
						| opener.getMEState().getStatus().equals(BLOCKED)) {
					effectiveOpeners.add(opener);
				}
			} catch (CircularDependencyException e) {
				//TODO: handle Exception
			}
		}

	}

	public void addBlocker(ModelElement me) {
		// TODO Auto-generated method stub

	}

	public void addModifiedChild(ModelElement me) {
		// TODO Auto-generated method stub

	}

	public void addOpener(ModelElement me) {
		// TODO Auto-generated method stub

	}

	public String getStatus() {
		// If there is a blocker, every me is blocked
		if (effectiveBlocker.size() > 0) {
			return BLOCKED;
		}
		// If the me is an Annotation, the isclosed Attribute is effective
		if (modelElement instanceof ActionItem) {
			ActionItem actionItem = (ActionItem) modelElement;
			if (!actionItem.isDone()) {
				return OPEN;
			}
		}
		//If the me is a FunctionalRequirement the reviewed attribute is effective.
		if(modelElement instanceof FunctionalRequirement){
			FunctionalRequirement fr = (FunctionalRequirement)modelElement;
			if(!fr.isReviewed()){
				return OPEN;
			}
		}
		// For all other Modelelements look if there is an openener
		if (effectiveOpeners.size() > 0) {
			return OPEN;
		}
		// Else the me is closed
		else {
			return CLOSED;
		}
	}

	public boolean isRecursivlyModified() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeBlocker(ModelElement me) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeModifiedChild(ModelElement me) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeOpener(ModelElement me) {
		// TODO Auto-generated method stub
		return false;
	}

}
