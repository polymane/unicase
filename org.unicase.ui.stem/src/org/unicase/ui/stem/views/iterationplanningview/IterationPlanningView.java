package org.unicase.ui.stem.views.iterationplanningview;

import java.net.URL;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.decorators.DecoratorManager;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.TreeViewerColumnSorter;
import org.unicase.ui.common.dnd.UCDropAdapter;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class IterationPlanningView extends ViewPart {
	private TreeViewer viewer;
	private DrillDownAdapter drillDownAdapter;
	private Action doubleClickAction;
	private Action groupByUser;
	private Action groupFlat;
	private Action groupByAnnotated;
	private WorkpackageContentProvider workpackageContentProvider;
	private AssignedToLabelProvider assignedToLabelProvider;
	private Project project;

	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */

	/**
	 * The constructor.
	 */
	public IterationPlanningView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());

		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		drillDownAdapter = new DrillDownAdapter(viewer);
		workpackageContentProvider = new WorkpackageContentProvider();
		viewer.setContentProvider(workpackageContentProvider);
		IDecoratorManager decoratorManager = new DecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(
				new LabelProvider(), decoratorManager.getLabelDecorator()));
		final Workspace workspace = WorkspaceManager.getInstance()
				.getCurrentWorkspace();

		workspace.eAdapters().add(new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if ((msg.getFeatureID(Workspace.class)) == WorkspacePackage.WORKSPACE__ACTIVE_PROJECT_SPACE) {
					if(workspace.getActiveProjectSpace() != null){
						project = workspace.getActiveProjectSpace().getProject();
					}
					viewer.setInput(project);
					System.out.println();
				}
				super.notifyChanged(msg);
			}

		});
//		TransactionalEditingDomain domain = TransactionUtil
//				.getEditingDomain(workspace);
//		domain.getCommandStack().execute(new RecordingCommand(domain) {
//			protected void doExecute() {
//				workspace.setActiveProjectSpace(workspace.getProjectSpaces()
//						.get(0));
//			}
//		});

		if(workspace.getActiveProjectSpace() != null){
			viewer.setInput(workspace.getActiveProjectSpace().getProject());
		}else{
			viewer.setInput(null);
		}
		
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);

		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.NONE);
		column.getColumn().setWidth(200);
		column.setLabelProvider(new EMFColumnLabelProvider());

		TreeViewerColumn column1 = new TreeViewerColumn(viewer, SWT.NONE);
		column1.getColumn().setText("Annotated");
		column1.getColumn().setWidth(200);
		column1.setLabelProvider(new TaskObjectLabelProvider());
		column1.setEditingSupport(new TaskObjectEditingSupport(viewer));

		TreeViewerColumn column2 = new TreeViewerColumn(viewer, SWT.NONE);
		column2.getColumn().setText("Assigned to");
		column2.getColumn().setWidth(200);
		assignedToLabelProvider = new AssignedToLabelProvider();
		column2.setLabelProvider(assignedToLabelProvider);
		column2.setEditingSupport(new AssignedToEditingSupport(viewer));
		
		TreeViewerColumnSorter cSorter = new TreeViewerColumnSorter(viewer, column2, assignedToLabelProvider);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"org.unicase.ui.treeview.viewer");

		hookDoubleClickAction();
		addDNDSupport();

	}

	private void fillLocalToolBar(IToolBarManager toolBarManager) {
		buildActions();
		toolBarManager.add(groupFlat);
		toolBarManager.add(groupByAnnotated);
		toolBarManager.add(groupByUser);

	}

	private void buildActions() {
		groupByUser = new Action() {
			@Override
			public void run() {
				workpackageContentProvider.setGroupBy(WorkpackageContentProvider.USER_GROUP);
				viewer.refresh();
			}
		};
		groupByUser.setText("Group by user");
		groupByUser.setToolTipText("Group by user");

		URL url = Platform.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/User.gif"));
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		groupByUser.setImageDescriptor(imageDescriptor);

		groupFlat = new Action() {
			@Override
			public void run() {
				workpackageContentProvider.setGroupBy(WorkpackageContentProvider.FLAT_GROUP);
				viewer.refresh();
			}
		};
		groupFlat.setText("Show flat list");
		groupFlat.setToolTipText("Show flat list");

		url = Platform.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/flatLayout.gif"));
		imageDescriptor = ImageDescriptor.createFromURL(url);
		groupFlat.setImageDescriptor(imageDescriptor);

		groupByAnnotated = new Action() {
			@Override
			public void run() {
				workpackageContentProvider.setGroupBy(WorkpackageContentProvider.ANNOTATED_GROUP);
				viewer.refresh();
			}
		};

		groupByAnnotated.setText("Group by user");
		groupByAnnotated.setToolTipText("Click to add new repository");

		url = Platform.find(Platform.getBundle("org.unicase.ui.stem"),
				new Path("icons/hierarchicalLayout.gif"));
		imageDescriptor = ImageDescriptor.createFromURL(url);
		groupByAnnotated.setImageDescriptor(imageDescriptor);

	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				TreeSelection selection = (TreeSelection) viewer.getSelection();
				Object object = selection.getFirstElement();
				openME(object);
			}

		});
	}

	private void openME(Object object) {
		if (object == null) {
			return;
		}
		if (object instanceof ModelElement) {
			ModelElement modelElement = (ModelElement) object;
			if (object instanceof MEDiagram) {
				// openDiagram((MEDiagram) modelElement);
			} else {
				MEEditorInput input = new MEEditorInput(modelElement);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().openEditor(input, MEEditor.ID,
									true);
				} catch (PartInitException e) {
					ErrorDialog.openError(PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell(), "Error", e
							.getMessage(), e.getStatus());
				}
			}
		}

	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getTree().setFocus();
	}

	private void addDNDSupport() {
		int dndOperations = DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK;
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		Object data = viewer.getTree().getData(DND.DRAG_SOURCE_KEY);

		viewer.addDragSupport(dndOperations, transfers, new ViewerDragAdapter(
				viewer));
		viewer
				.addDropSupport(dndOperations, transfers, new UCDropAdapter(
						TransactionalEditingDomain.Registry.INSTANCE
								.getEditingDomain("org.unicase.EditingDomain"),
						viewer));

	}
	
}