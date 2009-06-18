/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
//dengler: Document
/**
 * @author schroech
 */
public class DiagramElementAddRequest extends CreateElementRequest {

	private boolean addReferences;

	/**
	 * Default constructor.
	 * 
	 * @param container The container which should contain the new elements
	 * @param elementType The element types which should be added
	 */
	public DiagramElementAddRequest(EObject container, IElementType elementType) {
		super(container, elementType);
	}

	/**
	 * @param addReferences Flag indicating if connecting references between nodes should also be added
	 */
	public void setAddReferences(boolean addReferences) {
		this.addReferences = addReferences;
	}

	/**
	 * @return Flag indicating if connecting references between nodes should also be added
	 */
	public boolean getAddReferences() {
		return addReferences;
	}

}
