/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.ui.dialogs.login.LoginDialog;

/**
 * Login menu for the repository browser.
 * 
 * @author Shterev
 */
public class ServerLoginHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		ISelection selection = activeWorkbenchWindow.getSelectionService()
				.getSelection();
		if (selection.isEmpty()) {
			return null;
		}
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (obj instanceof TreeNode
				&& ((TreeNode) obj).getValue() instanceof ServerInfo) {
			ServerInfo serverInfo = (ServerInfo) ((TreeNode) obj).getValue();
			Shell parentShell = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell();
			Shell shell = new Shell(parentShell, parentShell.getStyle()
					| SWT.RESIZE);
			LoginDialog loginDialog = new LoginDialog(shell, serverInfo);
			loginDialog.open(false);
		}
		return null;
	}
}