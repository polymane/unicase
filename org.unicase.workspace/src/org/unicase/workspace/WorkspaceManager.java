/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.workspace.connectionmanager.AdminConnectionManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.KeyStoreManager;
import org.unicase.workspace.connectionmanager.RMIAdminConnectionManagerImpl;
import org.unicase.workspace.connectionmanager.RMIConnectionManagerImpl;
import org.unicase.workspace.util.WorkspaceUtil;

import edu.tum.cs.cope.migration.execution.MigrationException;
import edu.tum.cs.cope.migration.execution.Migrator;
import edu.tum.cs.cope.migration.execution.MigratorRegistry;
import edu.tum.cs.cope.migration.execution.ReleaseUtil;

/**
 * Controller for workspaces. Workspace Manager is a singleton.
 * 
 * @author Maximilian Koegel
 * @generated NOT
 */
public final class WorkspaceManager {

	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.EditingDomain";

	private static WorkspaceManager instance;

	private Workspace currentWorkspace;
	private ConnectionManager connectionManager;
	private AdminConnectionManager adminConnectionManager;

	/**
	 * Get an instance of the workspace manager. Will create an instance if no workspace manager is present.
	 * 
	 * @return the workspace manager singleton
	 * @generated NOT
	 */
	public static WorkspaceManager getInstance() {
		if (instance == null) {
			instance = new WorkspaceManager();
		}
		return instance;
	}

	/**
	 * Default constructor.
	 * 
	 * @generated NOT
	 */
	private WorkspaceManager() {
		this.connectionManager = initConnectionManager();
		this.adminConnectionManager = initAdminConnectionManager();
		this.currentWorkspace = initWorkSpace();

	}

	/**
	 * Initialize the connection manager of the workspace. The connection manager connects the workspace with the emf
	 * store.
	 * 
	 * @return the connection manager
	 * @generated NOT
	 */
	private ConnectionManager initConnectionManager() {
		KeyStoreManager.getInstance().setupKeys();
		// return new StubConnectionManagerImpl();
		return new RMIConnectionManagerImpl();
	}

	/**
	 * Initialize the connection manager of the workspace. The connection manager connects the workspace with the emf
	 * store.
	 * 
	 * @return the admin connection manager
	 * @generated NOT
	 */
	private AdminConnectionManager initAdminConnectionManager() {

		return new RMIAdminConnectionManagerImpl();
	}

	/**
	 * Initialize the workspace. Loads workspace from persistent storage if present. There is always one current
	 * Workspace.
	 * 
	 * @return the workspace
	 * @generated NOT
	 */
	private Workspace initWorkSpace() {
		ResourceSet resourceSet = new ResourceSetImpl();

		// register an editing domain on the ressource
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE
			.createEditingDomain(resourceSet);
		TransactionalEditingDomain.Registry.INSTANCE.add(TRANSACTIONAL_EDITINGDOMAIN_ID, domain);
		domain.setID(TRANSACTIONAL_EDITINGDOMAIN_ID);

		URI fileURI = URI.createFileURI(Configuration.getWorkspacePath());
		File workspaceFile = new File(Configuration.getWorkspacePath());
		final Workspace workspace;
		final Resource resource;
		if (!workspaceFile.exists()) {

			// no workspace content found, create a workspace
			resource = resourceSet.createResource(fileURI);
			workspace = WorkspaceFactory.eINSTANCE.createWorkspace();
			workspace.getServerInfos().addAll(Configuration.getDefaultServerInfos());
			EList<Usersession> usersessions = workspace.getUsersessions();
			for (ServerInfo serverInfo : workspace.getServerInfos()) {
				Usersession lastUsersession = serverInfo.getLastUsersession();
				if (lastUsersession != null) {
					usersessions.add(lastUsersession);
				}
			}
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					resource.getContents().add(workspace);
				}
			});

			try {
				resource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				// MK Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// file exists load it
			migrateModel();

			resource = resourceSet.getResource(fileURI, true);
			EList<EObject> directContents = resource.getContents();
			// MK cast
			workspace = (Workspace) directContents.get(0);
		}
		workspace.setConnectionManager(this.connectionManager);
		// MK: possible performance hit
		resource.setTrackingModification(true);
		workspace.setWorkspaceResourceSet(resourceSet);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				workspace.init(domain);
			}
		});

		return workspace;

	}

	private void migrateModel() {
		File workspaceFile = new File(Configuration.getWorkspaceDirectory());
		for (File file : workspaceFile.listFiles()) {
			if (file.getName().startsWith(Configuration.getProjectSpaceDirectoryPrefix())) {
				String projectFilePath = file.getAbsolutePath() + File.separatorChar
					+ Configuration.getProjectFolderName() + File.separatorChar + 0
					+ Configuration.getProjectFragmentFileExtension();
				URI projectURI = URI.createFileURI(projectFilePath);
				String operationsFilePath = null;
				for (File subDirFile : file.listFiles()) {
					if (subDirFile.getName().endsWith(Configuration.getOperationCompositeFileExtension())) {
						operationsFilePath = subDirFile.getAbsolutePath();
					}
				}
				if (operationsFilePath == null) {
					// MK: proper exception handling
					throw new IllegalStateException("Broken workspace!");
				}
				URI operationsURI = URI.createFileURI(operationsFilePath);
				try {
					migrate(projectURI, operationsURI);
				} catch (MigrationException e) {
					WorkspaceUtil.logException("The migration of the project in projectspace at " + projectFilePath
						+ " failed!", e);
				}
			}
		}
	}

	/**
	 * Migrate the model instance if neccessary.
	 * 
	 * @param projectURI the uri of the project state
	 * @param changesURI the uri of the local changes of the project state
	 * @throws ModelMigrationException
	 */
	private void migrate(URI projectURI, URI changesURI) throws MigrationException {
		String namespaceURI = ReleaseUtil.getNamespaceURI(projectURI);
		Migrator migrator = MigratorRegistry.getInstance().getMigrator(namespaceURI);
		if (migrator == null) {
			return;
		}
		List<URI> modelURIs = new ArrayList<URI>();
		modelURIs.add(projectURI);
		modelURIs.add(changesURI);
		migrator.migrate(modelURIs);
	}

	/**
	 * Get the current workspace. There is always one current workspace.
	 * 
	 * @return the workspace
	 */
	public Workspace getCurrentWorkspace() {
		return currentWorkspace;
	}

	/**
	 * Get the connection manager. Return the connection manager for this workspace.
	 * 
	 * @return the connectionManager
	 */
	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	/**
	 * Get the admin connection manager. Return the admin connection manager for this workspace.
	 * 
	 * @return the connectionManager
	 */
	public AdminConnectionManager getAdminConnectionManager() {
		return adminConnectionManager;
	}

	/**
	 * Retrieve the project space for a model element.
	 * 
	 * @param modelElement the model element
	 * @return the project space
	 */
	public static ProjectSpace getProjectSpace(ModelElement modelElement) {
		return getProjectSpace(modelElement.getProject());
	}

	/**
	 * Retrieve the project space for a project.
	 * 
	 * @param project the project
	 * @return the project space
	 */
	public static ProjectSpace getProjectSpace(Project project) {
		// check if my container is a project space
		if (WorkspacePackage.eINSTANCE.getProjectSpace().isInstance(project.eContainer())) {
			return (ProjectSpace) project.eContainer();
		} else {
			throw new IllegalStateException("Project is not contained by any project space");
		}
	}
}
