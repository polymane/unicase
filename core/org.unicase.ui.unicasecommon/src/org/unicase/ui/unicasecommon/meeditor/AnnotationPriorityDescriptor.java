/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.UnicaseModelElement;

/**
 * A {@link IAttributeDescriptor} using the annotation in the genmodel.
 * 
 * @author Shterev
 */
public class AnnotationPriorityDescriptor implements IAttributeDescriptor<Double> {

	private double defaultValue = 100.0;

	/**
	 * {@inheritDoc}
	 */
	public Double getValue(IItemPropertyDescriptor propertyDescriptor, UnicaseModelElement modelElement) {
		EAnnotation priority = ((EStructuralFeature) propertyDescriptor.getFeature(modelElement))
			.getEAnnotation("org.unicase.ui.meeditor");
		if (priority == null || priority.getDetails() == null) {
			return defaultValue;
		}
		String s = priority.getDetails().get("priority");
		return Double.parseDouble(s);
	}

}
