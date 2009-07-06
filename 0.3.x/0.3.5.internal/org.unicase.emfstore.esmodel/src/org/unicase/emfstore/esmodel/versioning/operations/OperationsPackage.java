/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.operations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/*
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul> <li>each class,</li> <li>each feature of each class,</li> <li>each enum,</li> <li>and each data type</li> </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory
 * @model kind="package"
 * @generated
 */
public interface OperationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "operations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versioning/operations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.versioning.operations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	OperationsPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl <em>Abstract Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAbstractOperation()
	 * @generated
	 */
	int ABSTRACT_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__MODEL_ELEMENT_ID = 2;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__ACCEPTED = 3;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION__CLIENT_DATE = 4;

	/**
	 * The number of structural features of the '<em>Abstract Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_OPERATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl <em>Composite Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCompositeOperation()
	 * @generated
	 */
	int COMPOSITE_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__NAME = ABSTRACT_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__DESCRIPTION = ABSTRACT_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__MODEL_ELEMENT_ID = ABSTRACT_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__ACCEPTED = ABSTRACT_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__CLIENT_DATE = ABSTRACT_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__SUB_OPERATIONS = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Composite Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__COMPOSITE_NAME = ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composite Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION = ABSTRACT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reversed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION__REVERSED = ABSTRACT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Composite Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl <em>Feature Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getFeatureOperation()
	 * @generated
	 */
	int FEATURE_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__NAME = ABSTRACT_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__DESCRIPTION = ABSTRACT_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__MODEL_ELEMENT_ID = ABSTRACT_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__ACCEPTED = ABSTRACT_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__CLIENT_DATE = ABSTRACT_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__FEATURE_NAME = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl <em>Create Delete Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCreateDeleteOperation()
	 * @generated
	 */
	int CREATE_DELETE_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__NAME = ABSTRACT_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__DESCRIPTION = ABSTRACT_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__MODEL_ELEMENT_ID = ABSTRACT_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__ACCEPTED = ABSTRACT_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__CLIENT_DATE = ABSTRACT_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Delete</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__DELETE = ABSTRACT_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Element</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__MODEL_ELEMENT = ABSTRACT_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sub Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION__SUB_OPERATIONS = ABSTRACT_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Create Delete Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREATE_DELETE_OPERATION_FEATURE_COUNT = ABSTRACT_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AttributeOperationImpl <em>Attribute Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AttributeOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAttributeOperation()
	 * @generated
	 */
	int ATTRIBUTE_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__OLD_VALUE = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION__NEW_VALUE = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.ReferenceOperationImpl <em>Reference Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.ReferenceOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getReferenceOperation()
	 * @generated
	 */
	int REFERENCE_OPERATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__BIDIRECTIONAL = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Reference Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.SingleReferenceOperationImpl <em>Single Reference Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.SingleReferenceOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getSingleReferenceOperation()
	 * @generated
	 */
	int SINGLE_REFERENCE_OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__NAME = REFERENCE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__DESCRIPTION = REFERENCE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__MODEL_ELEMENT_ID = REFERENCE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__ACCEPTED = REFERENCE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__CLIENT_DATE = REFERENCE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__FEATURE_NAME = REFERENCE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__BIDIRECTIONAL = REFERENCE_OPERATION__BIDIRECTIONAL;

	/**
	 * The feature id for the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__OLD_VALUE = REFERENCE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION__NEW_VALUE = REFERENCE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Single Reference Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_REFERENCE_OPERATION_FEATURE_COUNT = REFERENCE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl <em>Multi Reference Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceOperation()
	 * @generated
	 */
	int MULTI_REFERENCE_OPERATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__NAME = REFERENCE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__DESCRIPTION = REFERENCE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__MODEL_ELEMENT_ID = REFERENCE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__ACCEPTED = REFERENCE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__CLIENT_DATE = REFERENCE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__FEATURE_NAME = REFERENCE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Bidirectional</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__BIDIRECTIONAL = REFERENCE_OPERATION__BIDIRECTIONAL;

	/**
	 * The feature id for the '<em><b>Opposite Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__ADD = REFERENCE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__INDEX = REFERENCE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Model Elements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS = REFERENCE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Reference Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_OPERATION_FEATURE_COUNT = REFERENCE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceMoveOperationImpl <em>Multi Reference Move Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceMoveOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceMoveOperation()
	 * @generated
	 */
	int MULTI_REFERENCE_MOVE_OPERATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referenced Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Reference Move Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REFERENCE_MOVE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeOperationImpl <em>Multi Attribute Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeOperation()
	 * @generated
	 */
	int MULTI_ATTRIBUTE_OPERATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__ADD = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__INDEX = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION__VALUES = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multi Attribute Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.DiagramLayoutOperationImpl <em>Diagram Layout Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.DiagramLayoutOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getDiagramLayoutOperation()
	 * @generated
	 */
	int DIAGRAM_LAYOUT_OPERATION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__NAME = ATTRIBUTE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__DESCRIPTION = ATTRIBUTE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__MODEL_ELEMENT_ID = ATTRIBUTE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__ACCEPTED = ATTRIBUTE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__CLIENT_DATE = ATTRIBUTE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__FEATURE_NAME = ATTRIBUTE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__OLD_VALUE = ATTRIBUTE_OPERATION__OLD_VALUE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION__NEW_VALUE = ATTRIBUTE_OPERATION__NEW_VALUE;

	/**
	 * The number of structural features of the '<em>Diagram Layout Operation</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGRAM_LAYOUT_OPERATION_FEATURE_COUNT = ATTRIBUTE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeMoveOperationImpl <em>Multi Attribute Move Operation</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeMoveOperationImpl
	 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeMoveOperation()
	 * @generated
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__NAME = FEATURE_OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__DESCRIPTION = FEATURE_OPERATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Model Element Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__MODEL_ELEMENT_ID = FEATURE_OPERATION__MODEL_ELEMENT_ID;

	/**
	 * The feature id for the '<em><b>Accepted</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__ACCEPTED = FEATURE_OPERATION__ACCEPTED;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__CLIENT_DATE = FEATURE_OPERATION__CLIENT_DATE;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__FEATURE_NAME = FEATURE_OPERATION__FEATURE_NAME;

	/**
	 * The feature id for the '<em><b>Old Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Index</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX = FEATURE_OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multi Attribute Move Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_ATTRIBUTE_MOVE_OPERATION_FEATURE_COUNT = FEATURE_OPERATION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation <em>Abstract Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation
	 * @generated
	 */
	EClass getAbstractOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getName()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getDescription()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getModelElementId <em>Model Element Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Element Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getModelElementId()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EReference getAbstractOperation_ModelElementId();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#isAccepted <em>Accepted</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Accepted</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#isAccepted()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_Accepted();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getClientDate <em>Client Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Client Date</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation#getClientDate()
	 * @see #getAbstractOperation()
	 * @generated
	 */
	EAttribute getAbstractOperation_ClientDate();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation <em>Composite Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation
	 * @generated
	 */
	EClass getCompositeOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getSubOperations <em>Sub Operations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Operations</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getSubOperations()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EReference getCompositeOperation_SubOperations();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeName <em>Composite Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composite Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeName()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_CompositeName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeDescription <em>Composite Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composite Description</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#getCompositeDescription()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_CompositeDescription();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#isReversed <em>Reversed</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Reversed</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation#isReversed()
	 * @see #getCompositeOperation()
	 * @generated
	 */
	EAttribute getCompositeOperation_Reversed();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation <em>Feature Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation
	 * @generated
	 */
	EClass getFeatureOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.FeatureOperation#getFeatureName()
	 * @see #getFeatureOperation()
	 * @generated
	 */
	EAttribute getFeatureOperation_FeatureName();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation <em>Create Delete Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Create Delete Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation
	 * @generated
	 */
	EClass getCreateDeleteOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#isDelete <em>Delete</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Delete</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#isDelete()
	 * @see #getCreateDeleteOperation()
	 * @generated
	 */
	EAttribute getCreateDeleteOperation_Delete();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model Element</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getModelElement()
	 * @see #getCreateDeleteOperation()
	 * @generated
	 */
	EReference getCreateDeleteOperation_ModelElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getSubOperations <em>Sub Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Operations</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation#getSubOperations()
	 * @see #getCreateDeleteOperation()
	 * @generated
	 */
	EReference getCreateDeleteOperation_SubOperations();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation <em>Attribute Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation
	 * @generated
	 */
	EClass getAttributeOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getOldValue()
	 * @see #getAttributeOperation()
	 * @generated
	 */
	EAttribute getAttributeOperation_OldValue();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation#getNewValue()
	 * @see #getAttributeOperation()
	 * @generated
	 */
	EAttribute getAttributeOperation_NewValue();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation <em>Single Reference Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Reference Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation
	 * @generated
	 */
	EClass getSingleReferenceOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Old Value</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation#getOldValue()
	 * @see #getSingleReferenceOperation()
	 * @generated
	 */
	EReference getSingleReferenceOperation_OldValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Value</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation#getNewValue()
	 * @see #getSingleReferenceOperation()
	 * @generated
	 */
	EReference getSingleReferenceOperation_NewValue();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation <em>Multi Reference Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Reference Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation
	 * @generated
	 */
	EClass getMultiReferenceOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#isAdd <em>Add</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Add</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#isAdd()
	 * @see #getMultiReferenceOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceOperation_Add();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getIndex <em>Index</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getIndex()
	 * @see #getMultiReferenceOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceOperation_Index();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getReferencedModelElements <em>Referenced Model Elements</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Referenced Model Elements</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation#getReferencedModelElements()
	 * @see #getMultiReferenceOperation()
	 * @generated
	 */
	EReference getMultiReferenceOperation_ReferencedModelElements();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation <em>Multi Reference Move Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Reference Move Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation
	 * @generated
	 */
	EClass getMultiReferenceMoveOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getOldIndex <em>Old Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Index</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getOldIndex()
	 * @see #getMultiReferenceMoveOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceMoveOperation_OldIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getNewIndex <em>New Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Index</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getNewIndex()
	 * @see #getMultiReferenceMoveOperation()
	 * @generated
	 */
	EAttribute getMultiReferenceMoveOperation_NewIndex();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getReferencedModelElementId <em>Referenced Model Element Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Referenced Model Element Id</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceMoveOperation#getReferencedModelElementId()
	 * @see #getMultiReferenceMoveOperation()
	 * @generated
	 */
	EReference getMultiReferenceMoveOperation_ReferencedModelElementId();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation <em>Multi Attribute Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Attribute Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation
	 * @generated
	 */
	EClass getMultiAttributeOperation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#isAdd <em>Add</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Add</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#isAdd()
	 * @see #getMultiAttributeOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeOperation_Add();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#getIndex <em>Index</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#getIndex()
	 * @see #getMultiAttributeOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeOperation_Index();

	/**
	 * Returns the meta object for the attribute list '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation#getValues()
	 * @see #getMultiAttributeOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeOperation_Values();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation <em>Reference Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation
	 * @generated
	 */
	EClass getReferenceOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#isBidirectional <em>Bidirectional</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bidirectional</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#isBidirectional()
	 * @see #getReferenceOperation()
	 * @generated
	 */
	EAttribute getReferenceOperation_Bidirectional();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getOppositeFeatureName <em>Opposite Feature Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite Feature Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation#getOppositeFeatureName()
	 * @see #getReferenceOperation()
	 * @generated
	 */
	EAttribute getReferenceOperation_OppositeFeatureName();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation <em>Diagram Layout Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram Layout Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.DiagramLayoutOperation
	 * @generated
	 */
	EClass getDiagramLayoutOperation();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation <em>Multi Attribute Move Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Attribute Move Operation</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation
	 * @generated
	 */
	EClass getMultiAttributeMoveOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation#getOldIndex <em>Old Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Index</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation#getOldIndex()
	 * @see #getMultiAttributeMoveOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeMoveOperation_OldIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation#getNewIndex <em>New Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Index</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeMoveOperation#getNewIndex()
	 * @see #getMultiAttributeMoveOperation()
	 * @generated
	 */
	EAttribute getMultiAttributeMoveOperation_NewIndex();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OperationsFactory getOperationsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl <em>Abstract Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AbstractOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAbstractOperation()
		 * @generated
		 */
		EClass ABSTRACT_OPERATION = eINSTANCE.getAbstractOperation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__NAME = eINSTANCE.getAbstractOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__DESCRIPTION = eINSTANCE.getAbstractOperation_Description();

		/**
		 * The meta object literal for the '<em><b>Model Element Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ABSTRACT_OPERATION__MODEL_ELEMENT_ID = eINSTANCE.getAbstractOperation_ModelElementId();

		/**
		 * The meta object literal for the '<em><b>Accepted</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__ACCEPTED = eINSTANCE.getAbstractOperation_Accepted();

		/**
		 * The meta object literal for the '<em><b>Client Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_OPERATION__CLIENT_DATE = eINSTANCE.getAbstractOperation_ClientDate();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl <em>Composite Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CompositeOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCompositeOperation()
		 * @generated
		 */
		EClass COMPOSITE_OPERATION = eINSTANCE.getCompositeOperation();

		/**
		 * The meta object literal for the '<em><b>Sub Operations</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COMPOSITE_OPERATION__SUB_OPERATIONS = eINSTANCE.getCompositeOperation_SubOperations();

		/**
		 * The meta object literal for the '<em><b>Composite Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__COMPOSITE_NAME = eINSTANCE.getCompositeOperation_CompositeName();

		/**
		 * The meta object literal for the '<em><b>Composite Description</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__COMPOSITE_DESCRIPTION = eINSTANCE.getCompositeOperation_CompositeDescription();

		/**
		 * The meta object literal for the '<em><b>Reversed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITE_OPERATION__REVERSED = eINSTANCE.getCompositeOperation_Reversed();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl <em>Feature Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.FeatureOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getFeatureOperation()
		 * @generated
		 */
		EClass FEATURE_OPERATION = eINSTANCE.getFeatureOperation();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_OPERATION__FEATURE_NAME = eINSTANCE.getFeatureOperation_FeatureName();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl <em>Create Delete Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.CreateDeleteOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getCreateDeleteOperation()
		 * @generated
		 */
		EClass CREATE_DELETE_OPERATION = eINSTANCE.getCreateDeleteOperation();

		/**
		 * The meta object literal for the '<em><b>Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CREATE_DELETE_OPERATION__DELETE = eINSTANCE.getCreateDeleteOperation_Delete();

		/**
		 * The meta object literal for the '<em><b>Model Element</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CREATE_DELETE_OPERATION__MODEL_ELEMENT = eINSTANCE.getCreateDeleteOperation_ModelElement();

		/**
		 * The meta object literal for the '<em><b>Sub Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CREATE_DELETE_OPERATION__SUB_OPERATIONS = eINSTANCE.getCreateDeleteOperation_SubOperations();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.AttributeOperationImpl <em>Attribute Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.AttributeOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getAttributeOperation()
		 * @generated
		 */
		EClass ATTRIBUTE_OPERATION = eINSTANCE.getAttributeOperation();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPERATION__OLD_VALUE = eINSTANCE.getAttributeOperation_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_OPERATION__NEW_VALUE = eINSTANCE.getAttributeOperation_NewValue();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.SingleReferenceOperationImpl <em>Single Reference Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.SingleReferenceOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getSingleReferenceOperation()
		 * @generated
		 */
		EClass SINGLE_REFERENCE_OPERATION = eINSTANCE.getSingleReferenceOperation();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SINGLE_REFERENCE_OPERATION__OLD_VALUE = eINSTANCE.getSingleReferenceOperation_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SINGLE_REFERENCE_OPERATION__NEW_VALUE = eINSTANCE.getSingleReferenceOperation_NewValue();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl <em>Multi Reference Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceOperation()
		 * @generated
		 */
		EClass MULTI_REFERENCE_OPERATION = eINSTANCE.getMultiReferenceOperation();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_OPERATION__ADD = eINSTANCE.getMultiReferenceOperation_Add();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_OPERATION__INDEX = eINSTANCE.getMultiReferenceOperation_Index();

		/**
		 * The meta object literal for the '<em><b>Referenced Model Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_REFERENCE_OPERATION__REFERENCED_MODEL_ELEMENTS = eINSTANCE
			.getMultiReferenceOperation_ReferencedModelElements();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceMoveOperationImpl <em>Multi Reference Move Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiReferenceMoveOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiReferenceMoveOperation()
		 * @generated
		 */
		EClass MULTI_REFERENCE_MOVE_OPERATION = eINSTANCE.getMultiReferenceMoveOperation();

		/**
		 * The meta object literal for the '<em><b>Old Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_MOVE_OPERATION__OLD_INDEX = eINSTANCE.getMultiReferenceMoveOperation_OldIndex();

		/**
		 * The meta object literal for the '<em><b>New Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_REFERENCE_MOVE_OPERATION__NEW_INDEX = eINSTANCE.getMultiReferenceMoveOperation_NewIndex();

		/**
		 * The meta object literal for the '<em><b>Referenced Model Element Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_REFERENCE_MOVE_OPERATION__REFERENCED_MODEL_ELEMENT_ID = eINSTANCE
			.getMultiReferenceMoveOperation_ReferencedModelElementId();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeOperationImpl <em>Multi Attribute Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeOperation()
		 * @generated
		 */
		EClass MULTI_ATTRIBUTE_OPERATION = eINSTANCE.getMultiAttributeOperation();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_OPERATION__ADD = eINSTANCE.getMultiAttributeOperation_Add();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_OPERATION__INDEX = eINSTANCE.getMultiAttributeOperation_Index();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_OPERATION__VALUES = eINSTANCE.getMultiAttributeOperation_Values();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.ReferenceOperationImpl <em>Reference Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.ReferenceOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getReferenceOperation()
		 * @generated
		 */
		EClass REFERENCE_OPERATION = eINSTANCE.getReferenceOperation();

		/**
		 * The meta object literal for the '<em><b>Bidirectional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_OPERATION__BIDIRECTIONAL = eINSTANCE.getReferenceOperation_Bidirectional();

		/**
		 * The meta object literal for the '<em><b>Opposite Feature Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REFERENCE_OPERATION__OPPOSITE_FEATURE_NAME = eINSTANCE.getReferenceOperation_OppositeFeatureName();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.DiagramLayoutOperationImpl <em>Diagram Layout Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.DiagramLayoutOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getDiagramLayoutOperation()
		 * @generated
		 */
		EClass DIAGRAM_LAYOUT_OPERATION = eINSTANCE.getDiagramLayoutOperation();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeMoveOperationImpl <em>Multi Attribute Move Operation</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.MultiAttributeMoveOperationImpl
		 * @see org.unicase.emfstore.esmodel.versioning.operations.impl.OperationsPackageImpl#getMultiAttributeMoveOperation()
		 * @generated
		 */
		EClass MULTI_ATTRIBUTE_MOVE_OPERATION = eINSTANCE.getMultiAttributeMoveOperation();

		/**
		 * The meta object literal for the '<em><b>Old Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_MOVE_OPERATION__OLD_INDEX = eINSTANCE.getMultiAttributeMoveOperation_OldIndex();

		/**
		 * The meta object literal for the '<em><b>New Index</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_ATTRIBUTE_MOVE_OPERATION__NEW_INDEX = eINSTANCE.getMultiAttributeMoveOperation_NewIndex();

	}

} // OperationsPackage
