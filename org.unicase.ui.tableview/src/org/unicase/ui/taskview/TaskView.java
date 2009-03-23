/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.tableview.Activator;
import org.unicase.ui.tableview.viewer.METableViewer;
import org.unicase.ui.taskview.filters.BlockedElementsViewerFilter;
import org.unicase.ui.taskview.filters.UncheckedElementsViewerFilter;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.exceptions.CannotMatchUserInProjectException;
import org.unicase.workspace.util.EventUtil;
import org.unicase.workspace.util.NoCurrentUserException;
import org.unicase.workspace.util.OrgUnitHelper;

/**
 * TaskView shows checkables (work items which can be set to done).
 * 
 * @author Florian Schneider
 * @author Zardosht Hodaie
 */
public class TaskView extends ViewPart implements ProjectChangeObserver {

	private METableViewer viewer;
	private TableViewer tableViewer;
	// private final EClass itemMetaClass = TaskPackage.eINSTANCE.getWorkItem();
	// private FilteredItemProviderAdapterFactory adapterFactory;
	// private Action doubleClickAction;
	private DialogSettings settings;
	private String filename;
	private AdapterImpl adapterImpl;
	private Workspace workspace;

	private UncheckedElementsViewerFilter uncheckedFilter;
	private Action filterToUnchecked;
	//
	// private UserFilter userFilter;
	// private Action filterToMe;
	//
	// private TeamFilter teamFilter;
	// private Action filterToMyTeam;
	//
	private BlockedElementsViewerFilter blockedFilter;
	private Action filterToBlocked;
	//
	// private ResolvedBugReportFilter resolvedBugReportFilter;
	// private Action filterResolvedBugReports;
	private User currentUser;
	private WorkItemDoneOrResolvedLabelProvider doneOrResolvedLabelProvider;
	private WorkItemDoneOrResolvedEditingSupport doneOrResolvedEditingSupport;

	/**
	 * default constructor.
	 */

	public TaskView() {
		super();
		IPath path = Activator.getDefault().getStateLocation();
		filename = path.append("settings.txt").toOSString();
		settings = new DialogSettings("Top");
		try {
			settings.load(filename);
		} catch (IOException e) {
			// Do nothing.
		}
		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

		viewer = initMETableViewer(parent);
		tableViewer = viewer.getTableViewer();

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					ProjectSpace activeProjectSpace = workspace.getActiveProjectSpace();
					if (activeProjectSpace != null) {
						Project currentProject = activeProjectSpace.getProject();
						currentProject.addProjectChangeObserver(TaskView.this);
						initUserDependentFilters();
						doneOrResolvedEditingSupport.setCurrentUser(currentUser);
						doneOrResolvedLabelProvider.setCurrentUser(currentUser);
						viewer.setInput(currentProject);
					}

				}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(adapterImpl);

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();

		initUserDependentFilters();
		// menuManager.add(filterToMe);
		// menuManager.add(filterToMyTeam);
		// menuManager.add(filterResolvedBugReports);
		//
		// // Create Checked filter
		//
		createCheckedFilter();
		menuManager.add(filterToUnchecked);

		createBlockedFilter();
		menuManager.add(filterToBlocked);

		getSite().setSelectionProvider(tableViewer);
		hookDoubleClickAction();
	}

	private METableViewer initMETableViewer(Composite parent) {
		METableViewer metv = new METableViewer(parent, TaskPackage.eINSTANCE.getCheckable());
		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		// features.add(TaskPackage.Literals.CHECKABLE__CHECKED);
		features.add(ModelPackage.Literals.MODEL_ELEMENT__STATE);
		features.add(ModelPackage.Literals.MODEL_ELEMENT__NAME);
		features.add(TaskPackage.Literals.WORK_ITEM__ASSIGNEE);
		features.add(ModelPackage.Literals.MODEL_ELEMENT__CREATION_DATE);
		features.add(ModelPackage.Literals.MODEL_ELEMENT__CREATOR);
		features.add(TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE);
		features.add(TaskPackage.Literals.WORK_ITEM__DUE_DATE);
		features.add(TaskPackage.Literals.WORK_ITEM__PRIORITY);
		metv.createColumns(features);
		doneOrResolvedLabelProvider = new WorkItemDoneOrResolvedLabelProvider();
		doneOrResolvedLabelProvider.setCurrentUser(currentUser);
		doneOrResolvedEditingSupport = new WorkItemDoneOrResolvedEditingSupport(metv.getTableViewer(), currentUser);
		metv.addCustomColumn(0, "", 25, SWT.NONE, false, doneOrResolvedLabelProvider, doneOrResolvedEditingSupport);
		return metv;
	}

	private void createBlockedFilter() {
		blockedFilter = new BlockedElementsViewerFilter();
		filterToBlocked = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				// setBlockedFilter(isChecked());
				List<String> columnsToShow = viewer.displayShowHideColumnsDialog();
				viewer.showColumns(columnsToShow);
			}

		};
		filterToBlocked.setImageDescriptor(Activator.getImageDescriptor("/icons/blocked.gif"));
		Boolean blockedFilterBoolean = Boolean.parseBoolean(settings.get("BlockedFilter"));
		filterToBlocked.setChecked(blockedFilterBoolean);
		filterToBlocked.setToolTipText("Besides the unblocked elements, the blocked ones will be shown as well.");
		// setBlockedFilter(blockedFilterBoolean);

	}

	/**
	 * Sets the blocked filter.
	 * 
	 * @param checked if the blocked filter is activated.
	 */
	protected void setBlockedFilter(boolean checked) {
		if (!checked) {
			tableViewer.addFilter(blockedFilter);
		} else {
			tableViewer.removeFilter(blockedFilter);
		}

	}

	private void initUserDependentFilters() {
		try {

			currentUser = OrgUnitHelper.getCurrentUser(WorkspaceManager.getInstance().getCurrentWorkspace());
			// Create User filter
			// createUserFilter(currentUser);
			// Create Team Filter
			// createTeamFilter(currentUser);
			// create resolved bug reports filter
			// createResolvedBugReportFilter(currentUser);

		} catch (NoCurrentUserException e) {
			currentUser = null;
			// Disable filter
			// createUserFilter(null);
			// createTeamFilter(null);
			// createResolvedBugReportFilter(null);
		} catch (CannotMatchUserInProjectException e) {
			currentUser = null;
			// Disable filter
			// createUserFilter(null);
			// createTeamFilter(null);
			// createResolvedBugReportFilter(null);
		}
	}

	// private void createTeamFilter(User user) {
	// if (filterToMyTeam == null) {
	// filterToMyTeam = new Action("", SWT.TOGGLE) {
	// @Override
	// public void run() {
	// setTeamFilter(isChecked());
	// }
	//
	// };
	// filterToMyTeam.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertomyteam.png"));
	// Boolean teamFilter = Boolean.parseBoolean(settings.get("TeamFilter"));
	// filterToMyTeam.setChecked(teamFilter);
	// }
	// if (user == null) {
	// setTeamFilter(false);
	// filterToMyTeam.setEnabled(false);
	// return;
	// }
	// if (teamFilter != null) {
	// tableViewer.removeFilter(teamFilter);
	// }
	// filterToMyTeam
	// .setToolTipText("Restricts the displayed table items to items owned by the current user and it's teammates.");
	// filterToMyTeam.setEnabled(true);
	// teamFilter = new TeamFilter(user);
	// setTeamFilter(filterToMyTeam.isChecked());
	// }

	/**
	 * Sets the teamfilter.
	 * 
	 * @param checked if filtered
	 */
	// protected void setTeamFilter(boolean checked) {
	// if (checked) {
	// if (teamFilter != null) {
	// tableViewer.addFilter(teamFilter);
	// }
	// } else {
	// if (teamFilter != null) {
	// tableViewer.removeFilter(teamFilter);
	// }
	// }
	//
	// }
	private void createCheckedFilter() {
		uncheckedFilter = new UncheckedElementsViewerFilter();
		filterToUnchecked = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				setUncheckedFilter(isChecked());
			}

		};
		filterToUnchecked.setImageDescriptor(Activator.getImageDescriptor("/icons/tick.png"));
		Boolean uncheckedFilter = Boolean.parseBoolean(settings.get("UncheckedFilter"));
		filterToUnchecked.setChecked(uncheckedFilter);
		filterToUnchecked.setToolTipText("Besides the unchecked elements, the checked ones will be shown as well.");
		setUncheckedFilter(uncheckedFilter);
	}

	// private void createUserFilter(User user) {
	// if (filterToMe == null) {
	// filterToMe = new Action("", SWT.TOGGLE) {
	// @Override
	// public void run() {
	// setUserFilter(isChecked());
	// }
	//
	// };
	// filterToMe.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertouser.png"));
	// Boolean isUserFilter = Boolean.parseBoolean(settings.get("UserFilter"));
	// filterToMe.setChecked(isUserFilter);
	// }
	// if (user == null) {
	// setUserFilter(false);
	// filterToMe.setEnabled(false);
	// return;
	// }
	// if (userFilter != null) {
	// tableViewer.removeFilter(userFilter);
	// }
	// filterToMe.setEnabled(true);
	// userFilter = new UserFilter(user);
	// filterToMe.setToolTipText("Restricts the displayed table items to items owned by the current user.");
	// setUserFilter(filterToMe.isChecked());
	// }
	//
	// private void createResolvedBugReportFilter(User user) {
	//
	// if (filterResolvedBugReports == null) {
	// filterResolvedBugReports = new Action("", SWT.TOGGLE) {
	// @Override
	// public void run() {
	// setResolvedBugReportsFilter(isChecked());
	// }
	//
	// };
	// filterResolvedBugReports.setImageDescriptor(Activator.getImageDescriptor("/icons/Bug_resolved.png"));
	// Boolean resolvedBugReportsFilterBoolean = Boolean.parseBoolean(settings.get("ResolvedBugReportsFilter"));
	// filterResolvedBugReports.setChecked(resolvedBugReportsFilterBoolean);
	// filterResolvedBugReports.setToolTipText("Show/Hide resolved bug reports.");
	// }
	//
	// if (user == null) {
	// setResolvedBugReportsFilter(false);
	// filterResolvedBugReports.setEnabled(false);
	// return;
	// }
	//
	// if (resolvedBugReportFilter != null) {
	// tableViewer.removeFilter(userFilter);
	// }
	// filterResolvedBugReports.setEnabled(true);
	// resolvedBugReportFilter = new ResolvedBugReportFilter(user);
	// setResolvedBugReportsFilter(filterResolvedBugReports.isChecked());
	//
	// }
	//
	/**
	 * sets the uncheckd filter.
	 * 
	 * @param checked if filtered
	 */
	protected void setUncheckedFilter(boolean checked) {
		if (!checked) {
			tableViewer.addFilter(uncheckedFilter);
		} else {
			tableViewer.removeFilter(uncheckedFilter);
		}

	}

	/**
	 * sets the userfilter.
	 * 
	 * @param checked if fileterd.
	 */
	// protected void setUserFilter(boolean checked) {
	// if (checked) {
	// if (userFilter != null) {
	// tableViewer.addFilter(userFilter);
	// }
	// } else {
	// if (userFilter != null) {
	// tableViewer.removeFilter(userFilter);
	// }
	// }
	//
	// }
	//
	// /**
	// * sets the resolved bug report filter.
	// *
	// * @param checked if resolved bug reports are filtered.
	// */
	// protected void setResolvedBugReportsFilter(boolean checked) {
	// if (!checked) {
	// if (resolvedBugReportFilter != null) {
	// tableViewer.addFilter(resolvedBugReportFilter);
	// }
	// } else {
	// if (resolvedBugReportFilter != null) {
	// tableViewer.removeFilter(resolvedBugReportFilter);
	// }
	// }
	// }
	private void hookDoubleClickAction() {
		final Action doubleClickAction = new Action() {
			@Override
			public void run() {
				ActionHelper.openModelElement(ActionHelper.getSelectedModelElement(), TaskView.class.getName());
			}
		};
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		tableViewer.getTable().setFocus();
		EventUtil.logFocusEvent("org.unicase.ui.taskview");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProjectSpace() != null && workspace.getActiveProjectSpace().getProject() != null) {
			workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(this);
		}
		// settings.put("TeamFilter", filterToMyTeam.isChecked());
		settings.put("UncheckedFilter", filterToUnchecked.isChecked());
		// settings.put("UserFilter", filterToMe.isChecked());
		settings.put("BlockedFilter", filterToBlocked.isChecked());
		// settings.put("ResolvedBugReportsFilter", filterResolvedBugReports.isChecked());
		try {
			settings.save(filename);
		} catch (IOException e) {
			// JH Auto-generated catch block
			e.printStackTrace();
		}

		super.dispose();
	}

	/**
	 * Refresh the view if a work item has been added.
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementAdded(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 * @param project the project
	 * @param modelElement the model element
	 */
	public void modelElementAdded(Project project, ModelElement modelElement) {
		if (modelElement instanceof Checkable) {
			tableViewer.refresh();
		}
	}

	/**
	 * Refresh the view if a work item has been removed.
	 * 
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementRemoved(org.unicase.model.Project,
	 *      org.unicase.model.ModelElement)
	 * @param project the project
	 * @param modelElement the model element
	 */
	public void modelElementRemoved(Project project, ModelElement modelElement) {
		if (modelElement instanceof Checkable) {
			tableViewer.refresh();
		}
	}

	/**
	 * Refresh the view if a work item if notify has been called. Notify gets called when the model element has been
	 * changed or the container of the ME has been changed. y * @see
	 * org.unicase.model.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 * org.unicase.model.Project, org.unicase.model.ModelElement)
	 * 
	 * @param notification the notification
	 * @param project the project
	 * @param modelElement the model element
	 */
	public void notify(Notification notification, Project project, ModelElement modelElement) {
		if (modelElement instanceof Checkable) {
			tableViewer.update(modelElement, null);
		}
	}

	/**
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteCompleted(org.unicase.model.ModelElement)
	 *      {@inheritDoc}
	 */
	public void modelElementDeleteCompleted(ModelElement modelElement) {
	}

	/**
	 * @see org.unicase.model.util.ProjectChangeObserver#modelElementDeleteStarted(org.unicase.model.ModelElement)
	 *      {@inheritDoc}
	 */
	public void modelElementDeleteStarted(ModelElement modelElement) {
	}

}
