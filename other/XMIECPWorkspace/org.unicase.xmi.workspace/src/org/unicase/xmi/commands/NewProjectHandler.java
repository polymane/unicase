/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.xmi.commands;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.xmi.exceptions.XMIWorkspaceException;
import org.unicase.xmi.views.NewProjectDialog;

/**
 * Handler for creating a new project in workspace or filesystem.
 * @author kraftm, maierma
 *
 */
public class NewProjectHandler extends XmiAbstractHandler {
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		// open dialog
		Shell activeShell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		NewProjectDialog dialog = new NewProjectDialog(activeShell, this);

		// open dialog and process the results if the user doesn't cancel the dialog
		if(dialog.open() == Window.OK) {
			try {						
				// run the import process in a command
				buildCommand(ECPWorkspaceManager.getInstance().getWorkSpace()).run(true);
			} catch (NoWorkspaceException e) {
				new XMIWorkspaceException("Could not create new model element.", e);
			}
		}
		
		return null;
	}
}
