/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.provider;

import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.workspace.ServerInfo;

/**
 * Sort alphabetically the repository browser viewer
 * 
 * @author shterev
 * 
 */
public class ESBrowserViewerSorter extends ViewerSorter {

	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		if (o1 instanceof TreeNode && o2 instanceof TreeNode) {
			Object node1 = ((TreeNode) o1).getValue();
			Object node2 = ((TreeNode) o2).getValue();
			if (node1 instanceof ServerInfo && node2 instanceof ServerInfo) {
				return ((ServerInfo) node1).getName().toLowerCase().compareTo(
						((ServerInfo) node2).getName().toLowerCase());
			} else if (node1 instanceof ProjectInfo
					&& node2 instanceof ProjectInfo) {
				return ((ProjectInfo) node1).getName().toLowerCase().compareTo(
						((ProjectInfo) node2).getName().toLowerCase());
			}
		}

		return super.compare(viewer, o1, o2);
	}
}