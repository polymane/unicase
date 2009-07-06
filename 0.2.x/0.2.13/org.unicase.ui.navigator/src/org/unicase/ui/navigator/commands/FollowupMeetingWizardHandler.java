package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ui.navigator.wizards.FollowupMeetingWizard;

/**
 * @author naughton
 *
 *         This is the handler for "Follow-up Meeting" context menu command.
 *         The command is only shown on Meetings. The handler initializes
 *         and shows the FollowupMeetingWizard
 */
public class FollowupMeetingWizardHandler extends AbstractHandler implements
		IHandler {

	private static final String WIZARD_TITLE = "Create follow-up meeting";
	
	/**
	 * . ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		FollowupMeetingWizard wizard = new FollowupMeetingWizard();

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection ssel;
		if (selection != null && selection instanceof IStructuredSelection) {
			ssel = (IStructuredSelection) selection;
			wizard.init(HandlerUtil.getActiveWorkbenchWindow(event)
					.getWorkbench(), ssel);
		}

		WizardDialog dialog = new WizardDialog(HandlerUtil
				.getActiveShell(event), wizard);
		wizard.setWindowTitle(WIZARD_TITLE);
		dialog.create();
		dialog.open();

		return null;
	}

}
