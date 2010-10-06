/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElement;

/**
 * Wraps the given {@link ModelElement}. <br>
 * For example implementations of this interface can be used to wrap imported modelElements before adding them to the
 * project.
 */
public interface IModelElementWrapperFactory {

	/**
	 * Returns true, if this handler should be used to wrap the toWrap for the given container.<br>
	 * The container can be <code>null</code>, if the toWrap should not be wrapped for any container.
	 * 
	 * @param container the container for which the toWrap should be wrapped or <code>null</code>.
	 * @param toWrap the {@link ModelElement} which should be wrapped.
	 * @return true if the object can be wrapped
	 */
	boolean isFor(EObject container, ModelElement toWrap);

	/**
	 * Wraps the given {@link ModelElement}.
	 * 
	 * @param toWrap the {@link ModelElement} which should be wrapped.
	 * @return the wrapper of the toWrap.
	 */
	ModelElement wrap(ModelElement toWrap);

	/**
	 * Wraps the given {@link ModelElement}.
	 * 
	 * @param toWrap the {@link ModelElement} which should be wrapped.
	 * @param uri the {@link URI} of the resource to import.
	 * @param resourceIndex - the index of the element inside the eResource.
	 * @return the wrapper of the toWrap.
	 */
	ModelElement wrapForImport(ModelElement toWrap, URI uri, int resourceIndex);
}
