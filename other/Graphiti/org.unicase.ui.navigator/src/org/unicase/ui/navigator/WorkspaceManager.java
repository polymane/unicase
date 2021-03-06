/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.unicase.ui.navigator.workSpaceModel.ECPWorkspace;
import org.unicase.ui.navigator.workSpaceModel.util.ECPWorkspaceProvider;

/**
 * Class to provide access to a registered Workspace.
 * 
 * @author helming
 */
public final class WorkspaceManager {

	private static WorkspaceManager instance;

	/**
	 * Singleton Pattern.
	 * 
	 * @return the instance
	 */
	public static WorkspaceManager getInstance() {
		if (instance == null) {
			instance = new WorkspaceManager();
		}
		return instance;
	}

	private ECPWorkspace workspace;

	private WorkspaceManager() {
		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.navigator.ecpWorkspaceProvider");
		if (confs.length > 1) {
			Activator.logException(new IllegalStateException("Duplicate Workspace registered"));
		}
		if (confs.length < 1) {
			Activator.logException(new IllegalStateException("No Workspace registered"));
		}
		try {
			workspace = ((ECPWorkspaceProvider) confs[0].createExecutableExtension("class")).getECPWorkspace();
		} catch (CoreException e) {
			Activator.logException(e);
		}
	}

	/**
	 * Returns the registered workspace.
	 * 
	 * @return workspace
	 * @throws NoWorkspaceException if there is no workspace
	 */
	public ECPWorkspace getWorkSpace() throws NoWorkspaceException {
		if (workspace == null) {
			throw new NoWorkspaceException();
		}
		return workspace;
	}

}
