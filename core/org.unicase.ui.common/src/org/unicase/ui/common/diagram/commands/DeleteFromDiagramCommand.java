/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram.commands;

import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.unicase.model.ModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.diagram.util.EditPartUtility;

// dengler: refactor use of edit part request and variables
/**
 * Command to remove a model element from the diagram elements list, not from the model.
 * 
 * @author denglerm
 */
public class DeleteFromDiagramCommand extends DestroyElementCommand {

	/**
	 * The element's EditPart.
	 */
	private final EditPart editPart;

	/**
	 * Constructs a new command to delete an element from the diagram.
	 * 
	 * @param request the destroy element request
	 * @param editPart the editPart of the element to delete from the diagram
	 */
	public DeleteFromDiagramCommand(DestroyElementRequest request, EditPart editPart) {
		super(request);
		this.editPart = editPart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		ModelElement destructee = null;
		if (this.getElementToDestroy() instanceof ModelElement) {
			destructee = (ModelElement) this.getElementToDestroy();
		} else {
			return CommandResult.newErrorCommandResult("Element to delete is no ModelElement");
		}
		EditPart diagramEditPart = EditPartUtility.getDiagramEditPart(this.editPart);
		MEDiagram diag = (MEDiagram) EditPartUtility.getElement(diagramEditPart);
		diag.getElements().remove(destructee);
		// tear down references
		tearDownReferences(destructee, diag);
		
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Remove references (e.g. associations in class diagram) from the element to other diagram elements.
	 * 
	 * @param destructee the object being destroyed
	 * @param diag the MEDiagram
	 */
	protected void tearDownReferences(ModelElement destructee, MEDiagram diag) {
		Set<ModelElement> diagramNodeReferences = destructee.getCrossReferencedModelElements();
		for (ModelElement object : diagramNodeReferences) {
			if(object instanceof Association || object instanceof org.unicase.model.state.Transition ||
				object instanceof org.unicase.model.activity.Transition ){
			diag.getElements().remove(object);}
		}
	}
}