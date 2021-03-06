/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review.controlbuilder;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;

/**
 * This is the control to edit boolean value of the reviewed field.
 * @author kterzieva
 * 
 */

public class ReviewedDisplayControlBuilder extends AbstractControlBuilder {

	private static final int PRIORITY = 1;
	private Button check;

	/**
	 * Gives the render value of this control.
	 * 
	 * @param itemPropertyDescriptor the item descriptor
	 * @param urmlElement the urml element
	 * @return int the value
	 */
	
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
			UrmlModelElement urmlElement) 
	 {
		 Object feature = itemPropertyDescriptor.getFeature(urmlElement);
			if (feature instanceof EStructuralFeature && ((EStructuralFeature) feature).equals(UrmlPackage.eINSTANCE.getUrmlModelElement_Reviewed())) {

				return PRIORITY;
			}
			return AbstractControlBuilder.DO_NOT_RENDER;
	 
	}


	/**
	 * Creates the widget for reviewed fields.
	 * 
	 * @param parent the parent composite
	 * @param urmlElement the urml element
	 * @return check the check button
	 */
	
	protected Control doCreateControl(Composite parent,
			UrmlModelElement urmlElement) {
		Object feature = getItemPropertyDescriptor().getFeature(getModelElement());
		EStructuralFeature attribute = (EStructuralFeature) feature;
		check = new Button(parent, SWT.CHECK);
		if(!attribute.getName().equals("reviewed")){
			check.setEnabled(false);
		}
		
		IObservableValue model = EMFEditObservables.observeValue(getContext().getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(check), model, null, null);
		return check;

	}

}
