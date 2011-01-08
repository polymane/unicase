package org.unicase.projectchanger;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.workspace.util.UnicaseCommand;

public class GenerateProjectChangesHandler extends AbstractHandler implements IHandler{

	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(selection != null && selection instanceof IStructuredSelection) {
			final IStructuredSelection ssel = (IStructuredSelection) selection;
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					new ProjectChangerImpl(2, ssel);
				}
			}.run(false);
		}		
		return null;
	}

}