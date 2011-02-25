/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.unicase.emfstore.jdt.configuration.ConfigurationManager;
import org.unicase.emfstore.jdt.exception.NoEMFStoreJDTConfigurationException;

/**
 * Helper class to find out (for the EMF Store).
 * 
 * @author Adrian Staudt
 */
public final class CommitHelper {

	private CommitHelper() {
	}

	/**
	 * Tells if one of the projects is managed by an EMF Store.
	 * 
	 * @param releatedProjects A set of eclipse workspace projects.
	 * @return True if one the projects is managed by an EMF Store, false otherwise.
	 */
	public static boolean isEMFStoreJDTInvolved(Set<IProject> releatedProjects) {
		boolean isEMFStoreJDTInvolved = false;

		for (IProject relatedProject : releatedProjects) {
			try {
				ConfigurationManager.getConfiguration(relatedProject);
				isEMFStoreJDTInvolved = true;
				break;

			} catch (NoEMFStoreJDTConfigurationException e) {
				// ignore. Anyway this project is not involved.
			}
		}

		return isEMFStoreJDTInvolved;
	}

}