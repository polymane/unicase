/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.wizard;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.ui.iterationplanner.core.IterationPlannerManager;
import org.unicase.workspace.WorkspaceManager;

import java.util.List;

/**
 * In this page user selects backlog, and last sprint.
 * 
 * @author hodaie
 */
public class TaskPage extends WizardPage {

	/**
	 * content provider.
	 * 
	 * @author hodaie
	 */
	private final class WorkPackageTableContentProvider implements
			IStructuredContentProvider {
		@SuppressWarnings("unchecked")
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				return ((List) inputElement).toArray();
			}
			return new Object[0];
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private IterationPlannerManager iterationPlanner;
	private TableViewer tableViewer;

	/**
	 * Constructor.
	 * 
	 * @param planner
	 *            iteration planner.
	 */
	protected TaskPage(IterationPlannerManager planner) {
		super("task page");
		this.iterationPlanner = planner;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		Composite contents = new Composite(parent, SWT.NONE);

		contents.setLayout(new GridLayout(2, false));

		Label lblLastSprint = new Label(contents, SWT.NONE);
		lblLastSprint.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER,
				false, false, 2, 1));
		lblLastSprint
				.setText("Select work packages to include in planning (you will be normally selecting project backlog and last sprint):");

		Button btnAdd = new Button(contents, SWT.PUSH);
		btnAdd.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		btnAdd.setText("Add work package....");
		btnAdd.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				Object[] result = UnicaseUiUtil.showMESelectionDialog(
						getShell(), TaskPackage.eINSTANCE.getWorkPackage(),
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.getActiveProjectSpace().getProject(), true);
				if (result.length > 0) {
					for (int i = 0; i < result.length; i++) {
						iterationPlanner.getTaskProvider().getWorkPackages().add(
								(WorkPackage) result[i]);
					}
				}
				tableViewer.refresh();
			}

		});

		Button btnRemove = new Button(contents, SWT.PUSH);
		btnRemove.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		btnRemove.setText("Remove");
		btnRemove.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				IStructuredSelection sel = (IStructuredSelection) tableViewer
						.getSelection();
				WorkPackage wp = (WorkPackage) sel.getFirstElement();
				if (!wp.equals(iterationPlanner.getTaskProvider().getLastSprint())) {
					iterationPlanner.getTaskProvider().getWorkPackages().remove(wp);
				}
				tableViewer.refresh();
			}

		});

		tableViewer = new TableViewer(contents, SWT.NONE);
		tableViewer.getTable().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		tableViewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		tableViewer.setContentProvider(new WorkPackageTableContentProvider());
		tableViewer.setInput(iterationPlanner.getTaskProvider().getWorkPackages());

		setControl(contents);
		setPageComplete(true);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		tableViewer.refresh();
		return true;
	}

}
