/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Create Delete Operation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#isDelete <em>Delete</em>}</li>
 *   <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateDeleteOperationImpl extends AbstractOperationImpl implements
		CreateDeleteOperation {

	@Override
	public void apply(Project project) {
		super.apply(project);
		if (isDelete()) {
			EcoreUtil.delete(project.getModelElement(getModelElementId()), true);
		} else {
			project.getModelElements().add(ModelUtil.clone(getModelElement()));
		}
	}

	@Override
	public boolean canApply(Project project) {
		if (isDelete()) {
			return project.contains(getModelElementId());
		} else {
			return !project.contains(getModelElementId());
		}
	}

	@Override
	public AbstractOperation reverse() {
		CreateDeleteOperation createDeleteOperation = OperationsFactory.eINSTANCE
				.createCreateDeleteOperation();
		super.reverse(createDeleteOperation);
		createDeleteOperation.setDelete(!this.isDelete());
		createDeleteOperation.setModelElement(ModelUtil.clone(this
				.getModelElement()));
		return createDeleteOperation;
	}

	/**
	 * The default value of the '{@link #isDelete() <em>Delete</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDelete()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDelete() <em>Delete</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDelete()
	 * @generated
	 * @ordered
	 */
	protected boolean delete = DELETE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected ModelElement modelElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateDeleteOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.CREATE_DELETE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDelete() {
		return delete;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelete(boolean newDelete) {
		boolean oldDelete = delete;
		delete = newDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.CREATE_DELETE_OPERATION__DELETE,
					oldDelete, delete));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getModelElement() {
		if (modelElement != null && modelElement.eIsProxy()) {
			InternalEObject oldModelElement = (InternalEObject) modelElement;
			modelElement = (ModelElement) eResolveProxy(oldModelElement);
			if (modelElement != oldModelElement) {
				InternalEObject newModelElement = (InternalEObject) modelElement;
				NotificationChain msgs = oldModelElement
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
								null, null);
				if (newModelElement.eInternalContainer() == null) {
					msgs = newModelElement
							.eInverseAdd(
									this,
									EOPPOSITE_FEATURE_BASE
											- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
									null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
							oldModelElement, modelElement));
			}
		}
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement basicGetModelElement() {
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElement(ModelElement newModelElement,
			NotificationChain msgs) {
		ModelElement oldModelElement = modelElement;
		modelElement = newModelElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
					oldModelElement, newModelElement);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElement(ModelElement newModelElement) {
		if (newModelElement != modelElement) {
			NotificationChain msgs = null;
			if (modelElement != null)
				msgs = ((InternalEObject) modelElement)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
								null, msgs);
			if (newModelElement != null)
				msgs = ((InternalEObject) newModelElement)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
								null, msgs);
			msgs = basicSetModelElement(newModelElement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT,
					newModelElement, newModelElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			return basicSetModelElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			return isDelete() ? Boolean.TRUE : Boolean.FALSE;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			if (resolve)
				return getModelElement();
			return basicGetModelElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			setDelete(((Boolean) newValue).booleanValue());
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			setModelElement((ModelElement) newValue);
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
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			setDelete(DELETE_EDEFAULT);
			return;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			setModelElement((ModelElement) null);
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
		switch (featureID) {
		case OperationsPackage.CREATE_DELETE_OPERATION__DELETE:
			return delete != DELETE_EDEFAULT;
		case OperationsPackage.CREATE_DELETE_OPERATION__MODEL_ELEMENT:
			return modelElement != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (delete: ");
		result.append(delete);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isDelete()) {
			stringBuilder.append("Deleted  ");
		} else {
			stringBuilder.append("Created ");
		}
		stringBuilder.append(getModelElement().eClass().getName());
		stringBuilder.append(" ");
		stringBuilder.append(getModelElement().getName());
		stringBuilder.append(".");
		return stringBuilder.toString();
	}

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		if (isDelete()) {
			stringBuilder.append("Deleted  ");
			stringBuilder.append(getModelElement().eClass().getName());
			stringBuilder.append(" \"");
			stringBuilder.append(getModelElement().getName());
			stringBuilder.append("\"");
		} else {
			stringBuilder.append("Created ");
			stringBuilder.append(getModelElement().eClass().getName());
		}
		return stringBuilder.toString();
	}

} // CreateDeleteOperationImpl
