package org.unicase.ui.stem.views.statusview.dnd;

import java.util.List;

import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;

/**
 * This is the drag adapter for flat tab in status view.
 * 
 * @author Hodaie
 */
public class FlatTabDragAdapter extends ViewerDragAdapter {

	/**
	 * Constructor.
	 * 
	 * @param viewer viewer
	 */
	protected FlatTabDragAdapter(Viewer viewer) {
		super(viewer);
	}

	/**
	 * {@inheritDoc} This method extracts the viewer's selection and sets it as drag source in DragSourcePlaceHolder.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void dragStart(DragSourceEvent event) {
		super.dragStart(event);

		List<Object> dragSource = null;
		ISelection sel = viewer.getSelection();
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) sel;
			dragSource = ssel.toList();
		}

		DragSourcePlaceHolder.setDragSource(dragSource);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	@Override
	public void dragFinished(DragSourceEvent event) {
		super.dragFinished(event);
		viewer.refresh();
	}

}
