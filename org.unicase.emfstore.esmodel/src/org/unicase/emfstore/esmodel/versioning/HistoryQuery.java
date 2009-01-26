/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>History Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getSource <em>Source</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTarget <em>Target</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getModelElements <em>Model Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery()
 * @model
 * @generated
 */
public interface HistoryQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery_Source()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getSource();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getSource <em>Source</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery_Target()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getTarget();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTarget <em>Target</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.model.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.versioning.VersioningPackage#getHistoryQuery_ModelElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getModelElements();

} // HistoryQuery
