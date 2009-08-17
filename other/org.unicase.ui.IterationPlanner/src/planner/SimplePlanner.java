/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package planner;

import java.util.List;

import org.unicase.model.organization.User;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.iterationplanner.core.Plan;

/**
 * Simple dispatcher.
 * 
 * @author hodaie
 * 
 */
public class SimplePlanner extends Planner {

	
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public List<Plan> plan(List<WorkItem> tasks, List<User> assignees,
			int numOfIterations) {
		return null;
	}


}
