package org.unicase.ui.web.projectview;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.rwt.graphics.Graphics;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.ui.web.views.ProjectAwareView;

public class ProjectView extends ProjectAwareView {
	
	public static final String ID = "org.unicase.ui.web.projectview.ProjectView";
	
	private WorkItemsTab workItemsTab;
	private TeamListTab teamListTab;
	private CTabFolder tabFolder;
	
	public ProjectView() {
		super();
	}

	/**
	 * Ensures minimum tab height.
	 * 
	 * @param folder
	 */
	private static void ensureMinTabHeight(final CTabFolder folder) {
		int result = Graphics.getCharHeight(folder.getFont());
		if (result < 18) {
			folder.setTabHeight(18);
		}
	}

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		int style = SWT.TOP | SWT.FLAT | SWT.BORDER;
		
		tabFolder = new CTabFolder(parent, style);
		tabFolder.marginWidth = 8;
		tabFolder.marginHeight = 8;
		
		workItemsTab = new WorkItemsTab(projectSpace, tabFolder);
		teamListTab = new TeamListTab(projectSpace, tabFolder);
		
		ensureMinTabHeight(tabFolder);
		
		tabFolder.setSelection(0);
		tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent evt) {
				int index = tabFolder.getSelectionIndex();
		
			}
		});
	}

	@Override
	public void setFocus() {
		
	}

	public void modelElementAdded(Project project, ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();
	}

	public void modelElementDeleteCompleted(Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}

	public void modelElementDeleteStarted(Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}

	public void notify(Notification notification, Project project,
			ModelElement modelElement) {
		workItemsTab.refreshInput();
		teamListTab.refreshInput();		
	}
}
