/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Notification Read Event</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent#getNotificationId <em>Notification Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNotificationReadEvent()
 * @model
 * @generated
 */
public interface NotificationReadEvent extends ReadEvent {
	/**
	 * Returns the value of the '<em><b>Notification Id</b></em>' attribute. The default value is <code>""</code>. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification Id</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Notification Id</em>' attribute.
	 * @see #setNotificationId(String)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getNotificationReadEvent_NotificationId()
	 * @model default=""
	 * @generated
	 */
	String getNotificationId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent#getNotificationId <em>Notification Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification Id</em>' attribute.
	 * @see #getNotificationId()
	 * @generated
	 */
	void setNotificationId(String value);

} // NotificationReadEvent
