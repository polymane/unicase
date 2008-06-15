/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Version</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getProjectState
 * <em>Project State</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getPrimarySpec
 * <em>Primary Spec</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.changemanagment.Version#getTagSpecs
 * <em>Tag Specs</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getNextVersion
 * <em>Next Version</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getPreviousVersion
 * <em>Previous Version</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.changemanagment.Version#getChanges
 * <em>Changes</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getLogMessage
 * <em>Log Message</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends EObject {
	/**
	 * Returns the value of the '<em><b>Project State</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project State</em>' containment reference.
	 * @see #setProjectState(Project)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion_ProjectState()
	 * @model containment="true"
	 * @generated
	 */
	Project getProjectState();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getProjectState
	 * <em>Project State</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Project State</em>' containment
	 *            reference.
	 * @see #getProjectState()
	 * @generated
	 */
	void setProjectState(Project value);

	/**
	 * Returns the value of the '<em><b>Primary Spec</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Spec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Primary Spec</em>' containment reference.
	 * @see #setPrimarySpec(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion_PrimarySpec()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PrimaryVersionSpec getPrimarySpec();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getPrimarySpec
	 * <em>Primary Spec</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Primary Spec</em>' containment
	 *            reference.
	 * @see #getPrimarySpec()
	 * @generated
	 */
	void setPrimarySpec(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Tag Specs</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag Specs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tag Specs</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion_TagSpecs()
	 * @model containment="true"
	 * @generated
	 */
	EList<TagVersionSpec> getTagSpecs();

	/**
	 * Returns the value of the '<em><b>Next Version</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Next Version</em>' reference.
	 * @see #setNextVersion(Version)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion_NextVersion()
	 * @model
	 * @generated
	 */
	Version getNextVersion();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getNextVersion
	 * <em>Next Version</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Next Version</em>' reference.
	 * @see #getNextVersion()
	 * @generated
	 */
	void setNextVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Previous Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Previous Version</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Previous Version</em>' reference.
	 * @see #setPreviousVersion(Version)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion_PreviousVersion()
	 * @model
	 * @generated
	 */
	Version getPreviousVersion();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getPreviousVersion
	 * <em>Previous Version</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Previous Version</em>' reference.
	 * @see #getPreviousVersion()
	 * @generated
	 */
	void setPreviousVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Changes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changes</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changes</em>' containment reference.
	 * @see #setChanges(ChangePackage)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion_Changes()
	 * @model containment="true"
	 * @generated
	 */
	ChangePackage getChanges();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getChanges
	 * <em>Changes</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Changes</em>' containment reference.
	 * @see #getChanges()
	 * @generated
	 */
	void setChanges(ChangePackage value);

	/**
	 * Returns the value of the '<em><b>Log Message</b></em>' containment
	 * reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Message</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Log Message</em>' containment reference.
	 * @see #setLogMessage(LogMessage)
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage#getVersion_LogMessage()
	 * @model containment="true"
	 * @generated
	 */
	LogMessage getLogMessage();

	/**
	 * Sets the value of the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getLogMessage
	 * <em>Log Message</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Log Message</em>' containment
	 *            reference.
	 * @see #getLogMessage()
	 * @generated
	 */
	void setLogMessage(LogMessage value);

} // Version
