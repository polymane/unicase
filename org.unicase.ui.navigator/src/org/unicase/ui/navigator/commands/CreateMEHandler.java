/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.navigator.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.document.LeafSection;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.workspace.WorkspaceManager;

/**
 * 
 * @author Hodaie
 * 
 *         This is the handler for createME command
 *         (org.unicase.ui.navigator.createME). This command is just a command
 *         definition with a parameter. This command is not shown itself in the
 *         context menu. In DynamicMECreationCommands class the actually
 *         required command to create a Model element are created and assigned
 *         the ID of this generic createME command. When the user selects one of
 *         these commands this handler is executed. The generic createME command
 *         gets an EClass as parameter, and the handler creates a ModelElement
 *         of this EClass, adds it to the selected LeafSection and opens it for
 *         editing.
 * 
 */
public class CreateMEHandler extends AbstractHandler implements IHandler {

	/**
	 * The Id for EClass parameter to command. A model element of this EClass
	 * type is created in this handler.
	 */
	public static final String COMMAND_ECLASS_PARAM = "org.unicase.ui.navigator.eClassParameter";
	
	/**
	 * The Id for DiagramType parameter to command. A diagram of this type is created in the handler.
	 */
	public static final String COMMAND_DIAGRAMTYPE_PARAM = "org.unicase.ui.navigator.diagramTypeParameter";
	/**.
	 * ({@inheritDoc})
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// get the command parameter (EClass)
		Object o = event.getObjectParameterForExecution(COMMAND_ECLASS_PARAM);
		if (o instanceof EClass) {
			EClass newMEType = (EClass) o;
			final ModelElement newMEInstance;
			// create a new model element from this EClass
			newMEInstance = (ModelElement) ActionHelper.createModelElement(newMEType.getEPackage().getEFactoryInstance(),newMEType);
			newMEInstance.setName("new " + newMEType.getName());
			
			//if model element if MEDiagram, set the diagram type
			if(newMEInstance instanceof MEDiagram) {
				Object p = event.getObjectParameterForExecution(COMMAND_DIAGRAMTYPE_PARAM);
				DiagramType newDiagramType = (DiagramType) p;
				((MEDiagram) newMEInstance).setType(newDiagramType);
				newMEInstance.setName("new " + newDiagramType.getLiteral());
			}
			
			// add this newly created model element to LeafSection
			final LeafSection leafSection = (LeafSection)ActionHelper.getSelectedModelElement();
			if (leafSection != null) {
				TransactionalEditingDomain domain = WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						leafSection.getModelElements().add(newMEInstance);
					}
				});

				ActionHelper.openModelElement(newMEInstance);
			}
		}
		return null;

	}

}
