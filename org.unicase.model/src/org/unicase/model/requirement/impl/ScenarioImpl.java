/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.unicase.model.impl.ModelElementImpl;
import org.unicase.model.requirement.ActorInstance;
import org.unicase.model.requirement.FunctionalRequirement;
import org.unicase.model.requirement.NonFunctionalRequirement;
import org.unicase.model.requirement.RequirementPackage;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.Step;
import org.unicase.model.requirement.UseCase;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.impl.ScenarioImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ScenarioImpl#getInitiatingActorInstance <em>Initiating Actor Instance</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ScenarioImpl#getParticipatingActorInstances <em>Participating Actor Instances</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ScenarioImpl#getInstantiatedUseCases <em>Instantiated Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ScenarioImpl#getFunctionalRequirements <em>Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.impl.ScenarioImpl#getNonFunctionalRequirements <em>Non Functional Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScenarioImpl extends ModelElementImpl implements Scenario {
	/**
	 * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<Step> steps;
	/**
	 * The cached value of the '{@link #getInitiatingActorInstance() <em>Initiating Actor Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitiatingActorInstance()
	 * @generated
	 * @ordered
	 */
	protected ActorInstance initiatingActorInstance;
	/**
	 * The cached value of the '{@link #getParticipatingActorInstances() <em>Participating Actor Instances</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipatingActorInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorInstance> participatingActorInstances;
	/**
	 * The cached value of the '{@link #getInstantiatedUseCases() <em>Instantiated Use Cases</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstantiatedUseCases()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> instantiatedUseCases;

	/**
	 * The cached value of the '{@link #getFunctionalRequirements() <em>Functional Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<FunctionalRequirement> functionalRequirements;
	/**
	 * The cached value of the '{@link #getNonFunctionalRequirements() <em>Non Functional Requirements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNonFunctionalRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<NonFunctionalRequirement> nonFunctionalRequirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScenarioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RequirementPackage.Literals.SCENARIO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Step> getSteps() {
		if (steps == null) {
			steps = new EObjectContainmentEList<Step>(Step.class, this, RequirementPackage.SCENARIO__STEPS);
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorInstance getInitiatingActorInstance() {
		if (initiatingActorInstance != null && initiatingActorInstance.eIsProxy()) {
			InternalEObject oldInitiatingActorInstance = (InternalEObject)initiatingActorInstance;
			initiatingActorInstance = (ActorInstance)eResolveProxy(oldInitiatingActorInstance);
			if (initiatingActorInstance != oldInitiatingActorInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE, oldInitiatingActorInstance, initiatingActorInstance));
			}
		}
		return initiatingActorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActorInstance basicGetInitiatingActorInstance() {
		return initiatingActorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitiatingActorInstance(ActorInstance newInitiatingActorInstance, NotificationChain msgs) {
		ActorInstance oldInitiatingActorInstance = initiatingActorInstance;
		initiatingActorInstance = newInitiatingActorInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE, oldInitiatingActorInstance, newInitiatingActorInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitiatingActorInstance(ActorInstance newInitiatingActorInstance) {
		if (newInitiatingActorInstance != initiatingActorInstance) {
			NotificationChain msgs = null;
			if (initiatingActorInstance != null)
				msgs = ((InternalEObject)initiatingActorInstance).eInverseRemove(this, RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS, ActorInstance.class, msgs);
			if (newInitiatingActorInstance != null)
				msgs = ((InternalEObject)newInitiatingActorInstance).eInverseAdd(this, RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS, ActorInstance.class, msgs);
			msgs = basicSetInitiatingActorInstance(newInitiatingActorInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE, newInitiatingActorInstance, newInitiatingActorInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorInstance> getParticipatingActorInstances() {
		if (participatingActorInstances == null) {
			participatingActorInstances = new EObjectWithInverseResolvingEList.ManyInverse<ActorInstance>(ActorInstance.class, this, RequirementPackage.SCENARIO__PARTICIPATING_ACTOR_INSTANCES, RequirementPackage.ACTOR_INSTANCE__PARTICIPATED_SCENARIOS);
		}
		return participatingActorInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getInstantiatedUseCases() {
		if (instantiatedUseCases == null) {
			instantiatedUseCases = new EObjectWithInverseResolvingEList.ManyInverse<UseCase>(UseCase.class, this, RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES, RequirementPackage.USE_CASE__SCENARIOS);
		}
		return instantiatedUseCases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FunctionalRequirement> getFunctionalRequirements() {
		if (functionalRequirements == null) {
			functionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<FunctionalRequirement>(FunctionalRequirement.class, this, RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS, RequirementPackage.FUNCTIONAL_REQUIREMENT__SCENARIOS);
		}
		return functionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NonFunctionalRequirement> getNonFunctionalRequirements() {
		if (nonFunctionalRequirements == null) {
			nonFunctionalRequirements = new EObjectWithInverseResolvingEList.ManyInverse<NonFunctionalRequirement>(NonFunctionalRequirement.class, this, RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS, RequirementPackage.NON_FUNCTIONAL_REQUIREMENT__RESTRICTED_SCENARIOS);
		}
		return nonFunctionalRequirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE:
				if (initiatingActorInstance != null)
					msgs = ((InternalEObject)initiatingActorInstance).eInverseRemove(this, RequirementPackage.ACTOR_INSTANCE__INITIATED_SCENARIOS, ActorInstance.class, msgs);
				return basicSetInitiatingActorInstance((ActorInstance)otherEnd, msgs);
			case RequirementPackage.SCENARIO__PARTICIPATING_ACTOR_INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParticipatingActorInstances()).basicAdd(otherEnd, msgs);
			case RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInstantiatedUseCases()).basicAdd(otherEnd, msgs);
			case RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFunctionalRequirements()).basicAdd(otherEnd, msgs);
			case RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNonFunctionalRequirements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RequirementPackage.SCENARIO__STEPS:
				return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
			case RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE:
				return basicSetInitiatingActorInstance(null, msgs);
			case RequirementPackage.SCENARIO__PARTICIPATING_ACTOR_INSTANCES:
				return ((InternalEList<?>)getParticipatingActorInstances()).basicRemove(otherEnd, msgs);
			case RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES:
				return ((InternalEList<?>)getInstantiatedUseCases()).basicRemove(otherEnd, msgs);
			case RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<?>)getFunctionalRequirements()).basicRemove(otherEnd, msgs);
			case RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS:
				return ((InternalEList<?>)getNonFunctionalRequirements()).basicRemove(otherEnd, msgs);
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
			case RequirementPackage.SCENARIO__STEPS:
				return getSteps();
			case RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE:
				if (resolve) return getInitiatingActorInstance();
				return basicGetInitiatingActorInstance();
			case RequirementPackage.SCENARIO__PARTICIPATING_ACTOR_INSTANCES:
				return getParticipatingActorInstances();
			case RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES:
				return getInstantiatedUseCases();
			case RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS:
				return getFunctionalRequirements();
			case RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS:
				return getNonFunctionalRequirements();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RequirementPackage.SCENARIO__STEPS:
				getSteps().clear();
				getSteps().addAll((Collection<? extends Step>)newValue);
				return;
			case RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE:
				setInitiatingActorInstance((ActorInstance)newValue);
				return;
			case RequirementPackage.SCENARIO__PARTICIPATING_ACTOR_INSTANCES:
				getParticipatingActorInstances().clear();
				getParticipatingActorInstances().addAll((Collection<? extends ActorInstance>)newValue);
				return;
			case RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES:
				getInstantiatedUseCases().clear();
				getInstantiatedUseCases().addAll((Collection<? extends UseCase>)newValue);
				return;
			case RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS:
				getFunctionalRequirements().clear();
				getFunctionalRequirements().addAll((Collection<? extends FunctionalRequirement>)newValue);
				return;
			case RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS:
				getNonFunctionalRequirements().clear();
				getNonFunctionalRequirements().addAll((Collection<? extends NonFunctionalRequirement>)newValue);
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
			case RequirementPackage.SCENARIO__STEPS:
				getSteps().clear();
				return;
			case RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE:
				setInitiatingActorInstance((ActorInstance)null);
				return;
			case RequirementPackage.SCENARIO__PARTICIPATING_ACTOR_INSTANCES:
				getParticipatingActorInstances().clear();
				return;
			case RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES:
				getInstantiatedUseCases().clear();
				return;
			case RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS:
				getFunctionalRequirements().clear();
				return;
			case RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS:
				getNonFunctionalRequirements().clear();
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
			case RequirementPackage.SCENARIO__STEPS:
				return steps != null && !steps.isEmpty();
			case RequirementPackage.SCENARIO__INITIATING_ACTOR_INSTANCE:
				return initiatingActorInstance != null;
			case RequirementPackage.SCENARIO__PARTICIPATING_ACTOR_INSTANCES:
				return participatingActorInstances != null && !participatingActorInstances.isEmpty();
			case RequirementPackage.SCENARIO__INSTANTIATED_USE_CASES:
				return instantiatedUseCases != null && !instantiatedUseCases.isEmpty();
			case RequirementPackage.SCENARIO__FUNCTIONAL_REQUIREMENTS:
				return functionalRequirements != null && !functionalRequirements.isEmpty();
			case RequirementPackage.SCENARIO__NON_FUNCTIONAL_REQUIREMENTS:
				return nonFunctionalRequirements != null && !nonFunctionalRequirements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ScenarioImpl
