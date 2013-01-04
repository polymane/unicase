/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe;

import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Image</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.wireframe.Image#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.wireframe.WireframePackage#getImage()
 * @model
 * @generated
 */
public interface Image extends Widget {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(URI)
	 * @see org.unicase.wireframe.WireframePackage#getImage_Uri()
	 * @model dataType="org.unicase.wireframe.ImageURI"
	 * @generated
	 */
	URI getUri();

	/**
	 * Sets the value of the '{@link org.unicase.wireframe.Image#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(URI value);

} // Image
