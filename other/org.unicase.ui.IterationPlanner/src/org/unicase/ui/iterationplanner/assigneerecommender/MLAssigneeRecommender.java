/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner.assigneerecommender;

import org.unicase.model.organization.User;

import java.util.List;

/**
 * @author Hodaie
 */
public class MLAssigneeRecommender implements AssigneeRecommender {

	public void addAssignee(User assignee) {
	// TODO Auto-generated method stub

	}

	public List<User> getAssignees() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAssignee(User obj) {
	// TODO Auto-generated method stub

	}

}

// if (!(wi instanceof BugReport || wi instanceof ActionItem || wi instanceof Issue)) {
// return;
// }
// if (!(assignee instanceof OrgUnit)) {
// return;
// }
// totalPredictions++;
//
// meMatrix = new ModelElementMatrix(getRelevantWorkItems(), meMatrix.getFeatures());
//
// // put the WorkItem that is to be predicted to end of model elements
// // list
// // this is for classifier to predict assignee for this work item. see
// // Classificaiton.predictAssignee()
// meMatrix.getModelElements().remove(wi);
// meMatrix.getModelElements().add((ModelElement) wi);
//
// if (meMatrix.getModelElements().size() == 1) {
// return;
// }
// try {
// classification.init(meMatrix);
// } catch (Exception e) {
// e.printStackTrace();
// }
// String suggestedAssignee = null;
// try {
// suggestedAssignee = classification.predictAssignee();
// } catch (Exception e) {
// e.printStackTrace();
// }
// if (suggestedAssignee != null && assignee != null
// && areEqual(suggestedAssignee, ((OrgUnit) assignee).getName())) {
// correctPredictions++;
// }
