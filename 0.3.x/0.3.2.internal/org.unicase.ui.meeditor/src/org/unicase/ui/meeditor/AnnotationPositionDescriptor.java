/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.ModelElement;

/**
 * A {@link IAttributeDescriptor} using the annotation in the genmodel.
 * 
 * @author Shterev
 * 
 */
public class AnnotationPositionDescriptor implements
		IAttributeDescriptor<String> {

	private String defaultValue = "left";

	/**
	 * {@inheritDoc}
	 */
	public String getValue(IItemPropertyDescriptor propertyDescriptor,
			ModelElement modelElement) {
		EAnnotation priority = ((EStructuralFeature) propertyDescriptor
				.getFeature(modelElement))
				.getEAnnotation("org.unicase.ui.meeditor");
		if (priority == null || priority.getDetails() == null) {
			return defaultValue;
		}
		String s = priority.getDetails().get("position");
		return s;
	}

}
