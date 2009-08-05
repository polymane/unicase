/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.stem.views.statusview.dnd;

import java.util.Set;

import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * This is drop adapter for flat tab in StatusView. Note that in methods dropXXOnYY(), YY actually means the
 * currentOpenME and not drop target!
 * 
 * @author Hodaie
 */
public class FlatTabDropAdapter extends AbstractDropAdapter {

	/**
	 * {@inheritDoc} In flat tab: Drop WorkItem B on ME (non work package) A. If B somewhere exists in annotations of A
	 * (hierarchical), do nothing; otherwise Annotate A with B
	 * 
	 * @see org.unicase.ui.stem.views.statusview.dnd.AbstractDropAdapter#dropWorkItemOnNonWorkPackage()
	 */
	@Override
	protected void dropWorkItemOnNonWorkPackage() {
		// dorp WorkItem B on ME (non work package) A:
		// if B somewhere exists in annotations of A (hierachical),
		// do nothing; otherwise Annotate A with B
		ModelElement currentOpenME = getCurrentOpenME();
		ModelElement source = getDragSource();

		Set<ModelElement> openersForCurrentOpenME = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy()
			.getLeafOpeners(currentOpenME);
		if (!openersForCurrentOpenME.contains(source)) {
			((WorkItem) source).getAnnotatedModelElements().add(currentOpenME);
		}
	}

}
