/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.model.util.ModelUtil;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;
import org.unicase.workspace.preferences.DashboardKey;

/**
 * Provides notifications on updates of a project space.
 * 
 * @author koegel
 * @author shterev
 */
public class UpdateNotificationProvider implements NotificationProvider {

	/**
	 * The name.
	 */
	public static final String NAME = "Update Notification Provider";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getName()
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#provideNotifications(org.unicase.workspace.ProjectSpace,
	 *      java.util.List, java.lang.String)
	 */
	public List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername) {
		List<ESNotification> result = new ArrayList<ESNotification>();
		// do not generate an update notification for a commit
		if ((changePackages.size() == 1 && changePackages.get(0).getLogMessage() == null)) {
			return result;
		}

		ESNotification notification = NotificationFactory.eINSTANCE.createESNotification();
		notification.setProject(ModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(currentUsername);
		notification.setProvider(getName());

		if (changePackages.isEmpty()) {
			notification.setCreationDate(new Date());
			notification.setMessage("You checked out the project in version "
				+ projectSpace.getBaseVersion().getIdentifier());
			notification.setName("Project checkout");
		} else {
			Date date = changePackages.get(0).getLogMessage().getClientDate();
			for (ChangePackage cp : changePackages) {
				if (cp.getLogMessage().getClientDate().after(date)) {
					date = cp.getLogMessage().getClientDate();
				}
			}
			notification.setCreationDate(date);
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("You updated your project to version ");
			stringBuilder.append(projectSpace.getBaseVersion().getIdentifier());
			notification.setMessage(stringBuilder.toString());
			notification.setName("Updated Project");
		}
		result.add(notification);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.notification.NotificationProvider#getExcludedOperations()
	 */
	public Set<OperationId> getExcludedOperations() {
		return new HashSet<OperationId>();
	}

	/**
	 * {@inheritDoc}
	 */
	public DashboardKey getKey() {
		return DashboardKey.UPDATE_PROVIDER;
	}
}
