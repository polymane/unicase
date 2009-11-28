/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.implementation.operations.ExtractSuperClassOperation;
import org.unicase.implementation.operations.OperationsFactory;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.Project;
import org.unicase.model.classes.Class;
import org.unicase.workspace.util.SemanticCommand;

public class ExtractSuperClassHandler extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {

		IWorkbenchPage activePage = HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage();
		ISelection selection = activePage.getSelection();
		if (selection != null & selection instanceof IStructuredSelection) {

			IStructuredSelection structuredSelection = (IStructuredSelection) selection;

			List<Class> subClasses = SelectionHelper
					.getSelectedElements(structuredSelection);

			ExtractSuperClassOperation operation = OperationsFactory.eINSTANCE
					.createExtractSuperClassOperation();
			operation.getSubClasses().addAll(OperationHelper.getIds(subClasses));
			operation.setCompositeName(operation.eClass().getName());
			operation.setCompositeDescription(operation.eClass().getName());

			Project project = subClasses.get(0).getProject();
			ExecuteOperationDialog dialog = new ExecuteOperationDialog(
					operation, project);

			if (dialog.open() == IDialogConstants.OK_ID) {
				operation.setModelElementId(operation.getTargetPackage(project)
						.getModelElementId());

				new SemanticCommand(project, operation).run();
			}
		}

		return null;
	}

}
