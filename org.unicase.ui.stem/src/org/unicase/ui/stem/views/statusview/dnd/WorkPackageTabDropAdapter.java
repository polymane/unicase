/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.stem.views.statusview.dnd;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.organization.OrgUnit;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.common.dnd.DragSourcePlaceHolder;
import org.unicase.workspace.util.EventUtil;

/**
 * This is the drop adapter for User tab in Status view.
 * 
 * @author Shterev
 */
public class WorkPackageTabDropAdapter extends DropTargetAdapter {

	private ModelElement source;
	private WorkItem target;

	/**
	 * Constructor.
	 */
	public WorkPackageTabDropAdapter() {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#dragOver(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragOver(DropTargetEvent event) {
		event.feedback = event.feedback | DND.FEEDBACK_SCROLL;
		event.detail = DND.DROP_COPY;
		if (!extractDnDSourceAndTarget(event)) {
			event.detail = DND.DROP_NONE;
			return;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void drop(DropTargetEvent event) {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				EventUtil.logStatusViewDropEvent(target, source, "Unknown", "UserTab");
				reassignWorkItem(target, (OrgUnit) source);
			}

		});

	}

	private void reassignWorkItem(WorkItem workItem, OrgUnit orgUnit) {
		workItem.setAssignee(orgUnit);
	}

	@SuppressWarnings("unchecked")
	private boolean extractDnDSourceAndTarget(DropTargetEvent event) {
		boolean result = true;

		List<Object> tmpSource = (List<Object>) DragSourcePlaceHolder.getDragSource();

		if (tmpSource == null) {
			result = false;
		}

		if (tmpSource.size() != 1) {
			result = false;
		}
		if (!(tmpSource.get(0) instanceof OrgUnit)) {
			result = false;
		}

		if (event.item == null || event.item.getData() == null || !(event.item.getData() instanceof WorkItem)) {
			result = false;
		}

		// check if source and currentOpenME are in the same project
		if (result) {
			source = (ModelElement) tmpSource.get(0);
			target = (WorkItem) event.item.getData();
		}

		return result;
	}

}
