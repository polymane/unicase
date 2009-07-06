/**
 * <copyright>Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html</copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.events;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Start Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent#getPluginId <em>Plugin Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getPluginStartEvent()
 * @model
 * @generated
 */
public interface PluginStartEvent extends Event {

	/**
	 * Returns the value of the '<em><b>Plugin Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin Id</em>' attribute.
	 * @see #setPluginId(String)
	 * @see org.unicase.emfstore.esmodel.versioning.events.EventsPackage#getPluginStartEvent_PluginId()
	 * @model
	 * @generated
	 */
	String getPluginId();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent#getPluginId <em>Plugin Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugin Id</em>' attribute.
	 * @see #getPluginId()
	 * @generated
	 */
	void setPluginId(String value);

} // PluginStartEvent
