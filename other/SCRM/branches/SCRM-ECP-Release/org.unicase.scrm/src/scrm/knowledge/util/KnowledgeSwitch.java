/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import scrm.SCRMModelElement;

import scrm.SCRMSpace;
import scrm.knowledge.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see scrm.knowledge.KnowledgePackage
 * @generated
 */
public class KnowledgeSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static KnowledgePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KnowledgeSwitch() {
		if (modelPackage == null) {
			modelPackage = KnowledgePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(
					eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case KnowledgePackage.SCIENTIFIC_KNOWLEDGE: {
			ScientificKnowledge scientificKnowledge = (ScientificKnowledge) theEObject;
			T result = caseScientificKnowledge(scientificKnowledge);
			if (result == null)
				result = caseSCRMModelElement(scientificKnowledge);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KnowledgePackage.KNOWLEDGE_SPACE: {
			KnowledgeSpace knowledgeSpace = (KnowledgeSpace) theEObject;
			T result = caseKnowledgeSpace(knowledgeSpace);
			if (result == null)
				result = caseSCRMSpace(knowledgeSpace);
			if (result == null)
				result = caseScientificKnowledge(knowledgeSpace);
			if (result == null)
				result = caseSCRMModelElement(knowledgeSpace);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KnowledgePackage.SCIENTIFIC_PROBLEM: {
			ScientificProblem scientificProblem = (ScientificProblem) theEObject;
			T result = caseScientificProblem(scientificProblem);
			if (result == null)
				result = caseScientificKnowledge(scientificProblem);
			if (result == null)
				result = caseSCRMModelElement(scientificProblem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KnowledgePackage.MATHEMATICAL_MODEL: {
			MathematicalModel mathematicalModel = (MathematicalModel) theEObject;
			T result = caseMathematicalModel(mathematicalModel);
			if (result == null)
				result = caseScientificKnowledge(mathematicalModel);
			if (result == null)
				result = caseSCRMModelElement(mathematicalModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KnowledgePackage.NUMERICAL_METHOD: {
			NumericalMethod numericalMethod = (NumericalMethod) theEObject;
			T result = caseNumericalMethod(numericalMethod);
			if (result == null)
				result = caseScientificKnowledge(numericalMethod);
			if (result == null)
				result = caseSCRMModelElement(numericalMethod);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case KnowledgePackage.ASSUMPTION: {
			Assumption assumption = (Assumption) theEObject;
			T result = caseAssumption(assumption);
			if (result == null)
				result = caseScientificKnowledge(assumption);
			if (result == null)
				result = caseSCRMModelElement(assumption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scientific Knowledge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scientific Knowledge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScientificKnowledge(ScientificKnowledge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scientific Problem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scientific Problem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScientificProblem(ScientificProblem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mathematical Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mathematical Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMathematicalModel(MathematicalModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numerical Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numerical Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericalMethod(NumericalMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assumption</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assumption</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssumption(Assumption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKnowledgeSpace(KnowledgeSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCRM Model Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCRM Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCRMModelElement(SCRMModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCRM Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCRM Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCRMSpace(SCRMSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //KnowledgeSwitch
