/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.iterationplanningview;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.unicase.workspace.WorkspaceManager;

/**
 * . LabelProvider for IterationPlanning view to show decorations on WorkPackages
 * 
 * @author Helming
 */
public class LabelProvider extends TransactionalAdapterFactoryLabelProvider implements ILabelProvider {

	/**
	 * . Constructor
	 */
	public LabelProvider() {

		super(WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain(), new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

}
