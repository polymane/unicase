package org.unicase.workspace.ui.dialogs.merge.ui.components;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.unicase.workspace.ui.dialogs.merge.conflict.Conflict;
import org.unicase.workspace.ui.dialogs.merge.conflict.ConflictContext;
import org.unicase.workspace.ui.dialogs.merge.ui.DecisionBox;
import org.unicase.workspace.ui.dialogs.merge.util.DecisionUtil;

public class ContextComponent extends Composite {

	public ContextComponent(DecisionBox parent, Conflict conflict) {
		super(parent, SWT.NONE);

		ConflictContext context = conflict.getConflictContext();

		GridLayout layout = new GridLayout(3, false);
		layout.verticalSpacing = 1;
		layout.horizontalSpacing = 20;
		this.setLayout(layout);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		setBackground(parent.getBackground());

		FontRegistry fontRegistry = DecisionUtil.getFontRegistry();

		Label meTitle = new Label(this, SWT.NONE);
		meTitle.setText(context.getModelElementTitleLabel());
		meTitle.setFont(fontRegistry.get("titleLabel"));
		meTitle.setBackground(getBackground());

		Label attTitle = new Label(this, SWT.NONE);
		attTitle.setText(context.getAttributeTitleLabel());
		attTitle.setFont(fontRegistry.get("titleLabel"));
		attTitle.setBackground(getBackground());

		Label oppTitle = new Label(this, SWT.NONE);
		oppTitle.setText(context.getOpponentTitleLabel());
		oppTitle.setFont(fontRegistry.get("titleLabel"));
		oppTitle.setBackground(getBackground());

		AdapterFactoryLabelProvider provider = DecisionUtil.getLabelProvider();

		CLabel meLabel = new CLabel(this, SWT.NONE);
		meLabel.setImage(provider.getImage(context.getModelElement()));
		meLabel.setText(DecisionUtil.cutString(provider.getText(context
				.getModelElement()), 40, true));
		meLabel.setToolTipText(context.getModelElementTitleLabel() + ": "
				+ provider.getText(context.getModelElement()));
		meLabel.setFont(fontRegistry.get("content"));
		meLabel.setBackground(getBackground());

		Label attLabel = new Label(this, SWT.NONE);
		attLabel.setText(context.getAttribute());
		attLabel.setFont(fontRegistry.get("content"));
		attLabel.setBackground(getBackground());

		Label oppLable = new Label(this, SWT.NONE);
		oppLable.setText(context.getOpponent());
		oppLable.setFont(fontRegistry.get("content"));
		oppLable.setBackground(getBackground());
	}

}
