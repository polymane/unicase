/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.diagram;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.unicase.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.diagram.DiagramFactory
 * @model kind="package"
 * @generated
 */
public interface DiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/diagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.diagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramPackage eINSTANCE = org.unicase.model.diagram.impl.DiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.diagram.impl.MEDiagramImpl <em>ME Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.diagram.impl.MEDiagramImpl
	 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMEDiagram()
	 * @generated
	 */
	int ME_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Reader Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__READER_INFOS = ModelPackage.MODEL_ELEMENT__READER_INFOS;

	/**
	 * The feature id for the '<em><b>Action Items</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__ACTION_ITEMS = ModelPackage.MODEL_ELEMENT__ACTION_ITEMS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__ELEMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Gmfdiagram</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__GMFDIAGRAM = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>New Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM__NEW_ELEMENTS = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>ME Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ME_DIAGRAM_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.unicase.model.diagram.MEDiagram <em>ME Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ME Diagram</em>'.
	 * @see org.unicase.model.diagram.MEDiagram
	 * @generated
	 */
	EClass getMEDiagram();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.diagram.MEDiagram#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Elements</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getElements()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.model.diagram.MEDiagram#getGmfdiagram <em>Gmfdiagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gmfdiagram</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getGmfdiagram()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_Gmfdiagram();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.model.diagram.MEDiagram#getNewElements <em>New Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Elements</em>'.
	 * @see org.unicase.model.diagram.MEDiagram#getNewElements()
	 * @see #getMEDiagram()
	 * @generated
	 */
	EReference getMEDiagram_NewElements();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagramFactory getDiagramFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.diagram.impl.MEDiagramImpl <em>ME Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.diagram.impl.MEDiagramImpl
		 * @see org.unicase.model.diagram.impl.DiagramPackageImpl#getMEDiagram()
		 * @generated
		 */
		EClass ME_DIAGRAM = eINSTANCE.getMEDiagram();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ME_DIAGRAM__ELEMENTS = eINSTANCE.getMEDiagram_Elements();

		/**
		 * The meta object literal for the '<em><b>Gmfdiagram</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ME_DIAGRAM__GMFDIAGRAM = eINSTANCE.getMEDiagram_Gmfdiagram();

		/**
		 * The meta object literal for the '<em><b>New Elements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ME_DIAGRAM__NEW_ELEMENTS = eINSTANCE.getMEDiagram_NewElements();

	}

} //DiagramPackage
