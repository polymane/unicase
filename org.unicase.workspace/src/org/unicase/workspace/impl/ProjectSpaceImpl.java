/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.FeatureChange;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.changemanagment.ChangePackage;
import org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.emfstore.esmodel.changemanagment.LogMessage;
import org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.changemanagment.VersionSpec;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.connectionmanager.ConnectionManager;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Project Container</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProject <em>Project
 * </em>}</li>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectId <em>
 * Project Id</em>}</li>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectName <em>
 * Project Name</em>}</li>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getProjectDescription
 * <em>Project Description</em>}</li>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getLocalChanges <em>
 * Local Changes</em>}</li>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getUsersession <em>
 * Usersession</em>}</li>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getLastUpdated <em>
 * Last Updated</em>}</li>
 * <li>{@link org.unicase.workspace.impl.ProjectSpaceImpl#getBaseVersion <em>
 * Base Version</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProjectSpaceImpl extends EObjectImpl implements ProjectSpace {

	/**
	 * @generated NOT
	 */
	private ChangeRecorder changeRecorder;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The cached value of the '{@link #getProjectId() <em>Project Id</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectId()
	 * @generated
	 * @ordered
	 */
	protected ProjectId projectId;

	/**
	 * The default value of the '{@link #getProjectName() <em>Project Name</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectName() <em>Project Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProjectName()
	 * @generated
	 * @ordered
	 */
	protected String projectName = PROJECT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProjectDescription()
	 * <em>Project Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String PROJECT_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProjectDescription()
	 * <em>Project Description</em>}' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getProjectDescription()
	 * @generated
	 * @ordered
	 */
	protected String projectDescription = PROJECT_DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalChanges()
	 * <em>Local Changes</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLocalChanges()
	 * @generated
	 * @ordered
	 */
	protected ChangePackage localChanges;

	/**
	 * The cached value of the '{@link #getUsersession() <em>Usersession</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUsersession()
	 * @generated
	 * @ordered
	 */
	protected Usersession usersession;

	/**
	 * The default value of the '{@link #getLastUpdated() <em>Last Updated</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final Date LAST_UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected Date lastUpdated = LAST_UPDATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseVersion() <em>Base Version</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBaseVersion()
	 * @generated
	 * @ordered
	 */
	protected PrimaryVersionSpec baseVersion;

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected ProjectSpaceImpl() {
		super();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkspacePackage.Literals.PROJECT_SPACE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject,
			NotificationChain msgs) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, WorkspacePackage.PROJECT_SPACE__PROJECT,
					oldProject, newProject);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectGen(Project newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject) project).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT,
						null, msgs);
			if (newProject != null)
				msgs = ((InternalEObject) newProject).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT,
						null, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT, newProject,
					newProject));
	}

	// begin of custom code
	/**
	 * <!-- begin-user-doc --> Set a new Project for the ProjectSpace and
	 * re-init.
	 * 
	 * @param newProject
	 * 
	 *            <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setProject(Project newProject) {
		setProjectGen(newProject);
		init();
	}

	// end of custom code

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ProjectId getProjectId() {
		return projectId;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetProjectId(ProjectId newProjectId,
			NotificationChain msgs) {
		ProjectId oldProjectId = projectId;
		projectId = newProjectId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_ID, oldProjectId,
					newProjectId);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectId(ProjectId newProjectId) {
		if (newProjectId != projectId) {
			NotificationChain msgs = null;
			if (projectId != null)
				msgs = ((InternalEObject) projectId).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
						null, msgs);
			if (newProjectId != null)
				msgs = ((InternalEObject) newProjectId).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__PROJECT_ID,
						null, msgs);
			msgs = basicSetProjectId(newProjectId, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_ID, newProjectId,
					newProjectId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		String oldProjectName = projectName;
		projectName = newProjectName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_NAME,
					oldProjectName, projectName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProjectDescription(String newProjectDescription) {
		String oldProjectDescription = projectDescription;
		projectDescription = newProjectDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION,
					oldProjectDescription, projectDescription));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ChangePackage getLocalChanges() {
		return localChanges;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetLocalChanges(
			ChangePackage newLocalChanges, NotificationChain msgs) {
		ChangePackage oldLocalChanges = localChanges;
		localChanges = newLocalChanges;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
					oldLocalChanges, newLocalChanges);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLocalChanges(ChangePackage newLocalChanges) {
		if (newLocalChanges != localChanges) {
			NotificationChain msgs = null;
			if (localChanges != null)
				msgs = ((InternalEObject) localChanges)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
								null, msgs);
			if (newLocalChanges != null)
				msgs = ((InternalEObject) newLocalChanges)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
								null, msgs);
			msgs = basicSetLocalChanges(newLocalChanges, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES,
					newLocalChanges, newLocalChanges));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Usersession getUsersession() {
		return usersession;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetUsersession(Usersession newUsersession,
			NotificationChain msgs) {
		Usersession oldUsersession = usersession;
		usersession = newUsersession;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					WorkspacePackage.PROJECT_SPACE__USERSESSION,
					oldUsersession, newUsersession);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setUsersession(Usersession newUsersession) {
		if (newUsersession != usersession) {
			NotificationChain msgs = null;
			if (usersession != null)
				msgs = ((InternalEObject) usersession).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__USERSESSION,
						null, msgs);
			if (newUsersession != null)
				msgs = ((InternalEObject) newUsersession).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__USERSESSION,
						null, msgs);
			msgs = basicSetUsersession(newUsersession, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__USERSESSION,
					newUsersession, newUsersession));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLastUpdated(Date newLastUpdated) {
		Date oldLastUpdated = lastUpdated;
		lastUpdated = newLastUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__LAST_UPDATED,
					oldLastUpdated, lastUpdated));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PrimaryVersionSpec getBaseVersion() {
		return baseVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetBaseVersion(
			PrimaryVersionSpec newBaseVersion, NotificationChain msgs) {
		PrimaryVersionSpec oldBaseVersion = baseVersion;
		baseVersion = newBaseVersion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
					oldBaseVersion, newBaseVersion);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBaseVersion(PrimaryVersionSpec newBaseVersion) {
		if (newBaseVersion != baseVersion) {
			NotificationChain msgs = null;
			if (baseVersion != null)
				msgs = ((InternalEObject) baseVersion).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
						null, msgs);
			if (newBaseVersion != null)
				msgs = ((InternalEObject) newBaseVersion).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
						null, msgs);
			msgs = basicSetBaseVersion(newBaseVersion, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					WorkspacePackage.PROJECT_SPACE__BASE_VERSION,
					newBaseVersion, newBaseVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec commit() throws EmfStoreException {
		LogMessage logMessage = ChangemanagmentFactory.eINSTANCE
				.createLogMessage();
		logMessage.setAuthor("(Not set)");
		logMessage.setDate(new Date());
		logMessage.setMessage("(Not set)");
		return commit(logMessage);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	private PrimaryVersionSpec newBaseVersion;

	public PrimaryVersionSpec commit(final LogMessage logMessage)
			throws EmfStoreException {

		// MK: save projectspace if single resource

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					
					//FIXME: GUI has to relogin.
					getUsersession().logIn();
					
					stopChangeRecording();
					PrimaryVersionSpec resolvedVersion = resolveVersionSpec(VersionSpec.HEAD_VERSION);
					// FIXME insert not and write equals method
					if ((!getBaseVersion().equals(resolvedVersion))) {
						throw new BaseVersionOutdatedException(
								"BaseVersion outdated, please update before commit.");
					}
					final ConnectionManager connectionManager = WorkspaceManager
							.getInstance().getConnectionManager();

					// FIMXE: put this somewhere else
					// integrate project into one resource set with change
					// package for
					// serialization
					ResourceSet tempResourceSet = new ResourceSetImpl();
					// disconnect project and add to virtual resource
					Project project = getProject();
					setProjectGen(null);
					Resource projectResource = tempResourceSet
							.createResource(ConnectionManager.PROJECT_URI);
					projectResource.getContents().add(project);
					// disconnect change package and add to virtual resource
					ChangePackage changePackage = getLocalChanges();
					// remove backward delta information
					changePackage.setBackwardDelta(null);

					setLocalChanges(null);
					Resource changePackageResource = tempResourceSet
							.createResource(ConnectionManager.CHANGEPACKAGE_URI);
					changePackageResource.getContents().add(changePackage);

					newBaseVersion = connectionManager.createVersion(
							getUsersession().getSessionId(), getProjectId(),
							getBaseVersion(), changePackage, logMessage);

					// FIMXE: put this somewhere else
					// reconnect project to projectSpace
					setProjectGen(project);
					setBaseVersion(newBaseVersion);
					// MK: save projectspace if single resource
					startChangeRecording();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new IllegalStateException();
				}

			}
		});

		return newBaseVersion;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#update()
	 * @generated NOT
	 */
	public void update() throws EmfStoreException {
		update(VersionSpec.HEAD_VERSION);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#update(org.unicase.emfstore.esmodel.changemanagment.VersionSpec)
	 * @generated NOT
	 */
	public void update(final VersionSpec version) throws EmfStoreException {
		// TODO: update
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					
					//FIXME: GUI has to relogin.
					getUsersession().logIn();
					
					final ConnectionManager cm = WorkspaceManager.getInstance()
							.getConnectionManager();
					PrimaryVersionSpec resolvedVersion = cm.resolveVersionSpec(
							getUsersession().getSessionId(), getProjectId(),
							version);

					if (getBaseVersion().getIdentifier() > resolvedVersion
							.getIdentifier()) {
						return;
					}

					stopChangeRecording();

					List<ChangePackage> changes = cm.getChanges(
							getUsersession().getSessionId(), getProjectId(),
							getBaseVersion(), resolvedVersion);
					Project project = getProject();
					for (ChangePackage change : changes) {
						//FIXME hack to set project state
						project = change.getProjectState();
						change.getFowardDelta().apply();
					}
					setProjectGen(project);
					setBaseVersion(resolvedVersion);

					startChangeRecording();
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
		});
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void revert() {
		// TODO: revert changes
		stopChangeRecording();
		setLocalChanges(null);
		startChangeRecording();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void save() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				stopChangeRecording();
				startChangeRecording();
			}

		});
	}

	/**
	 * Stops current recording of changes and adds recorded changes to this
	 * project spaces changes.
	 * 
	 * @generated NOT
	 */
	private void stopChangeRecording() {
		ChangeDescription changeDescription = this.changeRecorder
				.endRecording();
		if (changeDescription == null) {
			return;
		}
		ChangeDescription backwardChangeDescription = (ChangeDescription) EcoreUtil
				.copy(changeDescription);
		changeDescription.applyAndReverse();
		ChangeDescription forwardChangeDescription = (ChangeDescription) EcoreUtil
				.copy(changeDescription);
		changeDescription.apply();
		ChangePackage changePackage = ChangemanagmentFactory.eINSTANCE
				.createChangePackage();
		changePackage.setBackwardDelta(backwardChangeDescription);
		changePackage.setFowardDelta(forwardChangeDescription);
		this.setLocalChanges(changePackage);
	}

	/**
	 * Starts change recording on this workspace, resumes previous recordings if
	 * there are any.
	 * 
	 * @generated NOT
	 */
	private void startChangeRecording() {

		changeRecorder = new ChangeRecorder();
		if (getLocalChanges() == null) {
			changeRecorder.beginRecording(Collections.singleton(project));
		} else {
			changeRecorder.beginRecording(localChanges.getBackwardDelta(),
					Collections.singleton(project));
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#init()
	 * @generated NOT
	 */
	public void init() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				startChangeRecording();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#getProjectInfo()
	 * @generated NOT
	 */
	public ProjectInfo getProjectInfo() {
		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setProjectId(getProjectId());
		projectInfo.setName(getProjectName());
		projectInfo.setDescription(getProjectDescription());
		projectInfo.setVersion(getBaseVersion());
		return projectInfo;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#isDirty()
	 * @generated NOT
	 */
	public boolean isDirty() {
		ChangeDescription changeDescription = this.changeRecorder.summarize();
		return !(changeDescription.getObjectChanges().isEmpty()
				&& changeDescription.getObjectsToAttach().isEmpty()
				&& changeDescription.getObjectsToDetach().isEmpty() && changeDescription
				.getResourceChanges().isEmpty());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.ProjectSpace#resolveVersionSpec(org.unicase.emfstore.esmodel.changemanagment.VersionSpec)
	 * @throws EmfStoreException
	 * @generated NOT
	 */
	public PrimaryVersionSpec resolveVersionSpec(VersionSpec versionSpec)
			throws EmfStoreException {
		ConnectionManager connectionManager = WorkspaceManager.getInstance()
				.getConnectionManager();
		return connectionManager.resolveVersionSpec(getUsersession()
				.getSessionId(), getProjectId(),
				ChangemanagmentFactory.eINSTANCE.createHeadVersionSpec());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			return basicSetProject(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			return basicSetProjectId(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			return basicSetLocalChanges(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			return basicSetUsersession(null, msgs);
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return basicSetBaseVersion(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			return getProject();
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			return getProjectId();
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			return getProjectName();
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			return getProjectDescription();
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			return getLocalChanges();
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			return getUsersession();
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			return getLastUpdated();
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return getBaseVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			setProject((Project) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			setProjectId((ProjectId) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			setProjectName((String) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			setProjectDescription((String) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			setLocalChanges((ChangePackage) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			setUsersession((Usersession) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			setLastUpdated((Date) newValue);
			return;
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			setProject((Project) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			setProjectId((ProjectId) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			setProjectName(PROJECT_NAME_EDEFAULT);
			return;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			setProjectDescription(PROJECT_DESCRIPTION_EDEFAULT);
			return;
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			setLocalChanges((ChangePackage) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			setUsersession((Usersession) null);
			return;
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			setLastUpdated(LAST_UPDATED_EDEFAULT);
			return;
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			setBaseVersion((PrimaryVersionSpec) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case WorkspacePackage.PROJECT_SPACE__PROJECT:
			return project != null;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_ID:
			return projectId != null;
		case WorkspacePackage.PROJECT_SPACE__PROJECT_NAME:
			return PROJECT_NAME_EDEFAULT == null ? projectName != null
					: !PROJECT_NAME_EDEFAULT.equals(projectName);
		case WorkspacePackage.PROJECT_SPACE__PROJECT_DESCRIPTION:
			return PROJECT_DESCRIPTION_EDEFAULT == null ? projectDescription != null
					: !PROJECT_DESCRIPTION_EDEFAULT.equals(projectDescription);
		case WorkspacePackage.PROJECT_SPACE__LOCAL_CHANGES:
			return localChanges != null;
		case WorkspacePackage.PROJECT_SPACE__USERSESSION:
			return usersession != null;
		case WorkspacePackage.PROJECT_SPACE__LAST_UPDATED:
			return LAST_UPDATED_EDEFAULT == null ? lastUpdated != null
					: !LAST_UPDATED_EDEFAULT.equals(lastUpdated);
		case WorkspacePackage.PROJECT_SPACE__BASE_VERSION:
			return baseVersion != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (projectName: ");
		result.append(projectName);
		result.append(", projectDescription: ");
		result.append(projectDescription);
		result.append(", lastUpdated: ");
		result.append(lastUpdated);
		result.append(')');
		return result.toString();
	}
} // ProjectContainerImpl
