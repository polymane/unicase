/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.builders.attributeRenderers;

import java.util.ArrayList;

import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersFactory;

/**
 * Creates a List of available AttributeRenderers for the Unicase model feature step.
 * 
 * @author Sebastian Hoecht
 */
public class MethodRendererBuilder extends AttributeRendererBuilder {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.docExport.exportModel.builders.attributeRenderers.AttributeRendererBuilder#buildRenderers(org.unicase.docExport.exportModel.Template)
	 */
	@Override
	public ArrayList<AttributeRenderer> buildRenderers(Template template) {
		ArrayList<AttributeRenderer> renderers = super.buildRenderers(template);

		renderers.add(SpecialRenderersFactory.eINSTANCE.createMethodRenderer());

		return renderers;
	}

}
