/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.MEEditorInput;
import org.unicase.ui.meeditor.MEEditor;
import org.unicase.ui.meeditor.METhreadPage;

/**
 * This handler is to be executed indirectly using IHandlerService.executeCommand() method. The Command itself does not
 * have any UI representation.
 * 
 * @author Shterev
 */
public class OpenModelElementDiscussionHandler extends AbstractHandler {

	private static final String ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE = "meToOpen";
	private static final String TOGGLE_ADD_COMMENT_VARIABLE = "toggleAddComment";

	/**
	 * {@inheritDoc}
	 */

	public Object execute(ExecutionEvent event) throws ExecutionException {

		// We get the required model element Through activeModelelemet
		// variable.
		// This variable is already set, in the method which calls to execute
		// this command.
		Object o = HandlerUtil.getVariableChecked(event, ME_TO_OPEN_EVALUATIONCONTEXT_VARIABLE);
		Object toggle = HandlerUtil.getVariableChecked(event, TOGGLE_ADD_COMMENT_VARIABLE);
		ModelElement me = (ModelElement) o;

		if (o != null) {
			MEEditorInput input;
			input = new MEEditorInput(me);
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input,
					"org.unicase.ui.meeditor", true);
				IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
				if (activeEditor instanceof MEEditor) {
					MEEditor meEditor = (MEEditor) activeEditor;
					meEditor.setActivePage("Discussion");
					if (meEditor.getActivePageInstance() instanceof METhreadPage && toggle != null
						&& toggle.equals("toggle")) {
						((METhreadPage) meEditor.getActivePageInstance()).addComment();
					}
				}
			} catch (PartInitException e) {
				// JH Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

}
