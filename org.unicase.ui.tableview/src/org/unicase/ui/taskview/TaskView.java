/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.organization.OrganizationPackage;
import org.unicase.model.organization.User;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.tableview.Activator;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;

/**
 * A specialized TableView to display Action Items.
 * 
 * @author Florian Schneider
 * 
 */
public class TaskView extends ViewPart {

	private METableViewer viewer;
	private final EClass itemMetaClass = TaskPackage.eINSTANCE.getWorkItem();
	private FilteredItemProviderAdapterFactory adapterFactory;

	private boolean restrictedToCurrentUser;
	private boolean showChecked;
	private Action doubleClickAction;
	private UncheckedElementsViewerFilter uncheckedElementsVF = new UncheckedElementsViewerFilter();

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		adapterFactory = new FilteredItemProviderAdapterFactory();
		adapterFactory.setFilteredItemProvider(new EClassFilterItemProvider(
				adapterFactory, itemMetaClass));
		viewer = new METableViewer(parent, adapterFactory, itemMetaClass);
		// the task view shall only display objects that are instance of
		// Checkable
		viewer.addFilter(new CheckableViewerFilter());
		// initially, only unchecked elements shall be shown
		viewer.addFilter(uncheckedElementsVF);
		getSite().setSelectionProvider(viewer);
		hookDoubleClickAction();
		// the toolbar contains two buttons: one to restrict the view to the
		// current user, the other one to toggle the exclusion of checked
		// elements.
		getViewSite().getActionBars().getToolBarManager().add(
				new RestrictTableContentToCurrentUserAction(this));
		getViewSite().getActionBars().getToolBarManager().add(
				new ToggleCheckedElementsDisplayAction(this));
	}

	private void hookDoubleClickAction() {
		createDoubleClickAction();
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void createDoubleClickAction() {
		doubleClickAction = new Action() {
			public void run() {
				ActionHelper.openModelElement(ActionHelper
						.getSelectedModelElement());
			}
		};
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.refresh();
	}

	/**
	 * Triggers a viewer update according to the current user session. As a
	 * result, only action items that are assigned to the user that corresponds
	 * to the current user session are displayed.
	 * 
	 * @param restricted
	 *            determines if this view shall be restricted to a specific user
	 *            instance or not
	 */
	public void setRestrictedToCurrentUser(boolean restricted) {
		this.restrictedToCurrentUser = restricted;

		if (restrictedToCurrentUser) {
			Workspace workspace = WorkspaceManager.getInstance()
					.getCurrentWorkspace();
			Usersession currentUserSession = workspace.getActiveProjectSpace()
					.getUsersession();

			EList<User> projectUsers = workspace.getActiveProjectSpace()
					.getProject().getAllModelElementsbyClass(
							OrganizationPackage.eINSTANCE.getUser(),
							new BasicEList<User>());
			// FS tell the user if the project has no users
			for (User currentUser : projectUsers) {
				// FS how can I get the appropriate user from the current user
				// session?
				if (currentUser.getName().equals(
						currentUserSession.getUsername())) {
					adapterFactory
							.setFilteredItemProvider(new UserAndEClassFilterItemProvider(
									adapterFactory, itemMetaClass, currentUser));
					viewer.setAdapterFactory(adapterFactory);
					// first come first serve
					break;
				}
			}
		} else {
			adapterFactory
					.setFilteredItemProvider(new EClassFilterItemProvider(
							adapterFactory, itemMetaClass));
			viewer.setAdapterFactory(adapterFactory);
		}
	}

	/**
	 * 
	 * @return if the view is currently restricted to the current user session
	 *         or not
	 */
	public boolean isRestrictedToCurrentUser() {
		return restrictedToCurrentUser;
	}

	public void toggleShowChecked() {
		showChecked = !showChecked;

		if (showChecked) {
			viewer.removeFilter(uncheckedElementsVF);
		} else {
			viewer.addFilter(uncheckedElementsVF);
		}
	}

	public boolean isShowUncheckedOnly() {
		return showChecked;
	}

	/**
	 * Restricts the items in the task view to those owned by the current user.
	 * 
	 * @author Florian Schneider
	 */
	private class RestrictTableContentToCurrentUserAction extends
			org.eclipse.jface.action.Action {
		private TaskView part;

		public RestrictTableContentToCurrentUserAction(TaskView part) {
			super();
			this.part = part;
			this.setText("Restrict to current user");
			this
					.setToolTipText("Restricts the displayed table items to items owned by the current user.");
			this.setImageDescriptor(Activator
					.getImageDescriptor("icons/User.gif"));
			this.setChecked(part.isRestrictedToCurrentUser());
		}

		@Override
		public void run() {
			super.run();
			part.setRestrictedToCurrentUser(isChecked());
		}
	}

	/**
	 * Restricts the items in the task view to those owned by the current user.
	 * 
	 * @author Florian Schneider
	 */
	private class ToggleCheckedElementsDisplayAction extends
			org.eclipse.jface.action.Action {
		private TaskView part;

		public ToggleCheckedElementsDisplayAction(TaskView part) {
			super();
			this.part = part;
			this.setText("Show checked elements as well");
			this
					.setToolTipText("Besides the unchecked elements, the checked ones will be shown as well.");
			this.setImageDescriptor(Activator
					.getImageDescriptor("icons/tick.png"));
			this.setChecked(part.isShowUncheckedOnly());
		}

		@Override
		public void run() {
			super.run();
			part.toggleShowChecked();
		}
	}
}
