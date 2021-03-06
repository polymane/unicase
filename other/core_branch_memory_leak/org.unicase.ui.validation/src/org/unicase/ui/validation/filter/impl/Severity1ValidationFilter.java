/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.filter.impl;

import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.validation.Activator;
import org.unicase.ui.validation.filter.ValidationFilter;

/**
 * The severity filter.
 * 
 * @author pfeifferc
 */
public class Severity1ValidationFilter extends ValidationFilter {

	/**
	 * default constructor.
	 */
	public Severity1ValidationFilter() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "The severity validation filter";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getImageDescriptor("icons/flag_blue.png").createImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		IConstraintStatus constraintStatus = (IConstraintStatus) element;
		if (constraintStatus.getSeverity() == 1) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean init() {
		return true;
	}
}
