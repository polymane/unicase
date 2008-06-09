package org.unicase.workspace;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.connectionmanager.RMIConnectionManagerImpl;
import org.unicase.workspace.impl.WorkspaceImpl;

/**
 * Controller for workspaces. Workspace Manager is a singleton.
 * 
 * @author Maximilian Koegel
 * 
 * 
 * @generated NOT
 */
public final class WorkspaceManager {

	private static WorkspaceManager instance;

	private Workspace currentWorkspace;
	private ConnectionManager connectionManager;

	/**
	 * Get an instance of the workspace manager. Will create an instance if no
	 * workspace manager is present.
	 * 
	 * @return the workspace manager singleton
	 * 
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
		this.currentWorkspace = initWorkSpace();

	}

	/**
	 * Initialize the connection manager of the workspace. The connection
	 * manager connects the workspace with the emf store.
	 * 
	 * @return the connection manager
	 * 
	 * @generated NOT
	 */
	private ConnectionManager initConnectionManager() {
		// return new StubConnectionManagerImpl();
			return new RMIConnectionManagerImpl();
	}

	/**
	 * Initialize the workspace. Loads workspace from persistent storage if
	 * present. There is always one current Workspace.
	 * 
	 * @return the workspace
	 * 
	 * @generated NOT
	 */
	private Workspace initWorkSpace() {
		ResourceSet resourceSet = new ResourceSetImpl();

		// register an editing domain on the ressource
		// TransactionalEditingDomain editingDomain =
		// TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
		// TransactionalEditingDomain.Registry.INSTANCE.add(MODEL_EDIT_DOMAIN,
		// editingDomain);

		URI fileURI = URI.createFileURI(Configuration.getWorkspacePath());
		File workspaceFile = new File(Configuration.getWorkspacePath());
		if (!workspaceFile.exists()) {

			// no workspace content found, create a workspace
			Resource resource = resourceSet.createResource(fileURI);
			Workspace workspace = WorkspaceFactory.eINSTANCE.createWorkspace();
			workspace.setConnectionManager(this.connectionManager);
			workspace.setResource(resource);
			workspace.getServerInfos()
					.add(Configuration.getDefaultServerInfo());
			resource.getContents().add(workspace);
			try {
				resource.save(Configuration.getResourceSaveOptions());
			} catch (IOException e) {
				// MK Auto-generated catch block
				e.printStackTrace();
			}
			return workspace;
		}

		// if file exists load it
		Resource resource = resourceSet.getResource(fileURI, true);
		EList<EObject> directContents = resource.getContents();
		for (EObject eObject : directContents) {
			if (eObject instanceof WorkspaceImpl) {
				Workspace workspace = (Workspace) eObject;
				workspace.setConnectionManager(this.connectionManager);
				workspace.setResource(resource);
				workspace.init();
				return workspace;
			}
		}

		throw new IllegalStateException();

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
}
