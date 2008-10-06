/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.common.decorators;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.unicase.model.ModelElement;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;

/**.
 * 
 * The decorator to show state of an element (blocked or open) shown in viewers
 * 
 * @author Helming
 * 
 */
public class StateDecorator implements ILightweightLabelDecorator {
	/**
	 * String constants for the various icon placement options from the template
	 * wizard.
	 */
	public static final String TOP_RIGHT = "TOP_RIGHT";
	/**
	 * String constants for the various icon placement options from the template
	 * wizard.
	 */
	public static final String TOP_LEFT = "TOP_LEFT";
	/**
	 * String constants for the various icon placement options from the template
	 * wizard.
	 */
	public static final String BOTTOM_RIGHT = "BOTTOM_RIGHT";
	/**
	 * String constants for the various icon placement options from the template
	 * wizard.
	 */
	public static final String BOTTOM_LEFT = "BOTTOM_LEFT";
	/**
	 * String constants for the various icon placement options from the template
	 * wizard.
	 */
	public static final String UNDERLAY = "UNDERLAY";

	/**.
	 * The integer value representing the placement options 
	 */
	private int quadrant;

	/**. 
	 * The icon image location in the project folder 
	 */
	private String openPath = "icons/open.gif"; // NON-NLS-1

	/** .
	 * The icon image location in the project folder 
	 */
	private String blockedPath = "icons/blocked.gif"; // NON-NLS-1

	/**.
	 * The image description used in
	 * <code>addOverlay(ImageDescriptor, int)</code>
	 */
	private ImageDescriptor descriptor;

	/**.
	 * {@inheritDoc}
	 * @see
	 * org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang
	 * .Object, org.eclipse.jface.viewers.IDecoration)
	 * @param element element
	 * @param decoration decoration
	 */	
	public void decorate(Object element, IDecoration decoration) {
		/**
		 * Checks that the element is an IResource with the 'Read-only'
		 * attribute and adds the decorator based on the specified image
		 * description and the integer representation of the placement option.
		 */
		URL url = null;

		ModelElement me;
		if (element instanceof ModelElement) {
			me = (ModelElement) element;
		} else {
			return;
		}
		try {
			if (me.getMEState().getStatus().equals(MEState.OPEN)) {
				url = FileLocator.find(Platform
						.getBundle("org.unicase.ui.common"),
						new Path(openPath), null);

			}
			if (me.getMEState().getStatus().equals(MEState.BLOCKED)) {
				url =FileLocator.find(Platform
						.getBundle("org.unicase.ui.common"), new Path(
						blockedPath), null);
			}
		} catch (CircularDependencyException e) {
			//JH : add questionmark image
			//Dont show exception dialog, cause it is intrusives
			return;
		}

		if (url == null){
			return;
		}

		descriptor = ImageDescriptor.createFromURL(url);
		quadrant = IDecoration.TOP_RIGHT;
		decoration.addOverlay(descriptor, quadrant);
	}

	/**.
	 * {@inheritDoc}
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.
	 * jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**.
	 * {@inheritDoc}
	 *  @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
	}

	/**.
	 * {@inheritDoc}
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang
	 * .Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**.
	 * {@inheritDoc}
	 * @see
	 * org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse
	 * .jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
	}
}