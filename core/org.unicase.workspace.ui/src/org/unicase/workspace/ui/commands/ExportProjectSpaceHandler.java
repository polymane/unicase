/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Exports a project space to a file.
 * 
 * @author helming
 */
public class ExportProjectSpaceHandler extends AbstractHandler {

	/**
	 * These filter names are used to filter which files are displayed.
	 */
	public static final String[] FILTER_NAMES = {
			"Unicase change package (*.ucc)", "All Files (*.*)" };

	/**
	 * These filter extensions are used to filter which files are displayed.
	 */
	public static final String[] FILTER_EXTS = { "*.ucc", "*.*" };

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final ProjectSpace projectSpace = ActionHelper.getProjectSpace(event);
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFilterNames(ExportProjectSpaceHandler.FILTER_NAMES);
		dialog.setFilterExtensions(ExportProjectSpaceHandler.FILTER_EXTS);
		dialog.setOverwrite(true);
		String initialFilename = "projectspace_"
				+ projectSpace.getProjectName() + "@"
				+ projectSpace.getBaseVersion().getIdentifier() + ".ucc";

		dialog.setFileName(initialFilename);

		String fn = dialog.open();
		if (fn == null) {
			return null;
		}

		String fileName = dialog.getFileName();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(dialog.getFilterPath());
		if (fileName.charAt(fileName.length() - 1) != File.separatorChar) {
			stringBuilder.append(File.separatorChar);
		}
		stringBuilder.append(fileName);
		final String absoluteFileName = stringBuilder.toString();
		final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());

		new UnicaseCommand() {
			@Override
			protected void doRun() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask(
							"Export projectspace...", 100);
					progressDialog.getProgressMonitor().worked(10);
					projectSpace.exportProject(absoluteFileName);
					WorkspaceManager.getInstance().getCurrentWorkspace()
							.exportProjectSpace(projectSpace, absoluteFileName);
				} catch (IOException e) {
					DialogHandler.showExceptionDialog(e);
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		}.run();
		MessageDialog.openInformation(null, "Export",
				"Exported projectspace to file " + fileName);
		return null;
	}
}
