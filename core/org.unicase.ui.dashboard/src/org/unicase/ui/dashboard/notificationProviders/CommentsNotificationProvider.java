/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.dashboard.notificationProviders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.notification.NotificationFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.organization.Group;
import org.unicase.model.organization.User;
import org.unicase.model.rationale.Comment;
import org.unicase.model.task.WorkItem;
import org.unicase.ui.unicasecommon.util.OrgUnitHelper;
import org.unicase.workspace.preferences.DashboardKey;
import org.unicase.workspace.preferences.PreferenceManager;

/**
 * Provides notifications for new Comments.
 * 
 * @author shterev
 */
public class CommentsNotificationProvider extends AbstractNotificationProvider {

	private HashMap<Comment, AbstractOperation> personalComment2OperationMap;
	private HashMap<Comment, AbstractOperation> reply2OperationMap;
	private HashMap<Comment, AbstractOperation> taskComment2OperationMap;
	private HashMap<UnicaseModelElement, ArrayList<Comment>> me2replyMap;
	private HashMap<UnicaseModelElement, ArrayList<Comment>> me2personalCommentMap;
	private HashMap<UnicaseModelElement, ArrayList<Comment>> me2taskCommentMap;

	/**
	 * The name.
	 */
	public static final String NAME = "Comments Notification Provider";

	/**
	 * Default constructor.
	 */
	public CommentsNotificationProvider() {
		personalComment2OperationMap = new HashMap<Comment, AbstractOperation>();
		reply2OperationMap = new HashMap<Comment, AbstractOperation>();
		taskComment2OperationMap = new HashMap<Comment, AbstractOperation>();
		me2replyMap = new HashMap<UnicaseModelElement, ArrayList<Comment>>();
		me2personalCommentMap = new HashMap<UnicaseModelElement, ArrayList<Comment>>();
		me2taskCommentMap = new HashMap<UnicaseModelElement, ArrayList<Comment>>();
	}

	private void aggregateComments(
			HashMap<UnicaseModelElement, ArrayList<Comment>> map,
			UnicaseModelElement modelElement, Comment comment) {
		if (map.get(modelElement) == null) {
			ArrayList<Comment> comments = new ArrayList<Comment>();
			map.put(modelElement, comments);
		}
		map.get(modelElement).add(comment);
	}

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
	 */
	@Override
	protected List<ESNotification> createNotifications() {
		List<ESNotification> result = new ArrayList<ESNotification>();
		OrgUnitProperty commentsProviderProperty = PreferenceManager.INSTANCE
				.getProperty(getProjectSpace(), DashboardKey.COMMENTS_PROVIDER);
		if (commentsProviderProperty.getBooleanProperty()) {
			OrgUnitProperty threadRepliesProperty = PreferenceManager.INSTANCE
					.getProperty(getProjectSpace(),
							DashboardKey.SHOW_CONTAINMENT_REPLIES);
			if (threadRepliesProperty.getBooleanProperty()) {
				for (UnicaseModelElement modelElement : me2replyMap.keySet()) {
					result.add(createCommentNotification(me2replyMap,
							reply2OperationMap, modelElement,
							" also commented in the thread for "));
				}
			}
			for (UnicaseModelElement modelElement : me2personalCommentMap
					.keySet()) {
				result.add(createCommentNotification(me2personalCommentMap,
						personalComment2OperationMap, modelElement,
						" commented on "));
			}
			for (UnicaseModelElement modelElement : me2taskCommentMap.keySet()) {
				result.add(createCommentNotification(me2taskCommentMap,
						taskComment2OperationMap, modelElement,
						" commented on your task "));
			}
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleOperation(AbstractOperation operation) {
		ModelElement modelElement = getProjectSpace().getProject()
				.getModelElement(operation.getModelElementId());
		if (modelElement == null) {
			// the ME was deleted from the project.
			return;
		}

		if (operation instanceof CreateDeleteOperation
				&& modelElement instanceof Comment) {
			handleCreateDeleteOperation(operation, getUser(),
					(Comment) modelElement);
		}
	}

	private void handleCreateDeleteOperation(AbstractOperation operation,
			User user, Comment comment) {
		CreateDeleteOperation cdo = (CreateDeleteOperation) operation;
		if (cdo.isDelete()) {
			return;
		}
		if (comment.getModelElementId() == null) {
			return;
		}
		Comment localComment = (Comment) getProjectSpace().getProject()
				.getModelElement(comment.getModelElementId());
		UnicaseModelElement firstParent = localComment.getFirstParent();
		if (firstParent == null) {
			return;
		}
		for (Comment c : firstParent.getComments()) {
			for (Comment c2 : c.getThread()) {
				if (c2.getSender() != null && c2.getSender().equals(user)) {
					reply2OperationMap.put(comment, operation);
					aggregateComments(me2replyMap, firstParent, comment);
					getExcludedOperations().add(operation.getOperationId());
					return;
				}
			}
		}
		Set<Group> groups = OrgUnitHelper.getAllGroupsOfOrgUnit(user);
		if (firstParent instanceof WorkItem) {
			WorkItem workItem = (WorkItem) firstParent;
			if ((workItem.getAssignee() != null && (workItem.getAssignee()
					.equals(user) || groups.contains(workItem.getAssignee())))
					|| (workItem.getReviewer() != null && workItem
							.getReviewer().equals(user))) {
				taskComment2OperationMap.put(comment, operation);
				aggregateComments(me2taskCommentMap, firstParent, comment);
				getExcludedOperations().add(operation.getOperationId());
				return;
			}
		}
		if (comment.getRecipients().contains(user)) {
			personalComment2OperationMap.put(comment, operation);
			aggregateComments(me2personalCommentMap, firstParent, comment);
			getExcludedOperations().add(operation.getOperationId());
			return;
		}
	}

	private ESNotification createNotification(List<Comment> comments,
			List<AbstractOperation> abstractOperations) {
		ESNotification notification = NotificationFactory.eINSTANCE
				.createESNotification();
		notification.setName("New comment notification");
		notification.setProject(ModelUtil.clone(getProjectSpace()
				.getProjectId()));
		notification.setRecipient(getUser().getName());
		notification.setSeen(false);
		notification.setProvider(getName());
		for (Comment comment : comments) {
			notification.getRelatedModelElements().add(
					comment.getModelElementId());
		}
		Collections.sort(abstractOperations,
				new Comparator<AbstractOperation>() {
					/**
					 * {@inheritDoc}
					 */
					public int compare(AbstractOperation arg0,
							AbstractOperation arg1) {
						if (arg0.getClientDate() == null
								&& arg1.getClientDate() == null) {
							return 0;
						} else if (arg0.getClientDate() == null
								&& arg1.getClientDate() != null) {
							return 1;
						} else if (arg0.getClientDate() != null
								&& arg1.getClientDate() == null) {
							return -1;
						} else {
							arg0.getClientDate()
									.compareTo(arg1.getClientDate());
						}
						return 0;
					}
				});
		for (AbstractOperation abstractOperation : abstractOperations) {
			notification.getRelatedOperations().add(
					abstractOperation.getOperationId());
		}
		Date date = abstractOperations.get(abstractOperations.size() - 1)
				.getClientDate();
		if (date == null) {
			date = new Date();
		}
		notification.setCreationDate(date);
		return notification;
	}

	private ESNotification createCommentNotification(
			HashMap<UnicaseModelElement, ArrayList<Comment>> me2commentMap,
			HashMap<Comment, AbstractOperation> comment2opMap,
			UnicaseModelElement modelElement, String message) {
		List<Comment> comments = me2commentMap.get(modelElement);
		ArrayList<AbstractOperation> ops = new ArrayList<AbstractOperation>();
		StringBuilder stringBuilder = new StringBuilder();

		for (Comment c : comments) {
			ops.add(comment2opMap.get(c));
			if (c.getSender() != null && !c.getSender().equals(getUser())) {
				stringBuilder.append(NotificationHelper
						.getHTMLLinkForModelElement(c.getSender(),
								getProjectSpace()));
				stringBuilder.append(", ");
			}
		}
		ESNotification notification = createNotification(comments, ops);
		int length = stringBuilder.length();
		if (length > 2) {
			stringBuilder.delete(length - 2, length - 1);
		}
		stringBuilder.append(message);
		stringBuilder.append(NotificationHelper.getHTMLLinkForModelElement(
				modelElement, getProjectSpace()));
		String text = stringBuilder.toString();
		notification.setMessage(text);
		return notification;
	}

	/**
	 * {@inheritDoc}
	 */
	public DashboardKey getKey() {
		return DashboardKey.COMMENTS_PROVIDER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.dashboard.notificationProviders.AbstractNotificationProvider#init()
	 */
	@Override
	protected void init() {
		super.init();
		personalComment2OperationMap.clear();
		taskComment2OperationMap.clear();
		reply2OperationMap.clear();
		me2personalCommentMap.clear();
		me2taskCommentMap.clear();
		me2replyMap.clear();
	}
}
