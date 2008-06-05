/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;

import org.unicase.model.ModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scenario</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.Scenario#getSteps <em>Steps</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Scenario#getInitiatingActorInstance <em>Initiating Actor Instance</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Scenario#getParticipatingActorInstances <em>Participating Actor Instances</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Scenario#getInstantiatedUseCases <em>Instantiated Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Scenario#getFunctionalRequirements <em>Functional Requirements</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Scenario#getNonFunctionalRequirements <em>Non Functional Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getScenario()
 * @model
 * @generated
 */
public interface Scenario extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Step}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getScenario_Steps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Step> getSteps();

	/**
	 * Returns the value of the '<em><b>Initiating Actor Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiating Actor Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiating Actor Instance</em>' reference.
	 * @see #setInitiatingActorInstance(ActorInstance)
	 * @see org.unicase.model.requirement.RequirementPackage#getScenario_InitiatingActorInstance()
	 * @model
	 * @generated
	 */
	ActorInstance getInitiatingActorInstance();

	/**
	 * Sets the value of the '{@link org.unicase.model.requirement.Scenario#getInitiatingActorInstance <em>Initiating Actor Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiating Actor Instance</em>' reference.
	 * @see #getInitiatingActorInstance()
	 * @generated
	 */
	void setInitiatingActorInstance(ActorInstance value);

	/**
	 * Returns the value of the '<em><b>Participating Actor Instances</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.ActorInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participating Actor Instances</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participating Actor Instances</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getScenario_ParticipatingActorInstances()
	 * @model
	 * @generated
	 */
	EList<ActorInstance> getParticipatingActorInstances();

	/**
	 * Returns the value of the '<em><b>Instantiated Use Cases</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.UseCase}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.UseCase#getScenarios <em>Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instantiated Use Cases</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instantiated Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getScenario_InstantiatedUseCases()
	 * @see org.unicase.model.requirement.UseCase#getScenarios
	 * @model opposite="scenarios"
	 * @generated
	 */
	EList<UseCase> getInstantiatedUseCases();

	/**
	 * Returns the value of the '<em><b>Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.FunctionalRequirement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Functional Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functional Requirements</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getScenario_FunctionalRequirements()
	 * @model
	 * @generated
	 */
	EList<FunctionalRequirement> getFunctionalRequirements();

	/**
	 * Returns the value of the '<em><b>Non Functional Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.NonFunctionalRequirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedScenarios <em>Restricted Scenarios</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Functional Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Functional Requirements</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getScenario_NonFunctionalRequirements()
	 * @see org.unicase.model.requirement.NonFunctionalRequirement#getRestrictedScenarios
	 * @model opposite="restrictedScenarios"
	 * @generated
	 */
	EList<NonFunctionalRequirement> getNonFunctionalRequirements();

} // Scenario
