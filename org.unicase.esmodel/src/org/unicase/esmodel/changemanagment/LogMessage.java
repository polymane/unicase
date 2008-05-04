/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel.changemanagment;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

import org.unicase.esmodel.accesscontrol.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Log Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.changemanagment.LogMessage#getMessage <em>Message</em>}</li>
 *   <li>{@link org.unicase.esmodel.changemanagment.LogMessage#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.unicase.esmodel.changemanagment.LogMessage#getDate <em>Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getLogMessage()
 * @model
 * @generated
 */
public interface LogMessage extends EObject {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getLogMessage_Message()
	 * @model required="true"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.changemanagment.LogMessage#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' containment reference.
	 * @see #setAuthor(User)
	 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getLogMessage_Author()
	 * @model containment="true" required="true"
	 * @generated
	 */
	User getAuthor();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.changemanagment.LogMessage#getAuthor <em>Author</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' containment reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(User value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see org.unicase.esmodel.changemanagment.ChangemanagmentPackage#getLogMessage_Date()
	 * @model required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link org.unicase.esmodel.changemanagment.LogMessage#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // LogMessage
