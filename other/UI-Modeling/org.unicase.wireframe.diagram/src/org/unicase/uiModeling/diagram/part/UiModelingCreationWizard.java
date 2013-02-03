/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class UiModelingCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected org.unicase.uiModeling.diagram.part.UiModelingCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected org.unicase.uiModeling.diagram.part.UiModelingCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(org.unicase.uiModeling.diagram.part.Messages.UiModelingCreationWizardTitle);
		setDefaultPageImageDescriptor(org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin
			.getBundledImageDescriptor("icons/wizban/NewUiModelingWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		diagramModelFilePage = new org.unicase.uiModeling.diagram.part.UiModelingCreationWizardPage(
			"DiagramModelFile", getSelection(), "uimodeling_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage
			.setTitle(org.unicase.uiModeling.diagram.part.Messages.UiModelingCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage
			.setDescription(org.unicase.uiModeling.diagram.part.Messages.UiModelingCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new org.unicase.uiModeling.diagram.part.UiModelingCreationWizardPage(
			"DomainModelFile", getSelection(), "uimodeling") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".uimodeling_diagram".length()); //$NON-NLS-1$
					setFileName(org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorUtil.getUniqueFileName(
						getContainerFullPath(), fileName, "uimodeling")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage
			.setTitle(org.unicase.uiModeling.diagram.part.Messages.UiModelingCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage
			.setDescription(org.unicase.uiModeling.diagram.part.Messages.UiModelingCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorUtil.createDiagram(
					diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
							org.unicase.uiModeling.diagram.part.Messages.UiModelingCreationWizardOpenEditorError, null,
							e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
					org.unicase.uiModeling.diagram.part.Messages.UiModelingCreationWizardCreationError, null,
					((CoreException) e.getTargetException()).getStatus());
			} else {
				org.unicase.uiModeling.diagram.part.UiModelingDiagramEditorPlugin.getInstance().logError(
					"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
