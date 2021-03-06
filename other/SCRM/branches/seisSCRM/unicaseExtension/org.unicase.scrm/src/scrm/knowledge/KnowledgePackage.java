/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.knowledge;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import scrm.ScrmPackage;

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
 * @see scrm.knowledge.KnowledgeFactory
 * @model kind="package"
 * @generated
 */
public interface KnowledgePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "knowledge";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/scrm/knowledge";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.scrm.knowledge";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KnowledgePackage eINSTANCE = scrm.knowledge.impl.KnowledgePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link scrm.knowledge.ScientificKnowledge <em>Scientific Knowledge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.ScientificKnowledge
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificKnowledge()
	 * @generated
	 */
	int SCIENTIFIC_KNOWLEDGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__NAME = ScrmPackage.SCRM_MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__DESCRIPTION = ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__ANNOTATIONS = ScrmPackage.SCRM_MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__ATTACHMENTS = ScrmPackage.SCRM_MODEL_ELEMENT__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES = ScrmPackage.SCRM_MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__LEAF_SECTION = ScrmPackage.SCRM_MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__STATE = ScrmPackage.SCRM_MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__COMMENTS = ScrmPackage.SCRM_MODEL_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__CREATION_DATE = ScrmPackage.SCRM_MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__CREATOR = ScrmPackage.SCRM_MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS = ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS;

	/**
	 * The number of structural features of the '<em>Scientific Knowledge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT = ScrmPackage.SCRM_MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.ScientificProblemImpl <em>Scientific Problem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.ScientificProblemImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificProblem()
	 * @generated
	 */
	int SCIENTIFIC_PROBLEM = 1;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.NumericalMethodImpl <em>Numerical Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.NumericalMethodImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getNumericalMethod()
	 * @generated
	 */
	int NUMERICAL_METHOD = 3;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.AssumptionImpl <em>Assumption</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.AssumptionImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getAssumption()
	 * @generated
	 */
	int ASSUMPTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Representing Model</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__REPRESENTING_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Solving Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__SOLVING_METHODS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Influenced Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Scientific Problem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCIENTIFIC_PROBLEM_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl <em>Mathematical Geophysical Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scrm.knowledge.impl.Mathematical_GeophysicalModelImpl
	 * @see scrm.knowledge.impl.KnowledgePackageImpl#getMathematical_GeophysicalModel()
	 * @generated
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Represented Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Refinements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Refined Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Used In Numerical Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Involved Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mathematical Geophysical Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATHEMATICAL_GEOPHYSICAL_MODEL_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Solved Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__SOLVED_PROBLEM = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__DEPENDENCIES = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Realizing Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__REALIZING_REQUIREMENT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Using Mathematical Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__USING_MATHEMATICAL_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Performance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD__PERFORMANCE = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Numerical Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_METHOD_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__NAME = SCIENTIFIC_KNOWLEDGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DESCRIPTION = SCIENTIFIC_KNOWLEDGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__ANNOTATIONS = SCIENTIFIC_KNOWLEDGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__ATTACHMENTS = SCIENTIFIC_KNOWLEDGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__INCOMING_DOCUMENT_REFERENCES = SCIENTIFIC_KNOWLEDGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__LEAF_SECTION = SCIENTIFIC_KNOWLEDGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__STATE = SCIENTIFIC_KNOWLEDGE__STATE;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__COMMENTS = SCIENTIFIC_KNOWLEDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__CREATION_DATE = SCIENTIFIC_KNOWLEDGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__CREATOR = SCIENTIFIC_KNOWLEDGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Displaying Diagrams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DISPLAYING_DIAGRAMS = SCIENTIFIC_KNOWLEDGE__DISPLAYING_DIAGRAMS;

	/**
	 * The feature id for the '<em><b>Depending Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DEPENDING_MODEL = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depending Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION__DEPENDING_METHOD = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assumption</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSUMPTION_FEATURE_COUNT = SCIENTIFIC_KNOWLEDGE_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.ScientificKnowledge <em>Scientific Knowledge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scientific Knowledge</em>'.
	 * @see scrm.knowledge.ScientificKnowledge
	 * @generated
	 */
	EClass getScientificKnowledge();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.ScientificProblem <em>Scientific Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scientific Problem</em>'.
	 * @see scrm.knowledge.ScientificProblem
	 * @generated
	 */
	EClass getScientificProblem();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.ScientificProblem#getRepresentingModel <em>Representing Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Representing Model</em>'.
	 * @see scrm.knowledge.ScientificProblem#getRepresentingModel()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_RepresentingModel();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.ScientificProblem#getSolvingMethods <em>Solving Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Solving Methods</em>'.
	 * @see scrm.knowledge.ScientificProblem#getSolvingMethods()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_SolvingMethods();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.ScientificProblem#getInfluencedFeature <em>Influenced Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Influenced Feature</em>'.
	 * @see scrm.knowledge.ScientificProblem#getInfluencedFeature()
	 * @see #getScientificProblem()
	 * @generated
	 */
	EReference getScientificProblem_InfluencedFeature();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.Mathematical_GeophysicalModel <em>Mathematical Geophysical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mathematical Geophysical Model</em>'.
	 * @see scrm.knowledge.Mathematical_GeophysicalModel
	 * @generated
	 */
	EClass getMathematical_GeophysicalModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Mathematical_GeophysicalModel#getRepresentedProblem <em>Represented Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Represented Problem</em>'.
	 * @see scrm.knowledge.Mathematical_GeophysicalModel#getRepresentedProblem()
	 * @see #getMathematical_GeophysicalModel()
	 * @generated
	 */
	EReference getMathematical_GeophysicalModel_RepresentedProblem();

	/**
	 * Returns the meta object for the containment reference list '{@link scrm.knowledge.Mathematical_GeophysicalModel#getRefinements <em>Refinements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Refinements</em>'.
	 * @see scrm.knowledge.Mathematical_GeophysicalModel#getRefinements()
	 * @see #getMathematical_GeophysicalModel()
	 * @generated
	 */
	EReference getMathematical_GeophysicalModel_Refinements();

	/**
	 * Returns the meta object for the container reference '{@link scrm.knowledge.Mathematical_GeophysicalModel#getRefinedModel <em>Refined Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Refined Model</em>'.
	 * @see scrm.knowledge.Mathematical_GeophysicalModel#getRefinedModel()
	 * @see #getMathematical_GeophysicalModel()
	 * @generated
	 */
	EReference getMathematical_GeophysicalModel_RefinedModel();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.Mathematical_GeophysicalModel#getUsedInNumericalMethods <em>Used In Numerical Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used In Numerical Methods</em>'.
	 * @see scrm.knowledge.Mathematical_GeophysicalModel#getUsedInNumericalMethods()
	 * @see #getMathematical_GeophysicalModel()
	 * @generated
	 */
	EReference getMathematical_GeophysicalModel_UsedInNumericalMethods();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.Mathematical_GeophysicalModel#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see scrm.knowledge.Mathematical_GeophysicalModel#getDependencies()
	 * @see #getMathematical_GeophysicalModel()
	 * @generated
	 */
	EReference getMathematical_GeophysicalModel_Dependencies();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.Mathematical_GeophysicalModel#getInvolvedData <em>Involved Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Involved Data</em>'.
	 * @see scrm.knowledge.Mathematical_GeophysicalModel#getInvolvedData()
	 * @see #getMathematical_GeophysicalModel()
	 * @generated
	 */
	EReference getMathematical_GeophysicalModel_InvolvedData();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.NumericalMethod <em>Numerical Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Method</em>'.
	 * @see scrm.knowledge.NumericalMethod
	 * @generated
	 */
	EClass getNumericalMethod();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getSolvedProblem <em>Solved Problem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Solved Problem</em>'.
	 * @see scrm.knowledge.NumericalMethod#getSolvedProblem()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_SolvedProblem();

	/**
	 * Returns the meta object for the reference list '{@link scrm.knowledge.NumericalMethod#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependencies</em>'.
	 * @see scrm.knowledge.NumericalMethod#getDependencies()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_Dependencies();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getRealizingRequirement <em>Realizing Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Realizing Requirement</em>'.
	 * @see scrm.knowledge.NumericalMethod#getRealizingRequirement()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_RealizingRequirement();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getUsingMathematicalModel <em>Using Mathematical Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Using Mathematical Model</em>'.
	 * @see scrm.knowledge.NumericalMethod#getUsingMathematicalModel()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_UsingMathematicalModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.NumericalMethod#getPerformance <em>Performance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Performance</em>'.
	 * @see scrm.knowledge.NumericalMethod#getPerformance()
	 * @see #getNumericalMethod()
	 * @generated
	 */
	EReference getNumericalMethod_Performance();

	/**
	 * Returns the meta object for class '{@link scrm.knowledge.Assumption <em>Assumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assumption</em>'.
	 * @see scrm.knowledge.Assumption
	 * @generated
	 */
	EClass getAssumption();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Assumption#getDependingModel <em>Depending Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depending Model</em>'.
	 * @see scrm.knowledge.Assumption#getDependingModel()
	 * @see #getAssumption()
	 * @generated
	 */
	EReference getAssumption_DependingModel();

	/**
	 * Returns the meta object for the reference '{@link scrm.knowledge.Assumption#getDependingMethod <em>Depending Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Depending Method</em>'.
	 * @see scrm.knowledge.Assumption#getDependingMethod()
	 * @see #getAssumption()
	 * @generated
	 */
	EReference getAssumption_DependingMethod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KnowledgeFactory getKnowledgeFactory();

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
		 * The meta object literal for the '{@link scrm.knowledge.ScientificKnowledge <em>Scientific Knowledge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.ScientificKnowledge
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificKnowledge()
		 * @generated
		 */
		EClass SCIENTIFIC_KNOWLEDGE = eINSTANCE.getScientificKnowledge();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.ScientificProblemImpl <em>Scientific Problem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.ScientificProblemImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getScientificProblem()
		 * @generated
		 */
		EClass SCIENTIFIC_PROBLEM = eINSTANCE.getScientificProblem();

		/**
		 * The meta object literal for the '<em><b>Representing Model</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__REPRESENTING_MODEL = eINSTANCE
				.getScientificProblem_RepresentingModel();

		/**
		 * The meta object literal for the '<em><b>Solving Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__SOLVING_METHODS = eINSTANCE
				.getScientificProblem_SolvingMethods();

		/**
		 * The meta object literal for the '<em><b>Influenced Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCIENTIFIC_PROBLEM__INFLUENCED_FEATURE = eINSTANCE
				.getScientificProblem_InfluencedFeature();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.Mathematical_GeophysicalModelImpl <em>Mathematical Geophysical Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.Mathematical_GeophysicalModelImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getMathematical_GeophysicalModel()
		 * @generated
		 */
		EClass MATHEMATICAL_GEOPHYSICAL_MODEL = eINSTANCE
				.getMathematical_GeophysicalModel();

		/**
		 * The meta object literal for the '<em><b>Represented Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_GEOPHYSICAL_MODEL__REPRESENTED_PROBLEM = eINSTANCE
				.getMathematical_GeophysicalModel_RepresentedProblem();

		/**
		 * The meta object literal for the '<em><b>Refinements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_GEOPHYSICAL_MODEL__REFINEMENTS = eINSTANCE
				.getMathematical_GeophysicalModel_Refinements();

		/**
		 * The meta object literal for the '<em><b>Refined Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_GEOPHYSICAL_MODEL__REFINED_MODEL = eINSTANCE
				.getMathematical_GeophysicalModel_RefinedModel();

		/**
		 * The meta object literal for the '<em><b>Used In Numerical Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_GEOPHYSICAL_MODEL__USED_IN_NUMERICAL_METHODS = eINSTANCE
				.getMathematical_GeophysicalModel_UsedInNumericalMethods();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_GEOPHYSICAL_MODEL__DEPENDENCIES = eINSTANCE
				.getMathematical_GeophysicalModel_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Involved Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATHEMATICAL_GEOPHYSICAL_MODEL__INVOLVED_DATA = eINSTANCE
				.getMathematical_GeophysicalModel_InvolvedData();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.NumericalMethodImpl <em>Numerical Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.NumericalMethodImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getNumericalMethod()
		 * @generated
		 */
		EClass NUMERICAL_METHOD = eINSTANCE.getNumericalMethod();

		/**
		 * The meta object literal for the '<em><b>Solved Problem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__SOLVED_PROBLEM = eINSTANCE
				.getNumericalMethod_SolvedProblem();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__DEPENDENCIES = eINSTANCE
				.getNumericalMethod_Dependencies();

		/**
		 * The meta object literal for the '<em><b>Realizing Requirement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__REALIZING_REQUIREMENT = eINSTANCE
				.getNumericalMethod_RealizingRequirement();

		/**
		 * The meta object literal for the '<em><b>Using Mathematical Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__USING_MATHEMATICAL_MODEL = eINSTANCE
				.getNumericalMethod_UsingMathematicalModel();

		/**
		 * The meta object literal for the '<em><b>Performance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_METHOD__PERFORMANCE = eINSTANCE
				.getNumericalMethod_Performance();

		/**
		 * The meta object literal for the '{@link scrm.knowledge.impl.AssumptionImpl <em>Assumption</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scrm.knowledge.impl.AssumptionImpl
		 * @see scrm.knowledge.impl.KnowledgePackageImpl#getAssumption()
		 * @generated
		 */
		EClass ASSUMPTION = eINSTANCE.getAssumption();

		/**
		 * The meta object literal for the '<em><b>Depending Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSUMPTION__DEPENDING_MODEL = eINSTANCE
				.getAssumption_DependingModel();

		/**
		 * The meta object literal for the '<em><b>Depending Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSUMPTION__DEPENDING_METHOD = eINSTANCE
				.getAssumption_DependingMethod();

	}

} //KnowledgePackage
