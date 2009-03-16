/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.esbrowser.views;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * Wizard for adding a new repository.
 * 
 * @author shterev
 */
public class NewRepositoryWizard extends Wizard implements INewWizard {

	private ServerInfo serverInfo;

	private NewRepositoryWizardPageOne mainPage;

	private IStructuredSelection selection;

	private IWorkbench workbench;

	private ESBrowserView view;
	private boolean edit;

	/**
	 * Default constructor.
	 * 
	 * @param view callback to the repository view
	 */
	public NewRepositoryWizard(ESBrowserView view) {
		super();
		this.view = view;
	}

	/**
	 * Adds all pages in the wizard.
	 */
	@Override
	public void addPages() {
		mainPage = new NewRepositoryWizardPageOne(workbench, selection);
		addPage(mainPage);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @param workbench the workbench
	 * @param selection the selection
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
	}

	/**
	 *{@inheritDoc}
	 * 
	 * @param workbench the workbench
	 * @param selection the selection
	 * @param serverInfo the serverInfo that would be modified
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection, ServerInfo serverInfo) {
		init(workbench, selection);
		this.serverInfo = serverInfo;
		this.edit = true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canFinish() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		if (this.getContainer().getCurrentPage().canFlipToNextPage()) {
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					// save serverInfo to workspace
					Workspace workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
					if (!NewRepositoryWizard.this.edit) {
						workspace.getServerInfos().add(NewRepositoryWizard.this.serverInfo);
					}
					workspace.save();
				}
			});
			view.getViewer().refresh();
			dispose();
		} else {
			MessageDialog.openError(workbench.getActiveWorkbenchWindow().getShell(), "Error",
				"Field(s) were left blank!");
		}
		return true;
	}

	/**
	 * Getter for the ServerInfo.
	 * 
	 * @return the {@link ServerInfo}
	 */
	public ServerInfo getServerInfo() {
		return serverInfo;
	}

}