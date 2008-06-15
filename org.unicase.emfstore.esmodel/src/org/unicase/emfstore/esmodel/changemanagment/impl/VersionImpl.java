/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentPackage;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.Version;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Version</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl#getProjectState
 * <em>Project State</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl#getPrimarySpec
 * <em>Primary Spec</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl#getTagSpecs
 * <em>Tag Specs</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl#getNextVersion
 * <em>Next Version</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl#getPreviousVersion
 * <em>Previous Version</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl#getChanges
 * <em>Changes</em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl#getLogMessage
 * <em>Log Message</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class VersionImpl extends EObjectImpl implements Version {
	/**
	 * The cached value of the '{@link #getProjectState()
	 * <em>Project State</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getProjectState()
	 * @generated
	 * @ordered
	 */
	protected Project projectState;

	/**
	 * The cached value of the '{@link #getPrimarySpec() <em>Primary Spec</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPrimarySpec()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec primarySpec;

	/**
	 * The cached value of the '{@link #getTagSpecs() <em>Tag Specs</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTagSpecs()
	 * @generated
	 * @ordered
	 */
	protected EList<TagVersionSpec> tagSpecs;

	/**
	 * The cached value of the '{@link #getNextVersion() <em>Next Version</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNextVersion()
	 * @generated
	 * @ordered
	 */
	protected Version nextVersion;

	/**
	 * The cached value of the '{@link #getPreviousVersion()
	 * <em>Previous Version</em>}' reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getPreviousVersion()
	 * @generated
	 * @ordered
	 */
	protected Version previousVersion;

	/**
	 * The cached value of the '{@link #getChanges() <em>Changes</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getChanges()
	 * @generated
	 * @ordered
	 */
	protected ChangePackage changes;

	/**
	 * The cached value of the '{@link #getLogMessage() <em>Log Message</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLogMessage()
	 * @generated
	 * @ordered
	 */
	protected LogMessage logMessage;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected VersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangemanagmentPackage.Literals.VERSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project getProjectState() {
		return projectState;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProjectState(Project newProjectState,
			NotificationChain msgs) {
		Project oldProjectState = projectState;
		projectState = newProjectState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangemanagmentPackage.VERSION__PROJECT_STATE,
					oldProjectState, newProjectState);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectState(Project newProjectState) {
		if (newProjectState != projectState) {
			NotificationChain msgs = null;
			if (projectState != null)
				msgs = ((InternalEObject) projectState)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ChangemanagmentPackage.VERSION__PROJECT_STATE,
								null, msgs);
			if (newProjectState != null)
				msgs = ((InternalEObject) newProjectState)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ChangemanagmentPackage.VERSION__PROJECT_STATE,
								null, msgs);
			msgs = basicSetProjectState(newProjectState, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangemanagmentPackage.VERSION__PROJECT_STATE,
					newProjectState, newProjectState));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec getPrimarySpec() {
		return primarySpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetPrimarySpec(
			PrimaryVersionSpec newPrimarySpec, NotificationChain msgs) {
		PrimaryVersionSpec oldPrimarySpec = primarySpec;
		primarySpec = newPrimarySpec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangemanagmentPackage.VERSION__PRIMARY_SPEC,
					oldPrimarySpec, newPrimarySpec);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPrimarySpec(PrimaryVersionSpec newPrimarySpec) {
		if (newPrimarySpec != primarySpec) {
			NotificationChain msgs = null;
			if (primarySpec != null)
				msgs = ((InternalEObject) primarySpec).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChangemanagmentPackage.VERSION__PRIMARY_SPEC,
						null, msgs);
			if (newPrimarySpec != null)
				msgs = ((InternalEObject) newPrimarySpec).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ChangemanagmentPackage.VERSION__PRIMARY_SPEC,
						null, msgs);
			msgs = basicSetPrimarySpec(newPrimarySpec, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangemanagmentPackage.VERSION__PRIMARY_SPEC,
					newPrimarySpec, newPrimarySpec));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<TagVersionSpec> getTagSpecs() {
		if (tagSpecs == null) {
			tagSpecs = new EObjectContainmentEList<TagVersionSpec>(
					TagVersionSpec.class, this,
					ChangemanagmentPackage.VERSION__TAG_SPECS);
		}
		return tagSpecs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Version getNextVersion() {
		if (nextVersion != null && nextVersion.eIsProxy()) {
			InternalEObject oldNextVersion = (InternalEObject) nextVersion;
			nextVersion = (Version) eResolveProxy(oldNextVersion);
			if (nextVersion != oldNextVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ChangemanagmentPackage.VERSION__NEXT_VERSION,
							oldNextVersion, nextVersion));
			}
		}
		return nextVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Version basicGetNextVersion() {
		return nextVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNextVersion(Version newNextVersion) {
		Version oldNextVersion = nextVersion;
		nextVersion = newNextVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangemanagmentPackage.VERSION__NEXT_VERSION,
					oldNextVersion, nextVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Version getPreviousVersion() {
		if (previousVersion != null && previousVersion.eIsProxy()) {
			InternalEObject oldPreviousVersion = (InternalEObject) previousVersion;
			previousVersion = (Version) eResolveProxy(oldPreviousVersion);
			if (previousVersion != oldPreviousVersion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							ChangemanagmentPackage.VERSION__PREVIOUS_VERSION,
							oldPreviousVersion, previousVersion));
			}
		}
		return previousVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Version basicGetPreviousVersion() {
		return previousVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPreviousVersion(Version newPreviousVersion) {
		Version oldPreviousVersion = previousVersion;
		previousVersion = newPreviousVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangemanagmentPackage.VERSION__PREVIOUS_VERSION,
					oldPreviousVersion, previousVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ChangePackage getChanges() {
		return changes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetChanges(ChangePackage newChanges,
			NotificationChain msgs) {
		ChangePackage oldChanges = changes;
		changes = newChanges;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, ChangemanagmentPackage.VERSION__CHANGES,
					oldChanges, newChanges);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setChanges(ChangePackage newChanges) {
		if (newChanges != changes) {
			NotificationChain msgs = null;
			if (changes != null)
				msgs = ((InternalEObject) changes).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChangemanagmentPackage.VERSION__CHANGES,
						null, msgs);
			if (newChanges != null)
				msgs = ((InternalEObject) newChanges).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ChangemanagmentPackage.VERSION__CHANGES,
						null, msgs);
			msgs = basicSetChanges(newChanges, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangemanagmentPackage.VERSION__CHANGES, newChanges,
					newChanges));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LogMessage getLogMessage() {
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLogMessage(LogMessage newLogMessage,
			NotificationChain msgs) {
		LogMessage oldLogMessage = logMessage;
		logMessage = newLogMessage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ChangemanagmentPackage.VERSION__LOG_MESSAGE, oldLogMessage,
					newLogMessage);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLogMessage(LogMessage newLogMessage) {
		if (newLogMessage != logMessage) {
			NotificationChain msgs = null;
			if (logMessage != null)
				msgs = ((InternalEObject) logMessage).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- ChangemanagmentPackage.VERSION__LOG_MESSAGE,
						null, msgs);
			if (newLogMessage != null)
				msgs = ((InternalEObject) newLogMessage).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- ChangemanagmentPackage.VERSION__LOG_MESSAGE,
						null, msgs);
			msgs = basicSetLogMessage(newLogMessage, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ChangemanagmentPackage.VERSION__LOG_MESSAGE, newLogMessage,
					newLogMessage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ChangemanagmentPackage.VERSION__PROJECT_STATE:
			return basicSetProjectState(null, msgs);
		case ChangemanagmentPackage.VERSION__PRIMARY_SPEC:
			return basicSetPrimarySpec(null, msgs);
		case ChangemanagmentPackage.VERSION__TAG_SPECS:
			return ((InternalEList<?>) getTagSpecs()).basicRemove(otherEnd,
					msgs);
		case ChangemanagmentPackage.VERSION__CHANGES:
			return basicSetChanges(null, msgs);
		case ChangemanagmentPackage.VERSION__LOG_MESSAGE:
			return basicSetLogMessage(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ChangemanagmentPackage.VERSION__PROJECT_STATE:
			return getProjectState();
		case ChangemanagmentPackage.VERSION__PRIMARY_SPEC:
			return getPrimarySpec();
		case ChangemanagmentPackage.VERSION__TAG_SPECS:
			return getTagSpecs();
		case ChangemanagmentPackage.VERSION__NEXT_VERSION:
			if (resolve)
				return getNextVersion();
			return basicGetNextVersion();
		case ChangemanagmentPackage.VERSION__PREVIOUS_VERSION:
			if (resolve)
				return getPreviousVersion();
			return basicGetPreviousVersion();
		case ChangemanagmentPackage.VERSION__CHANGES:
			return getChanges();
		case ChangemanagmentPackage.VERSION__LOG_MESSAGE:
			return getLogMessage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ChangemanagmentPackage.VERSION__PROJECT_STATE:
			setProjectState((Project) newValue);
			return;
		case ChangemanagmentPackage.VERSION__PRIMARY_SPEC:
			setPrimarySpec((PrimaryVersionSpec) newValue);
			return;
		case ChangemanagmentPackage.VERSION__TAG_SPECS:
			getTagSpecs().clear();
			getTagSpecs().addAll(
					(Collection<? extends TagVersionSpec>) newValue);
			return;
		case ChangemanagmentPackage.VERSION__NEXT_VERSION:
			setNextVersion((Version) newValue);
			return;
		case ChangemanagmentPackage.VERSION__PREVIOUS_VERSION:
			setPreviousVersion((Version) newValue);
			return;
		case ChangemanagmentPackage.VERSION__CHANGES:
			setChanges((ChangePackage) newValue);
			return;
		case ChangemanagmentPackage.VERSION__LOG_MESSAGE:
			setLogMessage((LogMessage) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ChangemanagmentPackage.VERSION__PROJECT_STATE:
			setProjectState((Project) null);
			return;
		case ChangemanagmentPackage.VERSION__PRIMARY_SPEC:
			setPrimarySpec((PrimaryVersionSpec) null);
			return;
		case ChangemanagmentPackage.VERSION__TAG_SPECS:
			getTagSpecs().clear();
			return;
		case ChangemanagmentPackage.VERSION__NEXT_VERSION:
			setNextVersion((Version) null);
			return;
		case ChangemanagmentPackage.VERSION__PREVIOUS_VERSION:
			setPreviousVersion((Version) null);
			return;
		case ChangemanagmentPackage.VERSION__CHANGES:
			setChanges((ChangePackage) null);
			return;
		case ChangemanagmentPackage.VERSION__LOG_MESSAGE:
			setLogMessage((LogMessage) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ChangemanagmentPackage.VERSION__PROJECT_STATE:
			return projectState != null;
		case ChangemanagmentPackage.VERSION__PRIMARY_SPEC:
			return primarySpec != null;
		case ChangemanagmentPackage.VERSION__TAG_SPECS:
			return tagSpecs != null && !tagSpecs.isEmpty();
		case ChangemanagmentPackage.VERSION__NEXT_VERSION:
			return nextVersion != null;
		case ChangemanagmentPackage.VERSION__PREVIOUS_VERSION:
			return previousVersion != null;
		case ChangemanagmentPackage.VERSION__CHANGES:
			return changes != null;
		case ChangemanagmentPackage.VERSION__LOG_MESSAGE:
			return logMessage != null;
		}
		return super.eIsSet(featureID);
	}

} // VersionImpl
