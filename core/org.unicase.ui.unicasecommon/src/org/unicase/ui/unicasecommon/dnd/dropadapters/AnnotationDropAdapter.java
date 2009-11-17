/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.Annotation;
import org.unicase.model.UnicaseModelElement;

/**
 * This is the drop adapter for annotations.
 * 
 * @author Hodaie
 */
public class AnnotationDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public AnnotationDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.MEDropAdapter#canDrop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      java.util.List, org.unicase.metamodel.UnicaseModelElement, org.unicase.metamodel.UnicaseModelElement)
	 */
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<UnicaseModelElement> source,
		UnicaseModelElement target, UnicaseModelElement dropee) {
		boolean result = super.canDrop(eventFeedback, event, source, target, dropee);
		if (dropee instanceof Annotation) {
			result = false;

		}

		return result;

	}

}
