/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Workspace</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getProjectSpaces <em>Project Spaces</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getServerInfos <em>Server Infos</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getUsersessions <em>Usersessions</em>}</li>
 *   <li>{@link org.unicase.workspace.impl.WorkspaceImpl#getActiveProjectSpace <em>Active Project Space</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkspaceImpl extends EObjectImpl implements Workspace {

	/**
	 * @generated NOT
	 */
	private ResourceSet workspaceResourceSet;

	/**
	 * The cached value of the '{@link #getProjectSpaces() <em>Project Spaces</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getProjectSpaces()
	 * @generated
	 * @ordered
	 */
	protected EList<ProjectSpace> projectSpaces;

	/**
	 * The cached value of the '{@link #getServerInfos() <em>Server Infos</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getServerInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<ServerInfo> serverInfos;

	/**
	 * The cached value of the '{@link #getUsersessions() <em>Usersessions</em>}
	 * ' containment reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getUsersessions()
	 * @generated
	 * @ordered
	 */
	protected EList<Usersession> usersessions;

	/**
	 * The cached value of the '{@link #getActiveProjectSpace() <em>Active Project Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActiveProjectSpace()
	 * @generated
	 * @ordered
	 */
	protected ProjectSpace activeProjectSpace;

	// begin of custom code
	/**
	 * The current connection manager used to connect to the server(s).
	 * 
	 * @generated NOT
	 */
	private ConnectionManager connectionManager;
	private TransactionalEditingDomain transactionalEditingDomain;

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.WORKSPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProjectSpace> getProjectSpaces() {
		if (projectSpaces == null) {
			projectSpaces = new EObjectContainmentEList.Resolving<ProjectSpace>(
					ProjectSpace.class, this,
					WorkspacePackage.WORKSPACE__PROJECT_SPACES);
		}
		return projectSpaces;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServerInfo> getServerInfos() {
		if (serverInfos == null) {
			serverInfos = new EObjectContainmentEList.Resolving<ServerInfo>(
					ServerInfo.class, this,
					WorkspacePackage.WORKSPACE__SERVER_INFOS);
		}
		return serverInfos;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Usersession> getUsersessions() {
		if (usersessions == null) {
			usersessions = new EObjectContainmentEList.Resolving<Usersession>(
					Usersession.class, this,
					WorkspacePackage.WORKSPACE__USERSESSIONS);
		}
		return usersessions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectSpace getActiveProjectSpace() {
		if (activeProjectSpace != null && activeProjectSpace.eIsProxy()) {
			InternalEObject oldActiveProjectSpace = (InternalEObject) activeProjectSpace;
			activeProjectSpace = (ProjectSpace) eResolveProxy(oldActiveProjectSpace);
			if (activeProjectSpace != oldActiveProjectSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE,
							oldActiveProjectSpace, activeProjectSpace));
			}
		}
		return activeProjectSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectSpace basicGetActiveProjectSpace() {
		return activeProjectSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActiveProjectSpace(ProjectSpace newActiveProjectSpace) {
		ProjectSpace oldActiveProjectSpace = activeProjectSpace;
		activeProjectSpace = newActiveProjectSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE,
					oldActiveProjectSpace, activeProjectSpace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ProjectSpace checkout(final Usersession usersession,
			final ProjectInfo projectInfo) throws EmfStoreException {

		//MK: hack: set head version manually because esbrowser does not update revisions properly
		ProjectInfo projectInfoCopy = (ProjectInfo) EcoreUtil.copy(projectInfo);
		projectInfoCopy.setVersion(this.connectionManager.resolveVersionSpec(
				usersession.getSessionId(), projectInfo.getProjectId(),
				VersionSpec.HEAD_VERSION));

		// get Project from server
		final Project project = this.connectionManager.getProject(usersession
				.getSessionId(), projectInfo.getProjectId(), projectInfoCopy
				.getVersion());
		if (project == null) {
			throw new EmfStoreException("Server returned a null project!");
		}

		final PrimaryVersionSpec primaryVersionSpec = projectInfoCopy
				.getVersion();

		// init project space
		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		projectSpace.setProjectId(projectInfo.getProjectId());
		projectSpace.setProjectName(projectInfo.getName());
		projectSpace.setProjectDescription(projectInfo.getDescription());
		projectSpace.setBaseVersion(primaryVersionSpec);
		projectSpace.setLastUpdated(new Date());
		projectSpace.setUsersession(usersession);
		projectSpace.setProject(project);
		projectSpace.setResourceCount(0);

		projectSpace.initResources(this.workspaceResourceSet);

		getProjectSpaces().add(projectSpace);
		this.save();

		return projectSpace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void save() {
		try {
			this.eResource().save(Configuration.getResourceSaveOptions());
		} catch (IOException e) {
			// MK Auto-generated catch block
			// FIXME OW MK: also insert code for dangling href handling here

		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isDirty() {
		return this.eResource().isModified();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			return ((InternalEList<?>) getProjectSpaces()).basicRemove(
					otherEnd, msgs);
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			return ((InternalEList<?>) getServerInfos()).basicRemove(otherEnd,
					msgs);
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			return ((InternalEList<?>) getUsersessions()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			return getProjectSpaces();
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			return getServerInfos();
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			return getUsersessions();
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			if (resolve)
				return getActiveProjectSpace();
			return basicGetActiveProjectSpace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			getProjectSpaces().clear();
			getProjectSpaces().addAll(
					(Collection<? extends ProjectSpace>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			getServerInfos().clear();
			getServerInfos()
					.addAll((Collection<? extends ServerInfo>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			getUsersessions().clear();
			getUsersessions().addAll(
					(Collection<? extends Usersession>) newValue);
			return;
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			setActiveProjectSpace((ProjectSpace) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			getProjectSpaces().clear();
			return;
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			getServerInfos().clear();
			return;
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			getUsersessions().clear();
			return;
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			setActiveProjectSpace((ProjectSpace) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case WorkspacePackage.WORKSPACE__PROJECT_SPACES:
			return projectSpaces != null && !projectSpaces.isEmpty();
		case WorkspacePackage.WORKSPACE__SERVER_INFOS:
			return serverInfos != null && !serverInfos.isEmpty();
		case WorkspacePackage.WORKSPACE__USERSESSIONS:
			return usersessions != null && !usersessions.isEmpty();
		case WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE:
			return activeProjectSpace != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * @param connectionManager
	 * @generated NOT
	 */
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	/**
	 * {@inheritDoc}
	 * This is to enable the workspace to be root of table views.
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#init(org.eclipse.emf.transaction.TransactionalEditingDomain)
	 * @generated NOT
	 */
	public void init(TransactionalEditingDomain editingDomain) {
		this.transactionalEditingDomain = editingDomain;
		// initialize all projectSpaces
		for (ProjectSpace projectSpace : getProjectSpaces()) {
			projectSpace.init();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.Workspace#getEditingDomain()
	 * @generated NOT
	 */
	public TransactionalEditingDomain getEditingDomain() {
		return this.transactionalEditingDomain;
	}

	/**
	 * @param fileName
	 * @param absoluteFileName
	 * @return
	 */
	public ProjectSpace importProject(String absoluteFileName)
			throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI
				.createFileURI(absoluteFileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1
				&& (!(directContents.get(0) instanceof Project))) {
			throw new IOException(
					"File is corrupt, does not contain a Project.");
		}

		Project project = (Project) directContents.get(0);
		resource.getContents().remove(project);

		ProjectSpace projectSpace = WorkspaceFactory.eINSTANCE
				.createProjectSpace();
		projectSpace.setProject(project);
		projectSpace.setProjectName(absoluteFileName.substring(absoluteFileName
				.lastIndexOf(File.separatorChar) + 1));
		projectSpace.setProjectDescription("Imported from " + absoluteFileName);

		projectSpace.initResources(this.workspaceResourceSet);

		getProjectSpaces().add(projectSpace);
		this.save();

		return projectSpace;
	}

	/**
	 * @param absoluteFileName
	 * @param projectSpace
	 */
	public void exportProject(ProjectSpace projectSpace, String absoluteFileName)
			throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI
				.createFileURI(absoluteFileName));
		Project project = (Project) EcoreUtil.copy(projectSpace.getProject());

		resource.getContents().add(project);
		resource.save(null);
	}

	public void setWorkspaceResourceSet(ResourceSet resourceSet) {
		this.workspaceResourceSet = resourceSet;
	}

	public ResourceSet getWorkspaceResourceSet() {
		return this.workspaceResourceSet;
	}

} // WorkspaceImpl
