package org.unicase.mergetest.merge;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.mergetest.merge.conflicts.Conflict;
import org.unicase.mergetest.merge.conflicts.ConflictOption;

public class DecisionBox extends Composite {

	private final Conflict conflict;
	private List<Button> optionButtons;

	public DecisionBox(Composite parent, Conflict conflict) {
		super(parent, SWT.BORDER);
		this.conflict = conflict;
		
		GridLayout decisionLayout = new GridLayout(4, false);
		this.setLayout(decisionLayout);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		Link link = new Link(this, SWT.LEFT);
		link.setText("ModelElement '"+conflict.getName()+"'\n"+conflict.getConflictDescription());
		link.setEnabled(true);
		
		Text optionDescription = new Text(this, SWT.NONE);
		optionDescription.setEditable(false);
		optionDescription.setText(conflict.getOptionDescription()
				+ " :");
		optionDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				true, true));
		
		
		// Add Option Buttons
		createOptions(conflict);
		
		//Additional Fields
		if(conflict.hasAdditionalInformation()) {
			addAdditionalInformationField();
		}
	}

	private void createOptions(Conflict conflict) {
		optionButtons = new ArrayList<Button>();
		int index = 0;
		for (ConflictOption option : conflict.getOptions()) {
			Button optionButton = new Button(this, SWT.NONE);
			optionButton.setText(option.getOptionLabel());
			final int optionIndex = index; 
			optionButton.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					DecisionBox.this.setSolution(optionIndex);
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					DecisionBox.this.setSolution(optionIndex);
				}
			});
			optionButtons.add(optionButton);
			index++;
		}
	}

	private void addAdditionalInformationField() {
		Section section = new Section(this, Section.TWISTIE);
		section.setText("Additional Information");
		section.setLayout(new GridLayout(1,false));
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
		layoutData.horizontalSpan=4;
		section.setLayoutData(layoutData);
		section.addExpansionListener(new IExpansionListener() {
			public void expansionStateChanged(ExpansionEvent e) {
				layoutPage();
			}
			public void expansionStateChanging(ExpansionEvent e) {
				layoutPage();
			}
		});
//		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Composite client = new Composite(section, SWT.NONE);
		client.setLayout(new GridLayout(1,true));
		client.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		new MultilineCompareWidget(client,conflict);
		
		section.setClient(client);
	}

	protected void setSolution(int optionIndex) {
		conflict.setSolution(conflict.getOptions().get(optionIndex));
		for(int i = 0; i < optionButtons.size(); i++) {
			Button button = optionButtons.get(i);
			if(i==optionIndex){
				button.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));
			} else {
				button.setBackground(null);
			}
		}
	}
	
	private void layoutPage() {
		getParent().getParent().getParent().layout();
	}
}
