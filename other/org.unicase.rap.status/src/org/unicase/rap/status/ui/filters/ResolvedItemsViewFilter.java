/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.rap.status.ui.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.unicase.model.task.WorkItem;

/**
 * This filter prevents showing of resolved bug reports in viewers.
 * 
 * @author Fatih Ulusoy
 */
public class ResolvedItemsViewFilter extends ViewerFilter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return ((element instanceof WorkItem) && (!((WorkItem) element).isResolved()));
	}

}
