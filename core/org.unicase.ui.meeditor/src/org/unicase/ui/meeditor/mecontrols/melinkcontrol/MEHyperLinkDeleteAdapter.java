/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.commands.DeleteReferenceCommand;

/**
 * A mouse adapter regarding deletion of model elements.
 * 
 * @author helming
 * @author shterev
 */
public class MEHyperLinkDeleteAdapter extends MouseAdapter {

	private EObject modelElement;
	private EReference reference;
	private EObject opposite;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement the model element
	 * @param reference the reference link
	 * @param opposite the model element on the other side of the link
	 */
	public MEHyperLinkDeleteAdapter(EObject modelElement, EReference reference, EObject opposite) {
		this.modelElement = modelElement;
		this.reference = reference;
		this.opposite = opposite;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseUp(MouseEvent e) {
		if (reference.isContainment() && opposite instanceof NonDomainElement) {
			new DeleteModelElementCommand((ModelElement) opposite).run();
		} else {
			new DeleteReferenceCommand((ModelElement) modelElement, reference, (ModelElement) opposite).run();
		}
	}
}
