/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.multiaction.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.multiaction.navigator.wizards.MultiactionWizard;

/**
 * @author naughton This is the handler for "Follow-up Meeting" context menu command. The command is only shown on
 *         Meetings. The handler initializes and shows the FollowupMeetingWizard
 */
public class MultiactionWizardHandler extends AbstractHandler implements IHandler {

	private static final String WIZARD_TITLE = "Create Multi Asignee Action Item";

	/***
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		MultiactionWizard wizard = new MultiactionWizard();

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			wizard.init(HandlerUtil.getActiveWorkbenchWindow(event).getWorkbench(), ssel);
		}

		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), wizard);
		wizard.setWindowTitle(WIZARD_TITLE);
		dialog.create();
		dialog.open();

		return null;
	}

}
