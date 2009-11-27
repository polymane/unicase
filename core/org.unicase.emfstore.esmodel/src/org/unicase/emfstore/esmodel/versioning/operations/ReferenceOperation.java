/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Reference Operation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#isBidirectional <em>Bidirectional
 * </em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getOppositeFeatureName <em>Opposite
 * Feature Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getReferenceOperation()
 * @model abstract="true"
 * @generated
 */
public interface ReferenceOperation extends FeatureOperation {
	/**
	 * Returns the value of the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bidirectional</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bidirectional</em>' attribute.
	 * @see #setBidirectional(boolean)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getReferenceOperation_Bidirectional()
	 * @model
	 * @generated
	 */
	boolean isBidirectional();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#isBidirectional <em>Bidirectional</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bidirectional</em>' attribute.
	 * @see #isBidirectional()
	 * @generated
	 */
	void setBidirectional(boolean value);

	/**
	 * Returns the value of the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Feature Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Feature Name</em>' attribute.
	 * @see #setOppositeFeatureName(String)
	 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage#getReferenceOperation_OppositeFeatureName()
	 * @model
	 * @generated
	 */
	String getOppositeFeatureName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getOppositeFeatureName <em>Opposite Feature Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Feature Name</em>' attribute.
	 * @see #getOppositeFeatureName()
	 * @generated
	 */
	void setOppositeFeatureName(String value);

} // ReferenceOperation
