/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent;
import org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent;
import org.unicase.model.Annotation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.model.rationale.Comment;
import org.unicase.model.rationale.RationaleFactory;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.edit.Activator;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A dashboard entry widget.
 * 
 * @author Shterev
 */
public class NotificationDashboardEntry extends AbstractDashboardEntry {

	/**
	 * A mouse adapter that toggles the drawer.
	 * 
	 * @author Shterev
	 */
	private final class ToggleDrawerAdapter extends MouseAdapter {
		@Override
		public void mouseDown(MouseEvent e) {
			toggleDrawer(e, showDrawer);
			showDrawer = !showDrawer;
			getPage().getForm().reflow(true);
			notificationComposite.setFocus();
		}
	}

	/**
	 * A mouse adapter that toggles the comments.
	 * 
	 * @author Shterev
	 */
	private final class ToggleCommentsAdapter extends MouseAdapter {
		@Override
		public void mouseDown(MouseEvent e) {
			toggleComments(e, showComments);
			showComments = !showComments;
			getPage().getForm().reflow(true);
			notificationComposite.setFocus();
		}
	}

	/**
	 * A hover listener to change the color appearance of the notification.
	 * 
	 * @author Shterev
	 */
	private final class HoverTrackAdapter extends MouseTrackAdapter {
		@Override
		public void mouseEnter(MouseEvent e) {
			setBackground(lightBlue);
			mouseOver = true;
			if (e.widget.equals(closeButton)) {
				mouseOverClose = true;
			}
		}

		@Override
		public void mouseExit(MouseEvent e) {
			setBackground(notificationColor);
			mouseOver = false;
			if (e.widget.equals(closeButton)) {
				mouseOverClose = false;
			}
		}
	}

	/**
	 * Selection listener for the links.
	 * 
	 * @author Shterev
	 */
	private final class LinkSelectionListener implements SelectionListener {

		private String source;

		public LinkSelectionListener(String source) {
			super();
			this.source = source;
		}

		public void widgetDefaultSelected(SelectionEvent e) {
			//
		}

		public void widgetSelected(SelectionEvent e) {
			String text = e.text;
			if (text.equals("more")) {
				return;
			}
			try {
				ModelElementUrl modelElementUrl = UrlFactory.eINSTANCE.createModelElementUrl(text);
				ModelElement modelElement = null;
				ModelElementUrlFragment modelElementUrlFragment = modelElementUrl.getModelElementUrlFragment();
				try {
					modelElement = getProjectSpace().resolve(modelElementUrlFragment);
				} catch (MEUrlResolutionException e1) {
				}
				ActionHelper.openModelElement(modelElement, DashboardEditor.ID);
				logEvent(modelElementUrlFragment.getModelElementId(), source);
			} catch (MalformedURLException ex) {
				WorkspaceUtil.logException("Invalid unicase URL pattern", ex);
			}
		}
	}

	private Color lightBlue;
	private Color notificationColor;
	private SimpleDateFormat format;
	private Composite drawerComposite;
	private Composite notificationComposite;
	private boolean mouseOver;
	private boolean mouseOverClose;

	private boolean showDrawer = true;
	private boolean showComments = true;
	private AdapterFactoryLabelProvider labelProvider;
	private Composite closeButton;
	private Link entryMessage;
	private Composite toolbar;
	private Comment[] comments;
	private Composite commentsComposite;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent composite.
	 * @param style the style.
	 * @param notification the notification.
	 * @param project the project.
	 * @param page a back link to the dashboard page (needed only for layout purposes).
	 */
	public NotificationDashboardEntry(DashboardPage page, Composite parent, int style, ESNotification notification,
		ProjectSpace project) {
		super(page, parent, style, notification, project);

		lightBlue = new Color(getDisplay(), 233, 244, 255);
		notificationColor = getDisplay().getSystemColor(SWT.COLOR_WHITE);
		format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		comments = getComment();
		createEntry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createEntry() {
		// contains the entry and the close button
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).margins(3, 0).applyTo(this);
		setBackground(notificationColor);

		// contains the entry - everything apart from the close button
		notificationComposite = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(notificationComposite);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(notificationComposite);

		if (getNotification().getRelatedModelElements().size() == 0) {
			// assuming that _all_ notifications are based on a specific element
			return;
		}

		createNotificationEntry();
		createCloseButton();

		MouseTrackAdapter hoverListener = new HoverTrackAdapter();
		addMouseTrackListener(this, hoverListener);
	}

	private void addMouseTrackListener(Control control, MouseTrackListener listener) {
		control.addMouseTrackListener(listener);
		if (control instanceof Composite) {
			for (Control c : ((Composite) control).getChildren()) {
				addMouseTrackListener(c, listener);
			}
		}
	}

	private void createComments() {
		commentsComposite = new Composite(notificationComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(commentsComposite);
		GridDataFactory.fillDefaults().span(3, 1).indent(20, 0).grab(true, false).applyTo(commentsComposite);
		for (Comment comment : comments) {
			createCommentEntry(commentsComposite, comment);
		}
		Composite c = commentsComposite;
		while (c != null) {
			c.layout(true);
			c = c.getParent();
		}
	}

	private void createDrawer() {

		drawerComposite = new Composite(notificationComposite, SWT.NONE);
		GridDataFactory.fillDefaults().hint(380, SWT.DEFAULT).grab(true, false).span(3, 1).indent(20, 0).applyTo(
			drawerComposite);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 8).extendedMargins(3, 3, 3, 3).applyTo(
			drawerComposite);
		drawerComposite.setBackground(lightBlue);

		for (ModelElementId mid : getNotification().getRelatedModelElements()) {
			Control drawerEntry = URLHelper.getModelElementLink(drawerComposite, mid, getProjectSpace(),
				URLHelper.UNLTD);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(drawerEntry);
		}

	}

	private void createCloseButton() {
		final Image closeImage = Activator.getImageDescriptor("icons/close.png").createImage();
		final Image closeImageRed = Activator.getImageDescriptor("icons/cross.png").createImage();
		closeButton = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).hint(18, 26).applyTo(closeButton);
		closeButton.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (mouseOver) {
					Rectangle area = closeButton.getClientArea();
					Image image = closeImage;
					if (mouseOverClose) {
						image = closeImageRed;
					}
					e.gc.drawImage(image, area.x, area.y + 5);
				}
			}
		});
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				boolean hide = MessageDialog
					.openQuestion(
						getShell(),
						"Reject notification",
						"Are you sure you are NOT interested in this notification? Your choice will be used to filter notifications you will receive in the future.");
				if (hide) {
					TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							getNotification().setSeen(true);
							logEvent(getNotification(), getProjectSpace());
							((DashboardEditor) getPage().getEditor()).refresh();
						}
					});
				}
			}
		});
	}

	private void createNotificationEntry() {
		ModelElement modelElement = getProjectSpace().getProject().getModelElement(
			getNotification().getRelatedModelElements().get(0));

		// the composite that wraps the whole notification
		Composite notificationEntry = new Composite(notificationComposite, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(notificationEntry);
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(false).margins(6, 6).spacing(3, 0).applyTo(
			notificationEntry);

		// the image
		final Image image = labelProvider.getImage(modelElement);
		final Composite imageComposite = new Composite(notificationEntry, SWT.NONE);
		GridDataFactory.fillDefaults().hint(16, 16).applyTo(imageComposite);
		imageComposite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Rectangle area = imageComposite.getClientArea();
				e.gc.drawImage(image, area.x, area.y);
			}
		});
		imageComposite.setData(modelElement.eClass());
		ModelElementClassTooltip.enableFor(imageComposite);

		// the message
		entryMessage = new Link(notificationEntry, SWT.WRAP | SWT.MULTI);
		String text = getMessage();
		if (text == null) {
			text = "";
		}
		entryMessage.setText(text);
		GridDataFactory.fillDefaults().hint(400, SWT.DEFAULT).grab(true, false).applyTo(entryMessage);
		entryMessage.addSelectionListener(new LinkSelectionListener("link"));

		// the toolbar
		createToolbar(notificationEntry);

		// the date
		Label date = new Label(notificationEntry, SWT.NONE);
		date.setText(format.format(getNotification().getCreationDate()));
		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(date);
		date.setForeground(getDisplay().getSystemColor(SWT.COLOR_GRAY));
	}

	private void createToolbar(Composite parent) {
		toolbar = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(toolbar);
		RowLayout layout = new RowLayout();
		layout.spacing = 0;
		layout.marginTop = 0;
		toolbar.setLayout(layout);
		if (getNotification().getRelatedModelElements().size() > 1) {
			DashboardToolbarAction toogleDrawer = new DashboardToolbarAction(toolbar, "details.png", 150);
			toogleDrawer.setToolTipText("Show details");
			toogleDrawer.addMouseListener(new ToggleDrawerAdapter());
		}
		if (comments != null) {
			DashboardToolbarAction toogleComments = new DashboardToolbarAction(toolbar, "comment.png", 110);
			toogleComments.setToolTipText("Show comments");
			Label toggleCommentsNumber = new Label(toolbar, SWT.WRAP);
			toggleCommentsNumber.setText(comments.length + "");
			toggleCommentsNumber.setForeground(new Color(getDisplay(), 123, 160, 199));
			ToggleCommentsAdapter toggleCommentsAdapter = new ToggleCommentsAdapter();
			toggleCommentsNumber.addMouseListener(toggleCommentsAdapter);
			toogleComments.addMouseListener(toggleCommentsAdapter);
		}

	}

	private void createCommentEntry(Composite parent, Comment comment) {

		if (comment.getCreator() != null) {
			Composite commentTitleBar = new Composite(parent, SWT.NONE);
			GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).margins(3, 3).applyTo(commentTitleBar);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(commentTitleBar);
			commentTitleBar.setBackground(new Color(getDisplay(), 246, 235, 197));

			Label commentAuthor = new Label(commentTitleBar, SWT.WRAP);
			commentAuthor.setText(comment.getCreator());
			GridDataFactory.fillDefaults().grab(true, false).applyTo(commentAuthor);

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			Label commentTime = new Label(commentTitleBar, SWT.WRAP);
			commentTime.setText(dateFormat.format(comment.getCreationDate()));

			Composite commentTitleBarBorder = new Composite(parent, SWT.NONE);
			GridDataFactory.fillDefaults().span(2, 1).hint(SWT.DEFAULT, 1).grab(true, false).applyTo(
				commentTitleBarBorder);
			commentTitleBarBorder.setBackground(new Color(getDisplay(), 189, 157, 95));
		}

		Composite commentEntry = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).spacing(3, 0).applyTo(commentEntry);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(commentEntry);
		commentEntry.setBackground(getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));

		Label userAvatar = new Label(commentEntry, SWT.WRAP);
		userAvatar.setImage(new Image(getDisplay(), DashboardImageUtil.getImage("homer.png").getImageData().scaledTo(
			30, 30)));
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(userAvatar);

		Label userComment = new Label(commentEntry, SWT.WRAP);
		userComment.setText(comment.getName());
		GridDataFactory.fillDefaults().grab(true, false).applyTo(userComment);

		ImageHyperlink replyButton = new ImageHyperlink(commentEntry, SWT.TOP);
		if (comment.eContainer() != null) {
			replyButton.setImage(DashboardImageUtil.getImage("comments.png"));
			replyButton.setToolTipText("Reply");
		}
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(replyButton);

		for (Comment c : comment.getReplies()) {
			Composite userReply = new Composite(commentEntry, SWT.NONE);
			GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(userReply);
			GridDataFactory.fillDefaults().indent(30, 0).span(3, 1).grab(true, false).applyTo(userReply);
			createCommentEntry(userReply, c);
		}
		for (Annotation annotation : comment.getAnnotations()) {
			if (RationalePackage.eINSTANCE.getComment().isInterface()) {
				Composite userReply = new Composite(commentEntry, SWT.NONE);
				GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(userReply);
				GridDataFactory.fillDefaults().indent(20, 0).span(3, 1).grab(true, false).applyTo(userReply);
				createCommentEntry(userReply, (Comment) annotation);
			}
		}
	}

	private void toggleDrawer(TypedEvent e, boolean open) {
		if (open) {
			createDrawer();

			final NotificationReadEvent readEvent = EventsFactory.eINSTANCE.createNotificationReadEvent();
			readEvent.setNotificationId(getNotification().getIdentifier());
			readEvent.setReadView(DashboardEditor.ID);
			readEvent.setSourceView(DashboardEditor.ID);
			readEvent.setTimestamp(new Date());
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					getProjectSpace().addEvent(readEvent);
				}
			});
		} else {
			drawerComposite.dispose();
		}
		getParent().layout();
	}

	private void toggleComments(TypedEvent e, boolean open) {
		if (open) {
			createComments();

			final NotificationReadEvent readEvent = EventsFactory.eINSTANCE.createNotificationReadEvent();
			readEvent.setNotificationId(getNotification().getIdentifier());
			readEvent.setReadView(DashboardEditor.ID);
			readEvent.setSourceView(DashboardEditor.ID);
			readEvent.setTimestamp(new Date());
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					getProjectSpace().addEvent(readEvent);
				}
			});
		} else {
			commentsComposite.dispose();
		}
		getParent().layout();
	}

	private void logEvent(ModelElementId modelElementId, String source) {
		final NotificationReadEvent readEvent = EventsFactory.eINSTANCE.createNotificationReadEvent();
		readEvent.setModelElement(modelElementId);
		readEvent.setNotificationId(getNotification().getIdentifier());
		readEvent.setReadView("org.unicase.ui.meeditor");
		readEvent.setSourceView(DashboardEditor.ID + "." + source);
		readEvent.setTimestamp(new Date());
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				getProjectSpace().addEvent(readEvent);
			}
		});
	}

	private void logEvent(ESNotification n, ProjectSpace projectSpace) {
		NotificationIgnoreEvent notificationIgnoreEvent = EventsFactory.eINSTANCE.createNotificationIgnoreEvent();
		notificationIgnoreEvent.setTimestamp(new Date());
		notificationIgnoreEvent.setNotificationId(n.getIdentifier());
		projectSpace.addEvent(notificationIgnoreEvent);
	}

	private Comment[] getComment() {
		if (getNotification().getSender() != null
			&& getNotification().getSender().equals("Pushed Notification Provider")) {
			String[] items = getNotification().getMessage().split("\\%\\%\\%");
			Comment tempComment = RationaleFactory.eINSTANCE.createComment();
			if (items.length == 2) {
				tempComment.setName(items[1]);
			} else {
				tempComment.setName("Log message: added new AIs for sprint 34");
			}
			return new Comment[] { tempComment };
		} else if (getNotification().getRelatedModelElements().size() == 1) {
			ArrayList<Comment> comments = new ArrayList<Comment>();
			for (ModelElementId modelElementId : getNotification().getRelatedModelElements()) {
				ModelElement modelElement = getProjectSpace().getProject().getModelElement(modelElementId);
				if (modelElement != null) {
					for (Annotation annotation : modelElement.getAnnotations()) {
						if (RationalePackage.eINSTANCE.getComment().isInstance(annotation)) {
							comments.add((Comment) annotation);
						}
					}
				}
			}
			if (comments.size() > 0) {
				return comments.toArray(new Comment[0]);
			}
		}
		return null;
	}

	private String getMessage() {
		String message = getNotification().getMessage();
		String[] items = message.split("\\%\\%\\%");
		if (items.length > 1) {
			return items[0];
		}
		return message;
	}
}
