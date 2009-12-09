/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.operations.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.impl.SemanticCompositeOperationImpl;
import org.unicase.implementation.operations.InlineSuperClassOperation;
import org.unicase.implementation.operations.OperationsPackage;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Association;
import org.unicase.model.classes.Attribute;
import org.unicase.model.classes.Class;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Inline Super Class Operation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.implementation.operations.impl.InlineSuperClassOperationImpl#getSuperClass <em>Super Class
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class InlineSuperClassOperationImpl extends SemanticCompositeOperationImpl implements InlineSuperClassOperation {
	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected ModelElementId superClass;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InlineSuperClassOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationsPackage.Literals.INLINE_SUPER_CLASS_OPERATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementId getSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetSuperClass(ModelElementId newSuperClass, NotificationChain msgs) {
		ModelElementId oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS, oldSuperClass, newSuperClass);
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
	public void setSuperClass(ModelElementId newSuperClass) {
		if (newSuperClass != superClass) {
			NotificationChain msgs = null;
			if (superClass != null)
				msgs = ((InternalEObject) superClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS, null, msgs);
			if (newSuperClass != null)
				msgs = ((InternalEObject) newSuperClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS, null, msgs);
			msgs = basicSetSuperClass(newSuperClass, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS, newSuperClass, newSuperClass));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.unicase.model.classes.Class getSuperClass(Project project) {
		return OperationHelper.getElement(project, getSuperClass());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateSuperClassSubClasses(Project project) {
		Class superClass = getSuperClass(project);
		return !superClass.getSubClasses().isEmpty();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS:
			return basicSetSuperClass(null, msgs);
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
		case OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS:
			return getSuperClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS:
			setSuperClass((ModelElementId) newValue);
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
		case OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS:
			setSuperClass((ModelElementId) null);
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
		case OperationsPackage.INLINE_SUPER_CLASS_OPERATION__SUPER_CLASS:
			return superClass != null;
		}
		return super.eIsSet(featureID);
	}

	public void semanticApply(Project project) {
		Class superClass = getSuperClass(project);
		List<Attribute> attributes = new ArrayList<Attribute>(superClass.getAttributes());
		List<Association> outgoingAssociations = new ArrayList<Association>(superClass.getOutgoingAssociations());
		List<Association> incomingAssociations = new ArrayList<Association>(superClass.getIncomingAssociations());

		// push down attributes and associations
		PushDownOperationImpl.pushDownAttributes(attributes, superClass);
		PushDownOperationImpl.pushDownOutgoingAssociations(outgoingAssociations, superClass);
		PushDownOperationImpl.pushDownIncomingAssociations(incomingAssociations, superClass);

		// remove super class
		for (Class subClass : superClass.getSubClasses()) {
			subClass.getSuperClasses().remove(superClass);
			subClass.getSuperClasses().addAll(superClass.getSuperClasses());
		}
		superClass.delete();
	}

} // InlineSuperClassOperationImpl
