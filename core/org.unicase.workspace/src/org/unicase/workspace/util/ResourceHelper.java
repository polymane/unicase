/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.util;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.unicase.model.Project;

/**
 * Helper for resource operations.
 * 
 * @author wesendon
 */
public final class ResourceHelper {

	private ResourceHelper() {
		// blub
	}

	/**
	 * Gets an element from a resource.
	 * 
	 * @param <T> type of element
	 * @param absoluteFileName filepath of resource
	 * @param type .class from type
	 * @param index index of element in resource
	 * @return selected element
	 * @throws IOException in case of failure
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T getElementFromResource(String absoluteFileName, Class<T> type, int index)
		throws IOException {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(absoluteFileName), true);
		EList<EObject> directContents = resource.getContents();
		// sanity check

		if (directContents.size() != 1 && (!(directContents.get(0) instanceof Project))) {
			throw new IOException("File is corrupt, does not contain a Project.");
		}

		T object = (T) directContents.get(index);
		resource.getContents().remove(object);

		return object;
	}
}
