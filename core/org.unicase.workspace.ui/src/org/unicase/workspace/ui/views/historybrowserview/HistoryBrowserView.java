/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.InvalidVersionSpecException;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.accesscontrol.AccessControlHelper;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.ui.views.scm.SCMContentProvider;
import org.unicase.workspace.ui.views.scm.SCMLabelProvider;
import org.unicase.workspace.util.EventUtil;

/**
 * This the History Browser view.
 * 
 * @author Hodaie
 * @author Wesendonk
 * @author Shterev
 */
public class HistoryBrowserView extends ViewPart {

	private static final String VIEW_ID = "org.unicase.workspace.ui.views.historybrowserview";

	private List<HistoryInfo> historyInfos;

	private ProjectSpace projectSpace;

	private int startOffset = 24;

	private int currentEnd;

	private int headVersion;

	private ModelElement modelElement;

	private TreeViewer viewer;
	private Map<Integer, ChangePackage> changePackageCache;

	private ChangePackageVisualizationHelper changePackageVisualizationHelper;

	private SCMContentProvider contentProvider;

	private SCMLabelProvider labelProvider;

	private Action groupByMe;

	private Action showRoots;

	private Label noProjectHint;

	private Composite parent;

	private Action removeTagAction;

	private Action addTagAction;

	private Action checkoutAction;

	/**
	 * Constructor.
	 */
	public HistoryBrowserView() {
		historyInfos = new ArrayList<HistoryInfo>();
		changePackageCache = new HashMap<Integer, ChangePackage>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		this.parent = parent;

		noProjectHint = new Label(parent, SWT.WRAP);
		GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).grab(true, true).applyTo(noProjectHint);
		noProjectHint.setText("Please call 'Show history' from the context menu of an element in the navigator.");

		viewer = new TreeViewer(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		ColumnViewerToolTipSupport.enableFor(viewer); 
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					TreeNode node = (TreeNode) ((IStructuredSelection) event.getSelection()).getFirstElement();
					if (node.getValue() instanceof ModelElement) {
						ActionHelper.openModelElement((ModelElement) node.getValue(), VIEW_ID);
					}
				}

			}
		});

		hookToobar();
		hookContextMenu();

	}

	private void hookToobar() {
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();

		Action expand = new Action() {
			@Override
			public void run() {
				viewer.expandToLevel(2);
			}
			
		};
		
		expand.setImageDescriptor(Activator.getImageDescriptor("icons/expandall.gif"));
		menuManager.add(expand);
		
		Action collapse = new Action() {
			@Override
			public void run() {
				viewer.collapseAll();
			}
			
		};
		collapse.setImageDescriptor(Activator.getImageDescriptor("icons/collapseall.gif"));
		menuManager.add(collapse);
		
		Action refresh = new Action() {
			@Override
			public void run() {
				refresh();
			}

		};
		refresh.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		refresh.setToolTipText("Refresh");
		menuManager.add(refresh);

		groupByMe = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				boolean showRootsCache = contentProvider.showRootNodes();
				if (isChecked()) {
					contentProvider = new SCMContentProvider.Compact(viewer, projectSpace.getProject());
				} else {
					contentProvider = new SCMContentProvider.Detailed(viewer, projectSpace.getProject());
				}
				contentProvider.setShowRootNodes(showRootsCache);
				viewer.setContentProvider(contentProvider);
				viewer.refresh();
			}

		};
		groupByMe.setImageDescriptor(Activator.getImageDescriptor("/icons/groupByME.png"));
		groupByMe.setToolTipText("Group by model element");
		groupByMe.setChecked(true);
		menuManager.add(groupByMe);

		showRoots = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (isChecked()) {
					contentProvider.setShowRootNodes(true);
				} else {
					contentProvider.setShowRootNodes(false);
				}
				viewer.setContentProvider(contentProvider);
				viewer.refresh();
			}

		};
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		showRoots.setImageDescriptor(ImageDescriptor.createFromImage(adapterFactoryLabelProvider
			.getImage(VersioningFactory.eINSTANCE.createChangePackage())));
		showRoots.setToolTipText("Show revision nodes");
		showRoots.setChecked(true);
		menuManager.add(showRoots);

		Action prev = new Action() {
			@Override
			public void run() {
				int temp = currentEnd + startOffset;
				if (temp <= headVersion) {
					currentEnd = temp;
				}
				refresh();
			}

		};
		prev.setImageDescriptor(Activator.getImageDescriptor("/icons/prev.png"));
		prev.setToolTipText("Previous " + (startOffset + 1) + " items");
		menuManager.add(prev);

		Action next = new Action() {
			@Override
			public void run() {
				int temp = currentEnd - startOffset;
				if (temp > 0) {
					currentEnd = temp;
				}
				refresh();
			}

		};
		next.setImageDescriptor(Activator.getImageDescriptor("/icons/next.png"));
		next.setToolTipText("Next " + (startOffset + 1) + " items");
		menuManager.add(next);
		
		Action jumpTo = new Action() {
			@Override
			public void run() {
				InputDialog inputDialog = new InputDialog(getSite().getShell(), "Go to revision", "Revision", "", null);
				if(inputDialog.open() == Window.OK){
					try{
						int temp = Integer.parseInt(inputDialog.getValue());
						currentEnd = temp;
						refresh();
					}catch(NumberFormatException e){
						MessageDialog.openError(getSite().getShell(), "Error", "A numeric value was expected!");
						run();
					}
				}
			}
			
		};
		jumpTo.setImageDescriptor(Activator.getImageDescriptor("/icons/magnifier.png"));
		jumpTo.setToolTipText("Go to revision...");
		menuManager.add(jumpTo);
	}

	/**
	 * Refreshes the view using the current end point.
	 */
	protected void refresh() {
		load(currentEnd);
		viewer.setInput(getHistoryInfos());
	}

	private void load(final int end) {
		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				try{
					loadContent(end);
				}catch(InvalidVersionSpecException e){
					MessageDialog.openError(getShell(), "Invalid revision", "The requested revision was invalid");
					currentEnd = projectSpace.getBaseVersion().getIdentifier();
					refresh();
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

	private void loadContent(int end) throws EmfStoreException {
		if (projectSpace == null) {
			historyInfos.clear();
			return;
		}
		HistoryQuery query = getQuery(end);
		List<HistoryInfo> historyInfo = projectSpace.getUsersession()
			.getHistoryInfo(projectSpace.getProjectId(), query);

		// Event logging
		ShowHistoryEvent historyEvent = EventsFactory.eINSTANCE.createShowHistoryEvent();
		historyEvent.setSourceVersion(query.getSource());
		historyEvent.setTargetVersion(query.getTarget());
		historyEvent.setTimestamp(new Date());
		EList<ModelElementId> modelElements = query.getModelElements();
		if (modelElements != null) {
			for (ModelElementId modelElementId : modelElements) {
				historyEvent.getModelElement().add(ModelUtil.clone(modelElementId));
			}
		}
		projectSpace.addEvent(historyEvent);

		if (historyInfo != null) {
			for (HistoryInfo hi : historyInfo) {
				if (hi.getPrimerySpec().equals(projectSpace.getBaseVersion())) {
					TagVersionSpec spec = VersioningFactory.eINSTANCE.createTagVersionSpec();
					spec.setName(VersionSpec.BASE);
					hi.getTagSpecs().add(spec);
					break;
				}
			}
			historyInfos.clear();
			historyInfos.addAll(historyInfo);
		}
		for (HistoryInfo hi : historyInfos) {
			if (hi.getChangePackage() != null) {
				changePackageCache.put(hi.getPrimerySpec().getIdentifier(), hi.getChangePackage());
			}
		}
		changePackageVisualizationHelper = new ChangePackageVisualizationHelper(new ArrayList<ChangePackage>(
			changePackageCache.values()), projectSpace.getProject());
		labelProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
		contentProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
	}

	/**
	 * Set the input for the History Browser.
	 * 
	 * @param projectSpace the input project space
	 */
	public void setInput(ProjectSpace projectSpace) {
		setInput(projectSpace, null);
	}

	/**
	 * Set the input for the History Browser.
	 * 
	 * @param projectSpace the input project space
	 * @param me the input model element
	 */
	public void setInput(ProjectSpace projectSpace, ModelElement me) {
		noProjectHint.dispose();
		this.parent.layout();

		this.projectSpace = projectSpace;
		modelElement = me;
		currentEnd = -1;
		String label = "History for ";
		Project project = projectSpace.getProject();
		if (me != null) {
			label += me.getName();
			groupByMe.setChecked(false);
			showRoots.setChecked(false);
			contentProvider = new SCMContentProvider.Detailed(viewer, project);
			contentProvider.setShowRootNodes(false);
		} else {
			label += projectSpace.getProjectName();
			groupByMe.setChecked(true);
			showRoots.setChecked(true);
			contentProvider = new SCMContentProvider.Compact(viewer, project);
			contentProvider.setShowRootNodes(true);
		}
		setContentDescription(label);
		labelProvider = new SCMLabelProvider(project);
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(labelProvider);
		refresh();
	}

	private void getHeadVersionIdentifier() throws EmfStoreException {
		PrimaryVersionSpec resolveVersionSpec = projectSpace.resolveVersionSpec(VersionSpec.HEAD_VERSION);
		int identifier = resolveVersionSpec.getIdentifier();
		headVersion = identifier;
	}

	private HistoryQuery getQuery(int end) throws EmfStoreException {
		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();

		getHeadVersionIdentifier();
		if (end == -1) {
			end = headVersion;
			currentEnd = headVersion;
		}
		int temp = end - startOffset;
		int start = (temp > 0 ? temp : 0);

		PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		source.setIdentifier(start);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		target.setIdentifier(end);
		query.setSource(source);
		query.setTarget(target);
		query.setIncludeChangePackage(true);
		if (modelElement != null) {
			query.getModelElements().add(modelElement.getModelElementId());
		}

		return query;
	}

	/**
	 * Returns a list of history infos.
	 * 
	 * @return a list of history infos
	 */
	public List<HistoryInfo> getHistoryInfos() {

		ArrayList<HistoryInfo> revisions = new ArrayList<HistoryInfo>();
		if (projectSpace != null) {
			// TODO: add a feature "hide local revision"
			HistoryInfo localHistoryInfo = VersioningFactory.eINSTANCE.createHistoryInfo();
			ChangePackage changePackage = projectSpace.getCannonizedLocalOperations();
			localHistoryInfo.setChangePackage(changePackage);
			revisions.add(localHistoryInfo);
		}
		revisions.addAll(historyInfos);

		return revisions;
	}

	/**
	 * Adds a tag to a version.
	 * 
	 * @param versionSpec the version
	 * @param tag the tag
	 */
	public void addTag(final PrimaryVersionSpec versionSpec, final TagVersionSpec tag) {

		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				projectSpace.addTag(versionSpec, tag);
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

	/**
	 * Checks out a specific revision.
	 * 
	 * @param versionSpec the version
	 */
	public void checkout(final PrimaryVersionSpec versionSpec) {
		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				WorkspaceManager.getInstance().getCurrentWorkspace().checkout(projectSpace.getUsersession(),
					projectSpace.getProjectInfo(), versionSpec);
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

	/**
	 * Removes a tag to a version.
	 * 
	 * @param versionSpec the version
	 * @param tag the tag
	 */
	public void removeTag(final PrimaryVersionSpec versionSpec, final TagVersionSpec tag) {

		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				projectSpace.removeTag(versionSpec, tag);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent("org.unicase.ui.repository.views.HistoryView");
	}

	/**
	 * @return the changePackageVisualizationHelper
	 */
	public ChangePackageVisualizationHelper getChangePackageVisualizationHelper() {
		return changePackageVisualizationHelper;
	}

	private void hookContextMenu() {

		checkoutAction = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				HistoryInfo historyInfo = (HistoryInfo) ((TreeNode)obj).getValue();
				PrimaryVersionSpec versionSpec = (PrimaryVersionSpec) EcoreUtil.copy(historyInfo.getPrimerySpec());
				checkout(versionSpec);
			}
		};
		checkoutAction.setText("Checkout this revision");
		checkoutAction.setToolTipText("Checkout this revision of the project");

		addTagAction = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				HistoryInfo historyInfo = (HistoryInfo) ((TreeNode)obj).getValue();
				PrimaryVersionSpec versionSpec = (PrimaryVersionSpec) EcoreUtil.copy(historyInfo.getPrimerySpec());
				InputDialog inputDialog = new InputDialog(getSite().getShell(), "Add tag",
					"Please enter the tag's name.", "", null);
				inputDialog.open();
				String str = inputDialog.getValue().trim();
				if (!(str == null || str.equals(""))) {
					TagVersionSpec tag = VersioningFactory.eINSTANCE.createTagVersionSpec();
					tag.setName(str);
					addTag(versionSpec, tag);
					refresh();
				}
			}
		};
		addTagAction.setText("Add tag");
		addTagAction.setToolTipText("Add a new tag to this revision");

		final LabelProvider tagLabelProvider = new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((TagVersionSpec) element).getName();
			}
		};
		removeTagAction = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				HistoryInfo historyInfo = (HistoryInfo) ((TreeNode)obj).getValue();
				ElementListSelectionDialog dlg = new ElementListSelectionDialog(PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getShell(), tagLabelProvider);
				dlg.setElements(historyInfo.getTagSpecs().toArray());
				dlg.setTitle("Tag selection");
				dlg.setBlockOnOpen(true);
				dlg.setMultipleSelection(true);
				int ret = dlg.open();
				if (ret != Window.OK) {
					return;
				}
				Object[] tags = dlg.getResult();
				for (Object tag : tags) {
					removeTag(historyInfo.getPrimerySpec(), (TagVersionSpec) tag);
				}
				refresh();
			}
		};
		removeTagAction.setText("Remove tag");
		removeTagAction.setToolTipText("Remove an existing tag");

		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				if (obj instanceof TreeNode) {
					TreeNode node = (TreeNode) obj;
					if (node.getValue() instanceof HistoryInfo
						&& ((HistoryInfo)node.getValue()).getChangePackage()!=null
						&& ((HistoryInfo)node.getValue()).getChangePackage().getLogMessage() != null) {
						AccessControlHelper helper = new AccessControlHelper(projectSpace.getUsersession());
						try {
							helper.checkProjectAdminAccess((ProjectId) EcoreUtil.copy(projectSpace.getProjectId()));
							manager.add(addTagAction);
							manager.add(removeTagAction);
							manager.add(new Separator());
						} catch (AccessControlException e) {
							// do nothing
						}
						manager.add(checkoutAction);
					}
				}
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}
	
	public void highlightOperations(List<AbstractOperation> operations){
		
	}

}
