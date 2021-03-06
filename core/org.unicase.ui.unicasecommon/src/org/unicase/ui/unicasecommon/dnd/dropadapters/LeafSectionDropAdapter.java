/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;

/**
 * This is the drop adapter for LeafSections.
 * 
 * @author Hodaie
 */
public class LeafSectionDropAdapter extends UCDropAdapter {

	/**
	 * {@inheritDoc} Adds the source list of {@link EObject EObjects} to the target {@link LeafSection}'s model
	 * elements.
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.ModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		for (EObject me : source) {
			((LeafSection) target).getModelElements().add(me);
		}
	}

	/**
	 * {@inheritDoc} You cannot drop a Section (Composite- or LeafSection) on a LeafSection.
	 */
	@Override
	protected boolean hasThisContainmentReference(EObject target, EClass refType) {
		if (DocumentPackage.eINSTANCE.getSection().isSuperTypeOf(refType)) {
			return false;
		} else {
			return super.hasThisContainmentReference(target, refType);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return DocumentPackage.eINSTANCE.getLeafSection();
	}

}
