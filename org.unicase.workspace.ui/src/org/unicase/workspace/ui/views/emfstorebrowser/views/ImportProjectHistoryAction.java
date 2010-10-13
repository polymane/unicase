/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.ui.views.emfstorebrowser.views;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectHistory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Action to import project history to server.
 * 
 * @author hodaie
 */
// TODO RAP
public class ImportProjectHistoryAction extends Action {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = { "Unicase Project History Files (*.uph)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.uph", "*.*" };

	private static final String IMPORT_PROJECT_HISTORY_PATH = "org.unicase.workspace.ui.importProjectHistoryPath";

	private Usersession usersession;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		final String absoluteFileName = showOpenFileDialog();
		if (absoluteFileName == null) {
			return;
		}

		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());

		progressDialog.open();
		progressDialog.getProgressMonitor().beginTask("Import project history...", 100);
		progressDialog.getProgressMonitor().worked(10);

		ProjectHistory projectHistory = null;
		try {
			projectHistory = getProjectHistory(absoluteFileName);
			if (usersession != null && projectHistory != null) {
				WorkspaceManager.getInstance().getConnectionManager()
					.importProjectHistoryToServer(usersession.getSessionId(), projectHistory);
				MessageDialog
					.openInformation(null, "Import", "Imported project history from file: " + absoluteFileName);
			}

		} catch (EmfStoreException e) {
			WorkspaceUtil.logException("Error importing project history.", e);
		} catch (IOException e) {
			WorkspaceUtil.logException("Error importing project history.", e);
		} finally {

			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}

	}

	private ProjectHistory getProjectHistory(String absoluteFileName) throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(absoluteFileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1 && (!(directContents.get(0) instanceof ProjectHistory))) {
			throw new IOException("File is corrupt, does not contain a ProjectHistory.");
		}

		ProjectHistory projectHistory = (ProjectHistory) directContents.get(0);
		resource.getContents().remove(projectHistory);

		return projectHistory;

	}

	private String showOpenFileDialog() {
		return "";
	}

	/**
	 * Sets the usersession.
	 * 
	 * @param session user session
	 */
	public void setUsersession(Usersession session) {
		this.usersession = session;
	}
}