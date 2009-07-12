/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram.part;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DiagramGraphicalViewerKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
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
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.impl.DiagramStoreException;
import org.unicase.ui.common.diagram.DeleteFromDiagramAction;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.workspace.util.WorkspaceUtil;

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
	 * The {@link LayoutListener} for layout save commands.
	 */
	private LayoutListener layoutChangeListener;
	
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

		focusListener = new FocusListener(){
			public void focusGained(FocusEvent event) {
				try {
					doSave(new NullProgressMonitor());	
				} catch (IllegalStateException e) {
					//do nothing
					//We catch this exception in case we have been in an read only transaction context 
					//and tried to save the layout which is performed with a read/write transaction
				}
			}
			
			public void focusLost(FocusEvent event) {
				try {
					doSave(new NullProgressMonitor());	
				} catch (IllegalStateException e) {
					//do nothing
					//@see focusGained
				}
			}
		};
		
		layoutChangeListener = new LayoutListener.Stub(){
			@Override
			public void postLayout(IFigure container) {
				doSave(new NullProgressMonitor());
			}
		};
	}
//dengler: document
	/**
	 * This method calls the MEDiagram's saveDiagramLayout method to save diagram elements and layout
	 * information.
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		getEditingDomain().getCommandStack().execute(new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				try {
					((MEDiagram) ModelDiagramEditor.this.getDiagram().eContainer()).saveDiagramLayout();

				} catch (DiagramStoreException e) {
					// dengler: handle exception
					WorkspaceUtil.logException("Saving diagram failed", e);
				}
			}

		});
	}
//dengler: document
	/**
	 * This method registers a Drag & drop listener and listeners for layout and focus change.
	 * Additionally the standard action for pressing the DEL key is changed to DeleteFromDiagram
	 * instead of GMF's DeleteFromModel.
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
		
		registerLayoutChangeListener();
		registerFocusListener();
	}

	/**
	 * @author denglerm This class implements the abstract DiagramDropTargetListener
	 * The superclass uses a DropObjectsRequest to obtain a dnd command from the Drag&Drop policy in
	 * @link org.unicase.ui.common.diagram.edit.parts.MEDiagramEditPart. To set the dropped objects field
	 * within the request the superclass calls the getObjectsBeingDropped() method of this class.
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramDropTargetListener
	 */
	private abstract class DropTargetListener extends DiagramDropTargetListener {

		public DropTargetListener(EditPartViewer viewer, Transfer xfer) {
			super(viewer, xfer);
		}

		@SuppressWarnings("unchecked")
		@Override
		protected List<EObject> getObjectsBeingDropped() {
			TransferData data = getCurrentEvent().currentDataType;

			Object transferedObject = getJavaObject(data);

			List<EObject> result = new ArrayList<EObject>();

			if (transferedObject instanceof List) {
				List selection = (List) transferedObject;
				for (Iterator it = selection.iterator(); it.hasNext();) {
					Object nextSelectedObject = it.next();
					if (nextSelectedObject instanceof ModelElement) {
						result.add((EObject) nextSelectedObject);
					}
				}
			}
			return result;
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

		} catch (CoreException x) {
			//dengler: show in error log
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

		deregisterFocusListener();
		deregisterLayoutChangeListener();
	}

	private void deregisterLayoutChangeListener() {
		IFigure primaryLayer = getDiagramEditPart().getLayer(LayerConstants.PRIMARY_LAYER);

		primaryLayer.removeLayoutListener(layoutChangeListener);		
	}

	private void deregisterFocusListener(){
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
	
	
	private void registerFocusListener(){
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

	private void registerLayoutChangeListener(){
		IFigure primaryLayer = getDiagramEditPart().getLayer(LayerConstants.PRIMARY_LAYER);

		LayoutListener layoutChangeListener = new LayoutListener.Stub(){
			@Override
			public void postLayout(IFigure container) {
				try {
					doSave(new NullProgressMonitor());	
				} catch (IllegalStateException e) {
					//do nothing
					//We catch this exception in case we have been in an read only transaction context 
					//and tried to save the layout which is performed with a read/write transaction
				}
			}
		};

		primaryLayer.addLayoutListener(layoutChangeListener);	
	}
	
	/**
	 * @author schroech
	 *
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

        KeyHandler viewerKeyHandler = new DiagramGraphicalViewerKeyHandler(viewer)
            .setParent(getKeyHandler());
        viewer.setKeyHandler(new OnEnterDirectEditKeyHandler(viewer)
            .setParent(viewerKeyHandler));
    }
	
	/**
	 *	We implement our own save method, so return always false. {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		return false;
	}
}