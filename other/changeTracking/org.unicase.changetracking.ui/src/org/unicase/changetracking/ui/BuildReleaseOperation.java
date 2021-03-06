/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.changetracking.ui;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.unicase.changetracking.commands.BuildReleaseCommand;
import org.unicase.changetracking.commands.ChangeTrackingCommandResult;

/**
 * Operation executing a buid release command. If the command yields conflict,
 * the operation switches to the java perspective.
 * 
 * In, addition, the command sets the lastConflictingCommand properly.
 * 
 * @author jfinis
 * 
 */
public class BuildReleaseOperation {

	private static final String JAVA_PERSPECTIVE_ID = "org.eclipse.jdt.ui.JavaPerspective";
	private boolean isContinueing;
	private BuildReleaseCommand command;

	/**
	 * Default constructor.
	 * 
	 * @param command command to be executed
	 * @param isContinueing whether this build is a continued one after a
	 *            conflict.
	 */
	public BuildReleaseOperation(BuildReleaseCommand command, boolean isContinueing) {
		this.command = command;
		this.isContinueing = isContinueing;
	}

	/**
	 * Runs the command. If it has conflicts, the command is set as last
	 * conflicting one in the activator and the java perspective is opened.
	 * 
	 * The result of the command is returned.
	 * 
	 * @return command execution result.
	 */
	public ChangeTrackingCommandResult run() {
		command.setContinue(isContinueing);
		ChangeTrackingCommandResult result = UIUtil.runCommand(command);
		if (command.hadConflicts()) {
			Activator.setLastConflictingCommand(command);
			try {
				PlatformUI.getWorkbench().showPerspective(JAVA_PERSPECTIVE_ID, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
			} catch (WorkbenchException e) {}
		} else {
			Activator.setLastConflictingCommand(null);
		}
		return result;
	}
}
