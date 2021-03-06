/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.UnkownFeatureException;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Multi Reference Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl#isAdd <em>Add</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl#getIndex <em>Index
 * </em>}</li>
 * <li>
 * {@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl#getReferencedModelElements
 * <em>Referenced Model Elements</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MultiReferenceOperationImpl extends ReferenceOperationImpl implements MultiReferenceOperation {

	/**
	 * The default value of the '{@link #isAdd() <em>Add</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAdd()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAdd() <em>Add</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAdd()
	 * @generated
	 * @ordered
	 */
	protected boolean add = ADD_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferencedModelElements() <em>Referenced Model Elements</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferencedModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementId> referencedModelElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MultiReferenceOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.MULTI_REFERENCE_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isAdd() {
		return add;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAdd(boolean newAdd) {
		boolean oldAdd = add;
		add = newAdd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_REFERENCE_OPERATION__ADD,
				oldAdd, add));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationsPackage.MULTI_REFERENCE_OPERATION__INDEX,
				oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ModelElementId> getReferencedModelElements() {
		if (referencedModelElements == null) {
			referencedModelElements = new EObjectContainmentEList.Resolving<ModelElementId>(ModelElementId.class, this,
				OperationsPackage.MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS);
		}
		return referencedModelElements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS:
			return ((InternalEList<?>) getReferencedModelElements()).basicRemove(otherEnd, msgs);
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
		case OperationsPackage.MULTI_REFERENCE_OPERATION__ADD:
			return isAdd();
		case OperationsPackage.MULTI_REFERENCE_OPERATION__INDEX:
			return getIndex();
		case OperationsPackage.MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS:
			return getReferencedModelElements();
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
		case OperationsPackage.MULTI_REFERENCE_OPERATION__ADD:
			setAdd((Boolean) newValue);
			return;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__INDEX:
			setIndex((Integer) newValue);
			return;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS:
			getReferencedModelElements().clear();
			getReferencedModelElements().addAll((Collection<? extends ModelElementId>) newValue);
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
		case OperationsPackage.MULTI_REFERENCE_OPERATION__ADD:
			setAdd(ADD_EDEFAULT);
			return;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__INDEX:
			setIndex(INDEX_EDEFAULT);
			return;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS:
			getReferencedModelElements().clear();
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
		case OperationsPackage.MULTI_REFERENCE_OPERATION__ADD:
			return add != ADD_EDEFAULT;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__INDEX:
			return index != INDEX_EDEFAULT;
		case OperationsPackage.MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS:
			return referencedModelElements != null && !referencedModelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (add: ");
		result.append(add);
		result.append(", index: ");
		result.append(index);
		result.append(')');
		return result.toString();
	}

	public void apply(Project project) {
		ModelElement modelElement = project.getModelElement(getModelElementId());
		if (modelElement == null) {
			// fail silently
			return;
		}
		EList<ModelElementId> referencedModelElementIds = getReferencedModelElements();
		List<ModelElement> referencedModelElements = new ArrayList<ModelElement>();
		for (ModelElementId refrencedModelElementId : referencedModelElementIds) {
			ModelElement referencedME = project.getModelElement(refrencedModelElementId);
			if (referencedME != null) {
				referencedModelElements.add(referencedME);
			}
		}
		EReference reference;
		try {
			reference = (EReference) this.getFeature(modelElement);
		} catch (UnkownFeatureException e) {
			// fail silently
			return;
		}
		Object object = modelElement.eGet(reference);
		@SuppressWarnings("unchecked")
		EList<ModelElement> list = (EList<ModelElement>) object;
		if (isAdd()) {
			if (index < list.size() && index > -1) {
				int i = index;
				for (ModelElement m : referencedModelElements) {

					if (i < list.size()) {
						if (list.contains(m)) {
							list.move(i, m);
						} else {
							list.add(i, m);
						}
					} else {
						// if index grows out of bounds, just append
						list.add(m);
					}

					i++;
				}
				// list.addAll(getIndex(), referencedModelElements);
			} else {
				// if index is out of range ignore index
				list.addAll(referencedModelElements);
			}
		} else {
			for (ModelElement me : referencedModelElements) {
				if (list.contains(me)) {
					list.remove(me);
				}
			}
			for (ModelElement currentElement : referencedModelElements) {
				if (currentElement.getProject() == null) {
					project.addModelElement(currentElement);
				}
			}
		}
	}

	@Override
	public String getDescription() {
		StringBuilder stringBuilder = new StringBuilder();

		if (isAdd()) {
			stringBuilder.append("Added ");
			stringBuilder.append(getMiddleDescription());
			stringBuilder.append(" to ");
		} else {
			stringBuilder.append("Removed ");
			stringBuilder.append(getMiddleDescription());
			stringBuilder.append(" from ");
		}
		stringBuilder.append(featureName);
		// stringBuilder.append(".");
		return stringBuilder.toString();
	}

	private String getMiddleDescription() {
		String featureName = getFeatureName();
		StringBuilder stringBuilder = new StringBuilder();

		if (getReferencedModelElements().size() > 1) {
			stringBuilder.append(getReferencedModelElements().size());
			stringBuilder.append(" ");
			stringBuilder.append(featureName);
		} else {
			String singular = featureName.substring(0, featureName.length() - 1);
			stringBuilder.append(singular);
		}
		return stringBuilder.toString();
	}

	@Override
	public String getName() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Changed ");
		stringBuilder.append(getFeatureName());
		return stringBuilder.toString();
	}

	@Override
	public AbstractOperation reverse() {
		MultiReferenceOperation multiReferenceOperation = OperationsFactory.eINSTANCE.createMultiReferenceOperation();
		super.reverse(multiReferenceOperation);
		multiReferenceOperation.setAdd(!isAdd());
		EList<ModelElementId> copiedReferencedModelElements = multiReferenceOperation.getReferencedModelElements();
		EList<ModelElementId> modelElements = getReferencedModelElements();
		for (ModelElementId modelElementId : modelElements) {
			copiedReferencedModelElements.add(ModelUtil.clone(modelElementId));
		}
		multiReferenceOperation.setIndex(getIndex());
		return multiReferenceOperation;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getOtherInvolvedModelElements()
	 */
	@Override
	public Set<ModelElementId> getOtherInvolvedModelElements() {
		Set<ModelElementId> set = new HashSet<ModelElementId>();
		set.addAll(getReferencedModelElements());
		return set;
	}

} // MultiReferenceOperationImpl
