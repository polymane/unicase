/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.model.ModelElement;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;
import org.unicase.ui.tableview.Activator;

/**
 * This label provider shows the status of a modelelement represented as an image.
 * 
 * @author helming
 */
public class StatusLabelProvider extends ColumnLabelProvider implements IColorProvider {

	private Map<String, Image> images;
	private static final String OPEN = "open";
	private static final String CLOSED = "closed";
	private static final String BLOCKED = "blocked";
	private static final String OPEN_RESOLVED = "open_resolved";

	/**
	 * Constructor.
	 */
	public StatusLabelProvider() {
		images = new HashMap<String, Image>();

		ImageDescriptor imageDescriptor = Activator.getImageDescriptor("icons/open.gif");
		images.put(OPEN, imageDescriptor.createImage());

		imageDescriptor = Activator.getImageDescriptor("icons/closed.gif");
		images.put(CLOSED, imageDescriptor.createImage());

		imageDescriptor = Activator.getImageDescriptor("icons/blocked.gif");
		images.put(BLOCKED, imageDescriptor.createImage());

		imageDescriptor = Activator.getImageDescriptor("icons/open_resolved.gif");
		images.put(OPEN_RESOLVED, imageDescriptor.createImage());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {

		images.get(OPEN).dispose();
		images.get(CLOSED).dispose();
		images.get(BLOCKED).dispose();
		images.get(OPEN_RESOLVED).dispose();

		images.clear();

		super.dispose();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			String status = MEState.CLOSED;
			try {
				status = me.getMEState().getStatus();
			} catch (CircularDependencyException e) {
				// JH Auto-generated catch block
				e.printStackTrace();
			}

			if (status.equals(MEState.OPEN)) {
				if (me instanceof WorkItem && ((WorkItem) me).isResolved()) {
					return images.get(OPEN_RESOLVED);
				}
				return images.get(OPEN);

			} else if (status.equals(MEState.CLOSED)) {
				return images.get(CLOSED);

			} else if (status.equals(MEState.BLOCKED)) {
				return images.get(BLOCKED);
			}

		}
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		return "";
	}

}
