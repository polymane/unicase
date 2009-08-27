/**
 * 
 */
package org.unicase.analyzer.questionnaire.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.unicase.workspace.Configuration;

/**
 * @author liya
 */
public class LogMsgPage extends WizardPage implements Listener {

	private static final String DIR = Configuration.getWorkspaceDirectory();
	private static final String PAGE_TITLE = "Log Messages";
	private static final String PAGE_DESCRIPTION = "Choose the log message which matches the commit.";
	private final List<Button> buttons = new ArrayList<Button>();
	private final List<String> logMsgs = new ArrayList<String>();
	private final List<Boolean> correct = new ArrayList<Boolean>();

	protected LogMsgPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		init();

	}

	private void init() {
		File file = new File(DIR + QuestionnaireManager.getInstance().getUser() + File.separatorChar + "logMsgs-"
			+ QuestionnaireManager.getInstance().getVersion() + ".csv");
		BufferedReader bufRdr;
		try {
			bufRdr = new BufferedReader(new FileReader(file));

			String line = null;

			// read each line of text file
			while ((line = bufRdr.readLine()) != null) {
				logMsgs.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		file = new File(DIR + QuestionnaireManager.getInstance().getUser() + File.separatorChar + "choices-"
			+ QuestionnaireManager.getInstance().getVersion() + ".csv");
		try {
			bufRdr = new BufferedReader(new FileReader(file));

			String line = null;

			// read each line of text file
			while ((line = bufRdr.readLine()) != null) {
				correct.add(Boolean.valueOf(line));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {

		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		for (int i = 0; i < logMsgs.size(); i++) {
			Button button = new Button(composite, SWT.RADIO);
			button.setText(logMsgs.get(i));
			gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = ncol;
			button.setLayoutData(gd);

			button.addListener(SWT.Selection, this);
			buttons.add(button);
		}

		setControl(composite);
	}

	public void handleEvent(Event event) {
		boolean result = false;
		for (Button button : buttons) {
			if (button.getSelection()) {
				result = true;
			}
		}
		QuestionnaireManager.getInstance().setLogMsgResult(result);
		((EvaluationWizard) getWizard()).setCanFinish(true);
		getWizard().getContainer().updateButtons();

	}

}
