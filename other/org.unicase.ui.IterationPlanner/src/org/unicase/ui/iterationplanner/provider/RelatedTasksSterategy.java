/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.provider;

import java.util.List;

import org.unicase.model.task.WorkItem;

/**
 * interface to determine related tasks.
 * @author hodaie
 *
 */
public interface RelatedTasksSterategy {
	/**
	 * Returns tasks related to this work item.
	 * @param workItem work item
	 * @return related tasks
	 */
	List<WorkItem> getRelatedTasks(WorkItem workItem);

}
