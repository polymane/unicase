/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.Actor;
import org.unicase.model.requirement.ActorInstance;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Actor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.ActorImpl#getInitiatedUseCases <em>Initiated Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ActorImpl#getParticipatedUseCases <em>Participated Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ActorImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorImpl extends ModelElementImpl implements Actor {
	/**
	 * The cached value of the '{@link #getInitiatedUseCases() <em>Initiated Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiatedUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> initiatedUseCases;

	/**
	 * The cached value of the '{@link #getParticipatedUseCases() <em>Participated Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipatedUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> participatedUseCases;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorInstance> instances;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getInitiatedUseCases() {
		if (initiatedUseCases == null) {
			initiatedUseCases = new EObjectWithInverseResolvingEList<UseCase>(
					UseCase.class, this,
					RequirementPackage.ACTOR__INITIATED_USE_CASES,
					RequirementPackage.USE_CASE__INITIATING_ACTOR);
		}
		return initiatedUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getParticipatedUseCases() {
		if (participatedUseCases == null) {
			participatedUseCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(
					UseCase.class, this,
					RequirementPackage.ACTOR__PARTICIPATED_USE_CASES,
					RequirementPackage.USE_CASE__PARTICIPATING_ACTORS);
		}
		return participatedUseCases;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorInstance> getInstances() {
		if (instances == null) {
			instances = new EObjectWithInverseResolvingEList<ActorInstance>(
					ActorInstance.class, this,
					RequirementPackage.ACTOR__INSTANCES,
					RequirementPackage.ACTOR_INSTANCE__INSTANTIATED_ACTOR);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.ACTOR__INITIATED_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInitiatedUseCases())
					.basicAdd(otherEnd, msgs);
		case RequirementPackage.ACTOR__PARTICIPATED_USE_CASES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getParticipatedUseCases())
					.basicAdd(otherEnd, msgs);
		case RequirementPackage.ACTOR__INSTANCES:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInstances())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case RequirementPackage.ACTOR__INITIATED_USE_CASES:
			return ((InternalEList<?>) getInitiatedUseCases()).basicRemove(
					otherEnd, msgs);
		case RequirementPackage.ACTOR__PARTICIPATED_USE_CASES:
			return ((InternalEList<?>) getParticipatedUseCases()).basicRemove(
					otherEnd, msgs);
		case RequirementPackage.ACTOR__INSTANCES:
			return ((InternalEList<?>) getInstances()).basicRemove(otherEnd,
					msgs);
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
		case RequirementPackage.ACTOR__INITIATED_USE_CASES:
			return getInitiatedUseCases();
		case RequirementPackage.ACTOR__PARTICIPATED_USE_CASES:
			return getParticipatedUseCases();
		case RequirementPackage.ACTOR__INSTANCES:
			return getInstances();
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
		case RequirementPackage.ACTOR__INITIATED_USE_CASES:
			getInitiatedUseCases().clear();
			getInitiatedUseCases().addAll(
					(Collection<? extends UseCase>) newValue);
			return;
		case RequirementPackage.ACTOR__PARTICIPATED_USE_CASES:
			getParticipatedUseCases().clear();
			getParticipatedUseCases().addAll(
					(Collection<? extends UseCase>) newValue);
			return;
		case RequirementPackage.ACTOR__INSTANCES:
			getInstances().clear();
			getInstances().addAll(
					(Collection<? extends ActorInstance>) newValue);
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
		case RequirementPackage.ACTOR__INITIATED_USE_CASES:
			getInitiatedUseCases().clear();
			return;
		case RequirementPackage.ACTOR__PARTICIPATED_USE_CASES:
			getParticipatedUseCases().clear();
			return;
		case RequirementPackage.ACTOR__INSTANCES:
			getInstances().clear();
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
		case RequirementPackage.ACTOR__INITIATED_USE_CASES:
			return initiatedUseCases != null && !initiatedUseCases.isEmpty();
		case RequirementPackage.ACTOR__PARTICIPATED_USE_CASES:
			return participatedUseCases != null
					&& !participatedUseCases.isEmpty();
		case RequirementPackage.ACTOR__INSTANCES:
			return instances != null && !instances.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ActorImpl
