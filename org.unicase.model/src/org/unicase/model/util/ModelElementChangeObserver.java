/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

/**
 * This abstract class reacts to the changes of individual model elements. It implements the ProjectChangeObserver
 * interface, so you have to register it with the project. You can inherit this class for further filtering of the
 * events, but of course you cannot override the classes own filtering methods.
 * 
 * @author andy
 */
public abstract class ModelElementChangeObserver implements ProjectChangeObserver {

	private List<ModelElement> observedElements;

	/**
	 * @param observedElements the set of elements that will be observed
	 */
	public ModelElementChangeObserver(List<ModelElement> observedElements) {
		this();
		this.observedElements.addAll(observedElements);
	}

	/**
	 * Empty constructor. You can add elements to observe with {@link #observeElement(ModelElement)}
	 */
	public ModelElementChangeObserver() {
		this.observedElements = new ArrayList<ModelElement>();
	}

	/**
	 * Will observe one more element, for example a new child.
	 * 
	 * @param newElement the new element to be observed
	 */
	public void observeElement(ModelElement newElement) {
		this.observedElements.add(newElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public final void modelElementAdded(Project project, ModelElement modelElement) {
		// reacting to new elements would be a contradiction to the idea of this class.
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public final void modelElementDeleteCompleted(Project project, ModelElement modelElement) {
		if (this.isObservedElement(modelElement)) {
			this.onElementDeleted(modelElement);

			// removing the element from the list of observed elements is not neccessary,
			// because the project want call this method anymore
		}
	}

	/**
	 * Implement this method to react to the deletion of one of the observed elements.
	 * 
	 * @param element the element that was deleted
	 */
	protected abstract void onElementDeleted(ModelElement element);

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 */
	public final void modelElementDeleteStarted(Project project, ModelElement modelElement) {
		// uninteresting, do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.model.Project, org.unicase.model.ModelElement)
	 */
	public final void notify(Notification notification, Project project, ModelElement modelElement) {
		if (this.isObservedElement(modelElement)) {
			this.onNotify(notification, modelElement);
		}
	}

	/**
	 * Implement this method to react to a notification of one of the observed elements.
	 * 
	 * @param notification the notification sent
	 * @param element the notifying element
	 */
	protected abstract void onNotify(Notification notification, ModelElement element);

	/**
	 * Checks if the observer wants to know about changes of the element.
	 * 
	 * @param element to be checked
	 * @return forward change event?
	 */
	private boolean isObservedElement(ModelElement element) {
		return this.observedElements.contains(element);
	}

}
