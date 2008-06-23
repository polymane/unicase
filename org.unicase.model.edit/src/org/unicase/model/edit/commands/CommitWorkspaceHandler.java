/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 * @author Hodaie This handlers handles CommitWorkspace command. This command is
 *         shown in UC View context menu only for Projects
 * 
 */
public class CommitWorkspaceHandler extends AbstractHandler {

	/**
	 * . ({@inheritDoc})
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub

		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);

		MessageDialog.openInformation(window.getShell(), null,
				"CommitWorkspace!");

		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object o = ssel.getFirstElement();
		if (!(o instanceof ProjectSpace)) {
			return null;
		}

		final ProjectSpace projectSpace = (ProjectSpace) o;

		// TODO: handle exception
		Workspace currentWorkspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();
		TransactionalEditingDomain domain = currentWorkspace.getEditingDomain();

		RecordingCommand command = new RecordingCommand(domain) {
			protected void doExecute() {
				try {
					projectSpace.commit();
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		domain.getCommandStack().execute(command);
		return null;
	}

}
