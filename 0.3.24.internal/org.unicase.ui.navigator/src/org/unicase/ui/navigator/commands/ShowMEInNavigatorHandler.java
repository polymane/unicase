/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.navigator.TreeView;

/**
 * This is the handler for ShowMEInNavigator command. It shows location of currently open model element or currently
 * selected model element in navigator tree.
 * 
 * @author Hodaie
 */
public class ShowMEInNavigatorHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ModelElement me = ActionHelper.getModelElement(event);
		if (me == null) {
			return null;
		}

		TreeViewer treeViewer = TreeView.getTreeViewer();

		// we could easily use the following method.
		// but it has the problem that it shows the first occurrence of and element.
		// for example if we have the same element somewhere else linked, and shown as a child (e.g. in
		// ActionItemMeetingSection),
		// it just show the first one that it finds. We want only the real containment to be shown.
		// // TreeView.getTreeViewer().setSelection(new StructuredSelection(me), true);

		EObject container = me.eContainer();
		treeViewer.setSelection(new StructuredSelection(container));

		TreeSelection treeSelection = (TreeSelection) treeViewer.getSelection();
		if (treeSelection.getPaths().length > 0) {
			TreePath treePath = treeSelection.getPaths()[0].createChildPath(me);

			TreeSelection newTreeSeleciton = new TreeSelection(treePath);
			treeViewer.setSelection(newTreeSeleciton, true);
		}

		return null;
	}
}
