/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.notification;

import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.model.IdentifiableElement;
import org.unicase.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ES Notification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getName <em>Name</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getMessage <em>Message</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getDetails <em>Details</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#isSeen <em>Seen</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getCreationDate <em>Creation Date</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getProvider <em>Provider</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getSender <em>Sender</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getRecipient <em>Recipient</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getProject <em>Project</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getRelatedModelElements <em>Related Model
 * Elements</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.notification.ESNotification#getRelatedOperations <em>Related Operations</em>}
 * </li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification()
 * @model
 * @generated
 */
public interface ESNotification extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Sender</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sender</em>' attribute.
	 * @see #setSender(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Sender()
	 * @model
	 * @generated
	 */
	String getSender();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getSender <em>Sender</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Sender</em>' attribute.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(String value);

	/**
	 * Returns the value of the '<em><b>Recipient</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipient</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Recipient</em>' attribute.
	 * @see #setRecipient(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Recipient()
	 * @model
	 * @generated
	 */
	String getRecipient();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getRecipient
	 * <em>Recipient</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Recipient</em>' attribute.
	 * @see #getRecipient()
	 * @generated
	 */
	void setRecipient(String value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(ProjectId)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Project()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ProjectId getProject();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getProject
	 * <em>Project</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(ProjectId value);

	/**
	 * Returns the value of the '<em><b>Related Model Elements</b></em>' containment reference list. The list contents
	 * are of type {@link org.unicase.model.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Model Elements</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Related Model Elements</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_RelatedModelElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getRelatedModelElements();

	/**
	 * Returns the value of the '<em><b>Related Operations</b></em>' containment reference list. The list contents are
	 * of type {@link org.unicase.emfstore.esmodel.versioning.operations.OperationId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Related Operations</em>' containment reference list isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Related Operations</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_RelatedOperations()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<OperationId> getRelatedOperations();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getMessage
	 * <em>Message</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Details</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Details</em>' attribute.
	 * @see #setDetails(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Details()
	 * @model
	 * @generated
	 */
	String getDetails();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getDetails
	 * <em>Details</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Details</em>' attribute.
	 * @see #getDetails()
	 * @generated
	 */
	void setDetails(String value);

	/**
	 * Returns the value of the '<em><b>Seen</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seen</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Seen</em>' attribute.
	 * @see #setSeen(boolean)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Seen()
	 * @model
	 * @generated
	 */
	boolean isSeen();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#isSeen <em>Seen</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Seen</em>' attribute.
	 * @see #isSeen()
	 * @generated
	 */
	void setSeen(boolean value);

	/**
	 * Returns the value of the '<em><b>Creation Date</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Date</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Creation Date</em>' attribute.
	 * @see #setCreationDate(Date)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_CreationDate()
	 * @model
	 * @generated
	 */
	Date getCreationDate();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getCreationDate
	 * <em>Creation Date</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Creation Date</em>' attribute.
	 * @see #getCreationDate()
	 * @generated
	 */
	void setCreationDate(Date value);

	/**
	 * Returns the value of the '<em><b>Provider</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provider</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Provider</em>' attribute.
	 * @see #setProvider(String)
	 * @see org.unicase.emfstore.esmodel.notification.NotificationPackage#getESNotification_Provider()
	 * @model
	 * @generated
	 */
	String getProvider();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.notification.ESNotification#getProvider
	 * <em>Provider</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Provider</em>' attribute.
	 * @see #getProvider()
	 * @generated
	 */
	void setProvider(String value);

} // ESNotification
