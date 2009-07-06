/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.views;

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.MEClassLabelProvider;

/**
 * @author abdelhamidbarzali this class extends ViewPart. this view shows the main information about a modelelement e.g.
 *         description, name , creator etc. the meta information of a selected modelelement in a unicase views is
 *         displayed here.
 */

public class Preview extends ViewPart implements ISelectionListener {

	private static String nocomment = " No Description available ! ";
	private static String orphansdescription = " Here are modelelements without container. ";

	private static String namelabelfont = "name";
	private static String creatorlabelfont = "creator+date";
	private static String descriptiontextfont = "description";

	private Text textwidget;
	private Font font;
	private Label namelabel;
	private Label creatorAndDatelabel;
	private Composite composite;
	private FontRegistry registry = new FontRegistry();
	private MEClassLabelProvider labelprovider;
	private Label iconlabel;

	/**
	 * . the Constructor.
	 */
	public Preview() {
		labelprovider = new MEClassLabelProvider();
	}

	/**
	 * @param parent the composite for all Preview widgets.
	 */
	@Override
	public void createPartControl(Composite parent) {

		// needed for "layout-reconstruction" if selection
		// is changed ( and by dispose() ).

		composite = parent;

		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		Display display = getSite().getShell().getDisplay();
		composite.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		registry.put(namelabelfont, new FontData[] { new FontData("Bold", 12, SWT.BOLD) });
		registry.put(creatorlabelfont, new FontData[] { new FontData("Courier New", 12, SWT.NORMAL) });
		registry.put(descriptiontextfont, new FontData[] { new FontData("Arial", 13, SWT.NORMAL) });
		iconlabel = new Label(composite, SWT.ICON);
		iconlabel.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		iconlabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		// Get standard image.
		Image initicon = labelprovider.getImage(null);
		iconlabel.setImage(initicon);

		namelabel = new Label(composite, SWT.WRAP | SWT.BORDER);
		namelabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		font = registry.get(namelabelfont);
		namelabel.setFont(font);
		namelabel.setText("  Titel ");
		namelabel.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

		// Creator + Date Lable .
		creatorAndDatelabel = new Label(composite, SWT.BORDER);
		creatorAndDatelabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

		creatorAndDatelabel.setFont(registry.get(creatorlabelfont));

		creatorAndDatelabel.setText("Creator/Creationdate");
		creatorAndDatelabel.setBackground(display.getSystemColor(SWT.COLOR_WHITE));

		// the Text widget for descriptions.
		textwidget = new Text(composite, SWT.WRAP | SWT.MULTI | SWT.BORDER);
		textwidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		textwidget.setFont(registry.get(descriptiontextfont));
		textwidget.setText(nocomment);
		textwidget.setEditable(false);
		getSite().getPage().addSelectionListener(this);
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void setFocus() {
		if (textwidget != null) {
			textwidget.setFocus();
		}
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public void dispose() {

		super.dispose();
		getSite().getPage().removeSelectionListener(this);
		if (namelabel != null) {
			namelabel.dispose();
		}
		if (creatorAndDatelabel != null) {
			creatorAndDatelabel.dispose();
		}
		if (textwidget != null) {
			textwidget.dispose();
		}
		if (composite != null) {
			composite.dispose();
		}

	}

	/**
	 * @param part is the part.
	 * @param selection is the selection.
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		if (selection.isEmpty()) {
			return;
		}
		IStructuredSelection selected = (IStructuredSelection) selection;
		Object object = selected.getFirstElement();
		if (object instanceof ModelElement) {
			ModelElement me = (ModelElement) object;
			setModelElement(me);

		} else {
			if (iconlabel != null) {
				Image icon = labelprovider.getImage(object);
				iconlabel.setImage(icon);
			}
			String labeltext = labelprovider.getText(object);
			if (namelabel != null) {
				namelabel.setText(labeltext);
			}
			if (creatorAndDatelabel != null) {
				creatorAndDatelabel.setText(" "); // Date ?!
			}
			if (textwidget != null) {
				if (labeltext == "Orphans") {
					textwidget.setText(orphansdescription);
				} else {
					textwidget.setText(nocomment);
				}
			}

		}
		// layout reconstituted.
		if (composite != null) {
			composite.layout();
		}

	}

	private void setModelElement(ModelElement me) {
		Image icon = labelprovider.getImage(me);
		if (iconlabel != null) {
			iconlabel.setImage(icon);
		}
		if (namelabel != null) {
			namelabel.setText(labelprovider.getText(me));
		}
		if (creatorAndDatelabel != null) {
			creatorAndDatelabel.setText(" " + me.getCreator() + " " + me.getCreationDate().toString());
		}
		if (textwidget != null) {
			String name = me.getDescriptionPlainText();
			if (name.equals(null)) {
				textwidget.setText(nocomment);
			}
			textwidget.setText(name);
		}
	}

}
