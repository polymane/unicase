/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;

/*
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call {@link
 * #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model, starting
 * with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is returned,
 * which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage
 * @generated
 */
public class OperationsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static OperationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OperationsSwitch() {
		if (modelPackage == null)
		{
			modelPackage = OperationsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage)
		{
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else
		{
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID)
		{
			case OperationsPackage.ABSTRACT_OPERATION:
			{
				AbstractOperation abstractOperation = (AbstractOperation)theEObject;
				T result = caseAbstractOperation(abstractOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.COMPOSITE_OPERATION:
			{
				CompositeOperation compositeOperation = (CompositeOperation)theEObject;
				T result = caseCompositeOperation(compositeOperation);
				if (result == null) result = caseAbstractOperation(compositeOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.FEATURE_OPERATION:
			{
				FeatureOperation featureOperation = (FeatureOperation)theEObject;
				T result = caseFeatureOperation(featureOperation);
				if (result == null) result = caseAbstractOperation(featureOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.CREATE_DELETE_OPERATION:
			{
				CreateDeleteOperation createDeleteOperation = (CreateDeleteOperation)theEObject;
				T result = caseCreateDeleteOperation(createDeleteOperation);
				if (result == null) result = caseAbstractOperation(createDeleteOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.ATTRIBUTE_OPERATION:
			{
				AttributeOperation attributeOperation = (AttributeOperation)theEObject;
				T result = caseAttributeOperation(attributeOperation);
				if (result == null) result = caseFeatureOperation(attributeOperation);
				if (result == null) result = caseAbstractOperation(attributeOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.SINGLE_REFERENCE_OPERATION:
			{
				SingleReferenceOperation singleReferenceOperation = (SingleReferenceOperation)theEObject;
				T result = caseSingleReferenceOperation(singleReferenceOperation);
				if (result == null) result = caseReferenceOperation(singleReferenceOperation);
				if (result == null) result = caseFeatureOperation(singleReferenceOperation);
				if (result == null) result = caseAbstractOperation(singleReferenceOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MULTI_REFERENCE_OPERATION:
			{
				MultiReferenceOperation multiReferenceOperation = (MultiReferenceOperation)theEObject;
				T result = caseMultiReferenceOperation(multiReferenceOperation);
				if (result == null) result = caseReferenceOperation(multiReferenceOperation);
				if (result == null) result = caseFeatureOperation(multiReferenceOperation);
				if (result == null) result = caseAbstractOperation(multiReferenceOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION:
			{
				MultiReferenceMoveOperation multiReferenceMoveOperation = (MultiReferenceMoveOperation)theEObject;
				T result = caseMultiReferenceMoveOperation(multiReferenceMoveOperation);
				if (result == null) result = caseFeatureOperation(multiReferenceMoveOperation);
				if (result == null) result = caseAbstractOperation(multiReferenceMoveOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MULTI_ATTRIBUTE_OPERATION:
			{
				MultiAttributeOperation multiAttributeOperation = (MultiAttributeOperation)theEObject;
				T result = caseMultiAttributeOperation(multiAttributeOperation);
				if (result == null) result = caseFeatureOperation(multiAttributeOperation);
				if (result == null) result = caseAbstractOperation(multiAttributeOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.REFERENCE_OPERATION:
			{
				ReferenceOperation referenceOperation = (ReferenceOperation)theEObject;
				T result = caseReferenceOperation(referenceOperation);
				if (result == null) result = caseFeatureOperation(referenceOperation);
				if (result == null) result = caseAbstractOperation(referenceOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.DIAGRAM_LAYOUT_OPERATION:
			{
				DiagramLayoutOperation diagramLayoutOperation = (DiagramLayoutOperation)theEObject;
				T result = caseDiagramLayoutOperation(diagramLayoutOperation);
				if (result == null) result = caseAttributeOperation(diagramLayoutOperation);
				if (result == null) result = caseFeatureOperation(diagramLayoutOperation);
				if (result == null) result = caseAbstractOperation(diagramLayoutOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OperationsPackage.MULTI_ATTRIBUTE_MOVE_OPERATION:
			{
				MultiAttributeMoveOperation multiAttributeMoveOperation = (MultiAttributeMoveOperation)theEObject;
				T result = caseMultiAttributeMoveOperation(multiAttributeMoveOperation);
				if (result == null) result = caseFeatureOperation(multiAttributeMoveOperation);
				if (result == null) result = caseAbstractOperation(multiAttributeMoveOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractOperation(AbstractOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeOperation(CompositeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Operation</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureOperation(FeatureOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Delete Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Delete Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateDeleteOperation(CreateDeleteOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeOperation(AttributeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Reference Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Reference Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleReferenceOperation(SingleReferenceOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Reference Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Reference Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiReferenceOperation(MultiReferenceOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Reference Move Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Reference Move Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiReferenceMoveOperation(MultiReferenceMoveOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Attribute Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Attribute Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiAttributeOperation(MultiAttributeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceOperation(ReferenceOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Layout Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Layout Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramLayoutOperation(DiagramLayoutOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Attribute Move Operation</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Attribute Move Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiAttributeMoveOperation(MultiAttributeMoveOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // OperationsSwitch
