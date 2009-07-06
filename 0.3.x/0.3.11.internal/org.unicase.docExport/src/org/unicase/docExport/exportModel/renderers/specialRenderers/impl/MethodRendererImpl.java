/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.impl.AttributeRendererImpl;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.model.ModelElement;
import org.unicase.model.classes.Method;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Method Renderer</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class MethodRendererImpl extends AttributeRendererImpl implements MethodRenderer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodRendererImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SpecialRenderersPackage.Literals.METHOD_RENDERER;
	}

	@SuppressWarnings("unchecked")
	public void render(EStructuralFeature feature, ModelElement modelElement, UCompositeSection parent,
		Template template) {

		EList<Method> methods = (EList<Method>) modelElement.eGet(feature);

		UTable table = new UTable(1);
		table.getBoxModel().setMarginTop(10);
		table.getDefaultCellBoxModel().setBorderBottom(0.5);
		table.getDefaultCellBoxModel().setBorderStyle(UBorderStyle.DOTTED);
		for (Method method : methods) {
			table.addCell(method.getLabel(), template.getLayoutOptions().getDefaultTextOption());
		}

		parent.add(table);
	}

} // MethodRendererImpl
