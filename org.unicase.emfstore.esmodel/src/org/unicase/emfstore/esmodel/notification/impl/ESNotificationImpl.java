/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.notification.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationPackage;
import org.unicase.model.ModelElementId;
import org.unicase.model.impl.IdentifiableElementImpl;

/*
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>ES Notification</b></em>'. <!-- end-user-doc
 * --> <p> The following features are implemented: <ul> <li>{@link
 * org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl#getSender <em>Sender</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl#getRecipient <em>Recipient</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl#getProject <em>Project</em>}</li> <li>{@link
 * org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl#getRelatedModelElements <em>Related Model
 * Elements</em>}</li> <li>{@link org.unicase.emfstore.esmodel.notification.impl.ESNotificationImpl#getMessage
 * <em>Message</em>}</li> </ul> </p>
 * @generated
 */
public class ESNotificationImpl extends IdentifiableElementImpl implements ESNotification {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isSeen() <em>Seen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSeen()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSeen() <em>Seen</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSeen()
	 * @generated
	 * @ordered
	 */
	protected boolean seen = SEEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSender() <em>Sender</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected static final String SENDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected String sender = SENDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecipient() <em>Recipient</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRecipient()
	 * @generated
	 * @ordered
	 */
	protected static final String RECIPIENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecipient() <em>Recipient</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRecipient()
	 * @generated
	 * @ordered
	 */
	protected String recipient = RECIPIENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected ProjectId project;

	/**
	 * The cached value of the '{@link #getRelatedModelElements() <em>Related Model Elements</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRelatedModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> relatedModelElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ESNotificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NotificationPackage.Literals.ES_NOTIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(String newSender) {
		String oldSender = sender;
		sender = newSender;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__SENDER, oldSender, sender));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecipient(String newRecipient) {
		String oldRecipient = recipient;
		recipient = newRecipient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__RECIPIENT, oldRecipient, recipient));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId getProject() {
		if (project != null && project.eIsProxy())
		{
			InternalEObject oldProject = (InternalEObject)project;
			project = (ProjectId)eResolveProxy(oldProject);
			if (project != oldProject)
			{
				InternalEObject newProject = (InternalEObject)project;
				NotificationChain msgs = oldProject.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NotificationPackage.ES_NOTIFICATION__PROJECT, null, null);
				if (newProject.eInternalContainer() == null)
				{
					msgs = newProject.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NotificationPackage.ES_NOTIFICATION__PROJECT, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NotificationPackage.ES_NOTIFICATION__PROJECT, oldProject, project));
			}
		}
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectId basicGetProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(ProjectId newProject, NotificationChain msgs) {
		ProjectId oldProject = project;
		project = newProject;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__PROJECT, oldProject, newProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(ProjectId newProject) {
		if (newProject != project)
		{
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject)project).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NotificationPackage.ES_NOTIFICATION__PROJECT, null, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NotificationPackage.ES_NOTIFICATION__PROJECT, null, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__PROJECT, newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementId> getRelatedModelElements() {
		if (relatedModelElements == null)
		{
			relatedModelElements = new EObjectContainmentEList.Resolving<ModelElementId>(ModelElementId.class, this, NotificationPackage.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS);
		}
		return relatedModelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSeen() {
		return seen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeen(boolean newSeen) {
		boolean oldSeen = seen;
		seen = newSeen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__SEEN, oldSeen, seen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NotificationPackage.ES_NOTIFICATION__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case NotificationPackage.ES_NOTIFICATION__PROJECT:
				return basicSetProject(null, msgs);
			case NotificationPackage.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS:
				return ((InternalEList<?>)getRelatedModelElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case NotificationPackage.ES_NOTIFICATION__NAME:
				return getName();
			case NotificationPackage.ES_NOTIFICATION__MESSAGE:
				return getMessage();
			case NotificationPackage.ES_NOTIFICATION__SEEN:
				return isSeen() ? Boolean.TRUE : Boolean.FALSE;
			case NotificationPackage.ES_NOTIFICATION__CREATION_DATE:
				return getCreationDate();
			case NotificationPackage.ES_NOTIFICATION__SENDER:
				return getSender();
			case NotificationPackage.ES_NOTIFICATION__RECIPIENT:
				return getRecipient();
			case NotificationPackage.ES_NOTIFICATION__PROJECT:
				if (resolve) return getProject();
				return basicGetProject();
			case NotificationPackage.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS:
				return getRelatedModelElements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
			case NotificationPackage.ES_NOTIFICATION__NAME:
				setName((String)newValue);
				return;
			case NotificationPackage.ES_NOTIFICATION__MESSAGE:
				setMessage((String)newValue);
				return;
			case NotificationPackage.ES_NOTIFICATION__SEEN:
				setSeen(((Boolean)newValue).booleanValue());
				return;
			case NotificationPackage.ES_NOTIFICATION__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case NotificationPackage.ES_NOTIFICATION__SENDER:
				setSender((String)newValue);
				return;
			case NotificationPackage.ES_NOTIFICATION__RECIPIENT:
				setRecipient((String)newValue);
				return;
			case NotificationPackage.ES_NOTIFICATION__PROJECT:
				setProject((ProjectId)newValue);
				return;
			case NotificationPackage.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS:
				getRelatedModelElements().clear();
				getRelatedModelElements().addAll((Collection<? extends ModelElementId>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
			case NotificationPackage.ES_NOTIFICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NotificationPackage.ES_NOTIFICATION__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case NotificationPackage.ES_NOTIFICATION__SEEN:
				setSeen(SEEN_EDEFAULT);
				return;
			case NotificationPackage.ES_NOTIFICATION__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case NotificationPackage.ES_NOTIFICATION__SENDER:
				setSender(SENDER_EDEFAULT);
				return;
			case NotificationPackage.ES_NOTIFICATION__RECIPIENT:
				setRecipient(RECIPIENT_EDEFAULT);
				return;
			case NotificationPackage.ES_NOTIFICATION__PROJECT:
				setProject((ProjectId)null);
				return;
			case NotificationPackage.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS:
				getRelatedModelElements().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case NotificationPackage.ES_NOTIFICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NotificationPackage.ES_NOTIFICATION__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case NotificationPackage.ES_NOTIFICATION__SEEN:
				return seen != SEEN_EDEFAULT;
			case NotificationPackage.ES_NOTIFICATION__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case NotificationPackage.ES_NOTIFICATION__SENDER:
				return SENDER_EDEFAULT == null ? sender != null : !SENDER_EDEFAULT.equals(sender);
			case NotificationPackage.ES_NOTIFICATION__RECIPIENT:
				return RECIPIENT_EDEFAULT == null ? recipient != null : !RECIPIENT_EDEFAULT.equals(recipient);
			case NotificationPackage.ES_NOTIFICATION__PROJECT:
				return project != null;
			case NotificationPackage.ES_NOTIFICATION__RELATED_MODEL_ELEMENTS:
				return relatedModelElements != null && !relatedModelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", message: ");
		result.append(message);
		result.append(", seen: ");
		result.append(seen);
		result.append(", creationDate: ");
		result.append(creationDate);
		result.append(", sender: ");
		result.append(sender);
		result.append(", recipient: ");
		result.append(recipient);
		result.append(')');
		return result.toString();
	}

} // ESNotificationImpl
