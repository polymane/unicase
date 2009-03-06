/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.tableview.labelprovider.StatusLabelProvider;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * A tableviewer for modelelements.
 * 
 * @author schneidf
 */
public class METableViewer extends TableViewer {
	private final Workspace workspace;

	/**
	 * remove adapter. {@inheritDoc}
	 */
	@Override
	protected void handleDispose(DisposeEvent event) {
		workspace.eAdapters().remove(adapterImpl);
		super.handleDispose(event);
	}

	private Project currentProject;
	private AdapterFactory adapterFactory;
	private AdapterImpl adapterImpl;

	/**
	 * Constructor that directly sets the input of the table view.
	 * 
	 * @param parent the parent control
	 * @param adapterFactory the adapterFactory to use
	 * @param input the new content for the table
	 * @param itemMetaClass the EClass of the items that shall be displayed in the table
	 */
	public METableViewer(Composite parent, AdapterFactory adapterFactory, Object input, EClass itemMetaClass) {
		this(parent, adapterFactory, itemMetaClass);
		this.setInput(input);
	}

	/**
	 * Standard constructor.
	 * 
	 * @param parent the parent control
	 * @param adapterFactory the adapterFactory to use
	 * @param itemMetaClass the EClass of the items that shall be displayed in the table
	 */
	public METableViewer(Composite parent, AdapterFactory adapterFactory, EClass itemMetaClass) {
		super(parent, SWT.FULL_SELECTION);
		this.adapterFactory = adapterFactory;

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					ProjectSpace activeProjectSpace = workspace.getActiveProjectSpace();
					if (activeProjectSpace != null) {
						currentProject = activeProjectSpace.getProject();
						setInput(currentProject);
					}

				}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(adapterImpl);

		this.setAdapterFactory(adapterFactory);

		this.createColumns();
		this.getTable().setLinesVisible(true);
		this.getTable().setHeaderVisible(true);

		// if viewer input is set before columns are created, sometime checkbox images are not shown (or created?)
		// correctly (see GenericColumnLabelProvider for checkbox images)
		if (workspace.getActiveProjectSpace() != null) {
			setInput(workspace.getActiveProjectSpace().getProject());
		}

	}

	/**
	 * Updates the {@code adapterFactory} attribute of this class. Calls {@link #setInput(Object)} to reflect the
	 * changed set of items that shall be displayed.
	 * 
	 * @param adapterFactory the new adapter factory that is used to create the AdapterFactoryContentProvider that
	 *            bridges jFace to EMF provider calls.
	 */
	public void setAdapterFactory(AdapterFactory adapterFactory) {
		this.adapterFactory = adapterFactory;
		AdapterFactoryContentProvider contentProvider = new AdapterFactoryContentProvider(this.adapterFactory);
		this.setContentProvider(contentProvider);

		setInput(currentProject);
	}

	private void createColumns() {
		EAttribute check = TaskPackage.Literals.CHECKABLE__CHECKED;
		TableViewerColumn currentColumn = new TableViewerColumn(this, SWT.CENTER);
		currentColumn.getColumn().setWidth(30);
		currentColumn.getColumn().setMoveable(true);
		currentColumn.getColumn().setResizable(false);
		ColumnLabelProvider provider = new GenericColumnLabelProvider(this, check);
		currentColumn.setLabelProvider(provider);

		EditingSupport es = new CheckableEditingSupport(this);
		currentColumn.setEditingSupport(es);

		TableViewerColumn state = new TableViewerColumn(this, SWT.NONE);
		state.getColumn().setWidth(20);
		state.setLabelProvider(new StatusLabelProvider());
		state.getColumn().setText("State");

		EAttribute name = ModelPackage.Literals.MODEL_ELEMENT__NAME;
		TableViewerColumn nameColumn = prepareStandardColumn(name, 250);
		nameColumn.getColumn().setAlignment(SWT.LEFT);

		EReference assignee = TaskPackage.Literals.WORK_ITEM__ASSIGNEE;
		prepareStandardColumn(assignee, 150);

		EAttribute creator = ModelPackage.Literals.MODEL_ELEMENT__CREATOR;
		prepareStandardColumn(creator, 100);

		EAttribute creationDate = ModelPackage.Literals.MODEL_ELEMENT__CREATION_DATE;
		prepareStandardColumn(creationDate, 150);

		EReference container = TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE;
		prepareStandardColumn(container, 150);

		EAttribute dueDate = TaskPackage.Literals.WORK_ITEM__DUE_DATE;
		prepareStandardColumn(dueDate, 150);

		EAttribute priority = TaskPackage.Literals.WORK_ITEM__PRIORITY;
		prepareStandardColumn(priority, 50);

	}

	private String getFeatureName(EStructuralFeature feature) {
		EStructuralFeature currentFeature = feature;
		String nameLookupString = "_UI_" + ((EClass) currentFeature.eContainer()).getName() + "_"
			+ currentFeature.getName() + "_feature";
		return ModelEditPlugin.INSTANCE.getString(nameLookupString);
	}

	private TableViewerColumn prepareStandardColumn(EStructuralFeature currentFeature, int width) {
		TableViewerColumn currentColumn = new TableViewerColumn(this, SWT.CENTER);

		String name = getFeatureName(currentFeature);
		currentColumn.getColumn().setText(name);
		currentColumn.getColumn().setWidth(width);

		currentColumn.getColumn().setMoveable(true);
		currentColumn.getColumn().setResizable(true);
		ColumnLabelProvider provider;
		if (currentFeature.getEType().equals(EcorePackage.Literals.EDATE)) {
			provider = new DateColumnLabelProvider(currentFeature);
		} else {
			provider = new GenericColumnLabelProvider(this, currentFeature);
		}
		currentColumn.setLabelProvider(provider);

		ViewerComparator comp = new TableViewerColumnSorter(this, currentColumn, provider);
		currentColumn.getViewer().setComparator(comp);

		return currentColumn;
	}

}