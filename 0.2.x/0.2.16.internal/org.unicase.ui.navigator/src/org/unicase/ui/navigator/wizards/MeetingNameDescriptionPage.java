package org.unicase.ui.navigator.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author naughton
 *
 * Wizard page for entering the name and description of a meeting.
 *
 */
public class MeetingNameDescriptionPage extends WizardPage {

	private static final String PAGE_TITLE = "Meeting information";
	private static final String PAGE_DESCRIPTION = "Enter name and description";
	private Text nameText;
	private Text descriptionText;

	/**
	 * . Constructor
	 * 
	 * @param pageName
	 *            page name
	 */
	protected MeetingNameDescriptionPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);

	}

	/**
	 * . ({@inheritDoc})
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		
		GridLayout gridLayout = new GridLayout();
		composite.setLayout(gridLayout);
		
		Label nameLabel = new Label(composite, SWT.LEFT);
		nameLabel.setText("Name:");
		nameLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		nameText = new Text(composite, SWT.SINGLE);
		nameText.setText("DOLLI2 Meeting");
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		Label descriptionLabel = new Label(composite, SWT.LEFT);
		descriptionLabel.setText("Description:");
		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		
		descriptionText = new Text(composite, SWT.MULTI);
		descriptionText.setText("DOLLI2 weekly team meeting");
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		setControl(composite);
	}

	/**
	 * Returns the name of the Meeting to be generated.
	 * 
	 * @return The name of the meeting to be generated.
	 */
	public String getMeetingName() {
		return nameText.getText();
	}

	/**
	 * Returns the description of the Meeting to be generated.
	 * 
	 * @return The description of the meeting to be generated.
	 */
	public String getMeetingDescription() {
		return descriptionText.getText();
	}

	/**
	 * . ({@inheritDoc})
	 */
	@Override
	public IWizardPage getNextPage() {
		((FollowupMeetingWizard)getWizard()).setCanFinish(true);
		return super.getNextPage();
	}
	
	
}
