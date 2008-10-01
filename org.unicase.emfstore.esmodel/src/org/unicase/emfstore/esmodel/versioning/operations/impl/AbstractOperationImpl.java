/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl#getModelElementId <em>Model Element Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractOperationImpl extends EObjectImpl implements
		AbstractOperation {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";
	/**
	 * The cached value of the '{@link #getModelElementId() <em>Model Element Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementId()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId modelElementId;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.ABSTRACT_OPERATION;
	}
	
	// begin of custom code
	/**
	 * <!-- begin-user-doc -->
	 * Return the operations name.
	 * @return the name
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getName();

	/**
	 * <!-- begin-user-doc -->
	 * Return the operations description.
	 * @return the description
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract String getDescription();
	// end of custom code
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId getModelElementId() {
		if (modelElementId != null && modelElementId.eIsProxy()) {
			InternalEObject oldModelElementId = (InternalEObject) modelElementId;
			modelElementId = (ModelElementId) eResolveProxy(oldModelElementId);
			if (modelElementId != oldModelElementId) {
				InternalEObject newModelElementId = (InternalEObject) modelElementId;
				NotificationChain msgs = oldModelElementId
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID,
								null, null);
				if (newModelElementId.eInternalContainer() == null) {
					msgs = newModelElementId
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID,
							oldModelElementId, modelElementId));
			}
		}
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementId basicGetModelElementId() {
		return modelElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElementId(
			ModelElementId newModelElementId, NotificationChain msgs) {
		ModelElementId oldModelElementId = modelElementId;
		modelElementId = newModelElementId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID,
					oldModelElementId, newModelElementId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementId(ModelElementId newModelElementId) {
		if (newModelElementId != modelElementId) {
			NotificationChain msgs = null;
			if (modelElementId != null)
				msgs = ((InternalEObject) modelElementId)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID,
								null, msgs);
			if (newModelElementId != null)
				msgs = ((InternalEObject) newModelElementId)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID,
								null, msgs);
			msgs = basicSetModelElementId(newModelElementId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID,
					newModelElementId, newModelElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void apply(Project project) {
		if (!canApply(project)) {
			//MK throw proper exception
			throw new IllegalStateException("Cannot apply!");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract AbstractOperation reverse();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void reverse(AbstractOperation abstractOperation) {
		abstractOperation.setModelElementId(ModelUtil
				.clone(getModelElementId()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract boolean canApply(Project project);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChange() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			return basicSetModelElementId(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.ABSTRACT_OPERATION__NAME:
			return getName();
		case OperationsPackage.ABSTRACT_OPERATION__DESCRIPTION:
			return getDescription();
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			if (resolve)
				return getModelElementId();
			return basicGetModelElementId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			setModelElementId((ModelElementId) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case OperationsPackage.ABSTRACT_OPERATION__NAME:
			return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT
					.equals(getName());
		case OperationsPackage.ABSTRACT_OPERATION__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? getDescription() != null
					: !DESCRIPTION_EDEFAULT.equals(getDescription());
		case OperationsPackage.ABSTRACT_OPERATION__MODEL_ELEMENT_ID:
			return modelElementId != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractOperationImpl
