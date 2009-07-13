/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.swt.widgets.Display;

/**
 * @author schroech
 *
 */
public class AppendSelectionAction extends SelectionAction {

	/**
	 * Default constructor.
	 * 
	 * @param diagramEditPart The {@link DiagramEditPart} on which this operation operates
	 * @param targetEditPart The {@link GraphicalEditPart} being selected / deselected
	 */
	public AppendSelectionAction(DiagramEditPart diagramEditPart, org.eclipse.gef.GraphicalEditPart targetEditPart) {
		super(diagramEditPart, targetEditPart);
	}

	/** 
	* {@inheritDoc}
	* @see org.unicase.ui.tom.actions.AbstractAction#execute()
	*/
	public void execute() {
		Runnable runnable = new Runnable(){
			public void run(){
				getDiagramEditPart().getViewer().appendSelection(getTargetEditPart());
			}
		};
		
		Display.getDefault().syncExec(runnable);
	}
}
