/**
 * 
 */
package traceRecovery.ui;

import java.io.File;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * @author taher
 * 
 */
public class SelectDirectory implements Listener, IViewActionDelegate {

	Button directory;
	Button setDirectory;
	Text directoryString;
	Label selectDirectory;
	Shell shell;
	Display display;
	Button ok;
	Button java;
	Button fortran;

	public void run() {
		display = Display.getCurrent();
		init("");

	}

	public void init(String path) {
		Monitor primary = display.getPrimaryMonitor();
		Rectangle bound = primary.getBounds();
		Shell s = display.getActiveShell();

		IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getPerspectiveRegistry();

		shell = new Shell(display);
		shell.setText("select a Project Directory");

		shell.setLayout(new GridLayout(4, false));

		Label chooseCodeType = new Label(shell, SWT.NONE);
		chooseCodeType.setText("Choose Language:");

		java = new Button(shell, SWT.RADIO);
		java.setText("Java");

		fortran = new Button(shell, SWT.RADIO);
		fortran.setText("Fortran");

		directoryString = new Text(shell, SWT.BORDER);
		directoryString.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				false, 3, 1));

		directory = new Button(shell, SWT.NONE);
		directory.addListener(SWT.Selection, this);
		directory.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false,
				0, 1));
		directory.setText("Browse...");

		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		// new Label(shell, SWT.NONE);

		setDirectory = new Button(shell, SWT.NONE);
		GridData gd_btnNext = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_btnNext.widthHint = 63;
		setDirectory.setLayoutData(gd_btnNext);
		setDirectory.addListener(SWT.Selection, this);
		setDirectory.setText("Next");

		shell.setBounds(300, 200, (bound.width - 300) / 2,
				(bound.height - 200) / 2);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	// public static void main(String[] args) {
	//
	// }

	private String lastPath;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */

	Shell sh;

	public void handleEvent(Event event) {
		if (event.widget == directory) {

			DirectoryDialog dir = new DirectoryDialog(shell);
			String path = dir.open();
			// directoryString = new StyledText(shell, SWT.NONE);
			directoryString.setText(path);
			// directoryString.setSize(500, 100);
			// DirectoryDialog dialog = new DirectoryDialog(shell);

		} else if (event.widget == setDirectory) {

			System.out.println("the next button was clicked");

			File file = new File(directoryString.getText());
			lastPath = directoryString.getText();
			if (!file.exists()) {

				MessageDialog.open(SWT.ERROR, shell, "wrong path",
						"You entered a wrong path please enter a correct path",
						SWT.None);
				// sh = new Shell(display);
				// sh.setLayout(new GridLayout());
				// Label text = new Label(sh, SWT.None);
				// text.setText("the entered path is not correct plz enter another path");
				// ok = new Button(sh, SWT.PUSH);
				// ok.setText("OK");
				// ok.addListener(SWT.Selection, this);

				// shell.dispose();
				//
				// sh.open();

				// while (!sh.isDisposed()) {
				// if (!display.readAndDispatch())
				// display.sleep();
				// }
				// display.dispose();
			} else {

				System.out
						.println("this will start the check from the java and fortran is choosen");
				if (!(java.getSelection() || fortran.getSelection())) {
					MessageDialog.open(SWT.ERROR, shell,
							"Programing Language not choosen",
							"You must choose a programing language", SWT.None);

				} else {

					String language = "";
					if (java.getSelection()) {
						language = "java";
					} else {
						language = "fortran";
					}

					

					shell.dispose();
					
					new RunRecovery().run(lastPath, language);
				}
			}
		}

		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		SelectDirectory dir = new SelectDirectory();
		dir.run();
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
	 * .IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {

		// TODO Auto-generated method stub

	}

}