/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;

/**
 * . This is the content provider for versions table on HistroyBrowser's browser
 * tab.
 * 
 * @author Hodaie
 */
public class HistoryTableContentProvider extends AdapterFactoryContentProvider {

	/**
	 * . Constructor
	 */
	public HistoryTableContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * . {@inheritDoc} The input to table is a list of versions
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object object) {
		List<HistoryInfo> historyInfo = (List<HistoryInfo>) object;
		return historyInfo.toArray(new Object[historyInfo.size()]);

	}

}
