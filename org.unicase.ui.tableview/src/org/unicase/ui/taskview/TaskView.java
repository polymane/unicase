/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.organization.OrganizationFactory;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.util.ProjectChangeObserver;
import org.unicase.ui.common.filter.TeamFilter;
import org.unicase.ui.common.filter.UserFilter;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.UnicaseUiUtil;
import org.unicase.ui.tableview.Activator;
import org.unicase.ui.tableview.labelproviders.IntegerEditingSupport;
import org.unicase.ui.tableview.viewer.METableViewer;
import org.unicase.ui.taskview.filters.BlockedElementsViewerFilter;
import org.unicase.ui.taskview.filters.ResolvedBugReportFilter;
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
	private AdapterImpl workspaceListenerAdapter;
	private Workspace workspace;
	private Project activeProject;

	private UncheckedElementsViewerFilter uncheckedFilter;
	private Action filterToUnchecked;

	private UserFilter userFilter;
	private Action filterToLoggedInUser;
	private IAction filterToSelectedUser;

	private TeamFilter teamFilter;
	private Action filterToTeam;

	private BlockedElementsViewerFilter blockedFilter;
	private Action filterToBlocked;

	private ResolvedBugReportFilter resolvedBugReportFilter;
	private Action filterResolvedBugReports;

	private User selectedUser;
	private User loggedInUser;

	private WorkItemDoneOrResolvedLabelProvider doneOrResolvedLabelProvider;
	private WorkItemDoneOrResolvedEditingSupport doneOrResolvedEditingSupport;
	private Text txtUser;

	private static final String TASKVIEW_FILTERS_GROUP = "taskviewFilters";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {

		viewer = initMETableViewer(parent);

		workspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		workspaceListenerAdapter = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					ProjectSpace activeProjectSpace = workspace.getActiveProjectSpace();
					if (activeProjectSpace != null) {
						activeProject = activeProjectSpace.getProject();
						activeProject.addProjectChangeObserver(TaskView.this);
						initLoggedInUser();
						viewer.setInput(activeProject);
					}

				}
				super.notifyChanged(msg);
			}
		};
		workspace.eAdapters().add(workspaceListenerAdapter);

		createActions();
		initLoggedInUser();

		getSite().setSelectionProvider(viewer.getTableViewer());
		hookDoubleClickAction();

		if (workspace.getActiveProjectSpace() != null) {
			activeProject = workspace.getActiveProjectSpace().getProject();
		}
		viewer.setInput(activeProject);
	}

	/**
	 * 
	 */
	private void createActions() {
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager toolbarManager = bars.getToolBarManager();

		createFilters();

		toolbarManager.add(filterToLoggedInUser);
		filterToSelectedUser = new Action() {
			@Override
			public void run() {
				List<User> users = new ArrayList<User>();
				List<User> projectUsers = activeProject.getAllModelElementsbyClass(OrganizationPackage.eINSTANCE
					.getUser(), new BasicEList<User>());
				users.addAll(projectUsers);
				User noUser = OrganizationFactory.eINSTANCE.createUser();
				noUser.setName("[no user]");
				users.add(noUser);
				Object[] userArray = UnicaseUiUtil.showMESelectionDialog(TaskView.this.getSite().getShell(), users,
					"Select user", false);
				if (userArray.length > 0) {
					selectedUser = (User) userArray[0];
					if (selectedUser.getName().equals("[no user]")) {
						selectedUser = null;
					}
					setUserFilter(true, selectedUser);
					setTeamFilter(filterToTeam.isChecked(), selectedUser);
					setResolvedBugReportsFilter(filterResolvedBugReports.isChecked(), selectedUser);
					filterToLoggedInUser.setChecked(false);
				}
			}
		};
		filterToSelectedUser.setToolTipText("Select a user to filter to his/her tasks.");
		filterToSelectedUser.setImageDescriptor(Activator.getImageDescriptor("/icons/User.gif"));
		toolbarManager.add(filterToSelectedUser);
		ControlContribution userTextToolbarContribution = new ControlContribution("userTextl") {

			@Override
			protected Control createControl(Composite parent) {
				Composite composite = new Composite(parent, SWT.NONE);
				GridLayout layout = new GridLayout();
				layout.verticalSpacing = 0;
				layout.marginHeight = 0;
				composite.setLayout(layout);
				txtUser = new Text(composite, SWT.BORDER);
				GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
				layoutData.widthHint = 100;
				txtUser.setLayoutData(layoutData);
				txtUser.setEditable(false);
				if (loggedInUser != null && filterToLoggedInUser.isChecked()) {
					txtUser.setText(loggedInUser.getName());
				} else {
					txtUser.setText("[no user]");
				}

				return composite;
			}

		};
		toolbarManager.add(userTextToolbarContribution);
		toolbarManager.add(filterToTeam);
		toolbarManager.add(filterResolvedBugReports);

		toolbarManager.add(filterToUnchecked);

		toolbarManager.add(filterToBlocked);

		Separator taskviewFiltersSeperator = new Separator(TASKVIEW_FILTERS_GROUP);
		toolbarManager.add(taskviewFiltersSeperator);

		toolbarManager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		Separator separator2 = new Separator("separator2");
		toolbarManager.insertAfter(IWorkbenchActionConstants.MB_ADDITIONS, separator2);

		Action showHideColumnsAction = new Action() {
			@Override
			public void run() {
				List<String> columnsToShow = viewer.displayShowHideColumnsDialog();
				viewer.showColumns(columnsToShow);
			}

		};
		showHideColumnsAction.setToolTipText("Show/Hide columns");
		showHideColumnsAction.setImageDescriptor(Activator.getImageDescriptor("/icons/table.png"));
		toolbarManager.add(showHideColumnsAction);
	}

	private void createFilters() {
		blockedFilter = new BlockedElementsViewerFilter();
		filterToBlocked = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				setBlockedFilter(isChecked());

			}

		};
		filterToBlocked.setImageDescriptor(Activator.getImageDescriptor("/icons/blocked.gif"));
		filterToBlocked.setToolTipText("Besides the unblocked elements, the blocked ones will be shown as well.");
		Boolean blockedFilterCheckState = Boolean.parseBoolean(getDialogSettings().get("BlockedFilter"));
		filterToBlocked.setChecked(blockedFilterCheckState);
		setBlockedFilter(blockedFilterCheckState);

		//
		// unchecked filter
		//
		uncheckedFilter = new UncheckedElementsViewerFilter();
		filterToUnchecked = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				setUncheckedFilter(isChecked());
			}

		};
		filterToUnchecked.setImageDescriptor(Activator.getImageDescriptor("/icons/tick.png"));
		filterToUnchecked.setToolTipText("Besides the unchecked elements, the checked ones will be shown as well.");
		Boolean uncheckedFilterCheckState = Boolean.parseBoolean(getDialogSettings().get("UncheckedFilter"));
		filterToUnchecked.setChecked(uncheckedFilterCheckState);
		setUncheckedFilter(uncheckedFilterCheckState);

		//
		// user filter
		//
		userFilter = new UserFilter(selectedUser);
		filterToLoggedInUser = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				setUserFilter(isChecked(), loggedInUser);
				selectedUser = null;
			}

		};
		filterToLoggedInUser.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertouser.png"));
		filterToLoggedInUser.setToolTipText("Restricts the displayed table items to items owned by the current user.");
		final Boolean userFilterCheckState = Boolean.parseBoolean(getDialogSettings().get("UserFilter"));
		filterToLoggedInUser.setChecked(userFilterCheckState);

		//
		// resolved bug reports filter
		//
		resolvedBugReportFilter = new ResolvedBugReportFilter(selectedUser);
		filterResolvedBugReports = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (loggedInUser != null && userFilterCheckState) {
					setResolvedBugReportsFilter(isChecked(), loggedInUser);
				} else {
					setResolvedBugReportsFilter(isChecked(), selectedUser);
				}

			}

		};
		filterResolvedBugReports.setImageDescriptor(Activator.getImageDescriptor("/icons/Bug_resolved.png"));
		filterResolvedBugReports.setToolTipText("Show/Hide resolved bug reports.");
		Boolean resolvedBugReportsCheckState = Boolean
			.parseBoolean(getDialogSettings().get("ResolvedBugReportsFilter"));
		filterResolvedBugReports.setChecked(resolvedBugReportsCheckState);
		if (loggedInUser != null && filterToSelectedUser.isChecked()) {
			setResolvedBugReportsFilter(resolvedBugReportsCheckState, loggedInUser);
		} else {
			setResolvedBugReportsFilter(resolvedBugReportsCheckState, selectedUser);
		}

		//
		// team filter
		//
		teamFilter = new TeamFilter(selectedUser);
		filterToTeam = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (loggedInUser != null && filterToSelectedUser.isChecked()) {
					setTeamFilter(isChecked(), loggedInUser);
				} else {
					setTeamFilter(isChecked(), selectedUser);
				}

			}

		};
		filterToTeam.setImageDescriptor(Activator.getImageDescriptor("/icons/filtertomyteam.png"));
		filterToTeam
			.setToolTipText("Restricts the displayed table items to items owned by the current user and it's teammates.");
		Boolean teamFilterCeckState = Boolean.parseBoolean(getDialogSettings().get("TeamFilter"));
		filterToTeam.setChecked(teamFilterCeckState);
		if (loggedInUser != null && userFilterCheckState) {
			setTeamFilter(teamFilterCeckState, loggedInUser);
		} else {
			setTeamFilter(teamFilterCeckState, selectedUser);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(workspaceListenerAdapter);
		if (activeProject != null) {
			workspace.getActiveProjectSpace().getProject().removeProjectChangeObserver(this);
		}

		super.dispose();
	}

	private void hookDoubleClickAction() {
		final Action doubleClickAction = new Action() {
			@Override
			public void run() {
				ActionHelper.openModelElement(ActionHelper.getSelectedModelElement(), TaskView.class.getName());
			}
		};
		viewer.setDoubleClickAction(doubleClickAction);
	}

	private METableViewer initMETableViewer(Composite parent) {
		METableViewer metv = new METableViewer(parent, TaskPackage.eINSTANCE.getCheckable());
		List<METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>> features = new ArrayList<METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>>();
		// features.add(TaskPackage.Literals.CHECKABLE__CHECKED);
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			ModelPackage.Literals.MODEL_ELEMENT__STATE, null));
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			ModelPackage.Literals.MODEL_ELEMENT__NAME, null));
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			TaskPackage.Literals.WORK_ITEM__ASSIGNEE, null));
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			ModelPackage.Literals.MODEL_ELEMENT__CREATION_DATE, null));
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			ModelPackage.Literals.MODEL_ELEMENT__CREATOR, null));
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			TaskPackage.Literals.WORK_ITEM__CONTAINING_WORKPACKAGE, null));
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			TaskPackage.Literals.WORK_ITEM__DUE_DATE, null));
		features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
			TaskPackage.Literals.WORK_ITEM__PRIORITY, new IntegerEditingSupport(metv.getTableViewer(),
				TaskPackage.Literals.WORK_ITEM__PRIORITY)));
		// features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
		// TaskPackage.Literals.WORK_ITEM__ESTIMATE, new IntegerEditingSupport(metv.getTableViewer(),
		// TaskPackage.Literals.WORK_ITEM__ESTIMATE)));
		// features.add(new METableViewer.FeatureEditignSupportPair<EStructuralFeature, EditingSupport>(
		// TaskPackage.Literals.WORK_ITEM__EFFORT, new IntegerEditingSupport(metv.getTableViewer(),
		// TaskPackage.Literals.WORK_ITEM__EFFORT)));

		metv.createColumnsWithEditingSupport(features);

		doneOrResolvedLabelProvider = new WorkItemDoneOrResolvedLabelProvider();
		doneOrResolvedLabelProvider.setCurrentUser(loggedInUser);
		doneOrResolvedEditingSupport = new WorkItemDoneOrResolvedEditingSupport(metv.getTableViewer(), loggedInUser);
		metv.addCustomColumn(0, "Done/Resolved", 30, SWT.NONE, false, doneOrResolvedLabelProvider,
			doneOrResolvedEditingSupport);
		return metv;
	}

	private void initLoggedInUser() {
		try {
			loggedInUser = OrgUnitHelper.getCurrentUser(WorkspaceManager.getInstance().getCurrentWorkspace());
		} catch (NoCurrentUserException e) {
			loggedInUser = null;
		} catch (CannotMatchUserInProjectException e) {
			loggedInUser = null;
		}
		selectedUser = null;
		viewer.removeFilter(userFilter);
		viewer.removeFilter(teamFilter);
		viewer.removeFilter(resolvedBugReportFilter);
		if (txtUser != null) {
			txtUser.setText("[no user]");
		}

		updateFilters();

	}

	private void updateFilters() {
		if (loggedInUser == null) {
			filterToLoggedInUser.setEnabled(false);
			if (selectedUser != null) {
				setUserFilter(true, selectedUser);
				setTeamFilter(true, selectedUser);
				// here false = set filter
				setResolvedBugReportsFilter(false, selectedUser);
			} else {
				setUserFilter(false, null);
				setTeamFilter(false, null);
				setResolvedBugReportsFilter(true, null);
			}

		} else {
			filterToLoggedInUser.setEnabled(true);
			if (filterToLoggedInUser.isChecked()) {
				setUserFilter(true, loggedInUser);
				setTeamFilter(filterToTeam.isChecked(), loggedInUser);
				setResolvedBugReportsFilter(filterResolvedBugReports.isChecked(), loggedInUser);
			}

		}

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
			viewer.refresh();
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
			viewer.refresh();
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
			viewer.refresh();
		}
	}

	/**
	 * Sets the blocked filter.
	 * 
	 * @param checked if the blocked filter is activated.
	 */
	protected void setBlockedFilter(boolean checked) {
		if (!checked) {
			viewer.addFilter(blockedFilter);

		} else {
			viewer.removeFilter(blockedFilter);
		}
		getDialogSettings().put("BlockedFilter", filterToBlocked.isChecked());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.getTableViewer().getTable().setFocus();
		EventUtil.logFocusEvent("org.unicase.ui.taskview");
	}

	/**
	 * sets the resolved bug report filter.
	 * 
	 * @param checked if resolved bug reports are filtered.
	 * @param user user
	 */
	protected void setResolvedBugReportsFilter(boolean checked, User user) {
		if (!checked) {
			if (resolvedBugReportFilter != null) {
				resolvedBugReportFilter.setUser(user);
				viewer.addFilter(resolvedBugReportFilter);
			}
		} else {
			if (resolvedBugReportFilter != null) {
				viewer.removeFilter(resolvedBugReportFilter);
			}
		}
		getDialogSettings().put("ResolvedBugReportsFilter", filterResolvedBugReports.isChecked());
	}

	/**
	 * Sets the teamfilter.
	 * 
	 * @param checked if filtered
	 * @param user user
	 */
	protected void setTeamFilter(boolean checked, User user) {
		if (checked) {
			if (teamFilter != null) {
				teamFilter.setUser(user);
				viewer.addFilter(teamFilter);
			}
		} else {
			if (teamFilter != null) {
				viewer.removeFilter(teamFilter);
			}
		}
		getDialogSettings().put("TeamFilter", filterToTeam.isChecked());

	}

	/**
	 * sets the uncheckd filter.
	 * 
	 * @param checked if filtered
	 */
	protected void setUncheckedFilter(boolean checked) {
		if (!checked) {
			viewer.addFilter(uncheckedFilter);
		} else {
			viewer.removeFilter(uncheckedFilter);
		}
		getDialogSettings().put("UncheckedFilter", filterToUnchecked.isChecked());

	}

	/**
	 * sets the userfilter.
	 * 
	 * @param checked if fileterd.
	 * @param user to which must be filtered
	 */
	protected void setUserFilter(boolean checked, User user) {
		updateLabelProvider(user);
		if (checked) {
			if (userFilter != null) {
				userFilter.setUser(user);
				viewer.addFilter(userFilter);
				if (txtUser == null) {
					return;
				}
				if (user != null) {
					txtUser.setText(user.getName());
				} else {
					txtUser.setText("[no user]");
				}

			}
		} else {
			if (userFilter != null) {
				viewer.removeFilter(userFilter);
				if (txtUser != null) {
					txtUser.setText("[no user]");
				}
			}
		}
		getDialogSettings().put("UserFilter", filterToLoggedInUser.isChecked());
	}

	private void updateLabelProvider(User user) {
		doneOrResolvedEditingSupport.setCurrentUser(user);
		doneOrResolvedLabelProvider.setCurrentUser(user);
	}

	private IDialogSettings getDialogSettings() {
		return Activator.getDefault().getDialogSettings();
	}
}
