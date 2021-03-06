/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.DocumentTemplateFactory
 * @model kind="package"
 * @generated
 */
public interface DocumentTemplatePackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "documentTemplate";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/documentExport/documentTemplate";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.documentExport.documentTemplate";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	DocumentTemplatePackage eINSTANCE = org.unicase.docExport.exportModel.impl.DocumentTemplatePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.docExport.exportModel.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.docExport.exportModel.impl.TemplateImpl
	 * @see org.unicase.docExport.exportModel.impl.DocumentTemplatePackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Model Element Renderer Mapping</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Layout Options</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__LAYOUT_OPTIONS = 1;

	/**
	 * The feature id for the '<em><b>Global Renderer Options</b></em>' containment reference list. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__GLOBAL_RENDERER_OPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__NAME = 3;

	/**
	 * The number of structural features of the '<em>Template</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = 4;

	/**
	 * Returns the meta object for class '{@link org.unicase.docExport.exportModel.Template <em>Template</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.unicase.docExport.exportModel.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.docExport.exportModel.Template#getModelElementRendererMapping
	 * <em>Model Element Renderer Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Model Element Renderer Mapping</em>'.
	 * @see org.unicase.docExport.exportModel.Template#getModelElementRendererMapping()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_ModelElementRendererMapping();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.docExport.exportModel.Template#getLayoutOptions <em>Layout Options</em>}'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Layout Options</em>'.
	 * @see org.unicase.docExport.exportModel.Template#getLayoutOptions()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_LayoutOptions();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.docExport.exportModel.Template#getGlobalRendererOptions <em>Global Renderer Options</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Global Renderer Options</em>'.
	 * @see org.unicase.docExport.exportModel.Template#getGlobalRendererOptions()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_GlobalRendererOptions();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.docExport.exportModel.Template#getName
	 * <em>Name</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.docExport.exportModel.Template#getName()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Name();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DocumentTemplateFactory getDocumentTemplateFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.docExport.exportModel.impl.TemplateImpl
		 * <em>Template</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.docExport.exportModel.impl.TemplateImpl
		 * @see org.unicase.docExport.exportModel.impl.DocumentTemplatePackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Model Element Renderer Mapping</b></em>' containment reference list
		 * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEMPLATE__MODEL_ELEMENT_RENDERER_MAPPING = eINSTANCE.getTemplate_ModelElementRendererMapping();

		/**
		 * The meta object literal for the '<em><b>Layout Options</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEMPLATE__LAYOUT_OPTIONS = eINSTANCE.getTemplate_LayoutOptions();

		/**
		 * The meta object literal for the '<em><b>Global Renderer Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEMPLATE__GLOBAL_RENDERER_OPTIONS = eINSTANCE.getTemplate_GlobalRendererOptions();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TEMPLATE__NAME = eINSTANCE.getTemplate_Name();

	}

} // DocumentTemplatePackage
