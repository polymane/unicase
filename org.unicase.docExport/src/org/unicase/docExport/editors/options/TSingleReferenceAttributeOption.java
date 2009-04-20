/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.options;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;

/**
 * @author Sebastian Hoecht
 */
public class TSingleReferenceAttributeOption extends Composite {

	/**
	 * @param parent SWT Composite parent
	 * @param option a SingleReferenceAttributeOption
	 * @param editor the editor for dirty checking
	 */
	public TSingleReferenceAttributeOption(Composite parent, final SingleReferenceAttributeOption option,
		TemplateEditor editor) {
		super(parent, SWT.NONE);

		GridLayout gLayout = new GridLayout();
		gLayout.numColumns = 2;
		setLayout(gLayout);
		GridData gData = new GridData(SWT.FILL, SWT.FILL, true, true);
		setLayoutData(gData);

		Button contained = new Button(this, SWT.CHECK);
		contained.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				option.setContained(((Button) e.widget).getSelection());
			}
		});
		contained.setSelection(option.isContained());
		new Label(this, SWT.LEFT).setText("contained");
	}

}
