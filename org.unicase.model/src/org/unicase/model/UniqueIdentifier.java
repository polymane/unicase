/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unique Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.UniqueIdentifier#getId <em>Id</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see org.unicase.model.ModelPackage#getUniqueIdentifier_Id()
	 * @model id="true" changeable="false"
	 * @generated
	 */
	String getId();

} // UniqueIdentifier
