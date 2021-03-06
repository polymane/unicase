/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview.handlers;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.window.Window;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.util.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.views.historybrowserview.HistoryBrowserView;

/**
 * Handler for forcing a revert operation.
 * 
 * @author Shterev
 */
public class ForceRevertHandler extends AbstractHistoryViewHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object run(ExecutionEvent event, HistoryBrowserView view, TreeNode node) {
		HistoryInfo historyInfo = (HistoryInfo) node.getValue();
		PrimaryVersionSpec versionSpec = ModelUtil.clone(historyInfo.getPrimerySpec());
		forceRevertCommit(view.getProjectSpace(), versionSpec);
		return null;
	}

	/**
	 * Reverts the commit from a certain revision in a local workspace on the HEAD version that can be committed later.
	 * 
	 * @param versionSpec the version of the commit to revert
	 */
	public void forceRevertCommit(final ProjectSpace projectSpace, final PrimaryVersionSpec versionSpec) {
		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				MessageDialog dialog = new MessageDialog(null, "Confirmation", null,
					"Do you really want to force to revert changes of this version on project "
						+ projectSpace.getProjectName(), MessageDialog.QUESTION, new String[] { "Yes", "No" }, 0);
				int result = dialog.open();
				if (result == Window.OK) {
					checkoutHeadAndReverseCommit(projectSpace, versionSpec);
				}
				return null;
			}

			@Override
			public String getTaskTitle() {
				return "Resolving project versions...";
			}
		};
		try {
			handler.execute(new ExecutionEvent());
		} catch (ExecutionException e) {
			DialogHandler.showErrorDialog(e.getMessage());
		}
	}

	private void checkoutHeadAndReverseCommit(final ProjectSpace projectSpace, final PrimaryVersionSpec versionSpec)
		throws EmfStoreException {

		ConnectionManager connectionManager = WorkspaceManager.getInstance().getConnectionManager();

		ProjectSpace revertSpace = WorkspaceManager
			.getInstance()
			.getCurrentWorkspace()
			.checkout(
				projectSpace.getUsersession(),
				projectSpace.getProjectInfo(),
				connectionManager.resolveVersionSpec(projectSpace.getUsersession().getSessionId(),
					projectSpace.getProjectId(), VersionSpec.HEAD_VERSION));
		PrimaryVersionSpec sourceVersion = ModelUtil.clone(versionSpec);
		sourceVersion.setIdentifier(sourceVersion.getIdentifier() - 1);
		List<ChangePackage> changes = revertSpace.getChanges(sourceVersion, versionSpec);
		if (changes.size() != 1) {
			throw new EmfStoreException("Zero or more than 1 Change Package received for one revision!");
		}
		ChangePackage changePackage = changes.get(0);
		ChangePackage reversedChangePackage = changePackage.reverse();
		reversedChangePackage.apply(revertSpace.getProject(), true);
	}
}