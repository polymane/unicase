/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.change;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.model.ModelPackage;
import org.unicase.model.rationale.RationalePackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.change.ChangeFactory
 * @model kind="package"
 * @generated
 */
public interface ChangePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "change";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/model/change";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.rationale";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	ChangePackage eINSTANCE = org.unicase.model.change.impl.ChangePackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.change.impl.ModelChangePackageImpl <em>Model Change Package</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.model.change.impl.ModelChangePackageImpl
	 * @see org.unicase.model.change.impl.ChangePackageImpl#getModelChangePackage()
	 * @generated
	 */
	int MODEL_CHANGE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__IDENTIFIER = ModelPackage.MODEL_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__NAME = ModelPackage.MODEL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__DESCRIPTION = ModelPackage.MODEL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__CREATOR = ModelPackage.MODEL_ELEMENT__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__CREATION_DATE = ModelPackage.MODEL_ELEMENT__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Last Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__LAST_MODIFIER = ModelPackage.MODEL_ELEMENT__LAST_MODIFIER;

	/**
	 * The feature id for the '<em><b>Last Modified Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__LAST_MODIFIED_DATE = ModelPackage.MODEL_ELEMENT__LAST_MODIFIED_DATE;

	/**
	 * The feature id for the '<em><b>String Reader Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__STRING_READER_INFOS = ModelPackage.MODEL_ELEMENT__STRING_READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__ANNOTATIONS = ModelPackage.MODEL_ELEMENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__INCOMING_DOCUMENT_REFERENCES = ModelPackage.MODEL_ELEMENT__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__LEAF_SECTION = ModelPackage.MODEL_ELEMENT__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__STATE = ModelPackage.MODEL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Source Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__SOURCE_VERSION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE__TARGET_VERSION = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Model Change Package</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_PACKAGE_FEATURE_COUNT = ModelPackage.MODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.model.change.impl.MergingIssueImpl
	 * <em>Merging Issue</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.unicase.model.change.impl.MergingIssueImpl
	 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingIssue()
	 * @generated
	 */
	int MERGING_ISSUE = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__IDENTIFIER = RationalePackage.ISSUE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__NAME = RationalePackage.ISSUE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__DESCRIPTION = RationalePackage.ISSUE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__CREATOR = RationalePackage.ISSUE__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__CREATION_DATE = RationalePackage.ISSUE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Last Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__LAST_MODIFIER = RationalePackage.ISSUE__LAST_MODIFIER;

	/**
	 * The feature id for the '<em><b>Last Modified Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__LAST_MODIFIED_DATE = RationalePackage.ISSUE__LAST_MODIFIED_DATE;

	/**
	 * The feature id for the '<em><b>String Reader Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__STRING_READER_INFOS = RationalePackage.ISSUE__STRING_READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__ANNOTATIONS = RationalePackage.ISSUE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__INCOMING_DOCUMENT_REFERENCES = RationalePackage.ISSUE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__LEAF_SECTION = RationalePackage.ISSUE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__STATE = RationalePackage.ISSUE__STATE;

	/**
	 * The feature id for the '<em><b>Annotated Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__ANNOTATED_MODEL_ELEMENTS = RationalePackage.ISSUE__ANNOTATED_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__CHECKED = RationalePackage.ISSUE__CHECKED;

	/**
	 * The feature id for the '<em><b>Containing Workpackage</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__CONTAINING_WORKPACKAGE = RationalePackage.ISSUE__CONTAINING_WORKPACKAGE;

	/**
	 * The feature id for the '<em><b>Associated Change Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__ASSOCIATED_CHANGE_PACKAGES = RationalePackage.ISSUE__ASSOCIATED_CHANGE_PACKAGES;

	/**
	 * The feature id for the '<em><b>Predecessors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__PREDECESSORS = RationalePackage.ISSUE__PREDECESSORS;

	/**
	 * The feature id for the '<em><b>Successors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__SUCCESSORS = RationalePackage.ISSUE__SUCCESSORS;

	/**
	 * The feature id for the '<em><b>Assignee</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__ASSIGNEE = RationalePackage.ISSUE__ASSIGNEE;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__PARTICIPANTS = RationalePackage.ISSUE__PARTICIPANTS;

	/**
	 * The feature id for the '<em><b>Proposals</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__PROPOSALS = RationalePackage.ISSUE__PROPOSALS;

	/**
	 * The feature id for the '<em><b>Solution</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__SOLUTION = RationalePackage.ISSUE__SOLUTION;

	/**
	 * The feature id for the '<em><b>Criteria</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__CRITERIA = RationalePackage.ISSUE__CRITERIA;

	/**
	 * The feature id for the '<em><b>Refining Issues</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__REFINING_ISSUES = RationalePackage.ISSUE__REFINING_ISSUES;

	/**
	 * The feature id for the '<em><b>Refined Issue</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__REFINED_ISSUE = RationalePackage.ISSUE__REFINED_ISSUE;

	/**
	 * The feature id for the '<em><b>Facilitator</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__FACILITATOR = RationalePackage.ISSUE__FACILITATOR;

	/**
	 * The feature id for the '<em><b>Resolving Revision</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE__RESOLVING_REVISION = RationalePackage.ISSUE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Merging Issue</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_ISSUE_FEATURE_COUNT = RationalePackage.ISSUE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.change.impl.MergingProposalImpl <em>Merging Proposal</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.model.change.impl.MergingProposalImpl
	 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingProposal()
	 * @generated
	 */
	int MERGING_PROPOSAL = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__IDENTIFIER = RationalePackage.PROPOSAL__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__NAME = RationalePackage.PROPOSAL__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__DESCRIPTION = RationalePackage.PROPOSAL__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__CREATOR = RationalePackage.PROPOSAL__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__CREATION_DATE = RationalePackage.PROPOSAL__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Last Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__LAST_MODIFIER = RationalePackage.PROPOSAL__LAST_MODIFIER;

	/**
	 * The feature id for the '<em><b>Last Modified Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__LAST_MODIFIED_DATE = RationalePackage.PROPOSAL__LAST_MODIFIED_DATE;

	/**
	 * The feature id for the '<em><b>String Reader Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__STRING_READER_INFOS = RationalePackage.PROPOSAL__STRING_READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__ANNOTATIONS = RationalePackage.PROPOSAL__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__INCOMING_DOCUMENT_REFERENCES = RationalePackage.PROPOSAL__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__LEAF_SECTION = RationalePackage.PROPOSAL__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__STATE = RationalePackage.PROPOSAL__STATE;

	/**
	 * The feature id for the '<em><b>Assessments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__ASSESSMENTS = RationalePackage.PROPOSAL__ASSESSMENTS;

	/**
	 * The feature id for the '<em><b>Issue</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__ISSUE = RationalePackage.PROPOSAL__ISSUE;

	/**
	 * The feature id for the '<em><b>Conflicting Proposals</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__CONFLICTING_PROPOSALS = RationalePackage.PROPOSAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pending Changes</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL__PENDING_CHANGES = RationalePackage.PROPOSAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Merging Proposal</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_PROPOSAL_FEATURE_COUNT = RationalePackage.PROPOSAL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.change.impl.MergingSolutionImpl <em>Merging Solution</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.model.change.impl.MergingSolutionImpl
	 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingSolution()
	 * @generated
	 */
	int MERGING_SOLUTION = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__IDENTIFIER = RationalePackage.SOLUTION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__NAME = RationalePackage.SOLUTION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__DESCRIPTION = RationalePackage.SOLUTION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__CREATOR = RationalePackage.SOLUTION__CREATOR;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__CREATION_DATE = RationalePackage.SOLUTION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Last Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__LAST_MODIFIER = RationalePackage.SOLUTION__LAST_MODIFIER;

	/**
	 * The feature id for the '<em><b>Last Modified Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__LAST_MODIFIED_DATE = RationalePackage.SOLUTION__LAST_MODIFIED_DATE;

	/**
	 * The feature id for the '<em><b>String Reader Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__STRING_READER_INFOS = RationalePackage.SOLUTION__STRING_READER_INFOS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__ANNOTATIONS = RationalePackage.SOLUTION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__INCOMING_DOCUMENT_REFERENCES = RationalePackage.SOLUTION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__LEAF_SECTION = RationalePackage.SOLUTION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__STATE = RationalePackage.SOLUTION__STATE;

	/**
	 * The feature id for the '<em><b>Underlying Proposals</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__UNDERLYING_PROPOSALS = RationalePackage.SOLUTION__UNDERLYING_PROPOSALS;

	/**
	 * The feature id for the '<em><b>Issue</b></em>' container reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__ISSUE = RationalePackage.SOLUTION__ISSUE;

	/**
	 * The feature id for the '<em><b>Applied Changes</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION__APPLIED_CHANGES = RationalePackage.SOLUTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Merging Solution</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MERGING_SOLUTION_FEATURE_COUNT = RationalePackage.SOLUTION_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.change.ModelChangePackage <em>Model Change Package</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Model Change Package</em>'.
	 * @see org.unicase.model.change.ModelChangePackage
	 * @generated
	 */
	EClass getModelChangePackage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.change.ModelChangePackage#getSourceVersion <em>Source Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Version</em>'.
	 * @see org.unicase.model.change.ModelChangePackage#getSourceVersion()
	 * @see #getModelChangePackage()
	 * @generated
	 */
	EAttribute getModelChangePackage_SourceVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.change.ModelChangePackage#getTargetVersion <em>Target Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Version</em>'.
	 * @see org.unicase.model.change.ModelChangePackage#getTargetVersion()
	 * @see #getModelChangePackage()
	 * @generated
	 */
	EAttribute getModelChangePackage_TargetVersion();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.change.MergingIssue <em>Merging Issue</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Merging Issue</em>'.
	 * @see org.unicase.model.change.MergingIssue
	 * @generated
	 */
	EClass getMergingIssue();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.model.change.MergingIssue#getResolvingRevision
	 * <em>Resolving Revision</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the attribute '<em>Resolving Revision</em>'.
	 * @see org.unicase.model.change.MergingIssue#getResolvingRevision()
	 * @see #getMergingIssue()
	 * @generated
	 */
	EAttribute getMergingIssue_ResolvingRevision();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.change.MergingProposal
	 * <em>Merging Proposal</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Merging Proposal</em>'.
	 * @see org.unicase.model.change.MergingProposal
	 * @generated
	 */
	EClass getMergingProposal();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.change.MergingProposal#getConflictingProposals <em>Conflicting Proposals</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the reference list '<em>Conflicting Proposals</em>'.
	 * @see org.unicase.model.change.MergingProposal#getConflictingProposals()
	 * @see #getMergingProposal()
	 * @generated
	 */
	EReference getMergingProposal_ConflictingProposals();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.change.MergingProposal#getPendingChanges <em>Pending Changes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pending Changes</em>'.
	 * @see org.unicase.model.change.MergingProposal#getPendingChanges()
	 * @see #getMergingProposal()
	 * @generated
	 */
	EReference getMergingProposal_PendingChanges();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.model.change.MergingSolution
	 * <em>Merging Solution</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Merging Solution</em>'.
	 * @see org.unicase.model.change.MergingSolution
	 * @generated
	 */
	EClass getMergingSolution();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.change.MergingSolution#getAppliedChanges <em>Applied Changes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Applied Changes</em>'.
	 * @see org.unicase.model.change.MergingSolution#getAppliedChanges()
	 * @see #getMergingSolution()
	 * @generated
	 */
	EReference getMergingSolution_AppliedChanges();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ChangeFactory getChangeFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
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
		 * The meta object literal for the '{@link org.unicase.model.change.impl.ModelChangePackageImpl <em>Model Change Package</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.change.impl.ModelChangePackageImpl
		 * @see org.unicase.model.change.impl.ChangePackageImpl#getModelChangePackage()
		 * @generated
		 */
		EClass MODEL_CHANGE_PACKAGE = eINSTANCE.getModelChangePackage();

		/**
		 * The meta object literal for the '<em><b>Source Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHANGE_PACKAGE__SOURCE_VERSION = eINSTANCE
				.getModelChangePackage_SourceVersion();

		/**
		 * The meta object literal for the '<em><b>Target Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHANGE_PACKAGE__TARGET_VERSION = eINSTANCE
				.getModelChangePackage_TargetVersion();

		/**
		 * The meta object literal for the '{@link org.unicase.model.change.impl.MergingIssueImpl <em>Merging Issue</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.change.impl.MergingIssueImpl
		 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingIssue()
		 * @generated
		 */
		EClass MERGING_ISSUE = eINSTANCE.getMergingIssue();

		/**
		 * The meta object literal for the '<em><b>Resolving Revision</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MERGING_ISSUE__RESOLVING_REVISION = eINSTANCE
				.getMergingIssue_ResolvingRevision();

		/**
		 * The meta object literal for the '{@link org.unicase.model.change.impl.MergingProposalImpl <em>Merging Proposal</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.change.impl.MergingProposalImpl
		 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingProposal()
		 * @generated
		 */
		EClass MERGING_PROPOSAL = eINSTANCE.getMergingProposal();

		/**
		 * The meta object literal for the '
		 * <em><b>Conflicting Proposals</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MERGING_PROPOSAL__CONFLICTING_PROPOSALS = eINSTANCE
				.getMergingProposal_ConflictingProposals();

		/**
		 * The meta object literal for the '<em><b>Pending Changes</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGING_PROPOSAL__PENDING_CHANGES = eINSTANCE
				.getMergingProposal_PendingChanges();

		/**
		 * The meta object literal for the '{@link org.unicase.model.change.impl.MergingSolutionImpl <em>Merging Solution</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.model.change.impl.MergingSolutionImpl
		 * @see org.unicase.model.change.impl.ChangePackageImpl#getMergingSolution()
		 * @generated
		 */
		EClass MERGING_SOLUTION = eINSTANCE.getMergingSolution();

		/**
		 * The meta object literal for the '<em><b>Applied Changes</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference MERGING_SOLUTION__APPLIED_CHANGES = eINSTANCE
				.getMergingSolution_AppliedChanges();

	}

} // ChangePackage
