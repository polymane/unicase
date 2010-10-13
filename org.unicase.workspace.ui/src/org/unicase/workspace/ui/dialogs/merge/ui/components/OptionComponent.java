/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.ui.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictOption;
import org.unicase.workspace.ui.dialogs.merge.conflict.CustomConflictOption;
import org.unicase.workspace.ui.dialogs.merge.ui.DecisionBox;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionConfig;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

/**
 * This component of the decisionbox dynamically displays the possible options.
 * 
 * @author wesendon
 */
// TODO RAP
public class OptionComponent {

	private Group group;
	private final Conflict conflict;

	// private final DecisionBox parent;

	/**
	 * Default constructor.
	 * 
	 * @param parent parent
	 * @param conflict conflict.
	 */
	public OptionComponent(DecisionBox parent, Conflict conflict) {
		// this.parent = parent;
		this.conflict = conflict;
		group = new Group(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 1;
		layout.verticalSpacing = 1;
		group.setLayout(layout);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.verticalSpan = 2;
		group.setLayoutData(gridData);
		group.setText("Choose your Option: ");

		for (ConflictOption option : conflict.getOptions()) {
			new OptionContainer(conflict, option);
		}

		refreshButtonColor();
	}

	private String generatePrefix(ConflictOption option) {
		String result = "";
		switch (option.getType()) {
		case MyOperation:
			result = "Keep My Change: ";
			break;
		case TheirOperation:
			result = "Keep Their Change: ";
			break;
		case Custom:
			if (option instanceof CustomConflictOption) {
				String optionPrefix = ((CustomConflictOption) option).getOptionPrefix();
				if (optionPrefix != null) {
					result = optionPrefix;
				}
			}
			break;
		default:
			result = "";
			break;
		}
		return result;
	}

	private void addMouseListener(Composite composite, Listener listener) {
		composite.addListener(SWT.MouseDown, listener);
		composite.addListener(SWT.MouseUp, listener);
		for (Control child : composite.getChildren()) {
			child.addListener(SWT.MouseDown, listener);
			child.addListener(SWT.MouseUp, listener);
		}
	}

	/**
	 * Updates the color of the buttons.
	 */
	public void refreshButtonColor() {
		for (Control composite : group.getChildren()) {
			if (composite instanceof OptionContainer) {
				if (conflict.isResolved() && conflict.getSolution() == ((OptionContainer) composite).getOption()) {
					setColor((Composite) composite, DecisionConfig.getOptionSelectedBack(),
						DecisionConfig.getOptionSelectedFor());
				} else {
					setColor((Composite) composite, DecisionConfig.getDefaultColor(),
						DecisionConfig.getDefaultTextColor());
				}
			}
		}
	}

	private void setColor(Composite composite, Color background, Color foreground) {
		composite.setBackground(background);
		composite.setForeground(foreground);
		for (Control control : composite.getChildren()) {
			control.setBackground(background);
			control.setForeground(foreground);
		}
	}

	private void extraAction(OptionContainer composite) {
		if (composite.getOption().optionChosen()) {
			composite.setText();
			composite.layout();
		}
	}

	/**
	 * Graphical container for an option.
	 * 
	 * @author wesendon
	 */
	private final class OptionContainer extends Composite {

		private final ConflictOption option;

		private OptionContainer(Conflict conflict, ConflictOption option) {
			super(group, SWT.BORDER | SWT.INHERIT_FORCE);
			this.option = option;
			GridLayout layout = new GridLayout();
			layout.verticalSpacing = 1;
			setLayout(layout);
			setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			// label = new Label(this, SWT.NONE);
			// setText();

			setText();

			OptionMouseListener listener = new OptionMouseListener(this);
			OptionComponent.this.addMouseListener(this, listener);
		}

		private void setText() {
			String prefix = generatePrefix(option);

			String result = DecisionUtil.cutString(option.getStrippedOptionLabel(), DecisionConfig.OPTION_LENGTH, true);

			if (prefix != null || prefix != "") {
			}
		}

		public ConflictOption getOption() {
			return option;
		}
	}

	/**
	 * Option mouse listener.
	 * 
	 * @author wesendon
	 */
	private final class OptionMouseListener implements Listener {
		private final OptionContainer composite;

		public OptionMouseListener(OptionContainer composite) {
			this.composite = composite;
			composite.setCursor(new Cursor(composite.getDisplay(), SWT.CURSOR_HAND));
		}

		public void handleEvent(Event event) {
			switch (event.type) {

			case SWT.MouseUp:
				if (composite.getOption().hasExtraOptionAction()) {
					extraAction(composite);
				}
				if (conflict.isResolved() && conflict.getSolution() == composite.getOption()) {
					conflict.setSolution(null);
				} else {
					conflict.setSolution(composite.getOption());
				}
				refreshButtonColor();
				break;

			case SWT.MouseDown:
				break;
			default:
				break;
			}
		}
	}
}
