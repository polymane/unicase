/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.dnd.DragSourcePlaceHolder;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.ModelElementContextListener;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.common.model.workSpaceModel.util.AssociationClassHelper;
import org.eclipse.emf.ecp.editor.ModelElementChangeListener;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.unicasecommon.common.diagram.DeleteFromDiagramAction;
import org.unicase.ui.unicasecommon.common.util.DNDHelper;
import org.unicase.ui.unicasecommon.diagram.commands.CreateViewCommand;

/**
 * @author denglerm This class is a superclass for the generated ModelDiagramEditor in each diagram.
 */
@SuppressWarnings("restriction")
public class ModelDiagramEditor extends DiagramDocumentEditor {

	/**
	 * The {@link FocusListener} for layout save commands.
	 */
	private FocusListener focusListener;

	/**
	 * The {@link ModelElementContext} {@link #modelElementContextListener} listens to.
	 */
	private ECPModelelementContext modelElementContext;

	/**
	 * The {@link ModelElementContextListener} to handle delete operations.
	 */
	private ModelElementContextListener modelElementContextListener;

	/**
	 * The {@link ModelElementChangeListener} to handle name changes.
	 */
	private ModelElementChangeListener modelElementChangeListener;

	/**
	 * The constructor.
	 */
	public ModelDiagramEditor() {
		this(true);
	}

	/**
	 * Constructs a diagram editor with optional flyout palette.
	 * 
	 * @param hasFlyoutPalette creates a palette if true, else no palette
	 */
	public ModelDiagramEditor(boolean hasFlyoutPalette) {
		super(hasFlyoutPalette);

		focusListener = new FocusListener() {
			public void focusGained(FocusEvent event) {
				syncDiagramView((MEDiagram) ModelDiagramEditor.this.getDiagram().getElement());
			}

			public void focusLost(FocusEvent event) {
			}
		};

	}

	/**
	 * Adds missing AssciationClassElements and refresh the hole view in case a reference has changed.
	 * 
	 * @param meDiagram The diagram to update.
	 */
	private void syncDiagramView(final MEDiagram meDiagram) {
		final ECPModelelementContext context = DNDHelper.getECPModelelementContext();
		if (context == null) {
			return;
		}

		final LinkedList<EObject> elements = new LinkedList<EObject>();
		elements.addAll(meDiagram.getElements());
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				for (EObject association : AssociationClassHelper.getRelatedAssociationClassToDrop(elements, elements,
					context.getMetaModelElementContext())) {
					// add reference to the element
					meDiagram.getElements().add((UnicaseModelElement) association);
					// create the View for the element
					CreateViewCommand command = new CreateViewCommand(new EObjectAdapter(association),
						getDiagramEditPart(), null, getPreferencesHint());
					try {
						command.execute(getProgressMonitor(), null);
					} catch (ExecutionException e) {
						ModelUtil.logException("Could not create a view for the droped content.", e);
					}
				}
			}
		}.run();
		// refresh all views to reorientate associations
		List<CanonicalEditPolicy> editPolicies = CanonicalEditPolicy.getRegisteredEditPolicies(meDiagram);
		for (Iterator<CanonicalEditPolicy> it = editPolicies.iterator(); it.hasNext();) {
			it.next().refresh();
		}
	}

	// dengler: document
	/**
	 * This method calls the MEDiagram's saveDiagramLayout method to save diagram elements and layout information.
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
	}

	// dengler: document
	/**
	 * This method registers a Drag & drop listener and listeners for layout and focus change. Additionally the standard
	 * action for pressing the DEL key is changed to DeleteFromDiagram instead of GMF's DeleteFromModel.
	 */
	@Override
	protected void initializeGraphicalViewer() {
		super.initializeGraphicalViewer();
		getDiagramGraphicalViewer().addDropTargetListener(
			new DropTargetListener(getDiagramGraphicalViewer(), LocalTransfer.getInstance()) {

				@Override
				protected Object getJavaObject(TransferData data) {
					return DragSourcePlaceHolder.getDragSource();
				}

			});
		getGraphicalViewer().getKeyHandler().put(KeyStroke.getPressed(SWT.DEL, 127, 0), new DeleteFromDiagramAction());

		registerFocusListener();
		registerModelElementListeners();
	}

	/**
	 * @author denglerm This class implements the abstract DiagramDropTargetListener The superclass uses a
	 *         DropObjectsRequest to obtain a dnd command from the Drag&Drop policy in
	 * @link org.unicase.ui.common.diagram.edit.parts.MEDiagramEditPart. To set the dropped objects field within the
	 *       request the superclass calls the getObjectsBeingDropped() method of this class.
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener
	 */
	private abstract class DropTargetListener extends DiagramDropTargetListener {
		private List<EObject> mesDrop, mesAdd;
		private int x, y;

		public DropTargetListener(EditPartViewer viewer, Transfer xfer) {
			super(viewer, xfer);
		}

		@Override
		public boolean isEnabled(DropTargetEvent event) {
			setEnablementDeterminedByCommand(false);
			if (super.isEnabled(event)) {
				mesAdd = new LinkedList<EObject>();
				if (DNDHelper.canDrop(mesDrop, (MEDiagram) getDiagram().getElement(), mesAdd)) {
					DropTarget target = (DropTarget) event.widget;
					org.eclipse.swt.graphics.Point location = target.getControl().toControl(event.x, event.y);
					x = location.x;
					y = location.y;
					return true;
				}
			}
			return false;
		}

		@Override
		protected List<EObject> getObjectsBeingDropped() {
			TransferData data = getCurrentEvent().currentDataType;
			Object transferedObject = getJavaObject(data);
			mesDrop = new ArrayList<EObject>();
			if (transferedObject instanceof List<?>) {
				List<?> selection = (List<?>) transferedObject;
				for (Iterator<?> it = selection.iterator(); it.hasNext();) {
					Object nextSelectedObject = it.next();
					if (nextSelectedObject instanceof EObject) {
						mesDrop.add((EObject) nextSelectedObject);
					}
				}
			}
			return mesDrop;
		}

		@Override
		protected void handleDrop() {
			if (DNDHelper.dropMessageCheck(mesDrop, mesAdd)) {
				final ECPModelelementContext context = DNDHelper.getECPModelelementContext();
				final MEDiagram diagram = (MEDiagram) getDiagram().getElement();
				if (context == null) {
					return;
				}
				LinkedList<EObject> elements = new LinkedList<EObject>();
				elements.addAll(diagram.getElements());
				mesAdd.addAll(AssociationClassHelper.getRelatedAssociationClassToDrop(mesAdd, elements,
					context.getMetaModelElementContext()));
				new EMFStoreCommand() {

					@Override
					protected void doRun() {
						int counter = 0;
						for (EObject me : mesAdd) {
							// add reference to the element
							diagram.getElements().add((UnicaseModelElement) me);
							// create the View for the element
							CreateViewCommand command = new CreateViewCommand(new EObjectAdapter(me),
								getDiagramEditPart(), new Point(x + counter * 20, y + counter * 20),
								getPreferencesHint());
							try {
								command.execute(getProgressMonitor(), null);
							} catch (ExecutionException e) {
								ModelUtil.logException("Could not create a view for the droped content.", e);
							}
							if (!context.getMetaModelElementContext().isAssociationClassElement(me)) {
								counter++;
							}
						}
					}
				}.run();
			}
			mesDrop = null;
			mesAdd = null;
		}

		protected abstract Object getJavaObject(TransferData data);
	}

	/**
	 * @see org.eclipse.ui.part.EditorPart#setInput(IEditorInput)
	 * @param input the editor input
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			doSetInput(input, true);
			IWorkbench wb = PlatformUI.getWorkbench();
			IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
			win.getSelectionService().addSelectionListener(this);
			this.setTitleImage(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getImage(this.getDiagram().getElement()));
		} catch (CoreException x) {
			// dengler: show in error log
			WorkspaceUtil.logException("Set diagram content failed", x);
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		win.getShell().setText("Java - Eclipse Platform");
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		// remove context- and change-listeners,
		// if they were registered
		if (modelElementContext != null) {
			modelElementContext.removeModelElementContextListener(modelElementContextListener);
		}
		if (modelElementChangeListener != null) {
			modelElementChangeListener.remove();
		}
		deregisterFocusListener();
		close(false);
	}

	private void deregisterFocusListener() {
		IDiagramGraphicalViewer diagramGraphicalViewer = getDiagramGraphicalViewer();
		if (diagramGraphicalViewer == null) {
			return;

		}
		Control control = diagramGraphicalViewer.getControl();
		if (control == null) {
			return;
		}
		control.removeFocusListener(focusListener);
	}

	private void registerFocusListener() {
		IDiagramGraphicalViewer diagramGraphicalViewer = getDiagramGraphicalViewer();
		if (diagramGraphicalViewer == null) {
			return;

		}
		Control control = diagramGraphicalViewer.getControl();
		if (control == null) {
			return;
		}
		control.addFocusListener(focusListener);
	}

	/**
	 * @generated NOT
	 */
	private void registerModelElementListeners() {

		final Diagram diagram = getDiagram();

		// register listener for changes on the name attribute
		modelElementChangeListener = new ModelElementChangeListener(diagram) {

			@Override
			public void onChange(Notification msg) {
				if (msg.getEventType() == Notification.SET
					&& msg.getFeatureID(MEDiagram.class) == DiagramPackage.ME_DIAGRAM__NAME) {
					setPartName(msg.getNewStringValue());
				}
			}

		};

		// register modelElementContext listener for behavior upon deletion
		if (diagram != null) {
			modelElementContext = ECPWorkspaceManager.getECPProject(diagram.eContainer());
		} else {
			try {
				modelElementContext = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
			} catch (NoWorkspaceException e) {
				ModelUtil.logException(e);
			}
		}

		if (modelElementContext == null) {
			return;
		}

		// initialize a listener that will close this editor if the MEDiagram,
		// its container or its context gets deleted
		modelElementContextListener = new ModelElementContextListener() {

			@Override
			public void onContextDeleted() {
				close(false);
			}

			@Override
			public void onModelElementDeleted(EObject element) {
				Diagram diagram = ModelDiagramEditor.this.getDiagram();
				if (diagram == null) {
					return;
				}
				EObject meDiagram = diagram.getElement();
				if (element == meDiagram || !modelElementContext.contains(meDiagram)) {
					close(false);
				}
			}

		};

		modelElementContext.addModelElementContextListener(modelElementContextListener);
	}

	/**
	 * @author schroech
	 */
	private class OnEnterDirectEditKeyHandler extends DirectEditKeyHandler {

		public OnEnterDirectEditKeyHandler(GraphicalViewer viewer) {
			super(viewer);
		}

		@Override
		public boolean keyPressed(KeyEvent event) {
			if (isEnterKey(event)) {
				// Create a Direct Edit Request and cache the character typed
				Request request = new Request(RequestConstants.REQ_DIRECT_EDIT);
				getFocusPart().performRequest(request);
				return true;
			}
			return super.keyPressed(event);
		}

		private boolean isEnterKey(KeyEvent event) {
			if (event.keyCode == 13) {
				return true;
			}
			return false;
		}

	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#configureGraphicalViewer()
	 */
	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();

		KeyHandler viewerKeyHandler = new DiagramGraphicalViewerKeyHandler(viewer).setParent(getKeyHandler());
		viewer.setKeyHandler(new OnEnterDirectEditKeyHandler(viewer).setParent(viewerKeyHandler));
	}

	/**
	 * We implement our own save method, so return always false. {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		return false;
	}
}
