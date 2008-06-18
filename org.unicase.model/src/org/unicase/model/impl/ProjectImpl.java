/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Project</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.impl.ProjectImpl#getModelElements <em>Model Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */

public class ProjectImpl extends EObjectImpl implements Project {

	/**
	 * The cached value of the '{@link #getModelElements() <em>Model Elements</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getModelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> modelElements;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getModelElements() {
		if (modelElements == null) {
			modelElements = new EObjectContainmentEList<ModelElement>(ModelElement.class, this, ModelPackage.PROJECT__MODEL_ELEMENTS);
		}
		return modelElements;
	}

	//begin of custom code
	/**
	 * {@inheritDoc}
	 * @see org.unicase.model.Project#addModelElement(org.unicase.model.ModelElement)
	 * @generated NOT
	 */
	public void addModelElement(ModelElement modelElement) {
		this.getModelElements().add(modelElement);
	}

	/**
	 * {@inheritDoc}
	 * @see org.unicase.model.Project#getAllModelElements()
	 * @generated NOT
	 */
	public EList<ModelElement> getAllModelElements() {
		return this.getAllModelElementsbyClass(ModelPackage.eINSTANCE.getModelElement());	
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.model.Project#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	public EList<ModelElement> getAllModelElementsbyClass(EClass modelElementClass) {
		BasicEList<ModelElement> result = new BasicEList<ModelElement>();
		
		//sanity check
		if (!ModelPackage.eINSTANCE.getModelElement().isSuperTypeOf(modelElementClass)) {
			return result;
		}
		
		//all elements
		Set<ModelElement> allElements = new HashSet<ModelElement>();
		//elements to do
		Set<ModelElement> todo = new HashSet<ModelElement>();
		
		//init with the projects direct model elements
		EList<ModelElement> elements = this.getModelElements();
		todo.addAll(elements);
		allElements.addAll(elements);
		
		while (!todo.isEmpty()) {
			ModelElement modelElement = todo.iterator().next();
			EList<EObject> contents = modelElement.eContents();
			for (EObject content: contents) {
				if (modelElementClass.isInstance(content)) {
					allElements.add((ModelElement)content);
					todo.add((ModelElement)content);
				}
			}
			todo.remove(modelElement);
		}
		result.addAllUnique(todo);
		return result;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.model.Project#getModelElementsByClass(org.eclipse.emf.ecore.EClass)
	 * @generated NOT
	 */
	public EList<ModelElement> getModelElementsByClass(EClass modelElementClass) {
		BasicEList<ModelElement> result = new BasicEList<ModelElement>();
		for (ModelElement modelElement: this.getModelElements()) {
			if (modelElementClass.isInstance(modelElement)) {
				result.add(modelElement);
			}
		}
		return result;
	}
	//end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PROJECT__MODEL_ELEMENTS:
				return ((InternalEList<?>)getModelElements()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PROJECT__MODEL_ELEMENTS:
				return getModelElements();
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
		switch (featureID) {
			case ModelPackage.PROJECT__MODEL_ELEMENTS:
				getModelElements().clear();
				getModelElements().addAll((Collection<? extends ModelElement>)newValue);
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
			case ModelPackage.PROJECT__MODEL_ELEMENTS:
				getModelElements().clear();
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
			case ModelPackage.PROJECT__MODEL_ELEMENTS:
				return modelElements != null && !modelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

//	public Collection<ModelElement> getElementsByClass(
//			Class<? extends EObject> elementType) {
//		Collection<ModelElement> returnList = new ArrayList<ModelElement>();
//		for (ModelElement currentME : modelElements) {
//			if (elementType.isAssignableFrom(currentME.getClass())) {
//				returnList.add(currentME);
//			}
//		}
//		return returnList;
//	}
} // ProjectImpl
