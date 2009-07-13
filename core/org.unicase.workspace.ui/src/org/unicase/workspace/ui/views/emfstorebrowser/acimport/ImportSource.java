/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.acimport;

import java.util.Properties;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author deser, karakoc
 */
public abstract class ImportSource {

	/**
	 * @param obj
	 *            the object to get the children from.
	 * @return the children of the given object.
	 */
	public abstract Object[] getChildren(Object obj);

	/**
	 * @param obj
	 *            Object (TreeItem) from which the parent object will be
	 *            returned
	 * @return the parent object of the given object
	 * @see org.unicase.workspace.ui.views.emfstorebrowser.acimport.ImportSource#getParent(java.lang.Object)
	 */
	public Object getParent(Object obj) {
		if ((ImportWrapper) ((TreeItem) obj).getData() != null) {
			return ((ImportWrapper) ((TreeItem) obj).getData())
					.getParentOrgUnit();
		} else {
			return null;
		}
	}

	/**
	 * @param arg0
	 *            the object to get the information, if it has children.
	 * @return wheter the given object has children or not.
	 */
	public boolean hasChildren(Object arg0) {
		// Get the children
		Object[] obj = getChildren(arg0);

		// Return whether the parent has children
		return obj == null ? false : obj.length > 0;
	}

	/**
	 * @param obj
	 *            the object to get the root elements from.
	 * @return the root elements of the given object.
	 */
	public abstract Object[] getElements(Object obj);

	/**
	 * @param properties
	 *            the properties of the import source
	 */
	public void setOptions(Properties properties) {
	}

	/**
	 * @return a small label for the import source.
	 */
	public abstract String getLabel();

	/**
	 * @param shell
	 *            Shell for UI actions, if needed. This parameter can be
	 *            ignored, if there is no use for it.
	 * @return whether the initialization of the source worked or not.
	 */
	public abstract boolean init(Shell shell);

	/**
	 * @return Returns a little description of the current ImportSource, e.g.
	 *         the server String of an LDAP server or the file of an CSV import.
	 */
	public abstract String getMessage();

}
