/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.versioning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.unicase.emfstore.esmodel.versioning.VersioningFactory
 * @model kind="package"
 * @generated
 */
public interface VersioningPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "versioning";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/versioning";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.versioning";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VersioningPackage eINSTANCE = org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.VersionSpec <em>Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.VersionSpec
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getVersionSpec()
	 * @generated
	 */
	int VERSION_SPEC = 3;

	/**
	 * The number of structural features of the '<em>Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.TagVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getTagVersionSpec()
	 * @generated
	 */
	int TAG_VERSION_SPEC = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC__NAME = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tag Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.DateVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getDateVersionSpec()
	 * @generated
	 */
	int DATE_VERSION_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC__DATE = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Date Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.PrimaryVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getPrimaryVersionSpec()
	 * @generated
	 */
	int PRIMARY_VERSION_SPEC = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_VERSION_SPEC__IDENTIFIER = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primary Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.LogMessageImpl <em>Log Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.LogMessageImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getLogMessage()
	 * @generated
	 */
	int LOG_MESSAGE = 4;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__DATE = 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__AUTHOR = 2;

	/**
	 * The number of structural features of the '<em>Log Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl <em>Change Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getChangePackage()
	 * @generated
	 */
	int CHANGE_PACKAGE = 5;

	/**
	 * The feature id for the '<em><b>Change Containers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__CHANGE_CONTAINERS = 0;

	/**
	 * The number of structural features of the '<em>Change Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl <em>History Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getHistoryInfo()
	 * @generated
	 */
	int HISTORY_INFO = 6;

	/**
	 * The feature id for the '<em><b>Primery Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__PRIMERY_SPEC = 0;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__LOG_MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Tag Specs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__TAG_SPECS = 2;

	/**
	 * The number of structural features of the '<em>History Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.HistoryQueryImpl <em>History Query</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.HistoryQueryImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getHistoryQuery()
	 * @generated
	 */
	int HISTORY_QUERY = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY__TARGET = 1;

	/**
	 * The number of structural features of the '<em>History Query</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersionImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 8;

	/**
	 * The feature id for the '<em><b>Project State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PROJECT_STATE = 0;

	/**
	 * The feature id for the '<em><b>Primary Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PRIMARY_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Tag Specs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__TAG_SPECS = 2;

	/**
	 * The feature id for the '<em><b>Next Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__NEXT_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Previous Version</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PREVIOUS_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__CHANGES = 5;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__LOG_MESSAGE = 6;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.versioning.impl.HeadVersionSpecImpl <em>Head Version Spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.versioning.impl.HeadVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getHeadVersionSpec()
	 * @generated
	 */
	int HEAD_VERSION_SPEC = 9;

	/**
	 * The number of structural features of the '<em>Head Version Spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.TagVersionSpec <em>Tag Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.TagVersionSpec
	 * @generated
	 */
	EClass getTagVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.TagVersionSpec#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.TagVersionSpec#getName()
	 * @see #getTagVersionSpec()
	 * @generated
	 */
	EAttribute getTagVersionSpec_Name();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.DateVersionSpec <em>Date Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.DateVersionSpec
	 * @generated
	 */
	EClass getDateVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.DateVersionSpec#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.DateVersionSpec#getDate()
	 * @see #getDateVersionSpec()
	 * @generated
	 */
	EAttribute getDateVersionSpec_Date();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec <em>Primary Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec
	 * @generated
	 */
	EClass getPrimaryVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec#getIdentifier()
	 * @see #getPrimaryVersionSpec()
	 * @generated
	 */
	EAttribute getPrimaryVersionSpec_Identifier();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.VersionSpec <em>Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.VersionSpec
	 * @generated
	 */
	EClass getVersionSpec();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.LogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Message</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.LogMessage
	 * @generated
	 */
	EClass getLogMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.LogMessage#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.LogMessage#getMessage()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.LogMessage#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.LogMessage#getDate()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.versioning.LogMessage#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.LogMessage#getAuthor()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Author();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.ChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Package</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage
	 * @generated
	 */
	EClass getChangePackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.versioning.ChangePackage#getChangeContainers <em>Change Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Change Containers</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.ChangePackage#getChangeContainers()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_ChangeContainers();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.HistoryInfo <em>History Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History Info</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HistoryInfo
	 * @generated
	 */
	EClass getHistoryInfo();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.HistoryInfo#getPrimerySpec <em>Primery Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primery Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HistoryInfo#getPrimerySpec()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_PrimerySpec();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.HistoryInfo#getLogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HistoryInfo#getLogMessage()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_LogMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.versioning.HistoryInfo#getTagSpecs <em>Tag Specs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tag Specs</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HistoryInfo#getTagSpecs()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_TagSpecs();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery <em>History Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>History Query</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HistoryQuery
	 * @generated
	 */
	EClass getHistoryQuery();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HistoryQuery#getSource()
	 * @see #getHistoryQuery()
	 * @generated
	 */
	EReference getHistoryQuery_Source();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HistoryQuery#getTarget()
	 * @see #getHistoryQuery()
	 * @generated
	 */
	EReference getHistoryQuery_Target();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.Version <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.Version#getProjectState <em>Project State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project State</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version#getProjectState()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_ProjectState();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.Version#getPrimarySpec <em>Primary Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primary Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version#getPrimarySpec()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PrimarySpec();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.versioning.Version#getTagSpecs <em>Tag Specs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tag Specs</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version#getTagSpecs()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_TagSpecs();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.versioning.Version#getNextVersion <em>Next Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version#getNextVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_NextVersion();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.versioning.Version#getPreviousVersion <em>Previous Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Version</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version#getPreviousVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PreviousVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.Version#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Changes</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version#getChanges()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_Changes();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.versioning.Version#getLogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.Version#getLogMessage()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_LogMessage();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.versioning.HeadVersionSpec <em>Head Version Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Head Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.versioning.HeadVersionSpec
	 * @generated
	 */
	EClass getHeadVersionSpec();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VersioningFactory getVersioningFactory();

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
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.TagVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getTagVersionSpec()
		 * @generated
		 */
		EClass TAG_VERSION_SPEC = eINSTANCE.getTagVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG_VERSION_SPEC__NAME = eINSTANCE.getTagVersionSpec_Name();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.DateVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getDateVersionSpec()
		 * @generated
		 */
		EClass DATE_VERSION_SPEC = eINSTANCE.getDateVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_VERSION_SPEC__DATE = eINSTANCE
				.getDateVersionSpec_Date();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.PrimaryVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getPrimaryVersionSpec()
		 * @generated
		 */
		EClass PRIMARY_VERSION_SPEC = eINSTANCE.getPrimaryVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_VERSION_SPEC__IDENTIFIER = eINSTANCE
				.getPrimaryVersionSpec_Identifier();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.VersionSpec <em>Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.VersionSpec
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getVersionSpec()
		 * @generated
		 */
		EClass VERSION_SPEC = eINSTANCE.getVersionSpec();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.LogMessageImpl <em>Log Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.LogMessageImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getLogMessage()
		 * @generated
		 */
		EClass LOG_MESSAGE = eINSTANCE.getLogMessage();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__MESSAGE = eINSTANCE.getLogMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__DATE = eINSTANCE.getLogMessage_Date();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__AUTHOR = eINSTANCE.getLogMessage_Author();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl <em>Change Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.ChangePackageImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getChangePackage()
		 * @generated
		 */
		EClass CHANGE_PACKAGE = eINSTANCE.getChangePackage();

		/**
		 * The meta object literal for the '<em><b>Change Containers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_PACKAGE__CHANGE_CONTAINERS = eINSTANCE
				.getChangePackage_ChangeContainers();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl <em>History Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.HistoryInfoImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getHistoryInfo()
		 * @generated
		 */
		EClass HISTORY_INFO = eINSTANCE.getHistoryInfo();

		/**
		 * The meta object literal for the '<em><b>Primery Spec</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_INFO__PRIMERY_SPEC = eINSTANCE
				.getHistoryInfo_PrimerySpec();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_INFO__LOG_MESSAGE = eINSTANCE
				.getHistoryInfo_LogMessage();

		/**
		 * The meta object literal for the '<em><b>Tag Specs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_INFO__TAG_SPECS = eINSTANCE
				.getHistoryInfo_TagSpecs();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.HistoryQueryImpl <em>History Query</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.HistoryQueryImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getHistoryQuery()
		 * @generated
		 */
		EClass HISTORY_QUERY = eINSTANCE.getHistoryQuery();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_QUERY__SOURCE = eINSTANCE.getHistoryQuery_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_QUERY__TARGET = eINSTANCE.getHistoryQuery_Target();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersionImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Project State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PROJECT_STATE = eINSTANCE.getVersion_ProjectState();

		/**
		 * The meta object literal for the '<em><b>Primary Spec</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PRIMARY_SPEC = eINSTANCE.getVersion_PrimarySpec();

		/**
		 * The meta object literal for the '<em><b>Tag Specs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__TAG_SPECS = eINSTANCE.getVersion_TagSpecs();

		/**
		 * The meta object literal for the '<em><b>Next Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__NEXT_VERSION = eINSTANCE.getVersion_NextVersion();

		/**
		 * The meta object literal for the '<em><b>Previous Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PREVIOUS_VERSION = eINSTANCE
				.getVersion_PreviousVersion();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__CHANGES = eINSTANCE.getVersion_Changes();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__LOG_MESSAGE = eINSTANCE.getVersion_LogMessage();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.versioning.impl.HeadVersionSpecImpl <em>Head Version Spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.versioning.impl.HeadVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.versioning.impl.VersioningPackageImpl#getHeadVersionSpec()
		 * @generated
		 */
		EClass HEAD_VERSION_SPEC = eINSTANCE.getHeadVersionSpec();

	}

} //VersioningPackage
