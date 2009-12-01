/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.metamodel.ModelElement;

/**
 * This is the standard Control to edit boolean values.
 * 
 * @author shterev
 */
public class MEEnumControl extends AbstractMEControl {

	private EAttribute attribute;

	private Combo combo;

	private static final int PRIORITY = 1;

	/**
	 * returns a check button without Label. {@inheritDoc}
	 * 
	 * @return Control
	 */
	@Override
	public Control createControl(Composite parent, int style) {
		combo = new Combo(parent, style | SWT.DROP_DOWN | SWT.READ_ONLY);
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EList<EEnumLiteral> list = ((EEnum) attribute.getEType()).getELiterals();
		for (EEnumLiteral literal : list) {
			combo.add(literal.getLiteral());
		}
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(combo), model, null, null);
		return combo;
	}

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (feature instanceof EAttribute
			&& (EEnum.class).isAssignableFrom(((EAttribute) feature).getEType().getClass())) {
			this.attribute = (EAttribute) feature;
			return PRIORITY;
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}
}
