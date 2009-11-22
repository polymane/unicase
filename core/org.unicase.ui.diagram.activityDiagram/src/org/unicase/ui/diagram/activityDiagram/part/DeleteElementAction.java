/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.part;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.AbstractDeleteFromAction;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.unicase.ui.unicasecommon.diagram.commands.DeleteFromModelCommand;
import org.unicase.ui.unicasecommon.diagram.util.EditPartUtility;

/**
 * @generated
 */
public class DeleteElementAction extends AbstractDeleteFromAction {

	/**
	 * @generated
	 */
	public DeleteElementAction(IWorkbenchPart part) {
		super(part);
	}

	/**
	 * @generated
	 */
	public DeleteElementAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	/**
	 * @generated
	 */
	@Override
	public void init() {
		super.init();
		setId(ActionIds.ACTION_DELETE_FROM_MODEL);
		setText(DiagramUIMessages.DiagramEditor_Delete_from_Model);
		setToolTipText(DiagramUIMessages.DiagramEditor_Delete_from_ModelToolTip);
		String path = "icons/delete.gif";
		java.net.URL url = FileLocator.find(Platform.getBundle("org.unicase.ui.common"), new Path(path), null);
		ImageDescriptor id = ImageDescriptor.createFromURL(url);
		setHoverImageDescriptor(id);
		setImageDescriptor(id);
		setDisabledImageDescriptor(id);
	}

	/**
	 * @generated
	 */
	@Override
	protected String getCommandLabel() {
		return DiagramUIMessages.DiagramEditor_Delete_from_Model;
	}

	/**
	 * @generated
	 */
	@Override
	@SuppressWarnings("null")
	protected Command getCommand(Request request) {
		List operationSet = getOperationSet();
		if (operationSet.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}
		Iterator editParts = operationSet.iterator();
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(getEditingDomain(), getCommandLabel());
		while (editParts.hasNext()) {
			EditPart editPart = (EditPart) editParts.next();
			EObject element = EditPartUtility.getElement(editPart);
			DestroyElementRequest destroyElementRequest = new DestroyElementRequest(element, false);

			DeleteFromModelCommand curCommand = new DeleteFromModelCommand(destroyElementRequest);
			if (curCommand != null) {
				command.compose(curCommand);
			}
		}
		if (command.isEmpty() || command.size() != operationSet.size()) {
			return UnexecutableCommand.INSTANCE;
		}
		return new ICommandProxy(command);
	}
}
