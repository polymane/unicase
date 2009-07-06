/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard.widgets;

import org.eclipse.swt.widgets.Composite;

/**
 * A dashboard widget displaying an overview of related tasks.
 * 
 * @author Shterev
 */
public class DashboardRelatedTasksWidget extends AbstractDashboardWidget {

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent
	 * @param style the style
	 */
	public DashboardRelatedTasksWidget(Composite parent, int style) {
		super(parent, style);
		setTitle("Tasks that might be related to you");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContent() {
	}

}
