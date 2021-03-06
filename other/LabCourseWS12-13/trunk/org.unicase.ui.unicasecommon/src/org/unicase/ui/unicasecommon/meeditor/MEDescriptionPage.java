/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.editor.AbstractMEEditorPage;
import org.eclipse.emf.ecp.editor.MEEditor;
import org.eclipse.emf.ecp.editor.mecontrols.MERichTextControl;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.unicase.ui.unicasecommon.common.util.UnicaseActionHelper;

/**
 * The editor page for the description feature.
 * 
 * @author shterev
 */
public class MEDescriptionPage extends AbstractMEEditorPage {

	/**
	 * Nested class to extend the from page.
	 * 
	 * @author koegel
	 */
	private final class FormPageExtension extends FormPage {
		private FormPageExtension(FormEditor editor, String id, String title) {
			super(editor, id, title);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void createFormContent(IManagedForm managedForm) {
			super.createFormContent(managedForm);

			toolkit = this.getEditor().getToolkit();
			form = managedForm.getForm();
			toolkit.decorateFormHeading(form.getForm());
			GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(form.getBody());
			form.setText(getEditor().getTitle() + ": Description");
			createWidget();
			form.pack();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void dispose() {
			if (textControl != null) {
				textControl.dispose();
			}
			super.dispose();
		}

		/**
		 * {@inheritDoc} This method is added to solve the focus bug of navigator. Every time that a ME is opened in
		 * editor, navigator has to lose focus so that its action contributions are set correctly for next time.
		 */
		@Override
		public void setFocus() {
			textWidget.setFocus();
		}
	}

	private static final String ID = "org.unicase.ui.unicasecommon.meeditor.descriptionpage";
	private static final String NAME = "Description";

	private EObject modelElement;
	private FormToolkit toolkit;

	private ScrolledForm form;
	private Composite body;
	private MERichTextControl textControl;
	private Control textWidget;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FormPage createPage(MEEditor editor, EditingDomain editingDomain, EObject modelElement) {
		this.modelElement = modelElement;
		FormPage page = new FormPageExtension(editor, ID, NAME);
		return page;

	}

	/**
	 * Constructor to replace the textcontrol.
	 * 
	 * @param control the control
	 */
	protected MEDescriptionPage(MERichTextControl control) {
		textControl = control;
	}

	/**
	 * Standard constructor.
	 */
	public MEDescriptionPage() {
		textControl = null;
	}

	private void createWidget() {
		if (body != null) {
			body.dispose();
		}
		body = new Composite(form.getBody(), SWT.NONE);
		GridLayoutFactory.fillDefaults().spacing(0, 0).applyTo(body);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(body);

		if (textControl == null) {
			textControl = new MERichTextControl();
		}
		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IItemPropertyDescriptor propertyDescriptor = adapterFactoryItemDelegator.getPropertyDescriptor(modelElement,
			"description");
		textWidget = textControl.createControl(body, SWT.NONE, propertyDescriptor, modelElement,
			UnicaseActionHelper.getContext(modelElement), toolkit);
		GridDataFactory.fillDefaults().hint(200, -1).grab(true, true).applyTo(textWidget);
	}
}
