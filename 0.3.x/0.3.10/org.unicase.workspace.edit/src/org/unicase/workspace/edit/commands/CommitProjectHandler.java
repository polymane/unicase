/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.commands;

import java.util.Date;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.BaseVersionOutdatedException;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.dashboard.DashboardEditor;
import org.unicase.workspace.edit.dashboard.DashboardEditorInput;
import org.unicase.workspace.edit.dialogs.CommitDialog;
import org.unicase.workspace.edit.dialogs.LoginDialog;
import org.unicase.workspace.exceptions.NoLocalChangesException;
import org.unicase.workspace.util.CommitObserver;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Hodaie
 * @author Shterev This handler handles CommitWorkspace command. This command is shown in UC View context menu only for
 *         Projects
 */
public class CommitProjectHandler extends ProjectActionHandler implements CommitObserver {

	private Shell shell;
	private Usersession usersession;
	private LogMessage logMessage;

	/**
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ProjectSpace projectSpace = getProjectSpace(event);
		if (projectSpace == null) {
			ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getActiveProjectSpace();
			if (activeProjectSpace == null) {
				MessageDialog.openInformation(shell, "Information", "You must select the Project");
				return null;
			}
			projectSpace = activeProjectSpace;
		}
		final ProjectSpace finalProjectSpace = projectSpace;
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				commitWithoutCommand(finalProjectSpace);
			}

		});
		return null;
	}

	private void commitWithoutCommand(final ProjectSpace projectSpace) {
		usersession = projectSpace.getUsersession();
		if (usersession == null) {
			MessageDialog.openInformation(shell, null,
				"This project is not yet shared with a server, you cannot commit.");
			return;
		}
		shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());
		progressDialog.open();
		progressDialog.getProgressMonitor().beginTask("Commit project...", 100);
		progressDialog.getProgressMonitor().worked(10);

		// initially setting the status as successful in case the user
		// is already logged in
		int loginStatus = LoginDialog.SUCCESSFUL;
		try {
			commit(projectSpace, progressDialog, loginStatus);
		} catch (BaseVersionOutdatedException e) {
			handleBaseVersionException(projectSpace);
		} catch (NoLocalChangesException e) {
			MessageDialog.openInformation(shell, null, "No local changes in your project. No need to commit.");
		} catch (ConnectionException e) {
			// after connection exception, try to relogin once.
			try {
				usersession.logIn();
				commit(projectSpace, progressDialog, loginStatus);
			} catch (BaseVersionOutdatedException e1) {
				handleBaseVersionException(projectSpace);
			} catch (EmfStoreException e1) {
				DialogHandler.showExceptionDialog(e);
			}
			// BEGIN SUPRESS CATCH EXCEPTION
			catch (Exception e1) {
				DialogHandler.showExceptionDialog(e);
			}
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		} catch (Exception e) {
			DialogHandler.showExceptionDialog(e);
		}
		// END SUPRESS CATCH EXCEPTION
		finally {
			progressDialog.getProgressMonitor().done();
			progressDialog.close();
		}
	}

	private void handleBaseVersionException(final ProjectSpace projectSpace) {
		MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
			"Your project is outdated, you need to update before commit. Do you want to update now?",
			MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
		int result = dialog.open();
		if (result == 0) {
			new UpdateProjectHandler().update(projectSpace);
			commitWithoutCommand(projectSpace);
		}
	}

	private void commit(final ProjectSpace projectSpace, ProgressMonitorDialog progressDialog, int loginStatus)
		throws EmfStoreException, BaseVersionOutdatedException {
		LoginDialog login;
		if (!usersession.isLoggedIn()) {
			login = new LoginDialog(shell, usersession, usersession.getServerInfo());
			loginStatus = login.open();
		}
		if (loginStatus == LoginDialog.SUCCESSFUL) {
			logMessage = VersioningFactory.eINSTANCE.createLogMessage();
			PrimaryVersionSpec oldVersion = projectSpace.getBaseVersion();
			PrimaryVersionSpec newVersion = projectSpace.commit(logMessage, CommitProjectHandler.this);
			if (!oldVersion.equals(newVersion)) {
				MessageDialog.openInformation(shell, null, "Commit completed.");
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean inspectChanges(ChangePackage changePackage) {
		CommitDialog commitDialog = new CommitDialog(shell, changePackage);
		int returnCode = commitDialog.open();
		if (returnCode == Window.OK) {
			logMessage.setAuthor(usersession.getUsername());
			logMessage.setClientDate(new Date());
			logMessage.setMessage(commitDialog.getLogText());
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.util.CommitObserver#commitCompleted()
	 */
	public void commitCompleted() {
		ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		DashboardEditorInput input = new DashboardEditorInput(activeProjectSpace);
		try {
			IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input,
				"org.unicase.workspace.edit.dashboard", true);
			((DashboardEditor) editor).refresh();
		} catch (PartInitException e) {
			WorkspaceUtil.logException(e.getMessage(), e);
		}
	}

}