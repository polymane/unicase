/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.changetracking.ui.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult.Result;
import org.unicase.changetracking.commands.CheckReleaseCommand;
import org.unicase.changetracking.ui.UIDecisionProvider;
import org.unicase.changetracking.ui.UIUtil;
import org.unicase.changetracking.ui.releases.CheckReleaseDialog;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.changetracking.vcs.VCSAdapterFactory;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

public class CheckReleaseHandler extends AbstractHandler {

	/**
	 * . {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		//Retrieve selected release
		UnicaseModelElement me = UnicaseActionHelper.getModelElement(event);
		if(!(me instanceof ChangeTrackingRelease)){
			UIUtil.errorMessage("The selected model element is no change tracking release");
			return null;
		}
		ChangeTrackingRelease r = (ChangeTrackingRelease) me;
		
		VCSAdapter vcs = new VCSAdapterFactory().createFromRelease(r);
		
		CheckReleaseCommand command = vcs.checkRelease(new UIDecisionProvider(), r);
		ChangeTrackingCommandResult result = UIUtil.runCommand(command);
		if(result.getResult() != Result.SUCCESS){
			return null;
		}
		
		CheckReleaseDialog dialog = new CheckReleaseDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), r, command.getReport());
		dialog.open();
		return null;
	}



	

}
