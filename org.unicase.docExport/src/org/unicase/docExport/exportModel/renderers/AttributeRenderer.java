/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Attribute Renderer</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.AttributeRenderer#getAttributeOption <em>Attribute Option
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getAttributeRenderer()
 * @model abstract="true"
 * @generated
 */
public interface AttributeRenderer extends EObject {

	/**
	 * Returns the value of the '<em><b>Attribute Option</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Option</em>' containment reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attribute Option</em>' containment reference.
	 * @see #setAttributeOption(AttributeOption)
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getAttributeRenderer_AttributeOption()
	 * @model containment="true"
	 * @generated
	 */
	AttributeOption getAttributeOption();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.AttributeRenderer#getAttributeOption
	 * <em>Attribute Option</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Attribute Option</em>' containment reference.
	 * @see #getAttributeOption()
	 * @generated
	 */
	void setAttributeOption(AttributeOption value);

	// begin custom code
	void render(EStructuralFeature feature, ModelElement modelElement, UCompositeSection section, Template template);
	// end custom code
} // AttributeRenderer
