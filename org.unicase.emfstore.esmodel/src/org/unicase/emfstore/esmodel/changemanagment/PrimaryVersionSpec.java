/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Primary Version Spec</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getPrimaryVersionSpec()
 * @model
 * @generated
 */
public interface PrimaryVersionSpec extends VersionSpec {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(int)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getPrimaryVersionSpec_Identifier()
	 * @model required="true"
	 * @generated
	 */
	int getIdentifier();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(int value);

} // PrimaryVersionSpec
