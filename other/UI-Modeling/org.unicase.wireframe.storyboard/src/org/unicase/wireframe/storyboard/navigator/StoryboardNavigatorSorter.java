/*
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.storyboard.navigator;

import org.eclipse.jface.viewers.ViewerSorter;
import org.unicase.wireframe.storyboard.part.StoryboardVisualIDRegistry;

/**
 * @generated
 */
public class StoryboardNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 2003;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof StoryboardNavigatorItem) {
			StoryboardNavigatorItem item = (StoryboardNavigatorItem) element;
			return StoryboardVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
