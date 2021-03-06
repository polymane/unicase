/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import java.util.ArrayList;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Handler for deleting a server info
 * 
 * @author shterev
 */
public class DeleteServerInfoHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService()
				.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (!(obj instanceof TreeNode)) {
			return null;
		}
		TreeNode node = (TreeNode) obj;

		final ServerInfo serverInfo = (ServerInfo) node.getValue();
		EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance()
				.getCurrentWorkspace().getProjectSpaces();
		ArrayList<ProjectSpace> usedSpaces = new ArrayList<ProjectSpace>();
		for (ProjectSpace projectSpace : projectSpaces) {
			if (projectSpace.getUsersession().getServerInfo()
					.equals(serverInfo)) {
				usedSpaces.add(projectSpace);
			}
		}
		if (usedSpaces.size() > 0) {
			String message = "";
			for (ProjectSpace pSpace : usedSpaces) {
				message += "\n" + pSpace.getProjectName();
			}
			DialogHandler
					.showErrorDialog("Cannot delete \'"
							+ serverInfo.getName()
							+ "\' because it is currently used by the following projects: \n"
							+ message);
		} else {
			if (MessageDialog.openQuestion(Display.getCurrent()
					.getActiveShell(), "Confirm deletion",
					"Are you sure you want to delete \'" + serverInfo.getName()
							+ "\'")) {
				new UnicaseCommand() {
					@Override
					protected void doRun() {
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.getServerInfos().remove(serverInfo);
						EcoreUtil.delete(serverInfo);
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.save();
					};
				}.run();
			}
		}
		return null;
	}
}