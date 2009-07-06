/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Annotation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.Annotation#getAnnotatedModelElements <em>Annotated Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.ModelPackage#getAnnotation()
 * @model abstract="true"
 * @generated
 */
public interface Annotation extends ModelElement {

	/**
	 * Returns the value of the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.ModelElement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.ModelElement#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated Model Elements</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated Model Elements</em>' reference list.
	 * @see org.unicase.model.ModelPackage#getAnnotation_AnnotatedModelElements()
	 * @see org.unicase.model.ModelElement#getAnnotations
	 * @model opposite="annotations"
	 * @generated
	 */
	EList<ModelElement> getAnnotatedModelElements();
} // Annotation
