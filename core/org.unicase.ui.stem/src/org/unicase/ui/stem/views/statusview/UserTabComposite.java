/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject;
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.stem.views.AssignedToLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.AssignedToEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectEditingSupport;
import org.unicase.ui.stem.views.iterationplanningview.TaskObjectLabelProvider;
import org.unicase.ui.stem.views.iterationplanningview.WorkPackageColumnLabelProvider;
import org.unicase.ui.stem.views.statusview.dnd.StatusViewTabsDragAdapter;
import org.unicase.ui.stem.views.statusview.dnd.UserTabDropAdapter;
import org.unicase.ui.tableview.labelproviders.IntegerEditingSupport;
import org.unicase.ui.unicasecommon.common.TreeViewerColumnSorter;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * This class provides contents of users tab in Status view. It contains a TreeViewer showing all OrgUnits participating
 * in progress of input model element. The TreeView has only two levels. At root level are the OrgUnits. The children
 * are Assignables corresponding the input element which are assigned to this OrgUnit.
 * 
 * @author Hodaie
 */
public class UserTabComposite extends Composite implements IdEObjectCollectionChangeObserver {

	private TreeViewer treeViewer;
	private UserTabStatusColumnLabelProvider statusColumnLabelProvider;
	private UserTabDropAdapter userTabDropAdapter;
	private StatusViewTabsDragAdapter userTabDragAdapter;
	private ECPWorkspace workspace;
	private AdapterImpl adapterImpl;

	// private ModelElement input;

	/**
	 * Constructor.
	 * 
	 * @param parent parent
	 * @param style style
	 * @param statusView status view. Used to register context menu on user tab.
	 */
	public UserTabComposite(Composite parent, int style, StatusView statusView) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree(statusView);

		try {
			workspace = ECPWorkspaceManager.getInstance().getWorkSpace();
		} catch (NoWorkspaceException e) {
			ModelUtil.logException("Failed to receive Project!", e);
			return;
		}
		if (workspace.getActiveProject() != null) {
			((Project) workspace.getActiveProject().getRootContainer()).addIdEObjectCollectionChangeObserver(this);
		}
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(ECPWorkspace.class)) == org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT) {

					// remove old listeners
					Object oldValue = msg.getOldValue();
					if (oldValue instanceof ECPProject) {
						((Project) ((ECPProject) oldValue).getRootContainer())
							.removeIdEObjectCollectionChangeObserver(UserTabComposite.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProject() != null) {
						((Project) workspace.getActiveProject().getRootContainer())
							.addIdEObjectCollectionChangeObserver(UserTabComposite.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);
	}

	private void createTree(StatusView statusView) {
		treeViewer = new TreeViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		UserTabContentProvider contentProvider = new UserTabContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new UserTabLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		addColumns(contentProvider);

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				if (sel.getFirstElement() instanceof UnicaseModelElement) {
					UnicaseActionHelper.openModelElement((UnicaseModelElement) sel.getFirstElement(), treeViewer
						.getClass().getName());
				}
			}

		});

		addDnDSupport();
		registerContextMenu(statusView);

	}

	private void registerContextMenu(StatusView statusView) {
		statusView.getSite().setSelectionProvider(treeViewer);
		MenuManager menuManager = new MenuManager();
		statusView.getSite().registerContextMenu("org.unicase.ui.stem.StatusView.UserTab", menuManager, treeViewer);
		Menu contextMenu = menuManager.createContextMenu(treeViewer.getTree());
		treeViewer.getTree().setMenu(contextMenu);
	}

	private void addDnDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };

		userTabDropAdapter = new UserTabDropAdapter();
		treeViewer.addDropSupport(dndOperations, transfers, userTabDropAdapter);
		userTabDragAdapter = new StatusViewTabsDragAdapter(treeViewer);
		treeViewer.addDragSupport(dndOperations, transfers, userTabDragAdapter);

	}

	private void addColumns(UserTabContentProvider contentProvider) {

		Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);

		// root nodes (WorkPackage) and their contained WorkItems
		TreeViewerColumn tclmWorkItem = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmWorkItem.getColumn().setText("WorkItem");
		tclmWorkItem.getColumn().setWidth(300);
		WorkPackageColumnLabelProvider emfColumnLabelProvider = new WorkPackageColumnLabelProvider();
		tclmWorkItem.setLabelProvider(emfColumnLabelProvider);
		new TreeViewerColumnSorter(treeViewer, tclmWorkItem, emfColumnLabelProvider);

		// status column
		TreeViewerColumn status = new TreeViewerColumn(treeViewer, SWT.NONE);
		status.getColumn().setWidth(40);
		statusColumnLabelProvider = new UserTabStatusColumnLabelProvider();
		status.setLabelProvider(statusColumnLabelProvider);
		status.getColumn().setText("State");

		// annotated model element
		TreeViewerColumn tclmAnnotatedME = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmAnnotatedME.getColumn().setText("Annotated");
		tclmAnnotatedME.getColumn().setWidth(200);
		TaskObjectLabelProvider taskObjectLabelProvider = new TaskObjectLabelProvider();
		tclmAnnotatedME.setLabelProvider(taskObjectLabelProvider);
		tclmAnnotatedME.setEditingSupport(new TaskObjectEditingSupport(treeViewer));
		new TreeViewerColumnSorter(treeViewer, tclmAnnotatedME, taskObjectLabelProvider);

		// Assignee
		TreeViewerColumn tclmAssignedTo = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmAssignedTo.getColumn().setText("Assigned to");
		tclmAssignedTo.getColumn().setWidth(100);
		AssignedToLabelProvider assignedToLabelProvider = new AssignedToLabelProvider();
		tclmAssignedTo.setLabelProvider(assignedToLabelProvider);
		tclmAssignedTo.setEditingSupport(new AssignedToEditingSupport(treeViewer));
		new TreeViewerColumnSorter(treeViewer, tclmAssignedTo, assignedToLabelProvider);

		// Priority
		TreeViewerColumn priority = new TreeViewerColumn(treeViewer, SWT.NONE);
		priority.getColumn().setText("Priority");
		priority.getColumn().setWidth(100);
		ColumnLabelProvider priorityLableProvider = new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {

				if (element instanceof WorkItem) {
					return ((WorkItem) element).getPriority() + "";
				}
				return "";
			}

		};
		priority.setLabelProvider(priorityLableProvider);
		priority.setEditingSupport(new IntegerEditingSupport(treeViewer, TaskPackage.eINSTANCE.getWorkItem_Priority()));
		new TreeViewerColumnSorter(treeViewer, priority, priorityLableProvider);

		// Estimate
		TreeViewerColumn estimate = new TreeViewerColumn(treeViewer, SWT.NONE);
		estimate.getColumn().setText("Estimate");
		estimate.getColumn().setWidth(100);
		UserEstimateLabelProvider userEstimateLabelProvider = new UserEstimateLabelProvider(contentProvider);
		estimate.setLabelProvider(userEstimateLabelProvider);
		estimate.setEditingSupport(new IntegerEditingSupport(treeViewer, TaskPackage.eINSTANCE.getWorkItem_Estimate()));
		new TreeViewerColumnSorter(treeViewer, estimate, userEstimateLabelProvider);

	}

	/**
	 * Set input to TreeViewer.
	 * 
	 * @param me input model element
	 * @param statusView the active status view. This is needed for drag and drop.
	 */
	public void setInput(UnicaseModelElement me, StatusView statusView) {
		// this.input = me;
		userTabDropAdapter.setCurrentOpenME(me);
		statusColumnLabelProvider.setCurrentOpenME(me);
		if ((treeViewer.getInput() == null) || (!treeViewer.getInput().equals(me))) {
			treeViewer.setInput(me);
		} else {
			treeViewer.refresh();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementAdded(IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementRemoved(org.unicase.model.UnicaseModelElement)
	 */
	public void modelElementRemoved(IdEObjectCollection project, EObject modelElement) {
		// nothing to do;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.model.UnicaseModelElement)
	 */
	public void notify(Notification notification, IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {

		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProject() != null && workspace.getActiveProject().getRootContainer() != null) {
			((Project) workspace.getActiveProject().getRootContainer()).removeIdEObjectCollectionChangeObserver(this);
		}

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#collectionDeleted(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)
	 */
	public void collectionDeleted(IdEObjectCollection collection) {
		// nothing to do

	}

}
