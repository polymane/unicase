/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.common.util.EList;

/*
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Composite Operation</b></em>'. <!-- end-user-doc
 * --> <p> The following features are supported: <ul> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getSubOperations <em>Sub Operations </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeName <em>Composite Name
 * </em>}</li> <li>{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeDescription
 * <em> Composite Description</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#isReversed <em>Reversed</em>}</li> </ul> </p>
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCompositeOperation()
 * @model
 * @generated
 */
public interface CompositeOperation extends AbstractOperation {
	/**
	 * Returns the value of the '<em><b>Sub Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Operations</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Operations</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCompositeOperation_SubOperations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<AbstractOperation> getSubOperations();

	/**
	 * Returns the value of the '<em><b>Composite Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Name</em>' attribute.
	 * @see #setCompositeName(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCompositeOperation_CompositeName()
	 * @model
	 * @generated
	 */
	String getCompositeName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeName <em>Composite Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Name</em>' attribute.
	 * @see #getCompositeName()
	 * @generated
	 */
	void setCompositeName(String value);

	/**
	 * Returns the value of the '<em><b>Composite Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Description</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Description</em>' attribute.
	 * @see #setCompositeDescription(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCompositeOperation_CompositeDescription()
	 * @model
	 * @generated
	 */
	String getCompositeDescription();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeDescription <em>Composite Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Description</em>' attribute.
	 * @see #getCompositeDescription()
	 * @generated
	 */
	void setCompositeDescription(String value);

	/**
	 * Returns the value of the '<em><b>Reversed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reversed</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reversed</em>' attribute.
	 * @see #setReversed(boolean)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getCompositeOperation_Reversed()
	 * @model
	 * @generated
	 */
	boolean isReversed();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#isReversed <em>Reversed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reversed</em>' attribute.
	 * @see #isReversed()
	 * @generated
	 */
	void setReversed(boolean value);

	/**
	 * Remove all operations from the composite that are masked by later operations in the same composite.
	 */
	void cannonize();

} // CompositeOperation
