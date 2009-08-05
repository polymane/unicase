/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Attribute Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#isAdd <em>Add</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#getIndex <em>Index</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiAttributeOperation()
 * @model
 * @generated
 */
public interface MultiAttributeOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Add</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Add</em>' attribute.
	 * @see #setAdd(boolean)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiAttributeOperation_Add()
	 * @model
	 * @generated
	 */
	boolean isAdd();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#isAdd
	 * <em>Add</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Add</em>' attribute.
	 * @see #isAdd()
	 * @generated
	 */
	void setAdd(boolean value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiAttributeOperation_Index()
	 * @model
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#getIndex <em>Index</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list. The list contents are of type
	 * {@link java.lang.Object}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getMultiAttributeOperation_Values()
	 * @model
	 * @generated
	 */
	EList<Object> getValues();

} // MultiAttributeOperation
