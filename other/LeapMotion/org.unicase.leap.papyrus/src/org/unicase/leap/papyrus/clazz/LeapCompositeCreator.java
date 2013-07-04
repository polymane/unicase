/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.leap.papyrus.clazz;

import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.swt.graphics.Point;
import org.unicase.leap.action.ILeapActionHandler;
import org.unicase.leap.events.LeapActionEvent;

/**
 * Implementation of the {@link ILeapActionHandler} that will create the composite pattern at the current cursor
 * location, once a {@link LeapActionEvent} is raised.
 * 
 * @author mharut
 */
public class LeapCompositeCreator implements ILeapActionHandler {

	@Override
	public void handleLeapAction(LeapActionEvent leapEvent) {
		final LeapPapyrusClassDiagramHelper helper = new LeapPapyrusClassDiagramHelper(leapEvent);

		final Point location = leapEvent.getMousePosition();
		new ECPCommand(helper.getDiagram()) {

			@Override
			protected void doRun() {
				Node componentNode = helper.createClass("Component", true);
				helper.addOperation("doThis", true, componentNode);
				Node leafNode = helper.createClass("Leaf", false);
				Node compositeNode = helper.createClass("Composite", false);
				helper.addOperation("addElement", false, compositeNode);

				helper.createGeneralization(componentNode, leafNode);
				helper.createGeneralization(componentNode, compositeNode);
				helper.createContainment(compositeNode, componentNode);

				helper.setLocation(componentNode, location.x, location.y, true);
				helper.setLocation(leafNode, location.x - 150, location.y + 150, true);
				helper.setLocation(compositeNode, location.x + 150, location.y + 150, true);

			}
		}.run(false);
	}

}
