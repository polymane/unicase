/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;

/**
 * Abstract class for the ME controls.
 * 
 * @author helming
 */
public abstract class AbstractMEControl {

	/**
	 * The default constant in case the widgets decides it shouldn't render the attribute.
	 */
	public static final int DO_NOT_RENDER = Integer.MIN_VALUE;

	/**
	 * gui toolkit used for rendering.
	 */
	private FormToolkit toolkit;
	/**
	 * the modelElement.
	 */
	private EObject modelElement;
	/**
	 * the editingDomain.
	 */
	private EditingDomain editingDomain;

	/**
	 * @return the toolkit
	 */
	public FormToolkit getToolkit() {
		return toolkit;
	}

	/**
	 * @param toolkit the toolkit to set
	 */
	public void setToolkit(FormToolkit toolkit) {
		this.toolkit = toolkit;
	}

	/**
	 * @return the modelElement
	 */
	public EObject getModelElement() {
		return modelElement;
	}

	/**
	 * @param modelElement the modelElement to set
	 */
	public void setModelElement(EObject modelElement) {
		this.modelElement = modelElement;
	}

	/**
	 * @return the editingDomain
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @param editingDomain the editingDomain to set
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * Default constructor.
	 */
	public AbstractMEControl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public int init(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement,
		EditingDomain editingDomain, FormToolkit toolkit) {
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
		return DO_NOT_RENDER;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {

	}

	/**
	 * Method for applying a custom layout data to widgets, as for {@link MERichTextControl}.
	 */
	public void applyCustomLayoutData() {
		// by default none. must me implemented by the subclass.
	}

	/**
	 * Creates the widget for this control.
	 * 
	 * @param attributeComposite the parent composite
	 * @param style the style
	 * @return the widget
	 */
	public abstract Control createControl(Composite attributeComposite, int style);

}
