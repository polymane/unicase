/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Unique Identifier</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.UniqueIdentifier#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.ModelPackage#getUniqueIdentifier()
 * @model abstract="true"
 * @generated
 */
public interface UniqueIdentifier extends EObject {

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>"Default Value Literal\t"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.unicase.model.ModelPackage#getUniqueIdentifier_Id()
	 * @model default="Default Value Literal\t" required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.unicase.model.UniqueIdentifier#getId <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // UniqueIdentifier
