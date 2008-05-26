/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model.changemanagment;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>History Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.model.changemanagment.HistoryInfo#getPrimerySpec <em>Primery Spec</em>}</li>
 *   <li>{@link org.unicase.emfstore.model.changemanagment.HistoryInfo#getLogMessage <em>Log Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.model.changemanagment.ChangemanagmentPackage#getHistoryInfo()
 * @model
 * @generated
 */
public interface HistoryInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Primery Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primery Spec</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primery Spec</em>' reference.
	 * @see #setPrimerySpec(PrimaryVersionSpec)
	 * @see org.unicase.emfstore.model.changemanagment.ChangemanagmentPackage#getHistoryInfo_PrimerySpec()
	 * @model required="true"
	 * @generated
	 */
	PrimaryVersionSpec getPrimerySpec();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.model.changemanagment.HistoryInfo#getPrimerySpec <em>Primery Spec</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primery Spec</em>' reference.
	 * @see #getPrimerySpec()
	 * @generated
	 */
	void setPrimerySpec(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Log Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log Message</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Message</em>' reference.
	 * @see #setLogMessage(LogMessage)
	 * @see org.unicase.emfstore.model.changemanagment.ChangemanagmentPackage#getHistoryInfo_LogMessage()
	 * @model required="true"
	 * @generated
	 */
	LogMessage getLogMessage();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.model.changemanagment.HistoryInfo#getLogMessage <em>Log Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Message</em>' reference.
	 * @see #getLogMessage()
	 * @generated
	 */
	void setLogMessage(LogMessage value);

} // HistoryInfo
