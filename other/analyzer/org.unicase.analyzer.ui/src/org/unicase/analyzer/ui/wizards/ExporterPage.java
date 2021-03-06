/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.analyzer.ui.wizards;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.exporters.ExportersPackage;
import org.unicase.analyzer.ui.commands.AnalysisCommand;

/**
 * @author liya
 */
public class ExporterPage extends WizardPage implements Listener {

	private static final String PAGE_TITLE = "Exporter";
	private static final String PAGE_DESCRIPTION = "Specify the file name for the analyzed result.";
	private Text exportPath;
	private final TransactionalEditingDomain editingDomain;
	private AnalyzerConfiguration conf;
	private Button selectFileLocation;
	private static final String TRANSACTIONAL_EDITINGDOMAIN_ID = "org.unicase.analysis.EditingDomain";

	/**
	 * @param pageName Name of the page
	 */
	protected ExporterPage(String pageName) {
		super(pageName);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESCRIPTION);
		editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(TRANSACTIONAL_EDITINGDOMAIN_ID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		GridData gd;
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
		int ncol = 4;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		new Label(composite, SWT.NONE).setText("File Name:");
		exportPath = new Text(composite, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		exportPath.setLayoutData(gd);

		selectFileLocation = new Button(composite, SWT.PUSH);
		selectFileLocation.setText("Browse");
		selectFileLocation.addSelectionListener(new FileLocationSelectionListener());
		exportPath.setFocus();
		exportPath.addListener(SWT.FocusOut, this);

		((ProjectAnalyzerWizard) getWizard()).setCanFinish(isPageComplete());
		// setPageComplete(false);
		setControl(composite);

	}

	/**
	 * Initializes the page, i.e. this method is not called at the time this class gets instantiated but later, when the
	 * page is going to get displayed. Mainly create the databinding here.
	 */
	public void init() {

		conf = ((ProjectAnalyzerWizard) getWizard()).getAnalyzerConfig();

		IObservableValue modelObservable = EMFEditObservables.observeValue(editingDomain, conf.getExporter(),
			ExportersPackage.eINSTANCE.getExporter_FileName());
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeText(exportPath, SWT.FocusOut), modelObservable, null, null);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
	 */
	public void handleEvent(Event event) {
		if (ProjectAnalyzerWizardHelper.isTextNonEmpty(exportPath)) {
			((ProjectAnalyzerWizard) getWizard()).setCanFinish(true);
		}
		setPageComplete(isPageComplete());

		getWizard().getContainer().updateButtons();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		if (ProjectAnalyzerWizardHelper.isTextNonEmpty(exportPath)) {
			return true;
		}
		return super.isPageComplete();
	}

	/**
	 * Listener for the file location selection.
	 */
	class FileLocationSelectionListener extends SelectionAdapter {
		/**
		 * {@inheritDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {

			new AnalysisCommand(editingDomain) {

				@Override
				protected void doRun() {
					FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						SWT.SAVE);
					dialog.setFilterNames(new String[] { "CSV Files(*.csv)", "All Files(*.*)" });
					dialog.setFilterExtensions(new String[] { ".csv", ".*" });
					dialog.setOverwrite(true);
					String initialFileName = "test.csv";
					dialog.setFileName(initialFileName);

					// dialog
					String fileName = dialog.open();
					String selected = dialog.getFilterPath() + fileName;

					if (fileName != null) {
						exportPath.setText(selected);
						selectFileLocation.setFocus();
					}

				}
			}.run();

		}
	}

}