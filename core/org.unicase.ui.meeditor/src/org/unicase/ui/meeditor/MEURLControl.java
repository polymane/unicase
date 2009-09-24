/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.model.attachment.UrlAttachment;
import org.unicase.model.util.ModelElementChangeObserver;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.workspace.Configuration;

/**
 * GUI Control for URL hyperlinks.
 * 
 * @author helming
 * @author shterev
 * @author nagel
 */
public class MEURLControl extends AbstractMEControl {

	/**
	 * Recording command to edit a URL.
	 * 
	 * @author helming
	 * @author nagel
	 */
	private final class SetURLCommand extends RecordingCommand {
		private final String newURL;
		private final UrlAttachment urlAttachment;

		public SetURLCommand(TransactionalEditingDomain domain, String newURL, UrlAttachment urlAttachment) {
			super(domain);
			this.newURL = newURL;
			this.urlAttachment = urlAttachment;
		}

		@Override
		protected void doExecute() {
			urlAttachment.setUrl(newURL);
		}
	}

	private Composite linkComposite;
	private Hyperlink hyperlink;
	private ModelElementChangeObserver observer;

	public MEURLControl(FormToolkit toolkit, EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
	}

	public Control createControl(final Composite parent, int style) {
		linkComposite = getToolkit().createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(2, false));

		ArrayList<ModelElement> list = new ArrayList<ModelElement>();
		list.add((ModelElement) getModelElement());
		observer = new ModelElementChangeObserver() {

			@Override
			protected void onNotify(Notification notification, ModelElement element) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						if (!hyperlink.isDisposed()) {
							String url = ((UrlAttachment) getModelElement()).getUrl();
							if (url == null)
								url = "";
							hyperlink.setText(url);
							linkComposite.layout(true);
							parent.getParent().layout(true);
						}
					}
				});
			}

			@Override
			protected void onElementDeleted(ModelElement element) {
				// nothing to do
			}
		};
		((ModelElement) getModelElement()).getProject().addProjectChangeObserver(observer);
		observer.observeElement((ModelElement) getModelElement());

		String url = ((UrlAttachment) getModelElement()).getUrl();
		if (url == null)
			url = "";
		hyperlink = getToolkit().createHyperlink(linkComposite, url, style);
		hyperlink.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent event) {
				String url = ((UrlAttachment) getModelElement()).getUrl();
				if (url == null)
					return;
				Program.launch(url);
				super.linkActivated(event);
			}
		});

		final Action editURL = new Action("Edit URL", SWT.PUSH) {

			@Override
			public void run() {
				InputDialog input = new InputDialog(parent.getShell(), "Edit URL", "Please enter the URL",
					((UrlAttachment) getModelElement()).getUrl(), null);
				input.setBlockOnOpen(true);
				int result = input.open();
				if (result == InputDialog.OK) {
					TransactionalEditingDomain domain = Configuration.getEditingDomain();
					domain.getCommandStack().execute(
						new SetURLCommand(domain, input.getValue(), (UrlAttachment) getModelElement()));
				}
			}

		};
		Button button = new Button(linkComposite, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editURL.run();
			}

		});
		button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		button.setImage(Activator.getImageDescriptor("icons/link.png").createImage());

		return linkComposite;
	}

	/**
	 * Disposes the Composite of this {@link MEURLControl}.
	 */
	@Override
	public void dispose() {
		if (getModelElement() != null) {
			Project project = ((ModelElement) getModelElement()).getProject();
			if (project != null) {
				project.removeProjectChangeObserver(observer);
			}
		}
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}
}
