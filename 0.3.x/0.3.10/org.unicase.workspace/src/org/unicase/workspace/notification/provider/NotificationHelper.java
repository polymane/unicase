/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.notification.provider;

import java.util.Date;
import java.util.List;

import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.ProjectSpace;

/**
 * This class offer helper methods for notifications.
 * 
 * @author helming
 */
public final class NotificationHelper {

	private NotificationHelper() {

	}

	/**
	 * Returns the latest date of a list of operations.
	 * 
	 * @param list a list of AbstractOperations
	 * @return the latest date.
	 */
	public static Date getLastDate(List<AbstractOperation> list) {
		Date date = null;
		for (AbstractOperation operation : list) {
			if (date == null) {
				date = operation.getClientDate();
			} else {
				Date newDate = operation.getClientDate();
				if (newDate.after(date)) {
					date = newDate;
				}

			}
		}
		if (date == null) {
			date = new Date();
		}
		return date;
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param meId The id of the model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElementId meId, ProjectSpace projectSpace) {

		ModelElement modelElement = projectSpace.getProject().getModelElement(meId);
		if (modelElement != null) {
			return getHTMLLinkForModelElement(modelElement, projectSpace);
		}
		return "(deleted element)";
	}

	/**
	 * This method create a HTML link pointing to a model element for the message of Notifications.
	 * 
	 * @param modelElement The model element
	 * @param projectSpace the project space
	 * @return a HTML link as string
	 */
	public static String getHTMLLinkForModelElement(ModelElement modelElement, ProjectSpace projectSpace) {
		StringBuilder ret = new StringBuilder("<a href=\"unicase://current:0/");
		ret.append(projectSpace.getProjectName());
		ret.append("%");
		ret.append(projectSpace.getProjectId().getId());
		ret.append("/");
		String name = modelElement.getName().replaceAll("\"", "\\'");
		ret.append(name);
		ret.append("%");
		ret.append(modelElement.getIdentifier());
		ret.append("\">");
		if (name.length() > 33) {
			name = name.substring(0, 30) + "...";
		}
		ret.append(name);
		ret.append("</a>");
		return ret.toString();
	}
}
