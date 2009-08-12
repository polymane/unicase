/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.dashboard.DashboardEditor;
import org.unicase.workspace.ui.dashboard.DashboardEditorInput;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Handler for viewing the dashboard.
 * 
 * @author Shterev
 */
public class ShowDashboardHandler extends AbstractHandler {

	private static final String DASHBOARD_CONTEXT_VARIABLE = "org.unicase.workspace.ui.dashboardInput";
	private static final String DASHBOARD_ID = "org.unicase.workspace.ui.dashboard";

	/**
	 * {@inheritDoc}
	 */
	public Object execute(final ExecutionEvent event) throws ExecutionException {

		ProjectSpace projectSpace = null;
		try {
			Object o = HandlerUtil.getVariableChecked(event, DASHBOARD_CONTEXT_VARIABLE);
			projectSpace = (ProjectSpace) o;
		} catch (ExecutionException e) {
			projectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		}

		if (projectSpace == null) {
			// forbid null inputs
			return null;
		}

		if (projectSpace.getUsersession() == null) {
			// do not open when the project is not shared yet
			MessageDialog.openWarning(Display.getCurrent().getActiveShell(), "No dashboard available",
				"You can't open the dashboard because your project is not shared yet");
			return null;
		}

		final ProjectSpace ps = projectSpace;
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				DashboardEditorInput input = new DashboardEditorInput(ps);
				try {
					IEditorPart openEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.openEditor(input, DASHBOARD_ID, true);
					if (openEditor instanceof DashboardEditor) {
						((DashboardEditor) openEditor).refresh();
					}
				} catch (PartInitException e) {
					WorkspaceUtil.logException(e.getMessage(), e);
				}
			}
		}.run();

		return null;
	}
}