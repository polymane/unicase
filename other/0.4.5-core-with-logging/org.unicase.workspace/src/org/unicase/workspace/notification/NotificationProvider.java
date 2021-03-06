/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification;

import java.util.List;
import java.util.Set;

import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.OperationId;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.preferences.DashboardKey;

/**
 * Provides notifications.
 * 
 * @author koegel
 */
public interface NotificationProvider {

	/**
	 * Return the name of the provider.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Provide notifications for a list of change packages.
	 * 
	 * @param projectSpace the project space.
	 * @param changePackages a list of change packages
	 * @param currentUsername the name of the current user
	 * @return a list of notifications
	 */
	List<ESNotification> provideNotifications(ProjectSpace projectSpace, List<ChangePackage> changePackages,
		String currentUsername);

	/**
	 * Provides a list of AbstractOperations to be excluded from providers pending in the generator queue. Every
	 * Provider should offer such a list to its direct successor (see the <i>after</i> parameter for the extension
	 * point).
	 * 
	 * @return the set of operations
	 */
	Set<OperationId> getExcludedOperations();

	/**
	 * @return the Enum key for this provider's settings
	 */
	DashboardKey getKey();

}
