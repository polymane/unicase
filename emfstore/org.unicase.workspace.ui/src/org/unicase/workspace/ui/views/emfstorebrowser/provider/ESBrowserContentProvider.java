/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.provider;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.client.ServerInfo;
import org.eclipse.emf.emfstore.client.Workspace;
import org.eclipse.emf.emfstore.client.accesscontrol.AccessControlHelper;
import org.eclipse.emf.emfstore.client.model.provider.WorkspaceItemProviderAdapterFactory;
import org.eclipse.jface.viewers.TreeNode;

/**
 * Content provider for the tree view.
 * 
 * @author shterev
 */
public class ESBrowserContentProvider extends AdapterFactoryContentProvider {

	private AccessControlHelper accessControl;

	/**
	 * Default constructor.
	 */
	public ESBrowserContentProvider() {
		super(new WorkspaceItemProviderAdapterFactory());
	}

	/**
	 * Getter for the AccesscontrolHelper.
	 * 
	 * @return the AccesscontrolHelper
	 */
	public AccessControlHelper getAccesscontrolHelper() {
		return accessControl;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof TreeNode) {
			TreeNode node = (TreeNode) object;
			Object value = node.getValue();
			Object[] children;
			if (value instanceof Workspace) {
				children = ((Workspace) value).getServerInfos().toArray();
			} else if (value instanceof ServerInfo) {
				ServerInfo serverInfo = (ServerInfo) value;
				children = getChildren(serverInfo);
			} else {
				children = super.getChildren(node.getValue());
			}
			return nodify(node, children);
		}
		return super.getChildren(object);
	}

	private Object[] getChildren(ServerInfo serverInfo) {
		return serverInfo.getProjectInfos().toArray();
	}

	private TreeNode[] nodify(TreeNode parent, Object[] children) {
		TreeNode[] ret = new TreeNode[children.length];
		for (int i = 0; i < children.length; i++) {
			TreeNode node = new TreeNode(children[i]);
			node.setParent(parent);
			ret[i] = node;
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeNode) {
			if (((TreeNode) parent).getValue() instanceof ServerInfo) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		TreeNode node = new TreeNode(object);
		return getChildren(node);
	}

}