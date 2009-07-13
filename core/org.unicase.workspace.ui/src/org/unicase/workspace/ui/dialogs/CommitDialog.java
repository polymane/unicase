/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.unicase.emfstore.esmodel.notification.ESNotification;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.views.changes.DetailedChangesComposite;
import org.unicase.workspace.ui.views.changes.PushedNotificationEditingSupport;
import org.unicase.workspace.ui.views.changes.TabbedChangesComposite;

/**
 * This class shows a ChangesTreeComposite and a Text control to enter commit message.
 * 
 * @author Hodaie
 * @author Shterev
 */
public class CommitDialog extends TitleAreaDialog implements KeyListener {

	private Text txtLogMsg;
	private String logMsg = "";
	private ChangePackage changes;
	private EList<String> oldLogMessages;
	private HashMap<AbstractOperation, ArrayList<ESNotification>> operationsMap;
	private CommitNotificationsTray notificationsTray;

	/**
	 * Constructor.
	 * 
	 * @param parentShell shell
	 * @param changes the {@link ChangePackage} to be displayed
	 */
	public CommitDialog(Shell parentShell, ChangePackage changes) {
		super(parentShell);
		this.setShellStyle(this.getShellStyle() | SWT.RESIZE);
		this.changes = changes;
		notificationsTray = new CommitNotificationsTray(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		oldLogMessages = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace()
			.getOldLogMessages();

		Composite contents = new Composite(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout(2, false));

		setTitle("Commit your changes");
		setMessage("Don't forget the commit message!");
		setTitleImage(Activator.getImageDescriptor("icons/dontForget.png").createImage());

		// Log message
		Label lblLogMsg = new Label(contents, SWT.NONE);
		lblLogMsg.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false, 2, 1));
		lblLogMsg.setText("Log message:");

		txtLogMsg = new Text(contents, SWT.MULTI | SWT.LEAD | SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1).align(SWT.FILL, SWT.TOP).hint(1, 150).applyTo(
			txtLogMsg);
		String logMsg = "";
		LogMessage logMessage = changes.getLogMessage();
		if (logMessage != null && logMessage.getMessage() != null) {
			logMsg = logMessage.getMessage();
		} else if (oldLogMessages != null && oldLogMessages.size() > 0) {
			logMsg = oldLogMessages.get(oldLogMessages.size() - 1);
		}
		txtLogMsg.setText(logMsg);
		txtLogMsg.selectAll();
		// to implement a shortcut for submitting the commit
		txtLogMsg.addKeyListener(this);

		// previous log messages
		Label oldLabel = new Label(contents, SWT.NONE);
		oldLabel.setText("Previous messages:");
		final Combo oldMsg = new Combo(contents, SWT.READ_ONLY);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.TOP).grab(true, false).applyTo(oldMsg);

		ArrayList<String> oldLogMessagesCopy = new ArrayList<String>();
		oldLogMessagesCopy.addAll(oldLogMessages);
		Collections.reverse(oldLogMessagesCopy);
		oldMsg.setItems(oldLogMessagesCopy.toArray(new String[0]));
		oldMsg.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}

			public void widgetSelected(SelectionEvent e) {
				txtLogMsg.setText(oldMsg.getItem(oldMsg.getSelectionIndex()));
			}

		});

		// ChangesTree
		ArrayList<ChangePackage> changePackages = new ArrayList<ChangePackage>();
		changePackages.add(changes);
		TabbedChangesComposite changesComposite = new TabbedChangesComposite(contents, SWT.BORDER, changePackages);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(2, 1).applyTo(changesComposite);

		// TODO AS: add proper handling to acquire a specific column
		final DetailedChangesComposite detailedTab = (DetailedChangesComposite) changesComposite.getTabs().get(1);

		operationsMap = new HashMap<AbstractOperation, ArrayList<ESNotification>>();
		for (AbstractOperation op : changes.getOperations()) {
			operationsMap.put(op, new ArrayList<ESNotification>());
		}

		TreeViewerColumn userColumn = new TreeViewerColumn(detailedTab.getTreeViewer(), SWT.NONE);
		userColumn.getColumn().setWidth(300);
		userColumn.getColumn().setText("Notify user");
		userColumn.getColumn().setWidth(getShell().getSize().x / 2);
		userColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				Object obj = cell.getElement();
				String text = "";
				Image image = null;
				if (obj instanceof AbstractOperation) {
					ArrayList<ESNotification> data = operationsMap.get(obj);
					StringBuilder ret = new StringBuilder();
					for (ESNotification n : data) {
						ret.append(n.getRecipient());
						ret.append("  ");
					}
					text = ret.toString();
					if (data.size() > 0) {
						image = Activator.getImageDescriptor("icons/user_comment.png").createImage();
					}
				}
				cell.setText(text);
				cell.setImage(image);
				cell.setBackground(super.getBackground(obj));
				cell.setForeground(super.getForeground(obj));
				cell.setFont(super.getFont(obj));
			}
		});

		userColumn.setEditingSupport(new PushedNotificationEditingSupport(detailedTab.getTreeViewer(), operationsMap));

		return contents;

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configureShell(Shell newShell) {

		super.configureShell(newShell);
		newShell.setText("Commit");
		Rectangle area = newShell.getShell().getParent().getClientArea();
		int width = area.width * 2 / 3;
		int height = area.height * 2 / 3;
		newShell.setBounds((area.width - width) / 2, (area.height - height) / 2, width, height);
		newShell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				notificationsTray.dispose();
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void okPressed() {
		logMsg = txtLogMsg.getText();

		// suppress duplicates
		if (!oldLogMessages.contains(logMsg)) {
			oldLogMessages.add(logMsg);
		}

		// remove older messages
		if (oldLogMessages.size() > 10) {
			// the list can only grow one element at a time,
			// so only one element should be deleted
			oldLogMessages.remove(0);
		}

		// add the newly created notifications to the change package
		for (ArrayList<ESNotification> list : operationsMap.values()) {
			changes.getNotifications().addAll(list);
		}

		super.okPressed();
	}

	/**
	 * @return the log message that has been set by the user.
	 */
	public String getLogText() {
		return logMsg.equals("") ? "<Empty log message>" : logMsg;
	}

	/**
	 * handles the pressing of Ctrl+ENTER: OKpressed() is called. {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.KeyListener#keyPressed(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		if (e.keyCode == SWT.CR && (e.stateMask & SWT.CTRL) != 0) {
			this.okPressed();
		}
	}

	/**
	 * does nothing. {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		// nothing to do
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// final String notifyUsers = "Notify users";
		// final Button notificationsButton = createButton(parent, 2138, notifyUsers + " >>", false);
		// notificationsButton.addSelectionListener(new SelectionAdapter() {
		// private boolean isOpen;
		//
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// if (!isOpen) {
		// openTray(notificationsTray);
		// notificationsButton.setText(notifyUsers + " <<");
		// Rectangle bounds = getShell().getBounds();
		// bounds.x -= 100;
		// getShell().setBounds(bounds);
		// } else {
		// closeTray();
		// notificationsButton.setText(notifyUsers + " >>");
		// Rectangle bounds = getShell().getBounds();
		// bounds.x += 100;
		// getShell().setBounds(bounds);
		// }
		// isOpen = !isOpen;
		// }
		// });
		super.createButtonsForButtonBar(parent);
	}

	/**
	 * @return the operations.
	 */
	public List<AbstractOperation> getOperations() {
		return changes.getOperations();
	}

}
