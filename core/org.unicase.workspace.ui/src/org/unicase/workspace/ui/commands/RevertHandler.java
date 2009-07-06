/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.RecordingCommandWithResult;

// MK: document whats this exactly does
/**
 * @author helming
 * @author shterev
 */
public class RevertHandler extends AbstractHandler {
	/**
	 * Command to revert a project.
	 * 
	 * @author helming
	 */
	private final class RevertCommand extends RecordingCommandWithResult<Boolean> {
		private final ProgressMonitorDialog progressDialog;
		private final ProjectSpace projectSpace;

		private RevertCommand(TransactionalEditingDomain domain, ProgressMonitorDialog progressDialog,
			ProjectSpace projectSpace) {
			super(domain);
			this.progressDialog = progressDialog;
			this.projectSpace = projectSpace;
		}

		@Override
		protected void doExecute() {
			MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
				"Do you really want to revert all your changes on project " + projectSpace.getProjectName(),
				MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
			int result = dialog.open();
			if (result == Window.OK) {
				progressDialog.open();
				progressDialog.getProgressMonitor().beginTask("Revert project...", 100);
				progressDialog.getProgressMonitor().worked(10);
				// BEGIN SUPRESS CATCH EXCEPTION
				try {
					projectSpace.revert();
					setTypedResult(true);
				} catch (RuntimeException e) {
					DialogHandler.showExceptionDialog(e);
				}
				// END SUPRESS CATCH EXCEPTION
				progressDialog.getProgressMonitor().done();
				progressDialog.close();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final ProjectSpace projectSpace;
		projectSpace = ActionHelper.getProjectSpace(event);

		if (projectSpace == null) {
			DialogHandler.showErrorDialog("No Project selected.");
		}
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());
		RevertCommand command = new RevertCommand(domain, progressDialog, projectSpace);
		domain.getCommandStack().execute(command);

		if (command.getTypedResult()) {
			MessageDialog.openInformation(null, "Revert", "Reverted project ");
		}
		return null;
	}
}
