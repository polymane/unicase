/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.notification.NotificationProvider;

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
		notification.setProject(EsModelUtil.clone(projectSpace.getProjectId()));
		notification.setRecipient(currentUsername);
		notification.setProvider(getName());
		result.add(notification);
		return result;
	}
}
