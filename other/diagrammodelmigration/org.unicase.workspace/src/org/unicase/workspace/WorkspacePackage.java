/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.unicase.metamodel.MetamodelPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.workspace.WorkspaceFactory
 * @model kind="package"
 * @generated
 */
public interface WorkspacePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workspace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/workspace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.workspace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	WorkspacePackage eINSTANCE = org.unicase.workspace.impl.WorkspacePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.WorkspaceImpl <em>Workspace</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.workspace.impl.WorkspaceImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getWorkspace()
	 * @generated
	 */
	int WORKSPACE = 0;

	/**
	 * The feature id for the '<em><b>Project Spaces</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__PROJECT_SPACES = 0;

	/**
	 * The feature id for the '<em><b>Server Infos</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__SERVER_INFOS = 1;

	/**
	 * The feature id for the '<em><b>Usersessions</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__USERSESSIONS = 2;

	/**
	 * The feature id for the '<em><b>Active Project Space</b></em>' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKSPACE__ACTIVE_PROJECT_SPACE = 3;

	/**
	 * The number of structural features of the '<em>Workspace</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WORKSPACE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.ServerInfoImpl <em>Server Info</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.workspace.impl.ServerInfoImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getServerInfo()
	 * @generated
	 */
	int SERVER_INFO = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__NAME = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__URL = 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__PORT = 2;

	/**
	 * The feature id for the '<em><b>Project Infos</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__PROJECT_INFOS = 3;

	/**
	 * The feature id for the '<em><b>Last Usersession</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__LAST_USERSESSION = 4;

	/**
	 * The feature id for the '<em><b>Certificate Alias</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO__CERTIFICATE_ALIAS = 5;

	/**
	 * The number of structural features of the '<em>Server Info</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVER_INFO_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.UsersessionImpl <em>Usersession</em>}' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.workspace.impl.UsersessionImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getUsersession()
	 * @generated
	 */
	int USERSESSION = 2;

	/**
	 * The feature id for the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__USERNAME = 0;

	/**
	 * The feature id for the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__PASSWORD = 1;

	/**
	 * The feature id for the '<em><b>Session Id</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__SESSION_ID = 2;

	/**
	 * The feature id for the '<em><b>Persistent Password</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USERSESSION__PERSISTENT_PASSWORD = 3;

	/**
	 * The feature id for the '<em><b>Server Info</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__SERVER_INFO = 4;

	/**
	 * The feature id for the '<em><b>Save Password</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__SAVE_PASSWORD = 5;

	/**
	 * The feature id for the '<em><b>AC User</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USERSESSION__AC_USER = 6;

	/**
	 * The feature id for the '<em><b>Changed Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERSESSION__CHANGED_PROPERTIES = 7;

	/**
	 * The number of structural features of the '<em>Usersession</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USERSESSION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.ProjectSpaceImpl <em>Project Space</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.workspace.impl.ProjectSpaceImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getProjectSpace()
	 * @generated
	 */
	int PROJECT_SPACE = 3;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__IDENTIFIER = MetamodelPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__PROJECT = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Project Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__PROJECT_ID = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__PROJECT_NAME = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Project Description</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__PROJECT_DESCRIPTION = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__EVENTS = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Usersession</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__USERSESSION = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__LAST_UPDATED = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Base Version</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__BASE_VERSION = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Resource Count</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__RESOURCE_COUNT = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Dirty</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__DIRTY = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Old Log Messages</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__OLD_LOG_MESSAGES = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Local Operations</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__LOCAL_OPERATIONS = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__NOTIFICATIONS = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Pending File Transfers</b></em>' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__PENDING_FILE_TRANSFERS = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Event Composite</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__EVENT_COMPOSITE = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Notification Composite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE__NOTIFICATION_COMPOSITE = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Project Space</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_SPACE_FEATURE_COUNT = MetamodelPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.OperationCompositeImpl <em>Operation Composite</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.workspace.impl.OperationCompositeImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getOperationComposite()
	 * @generated
	 */
	int OPERATION_COMPOSITE = 4;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COMPOSITE__OPERATIONS = 0;

	/**
	 * The number of structural features of the '<em>Operation Composite</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_COMPOSITE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.PendingFileTransferImpl <em>Pending File Transfer</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.workspace.impl.PendingFileTransferImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getPendingFileTransfer()
	 * @generated
	 */
	int PENDING_FILE_TRANSFER = 5;

	/**
	 * The feature id for the '<em><b>Attachment Id</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__ATTACHMENT_ID = 0;

	/**
	 * The feature id for the '<em><b>File Version</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__FILE_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Chunk Number</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__CHUNK_NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Upload</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__UPLOAD = 3;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__FILE_NAME = 4;

	/**
	 * The feature id for the '<em><b>Preliminary File Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME = 5;

	/**
	 * The number of structural features of the '<em>Pending File Transfer</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PENDING_FILE_TRANSFER_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.EventCompositeImpl <em>Event Composite</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.workspace.impl.EventCompositeImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getEventComposite()
	 * @generated
	 */
	int EVENT_COMPOSITE = 6;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COMPOSITE__EVENTS = 0;

	/**
	 * The number of structural features of the '<em>Event Composite</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_COMPOSITE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.unicase.workspace.impl.NotificationCompositeImpl <em>Notification Composite</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.workspace.impl.NotificationCompositeImpl
	 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getNotificationComposite()
	 * @generated
	 */
	int NOTIFICATION_COMPOSITE = 7;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_COMPOSITE__NOTIFICATIONS = 0;

	/**
	 * The number of structural features of the '<em>Notification Composite</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_COMPOSITE_FEATURE_COUNT = 1;

	/**
	 * Returns the meta object for class ' {@link org.unicase.workspace.Workspace <em>Workspace</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Workspace</em>'.
	 * @see org.unicase.workspace.Workspace
	 * @generated
	 */
	EClass getWorkspace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.Workspace#getProjectSpaces <em>Project Spaces</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Project Spaces</em>'.
	 * @see org.unicase.workspace.Workspace#getProjectSpaces()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_ProjectSpaces();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.Workspace#getServerInfos <em>Server Infos</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Server Infos</em>'.
	 * @see org.unicase.workspace.Workspace#getServerInfos()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_ServerInfos();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.Workspace#getUsersessions <em>Usersessions</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Usersessions</em>'.
	 * @see org.unicase.workspace.Workspace#getUsersessions()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_Usersessions();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.workspace.Workspace#getActiveProjectSpace <em>Active Project Space</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Active Project Space</em>'.
	 * @see org.unicase.workspace.Workspace#getActiveProjectSpace()
	 * @see #getWorkspace()
	 * @generated
	 */
	EReference getWorkspace_ActiveProjectSpace();

	/**
	 * Returns the meta object for class ' {@link org.unicase.workspace.ServerInfo <em>Server Info</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Server Info</em>'.
	 * @see org.unicase.workspace.ServerInfo
	 * @generated
	 */
	EClass getServerInfo();

	/**
	 * Returns the meta object for the attribute ' {@link org.unicase.workspace.ServerInfo#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.workspace.ServerInfo#getName()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_Name();

	/**
	 * Returns the meta object for the attribute ' {@link org.unicase.workspace.ServerInfo#getUrl <em>Url</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.unicase.workspace.ServerInfo#getUrl()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_Url();

	/**
	 * Returns the meta object for the attribute ' {@link org.unicase.workspace.ServerInfo#getPort <em>Port</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see org.unicase.workspace.ServerInfo#getPort()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_Port();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.ServerInfo#getProjectInfos <em>Project Infos</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Project Infos</em>'.
	 * @see org.unicase.workspace.ServerInfo#getProjectInfos()
	 * @see #getServerInfo()
	 * @generated
	 */
	EReference getServerInfo_ProjectInfos();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.workspace.ServerInfo#getLastUsersession <em>Last Usersession</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Last Usersession</em>'.
	 * @see org.unicase.workspace.ServerInfo#getLastUsersession()
	 * @see #getServerInfo()
	 * @generated
	 */
	EReference getServerInfo_LastUsersession();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.ServerInfo#getCertificateAlias <em>Certificate Alias</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Certificate Alias</em>'.
	 * @see org.unicase.workspace.ServerInfo#getCertificateAlias()
	 * @see #getServerInfo()
	 * @generated
	 */
	EAttribute getServerInfo_CertificateAlias();

	/**
	 * Returns the meta object for class ' {@link org.unicase.workspace.Usersession <em>Usersession</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Usersession</em>'.
	 * @see org.unicase.workspace.Usersession
	 * @generated
	 */
	EClass getUsersession();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.Usersession#getUsername <em>Username</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Username</em>'.
	 * @see org.unicase.workspace.Usersession#getUsername()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_Username();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.Usersession#getPassword <em>Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password</em>'.
	 * @see org.unicase.workspace.Usersession#getPassword()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_Password();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.workspace.Usersession#getSessionId <em>Session Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Session Id</em>'.
	 * @see org.unicase.workspace.Usersession#getSessionId()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_SessionId();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.Usersession#getPersistentPassword <em>Persistent Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Persistent Password</em>'.
	 * @see org.unicase.workspace.Usersession#getPersistentPassword()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_PersistentPassword();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.workspace.Usersession#getServerInfo <em>Server Info</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Server Info</em>'.
	 * @see org.unicase.workspace.Usersession#getServerInfo()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_ServerInfo();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.Usersession#isSavePassword <em>Save Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Save Password</em>'.
	 * @see org.unicase.workspace.Usersession#isSavePassword()
	 * @see #getUsersession()
	 * @generated
	 */
	EAttribute getUsersession_SavePassword();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.workspace.Usersession#getACUser <em>AC User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>AC User</em>'.
	 * @see org.unicase.workspace.Usersession#getACUser()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_ACUser();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.Usersession#getChangedProperties <em>Changed Properties</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changed Properties</em>'.
	 * @see org.unicase.workspace.Usersession#getChangedProperties()
	 * @see #getUsersession()
	 * @generated
	 */
	EReference getUsersession_ChangedProperties();

	/**
	 * Returns the meta object for class ' {@link org.unicase.workspace.ProjectSpace <em>Project Space</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project Space</em>'.
	 * @see org.unicase.workspace.ProjectSpace
	 * @generated
	 */
	EClass getProjectSpace();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.workspace.ProjectSpace#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getProject()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_Project();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.workspace.ProjectSpace#getProjectId <em>Project Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project Id</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getProjectId()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_ProjectId();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.ProjectSpace#getProjectName <em>Project Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Name</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getProjectName()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EAttribute getProjectSpace_ProjectName();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.ProjectSpace#getProjectDescription <em>Project Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Project Description</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getProjectDescription()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EAttribute getProjectSpace_ProjectDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.ProjectSpace#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getEvents()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_Events();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.workspace.ProjectSpace#getUsersession <em>Usersession</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Usersession</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getUsersession()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_Usersession();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.ProjectSpace#getLastUpdated <em>Last Updated</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Updated</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getLastUpdated()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EAttribute getProjectSpace_LastUpdated();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.workspace.ProjectSpace#getBaseVersion <em>Base Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Base Version</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getBaseVersion()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_BaseVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.ProjectSpace#getResourceCount <em>Resource Count</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource Count</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getResourceCount()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EAttribute getProjectSpace_ResourceCount();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.ProjectSpace#isDirty <em>Dirty</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dirty</em>'.
	 * @see org.unicase.workspace.ProjectSpace#isDirty()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EAttribute getProjectSpace_Dirty();

	/**
	 * Returns the meta object for the attribute list '{@link org.unicase.workspace.ProjectSpace#getOldLogMessages <em>Old Log Messages</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Old Log Messages</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getOldLogMessages()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EAttribute getProjectSpace_OldLogMessages();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.workspace.ProjectSpace#getLocalOperations <em>Local Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Operations</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getLocalOperations()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_LocalOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.ProjectSpace#getNotifications <em>Notifications</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notifications</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getNotifications()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_Notifications();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.workspace.ProjectSpace#getPendingFileTransfers <em>Pending File Transfers</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Pending File Transfers</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getPendingFileTransfers()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_PendingFileTransfers();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.workspace.ProjectSpace#getEventComposite <em>Event Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Composite</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getEventComposite()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_EventComposite();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.workspace.ProjectSpace#getNotificationComposite <em>Notification Composite</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Notification Composite</em>'.
	 * @see org.unicase.workspace.ProjectSpace#getNotificationComposite()
	 * @see #getProjectSpace()
	 * @generated
	 */
	EReference getProjectSpace_NotificationComposite();

	/**
	 * Returns the meta object for class '{@link org.unicase.workspace.OperationComposite <em>Operation Composite</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Composite</em>'.
	 * @see org.unicase.workspace.OperationComposite
	 * @generated
	 */
	EClass getOperationComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.OperationComposite#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.unicase.workspace.OperationComposite#getOperations()
	 * @see #getOperationComposite()
	 * @generated
	 */
	EReference getOperationComposite_Operations();

	/**
	 * Returns the meta object for class '{@link org.unicase.workspace.PendingFileTransfer <em>Pending File Transfer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pending File Transfer</em>'.
	 * @see org.unicase.workspace.PendingFileTransfer
	 * @generated
	 */
	EClass getPendingFileTransfer();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.workspace.PendingFileTransfer#getAttachmentId <em>Attachment Id</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attachment Id</em>'.
	 * @see org.unicase.workspace.PendingFileTransfer#getAttachmentId()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EReference getPendingFileTransfer_AttachmentId();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.PendingFileTransfer#getFileVersion <em>File Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Version</em>'.
	 * @see org.unicase.workspace.PendingFileTransfer#getFileVersion()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_FileVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.PendingFileTransfer#getChunkNumber <em>Chunk Number</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Chunk Number</em>'.
	 * @see org.unicase.workspace.PendingFileTransfer#getChunkNumber()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_ChunkNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.PendingFileTransfer#isUpload <em>Upload</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upload</em>'.
	 * @see org.unicase.workspace.PendingFileTransfer#isUpload()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_Upload();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.workspace.PendingFileTransfer#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.unicase.workspace.PendingFileTransfer#getFileName()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_FileName();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.workspace.PendingFileTransfer#getPreliminaryFileName <em>Preliminary File Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Preliminary File Name</em>'.
	 * @see org.unicase.workspace.PendingFileTransfer#getPreliminaryFileName()
	 * @see #getPendingFileTransfer()
	 * @generated
	 */
	EAttribute getPendingFileTransfer_PreliminaryFileName();

	/**
	 * Returns the meta object for class '{@link org.unicase.workspace.EventComposite <em>Event Composite</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Event Composite</em>'.
	 * @see org.unicase.workspace.EventComposite
	 * @generated
	 */
	EClass getEventComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.EventComposite#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.unicase.workspace.EventComposite#getEvents()
	 * @see #getEventComposite()
	 * @generated
	 */
	EReference getEventComposite_Events();

	/**
	 * Returns the meta object for class '{@link org.unicase.workspace.NotificationComposite <em>Notification Composite</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Composite</em>'.
	 * @see org.unicase.workspace.NotificationComposite
	 * @generated
	 */
	EClass getNotificationComposite();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.workspace.NotificationComposite#getNotifications <em>Notifications</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Notifications</em>'.
	 * @see org.unicase.workspace.NotificationComposite#getNotifications()
	 * @see #getNotificationComposite()
	 * @generated
	 */
	EReference getNotificationComposite_Notifications();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkspaceFactory getWorkspaceFactory();

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
		 * The meta object literal for the '{@link org.unicase.workspace.impl.WorkspaceImpl <em>Workspace</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.WorkspaceImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getWorkspace()
		 * @generated
		 */
		EClass WORKSPACE = eINSTANCE.getWorkspace();

		/**
		 * The meta object literal for the '<em><b>Project Spaces</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKSPACE__PROJECT_SPACES = eINSTANCE.getWorkspace_ProjectSpaces();

		/**
		 * The meta object literal for the '<em><b>Server Infos</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKSPACE__SERVER_INFOS = eINSTANCE.getWorkspace_ServerInfos();

		/**
		 * The meta object literal for the '<em><b>Usersessions</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference WORKSPACE__USERSESSIONS = eINSTANCE.getWorkspace_Usersessions();

		/**
		 * The meta object literal for the '<em><b>Active Project Space</b></em>' reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORKSPACE__ACTIVE_PROJECT_SPACE = eINSTANCE.getWorkspace_ActiveProjectSpace();

		/**
		 * The meta object literal for the '{@link org.unicase.workspace.impl.ServerInfoImpl <em>Server Info</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.ServerInfoImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getServerInfo()
		 * @generated
		 */
		EClass SERVER_INFO = eINSTANCE.getServerInfo();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__NAME = eINSTANCE.getServerInfo_Name();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__URL = eINSTANCE.getServerInfo_Url();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__PORT = eINSTANCE.getServerInfo_Port();

		/**
		 * The meta object literal for the '<em><b>Project Infos</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SERVER_INFO__PROJECT_INFOS = eINSTANCE.getServerInfo_ProjectInfos();

		/**
		 * The meta object literal for the '<em><b>Last Usersession</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVER_INFO__LAST_USERSESSION = eINSTANCE.getServerInfo_LastUsersession();

		/**
		 * The meta object literal for the '<em><b>Certificate Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVER_INFO__CERTIFICATE_ALIAS = eINSTANCE.getServerInfo_CertificateAlias();

		/**
		 * The meta object literal for the '{@link org.unicase.workspace.impl.UsersessionImpl <em>Usersession</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.UsersessionImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getUsersession()
		 * @generated
		 */
		EClass USERSESSION = eINSTANCE.getUsersession();

		/**
		 * The meta object literal for the '<em><b>Username</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__USERNAME = eINSTANCE.getUsersession_Username();

		/**
		 * The meta object literal for the '<em><b>Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__PASSWORD = eINSTANCE.getUsersession_Password();

		/**
		 * The meta object literal for the '<em><b>Session Id</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference USERSESSION__SESSION_ID = eINSTANCE.getUsersession_SessionId();

		/**
		 * The meta object literal for the '<em><b>Persistent Password</b></em>' attribute feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__PERSISTENT_PASSWORD = eINSTANCE.getUsersession_PersistentPassword();

		/**
		 * The meta object literal for the '<em><b>Server Info</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference USERSESSION__SERVER_INFO = eINSTANCE.getUsersession_ServerInfo();

		/**
		 * The meta object literal for the '<em><b>Save Password</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USERSESSION__SAVE_PASSWORD = eINSTANCE.getUsersession_SavePassword();

		/**
		 * The meta object literal for the '<em><b>AC User</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference USERSESSION__AC_USER = eINSTANCE.getUsersession_ACUser();

		/**
		 * The meta object literal for the '<em><b>Changed Properties</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference USERSESSION__CHANGED_PROPERTIES = eINSTANCE.getUsersession_ChangedProperties();

		/**
		 * The meta object literal for the '{@link org.unicase.workspace.impl.ProjectSpaceImpl <em>Project Space</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.ProjectSpaceImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getProjectSpace()
		 * @generated
		 */
		EClass PROJECT_SPACE = eINSTANCE.getProjectSpace();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_SPACE__PROJECT = eINSTANCE.getProjectSpace_Project();

		/**
		 * The meta object literal for the '<em><b>Project Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_SPACE__PROJECT_ID = eINSTANCE.getProjectSpace_ProjectId();

		/**
		 * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE__PROJECT_NAME = eINSTANCE.getProjectSpace_ProjectName();

		/**
		 * The meta object literal for the '<em><b>Project Description</b></em>' attribute feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE__PROJECT_DESCRIPTION = eINSTANCE.getProjectSpace_ProjectDescription();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_SPACE__EVENTS = eINSTANCE.getProjectSpace_Events();

		/**
		 * The meta object literal for the '<em><b>Usersession</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_SPACE__USERSESSION = eINSTANCE.getProjectSpace_Usersession();

		/**
		 * The meta object literal for the '<em><b>Last Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE__LAST_UPDATED = eINSTANCE.getProjectSpace_LastUpdated();

		/**
		 * The meta object literal for the '<em><b>Base Version</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_SPACE__BASE_VERSION = eINSTANCE.getProjectSpace_BaseVersion();

		/**
		 * The meta object literal for the '<em><b>Resource Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE__RESOURCE_COUNT = eINSTANCE.getProjectSpace_ResourceCount();

		/**
		 * The meta object literal for the '<em><b>Dirty</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_SPACE__DIRTY = eINSTANCE.getProjectSpace_Dirty();

		/**
		 * The meta object literal for the '<em><b>Old Log Messages</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT_SPACE__OLD_LOG_MESSAGES = eINSTANCE.getProjectSpace_OldLogMessages();

		/**
		 * The meta object literal for the '<em><b>Local Operations</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_SPACE__LOCAL_OPERATIONS = eINSTANCE.getProjectSpace_LocalOperations();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_SPACE__NOTIFICATIONS = eINSTANCE.getProjectSpace_Notifications();

		/**
		 * The meta object literal for the '<em><b>Pending File Transfers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_SPACE__PENDING_FILE_TRANSFERS = eINSTANCE.getProjectSpace_PendingFileTransfers();

		/**
		 * The meta object literal for the '<em><b>Event Composite</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_SPACE__EVENT_COMPOSITE = eINSTANCE.getProjectSpace_EventComposite();

		/**
		 * The meta object literal for the '<em><b>Notification Composite</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROJECT_SPACE__NOTIFICATION_COMPOSITE = eINSTANCE.getProjectSpace_NotificationComposite();

		/**
		 * The meta object literal for the '{@link org.unicase.workspace.impl.OperationCompositeImpl <em>Operation Composite</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.OperationCompositeImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getOperationComposite()
		 * @generated
		 */
		EClass OPERATION_COMPOSITE = eINSTANCE.getOperationComposite();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATION_COMPOSITE__OPERATIONS = eINSTANCE.getOperationComposite_Operations();

		/**
		 * The meta object literal for the '{@link org.unicase.workspace.impl.PendingFileTransferImpl <em>Pending File Transfer</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.PendingFileTransferImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getPendingFileTransfer()
		 * @generated
		 */
		EClass PENDING_FILE_TRANSFER = eINSTANCE.getPendingFileTransfer();

		/**
		 * The meta object literal for the '<em><b>Attachment Id</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PENDING_FILE_TRANSFER__ATTACHMENT_ID = eINSTANCE.getPendingFileTransfer_AttachmentId();

		/**
		 * The meta object literal for the '<em><b>File Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__FILE_VERSION = eINSTANCE.getPendingFileTransfer_FileVersion();

		/**
		 * The meta object literal for the '<em><b>Chunk Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__CHUNK_NUMBER = eINSTANCE.getPendingFileTransfer_ChunkNumber();

		/**
		 * The meta object literal for the '<em><b>Upload</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__UPLOAD = eINSTANCE.getPendingFileTransfer_Upload();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__FILE_NAME = eINSTANCE.getPendingFileTransfer_FileName();

		/**
		 * The meta object literal for the '<em><b>Preliminary File Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PENDING_FILE_TRANSFER__PRELIMINARY_FILE_NAME = eINSTANCE
			.getPendingFileTransfer_PreliminaryFileName();

		/**
		 * The meta object literal for the '{@link org.unicase.workspace.impl.EventCompositeImpl <em>Event Composite</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.EventCompositeImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getEventComposite()
		 * @generated
		 */
		EClass EVENT_COMPOSITE = eINSTANCE.getEventComposite();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_COMPOSITE__EVENTS = eINSTANCE.getEventComposite_Events();

		/**
		 * The meta object literal for the '{@link org.unicase.workspace.impl.NotificationCompositeImpl <em>Notification Composite</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.unicase.workspace.impl.NotificationCompositeImpl
		 * @see org.unicase.workspace.impl.WorkspacePackageImpl#getNotificationComposite()
		 * @generated
		 */
		EClass NOTIFICATION_COMPOSITE = eINSTANCE.getNotificationComposite();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NOTIFICATION_COMPOSITE__NOTIFICATIONS = eINSTANCE.getNotificationComposite_Notifications();

	}

} // WorkspacePackage
