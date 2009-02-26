/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.task.Checkable;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;

/**
 * This is the ContentProvider.
 * 
 * @author Shterev
 */

public class WorkPackageTabContentProvider extends AdapterFactoryContentProvider {
	/**
	 * Constant for the unassigned column.
	 */
	public static final String UNASSIGNED = "Unassigned";
	/**
	 * Constant for the assigned column.
	 */
	public static final String ASSIGNED = "Assigned";
	/**
	 * Constant for the blocked column.
	 */
	public static final String BLOCKED = "Blocked";
	/**
	 * Constant for the done column.
	 */
	public static final String DONE = "Done";
	/**
	 * Column for the testing column.
	 */
	public static final String TESTING = "Testing";

	private String key;
	private PriorityComparator priorityComparator;

	/**
	 * Compares two WorkItems by their priority.
	 * 
	 * @author Shterev
	 */
	private final class PriorityComparator implements Comparator<WorkItem> {

		public int compare(WorkItem o1, WorkItem o2) {
			int prio1 = o1.getPriority();
			int prio2 = o2.getPriority();
			if (prio1 > prio2) {
				return 1;
			} else if (prio1 < prio2) {
				return -1;
			}
			return 0;
		}

	}

	/**
	 * Constructor.
	 * 
	 * @param key determines which column is shown.
	 */
	public WorkPackageTabContentProvider(String key) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		priorityComparator = new PriorityComparator();
		this.key = key;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		ArrayList<WorkItem> ret = new ArrayList<WorkItem>();
		if (!(object instanceof WorkPackage)) {
			return new Object[0];
		}
		WorkPackage wp = (WorkPackage) object;
		List<WorkItem> wis = wp.getAllContainedWorkItems();
		for (WorkItem wi : wis) {
			if (wi instanceof WorkPackage) {
				continue;
			}
			if (key.equals(ASSIGNED)) {
				handleAssigneColumn(ret, wi);
			} else if (key.equals(BLOCKED)) {
				handleBlockedColumn(ret, wi);
			} else if (key.equals(TESTING)) {
				handleTestingColumn(ret, wi);
			} else if (key.equals(DONE)) {
				handleDoneColumn(ret, wi);
			} else if (key.equals(UNASSIGNED)) {
				handleUnassignedColumn(ret, wi);
			}
		}
		Collections.sort(ret, priorityComparator);
		return ret.toArray();
	}

	private void handleUnassignedColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (!((Checkable) wi).isChecked() && wi.getAssignee() == null && wi.getParticipants().isEmpty()
			&& wi.getPredecessors().isEmpty()) {
			ret.add(wi);
		}
	}

	private void handleDoneColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (((Checkable) wi).isChecked()) {
			ret.add(wi);
		}
	}

	private void handleTestingColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (!wi.getParticipants().isEmpty() && !((Checkable) wi).isChecked() && wi.getPredecessors().isEmpty()) {
			ret.add(wi);
		}
	}

	private void handleBlockedColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (!wi.getPredecessors().isEmpty() && !((Checkable) wi).isChecked()) {
			ret.add(wi);
		}
	}

	private void handleAssigneColumn(ArrayList<WorkItem> ret, WorkItem wi) {
		if (wi.getAssignee() != null && wi.getParticipants().isEmpty() && !((Checkable) wi).isChecked()
			&& wi.getPredecessors().isEmpty()) {
			ret.add(wi);
		}
	}

	/**
	 * Getter.
	 * 
	 * @return the key.
	 */
	public String getKey() {
		return key;
	}

}
