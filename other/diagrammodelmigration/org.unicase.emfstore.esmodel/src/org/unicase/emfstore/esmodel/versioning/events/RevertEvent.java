/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Revert Event</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.events.RevertEvent#getRevertedChangesCount <em>Reverted Changes
 * Count</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getRevertEvent()
 * @model
 * @generated
 */
public interface RevertEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Reverted Changes Count</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverted Changes Count</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Reverted Changes Count</em>' attribute.
	 * @see #setRevertedChangesCount(int)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getRevertEvent_RevertedChangesCount()
	 * @model
	 * @generated
	 */
	int getRevertedChangesCount();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.RevertEvent#getRevertedChangesCount
	 * <em>Reverted Changes Count</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Reverted Changes Count</em>' attribute.
	 * @see #getRevertedChangesCount()
	 * @generated
	 */
	void setRevertedChangesCount(int value);

} // RevertEvent
