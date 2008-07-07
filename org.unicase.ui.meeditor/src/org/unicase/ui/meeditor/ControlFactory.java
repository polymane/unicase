/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import java.util.Date;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.ui.meeditor.mecontrols.MEBoolControl;
import org.unicase.ui.meeditor.mecontrols.MEControl;
import org.unicase.ui.meeditor.mecontrols.MEDateControl;
import org.unicase.ui.meeditor.mecontrols.MEIntControl;
import org.unicase.ui.meeditor.mecontrols.METextAreaControl;
import org.unicase.ui.meeditor.mecontrols.METextControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MEMultiLinkControl;
import org.unicase.ui.meeditor.mecontrols.melinkcontrol.MESingleLinkControl;

/**
 * Factory for generating {@link MEControl}'s according to a
 * {@link IItemPropertyDescriptor}.
 * 
 * @author shterev
 * 
 */
public class ControlFactory {
	private final EObject modelElement;
	private final EditingDomain editingDomain;
	private FormToolkit toolkit;

	/**
	 * Default constructor.
	 * 
	 * @param editingDomain
	 *            the editing domain
	 * @param modelElement
	 *            the model element
	 * @param toolkit
	 *            the gui toolkit
	 */
	public ControlFactory(EditingDomain editingDomain, EObject modelElement,
			FormToolkit toolkit) {
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
	}

	/**
	 * Creates a {@link MEControl} according to the
	 * {@link IItemPropertyDescriptor}.
	 * 
	 * @param itemPropertyDescriptor
	 *            the descriptor
	 * @return the {@link MEControl}
	 */
	public MEControl createControl(
			IItemPropertyDescriptor itemPropertyDescriptor) {

		EStructuralFeature feature = (EStructuralFeature) itemPropertyDescriptor
				.getFeature(modelElement);
		if (feature instanceof EAttribute) {

			if (itemPropertyDescriptor.isMultiLine(modelElement)) {
				//AS: deactivated until the RichText is implemented.
				//return createMETextAreaControl((EAttribute) feature);
			}
			if (feature.getEType().getInstanceClass().equals(boolean.class)) {
				return createMEBoolControl((EAttribute) feature);
			}
			if (feature.getEType().getInstanceClass().equals(int.class)) {
				return createMEIntControl((EAttribute) feature);
			}
			if (feature.getEType().getInstanceClass().equals(Date.class)) {
				return createMEDateControl((EAttribute) feature);
			}
			return createMETextControl((EAttribute) feature);
		}
		if (feature instanceof EReference && feature.getUpperBound() != 1) {
			EReference reference = (EReference) feature;
			if (reference.isMany()) {
				return createMELinkControl((EReference) feature,
						itemPropertyDescriptor);
			}
		}

		if (feature instanceof EReference && feature.getUpperBound() == 1) {
			EReference reference = (EReference) feature;
			return createMESingleLinkControl(reference);

		}

		return null;
		// TODO: Add other types
	}

	private MEControl createMESingleLinkControl(EReference reference) {
		return new MESingleLinkControl(editingDomain, modelElement, toolkit,
				reference);
	}

	private MEControl createMEDateControl(EAttribute attribute) {
		return new MEDateControl(attribute, toolkit, modelElement,
				editingDomain);
	}

	private MEControl createMEIntControl(EAttribute attribute) {
		return new MEIntControl(attribute, toolkit, modelElement, editingDomain);
	}

	private MEControl createMEBoolControl(EAttribute attribute) {
		return new MEBoolControl(attribute, toolkit, modelElement,
				editingDomain);

	}

	@SuppressWarnings("unused")
	private MEControl createMETextAreaControl(EAttribute attribute) {
		return new METextAreaControl(attribute, toolkit, modelElement,
				editingDomain);
	}

	private MEControl createMETextControl(EAttribute attribute) {
		return new METextControl(attribute, toolkit, modelElement,
				editingDomain);
	}

	private MEControl createMELinkControl(EReference reference,
			IItemPropertyDescriptor itemPropertyDescriptor) {
		return new MEMultiLinkControl(modelElement, reference, toolkit,
				editingDomain, itemPropertyDescriptor);
	}

}
