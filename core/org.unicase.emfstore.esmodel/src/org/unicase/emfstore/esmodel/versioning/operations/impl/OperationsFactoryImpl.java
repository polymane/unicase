/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation;
import org.unicase.emfstore.esmodel.versioning.operations.ModelElementGroup;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationGroup;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsPackage;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class OperationsFactoryImpl extends EFactoryImpl implements OperationsFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static OperationsFactory init() {
		try {
			OperationsFactory theOperationsFactory = (OperationsFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/esmodel/versioning/operations");
			if (theOperationsFactory != null) {
				return theOperationsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OperationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case OperationsPackage.COMPOSITE_OPERATION:
			return createCompositeOperation();
		case OperationsPackage.CREATE_DELETE_OPERATION:
			return createCreateDeleteOperation();
		case OperationsPackage.ATTRIBUTE_OPERATION:
			return createAttributeOperation();
		case OperationsPackage.SINGLE_REFERENCE_OPERATION:
			return createSingleReferenceOperation();
		case OperationsPackage.MULTI_REFERENCE_OPERATION:
			return createMultiReferenceOperation();
		case OperationsPackage.MULTI_REFERENCE_MOVE_OPERATION:
			return createMultiReferenceMoveOperation();
		case OperationsPackage.DIAGRAM_LAYOUT_OPERATION:
			return createDiagramLayoutOperation();
		case OperationsPackage.OPERATION_ID:
			return createOperationId();
		case OperationsPackage.OPERATION_GROUP:
			return createOperationGroup();
		case OperationsPackage.MODEL_ELEMENT_GROUP:
			return createModelElementGroup();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CompositeOperation createCompositeOperation() {
		CompositeOperationImpl compositeOperation = new CompositeOperationImpl();
		return compositeOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CreateDeleteOperation createCreateDeleteOperation() {
		CreateDeleteOperationImpl createDeleteOperation = new CreateDeleteOperationImpl();
		return createDeleteOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AttributeOperation createAttributeOperation() {
		AttributeOperationImpl attributeOperation = new AttributeOperationImpl();
		return attributeOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SingleReferenceOperation createSingleReferenceOperation() {
		SingleReferenceOperationImpl singleReferenceOperation = new SingleReferenceOperationImpl();
		return singleReferenceOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiReferenceOperation createMultiReferenceOperation() {
		MultiReferenceOperationImpl multiReferenceOperation = new MultiReferenceOperationImpl();
		return multiReferenceOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MultiReferenceMoveOperation createMultiReferenceMoveOperation() {
		MultiReferenceMoveOperationImpl multiReferenceMoveOperation = new MultiReferenceMoveOperationImpl();
		return multiReferenceMoveOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramLayoutOperation createDiagramLayoutOperation() {
		DiagramLayoutOperationImpl diagramLayoutOperation = new DiagramLayoutOperationImpl();
		return diagramLayoutOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationId createOperationId() {
		OperationIdImpl operationId = new OperationIdImpl();
		return operationId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationGroup createOperationGroup() {
		OperationGroupImpl operationGroup = new OperationGroupImpl();
		return operationGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElementGroup createModelElementGroup() {
		ModelElementGroupImpl modelElementGroup = new ModelElementGroupImpl();
		return modelElementGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationsPackage getOperationsPackage() {
		return (OperationsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OperationsPackage getPackage() {
		return OperationsPackage.eINSTANCE;
	}

} // OperationsFactoryImpl
