/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.navigator.commands;

import java.util.EventObject;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.jface.action.Action;
import org.unicase.workspace.Configuration;

/**
 * @author Hodaie This is the temporary implementation for redo action in navigator. Currently we have a problem with
 *         undo/redo and EditingDomain; in that, navigator can undo/redo changes not occurred through it. The unod/redo
 *         in navigator should actually consider only its own context. To set enablement of global undo/redo menu items
 *         in Workbench edit menu, this class implements CommandStackListener
 */
public class UndoAction extends Action implements CommandStackListener {

	private CommandStack commandStack;

	/**
	 * . Constructor
	 */
	public UndoAction() {
		this.commandStack = Configuration.getEditingDomain().getCommandStack();
		commandStack.addCommandStackListener(this);

	}

	/**
	 * . {@inheritDoc}
	 */
	public void commandStackChanged(EventObject event) {
		setEnabled(commandStack.canUndo());
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void run() {
		if (commandStack.canUndo()) {
			commandStack.undo();
		}

	}

}
