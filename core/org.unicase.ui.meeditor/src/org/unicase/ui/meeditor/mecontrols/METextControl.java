/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;

/**
 * Standard widgets to edit a single line text attribute.
 * 
 * @author helming
 */
public class METextControl extends AbstractMEControl implements MEControl {

	private Text text;

	private EAttribute attribute;

	private IItemPropertyDescriptor itemPropertyDescriptor;

	private static final int PRIORITY = 1;

	/**
	 * Standard Constructor.
	 */
	public METextControl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int init(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement,
		EditingDomain editingDomain, FormToolkit toolkit) {
		super.init(itemPropertyDescriptor, modelElement, editingDomain, toolkit);

		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute && ((EAttribute) feature).getEType().getInstanceClass().equals(String.class)) {
			this.attribute = (EAttribute) feature;
			return PRIORITY;
		}
		return MEControl.DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return A Text Control. {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		text = getToolkit().createText(parent, new String(), style | SWT.SINGLE);
		if (!itemPropertyDescriptor.canSetProperty(getModelElement())) {
			text.setEditable(false);
		}
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(text, SWT.FocusOut), model, null, null);
		return text;
	}

	/**
	 * . This sets the keyboard focus in Text control.
	 */
	public void setFocus() {
		this.text.setFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void applyCustomLayoutData() {
		GridDataFactory.fillDefaults().grab(true, false).hint(250, 16).align(SWT.FILL, SWT.TOP).applyTo(text);
	}

}
