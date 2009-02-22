/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.dashboard;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
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
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent;
import org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.edit.Activator;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.notification.provider.NotificationHelper;
import org.unicase.workspace.notification.provider.UpdateNotificationProvider;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A dashboard entry widget.
 * 
 * @author Shterev
 */
public class DashboardEntry extends Composite {

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
			System.out.println("");
		}

		public void widgetSelected(SelectionEvent e) {
			String text = e.text;
			if (text.equals("more")) {
				toggleDrawer(e, open);
				open = !open;
				return;
			}
			try {
				ModelElementUrl modelElementUrl = UrlFactory.eINSTANCE.createModelElementUrl(text);
				ModelElement modelElement = null;
				ModelElementUrlFragment modelElementUrlFragment = modelElementUrl.getModelElementUrlFragment();
				try {
					modelElement = project.resolve(modelElementUrlFragment);
				} catch (MEUrlResolutionException e1) {
				}
				ActionHelper.openModelElement(modelElement, DashboardEditor.ID);
				logEvent(modelElementUrlFragment.getModelElementId(), source);
			} catch (MalformedURLException ex) {
				WorkspaceUtil.logException("Invalid unicase URL pattern", ex);
			}
		}
	}

	private Image left;
	private Image right;
	private Image line;
	private Color lightBlue;
	private Color notificationColor;
	private ESNotification n;
	private SimpleDateFormat format;
	private Display display;
	private ProjectSpace project;
	private Composite drawer;

	private boolean open = true;
	private boolean mouseOver;
	private Color blue;
	private DashboardPage page;

	/**
	 * Default constuctor.
	 * 
	 * @param parent the parent composite.
	 * @param style the style.
	 * @param notification the notification.
	 * @param project the project.
	 * @param page a back link to the dashboard page (needed only for layout purposes).
	 */
	public DashboardEntry(DashboardPage page, Composite parent, int style, ESNotification notification,
		ProjectSpace project) {
		super(parent, style);

		this.page = page;
		n = notification;
		this.project = project;
		display = Display.getCurrent();

		left = Activator.getImageDescriptor("icons/left.png").createImage();
		right = Activator.getImageDescriptor("icons/right.png").createImage();
		line = Activator.getImageDescriptor("icons/line.png").createImage();
		lightBlue = new Color(display, 233, 244, 255);
		blue = new Color(Display.getCurrent(), 191, 222, 255);
		notificationColor = display.getSystemColor(SWT.COLOR_WHITE);
		format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

		this.setBackgroundMode(SWT.INHERIT_FORCE);
		if (!createUpdateEntry()) {
			createNotificationEntry();
		}
	}

	private void createNotificationEntry() {
		GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(false).extendedMargins(3, 0, 6, 6).spacing(5, 0)
			.applyTo(this);
		this.setBackground(notificationColor);

		AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		Image image = labelProvider.getImage(project.getProject().getModelElement(n.getRelatedModelElements().get(0)));
		Link link = createImageLink(image, this, n.getMessage());

		link.addSelectionListener(new LinkSelectionListener("link"));
		Label date = new Label(this, SWT.NONE);
		date.setText(format.format(n.getCreationDate()));
		GridDataFactory.fillDefaults().grab(true, false).align(SWT.END, SWT.BEGINNING).applyTo(date);
		date.setForeground(display.getSystemColor(SWT.COLOR_GRAY));

		final Composite close = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().hint(16, 16).applyTo(close);
		final Image closeImage = Activator.getImageDescriptor("icons/close.png").createImage();
		close.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				if (mouseOver) {
					Rectangle area = close.getClientArea();
					e.gc.drawImage(closeImage, area.x, area.y);
				}
			}
		});
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				boolean hide = MessageDialog.openConfirm(getShell(), "Hide notification",
					"Are you sure you are not interested in this kind of notification?");
				if (hide) {
					TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
					domain.getCommandStack().execute(new RecordingCommand(domain) {

						@Override
						protected void doExecute() {
							n.setSeen(true);
							logEvent(n, project);
							((DashboardEditor) page.getEditor()).refresh();
						}
					});
				}
			}
		});

		MouseTrackAdapter hoverListener = new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				mouseOver = true;
				setBackground(lightBlue);
			}

			@Override
			public void mouseExit(MouseEvent e) {
				mouseOver = false;
				setBackground(notificationColor);
			}
		};

		MouseListener clickListener = new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				toggleDrawer(e, open);
				open = !open;
			}
		};

		this.addMouseListener(clickListener);
		date.addMouseListener(clickListener);

		this.addMouseTrackListener(hoverListener);
		link.addMouseTrackListener(hoverListener);
		date.addMouseTrackListener(hoverListener);
		close.addMouseTrackListener(hoverListener);

		drawer = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().hint(10, 0).span(3, 1).grab(true, false).applyTo(drawer);
		GridLayoutFactory.fillDefaults().numColumns(1).spacing(0, 5).extendedMargins(3, 3, 3, 3).applyTo(drawer);
		drawer.setBackground(lightBlue);
		for (ModelElementId mid : n.getRelatedModelElements()) {
			ModelElement me = project.getProject().getModelElement(mid);
			Composite drawerEntry = new Composite(drawer, SWT.NONE);
			GridDataFactory.fillDefaults().grab(true, false).applyTo(drawerEntry);
			GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false).spacing(5, 0).applyTo(drawerEntry);

			String hyperlink = NotificationHelper.getHTMLLinkForModelElement(mid, project);
			Link meLink = createImageLink(labelProvider.getImage(me), drawerEntry, hyperlink);
			meLink.addSelectionListener(new LinkSelectionListener("drawer"));
			meLink.addMouseTrackListener(hoverListener);
			drawerEntry.addMouseTrackListener(hoverListener);
		}
		drawer.addMouseTrackListener(hoverListener);
	}

	private boolean createUpdateEntry() {
		if (n.getSender() == null || (n.getSender() != null && !n.getSender().equals(UpdateNotificationProvider.NAME))) {
			return false;
		}
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(this);
		GridLayoutFactory.fillDefaults().numColumns(5).equalWidth(false).extendedMargins(0, 0, 6, 6).spacing(0, 0)
			.applyTo(this);

		Composite updated = createRoundedLabel(this, n.getMessage());
		GridDataFactory.fillDefaults().applyTo(updated);

		Composite space = new Composite(this, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).hint(10, 15).applyTo(space);
		space.setBackgroundImage(line);

		Composite date = createRoundedLabel(this, format.format(n.getCreationDate()));
		GridDataFactory.fillDefaults().applyTo(date);

		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(date);

		return true;
	}

	private Composite createRoundedLabel(Composite parent, String text) {

		Composite c = new Composite(parent, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).spacing(0, 0).applyTo(c);

		Composite left = new Composite(c, SWT.NONE);
		left.setBackgroundImage(this.left);
		GridDataFactory.fillDefaults().hint(10, 15).applyTo(left);

		Composite main = new Composite(c, SWT.NONE);
		GridDataFactory.fillDefaults().applyTo(main);
		GridLayoutFactory.fillDefaults().numColumns(1).applyTo(main);
		main.setBackground(blue);
		Label label = new Label(main, SWT.NONE);
		label.setText(text);

		Composite right = new Composite(c, SWT.NONE);
		right.setBackgroundImage(this.right);
		GridDataFactory.fillDefaults().hint(10, 15).applyTo(right);

		return c;
	}

	private void toggleDrawer(TypedEvent e, boolean open) {
		int size = n.getRelatedModelElements().size();
		if (size <= 1) {
			return;
		}
		int height;
		int indent;
		if (open) {
			height = size * 20 + 6;
			indent = 10;
			final NotificationReadEvent readEvent = EventsFactory.eINSTANCE.createNotificationReadEvent();
			readEvent.setNotificationId(n.getIdentifier());
			readEvent.setReadView(DashboardEditor.ID);
			readEvent.setSourceView(DashboardEditor.ID);
			readEvent.setTimestamp(new Date());
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					project.addEvent(readEvent);
				}
			});
		} else {
			indent = 0;
			height = 0;
		}
		GridDataFactory.fillDefaults().hint(10, height).span(3, 1).indent(20, indent).grab(true, false).applyTo(drawer);
		getParent().layout();
		page.getForm().reflow(true);
	}

	private void logEvent(ModelElementId modelElementId, String source) {
		final NotificationReadEvent readEvent = EventsFactory.eINSTANCE.createNotificationReadEvent();
		readEvent.setModelElement(modelElementId);
		readEvent.setNotificationId(n.getIdentifier());
		readEvent.setReadView("org.unicase.ui.meeditor");
		readEvent.setSourceView(DashboardEditor.ID + "." + source);
		readEvent.setTimestamp(new Date());
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				project.addEvent(readEvent);
			}
		});
	}

	private Link createImageLink(final Image image, Composite parent, String text) {
		final Composite imageComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().hint(16, 16).applyTo(imageComposite);
		imageComposite.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				Rectangle area = imageComposite.getClientArea();
				e.gc.drawImage(image, area.x, area.y);
			}
		});

		Link link = new Link(parent, SWT.WRAP);
		link.setText(text);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.BEGINNING).applyTo(link);
		return link;
	}

	private void logEvent(ESNotification n, ProjectSpace projectSpace) {
		NotificationIgnoreEvent notificationIgnoreEvent = EventsFactory.eINSTANCE.createNotificationIgnoreEvent();
		notificationIgnoreEvent.setTimestamp(new Date());
		notificationIgnoreEvent.setNotificationId(n.getIdentifier());
		projectSpace.addEvent(notificationIgnoreEvent);
	}

}
