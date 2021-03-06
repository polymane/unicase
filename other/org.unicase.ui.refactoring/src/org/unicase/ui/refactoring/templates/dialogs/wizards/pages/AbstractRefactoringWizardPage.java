/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.refactoring.templates.dialogs.wizards.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.refactoring.Activator;
import org.unicase.ui.refactoring.templates.dialogs.wizards.AbstractRefactoringWizard;
import org.unicase.ui.refactoring.templates.util.MERichTextControlWithoutToolbar;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.workspace.WorkspaceManager;


/**
 * @author pfeifferc
 */
public abstract class AbstractRefactoringWizardPage extends WizardPage {

	private AbstractRefactoringWizard wizard;

	private List<Control> controls;

	private List<AbstractMEControl> abstractControls;

	private Map<UnicaseModelElement, ModelElementChangeListener> modelElementChangeListeners;

	private Composite parent;

	/**
	 * The constructor.
	 * 
	 * @param pageName the
	 * @param wizard the
	 */
	protected AbstractRefactoringWizardPage(String pageName, AbstractRefactoringWizard wizard) {
		super(pageName);
		this.wizard = wizard;
		controls = new ArrayList<Control>();
		abstractControls = new ArrayList<AbstractMEControl>();
		modelElementChangeListeners = new HashMap<UnicaseModelElement, ModelElementChangeListener>();
		setTitle("Violation of constraint rule " + pageName.replace("_", " "));
		setDescription("Please choose how to proceed with the refactoring");
		setPageComplete(false);
	}

	/**
	 * @param parent the
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		this.parent = parent;
		parent.getShell().setSize(600, 750);
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	/**
	 * @return the wizard
	 */
	protected AbstractRefactoringWizard getRefactoringWizard() {
		return wizard;
	}

	/**
	 * @param parent composite
	 * @return composite
	 */
	protected Composite createBodyComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		addControl(composite);
		return composite;
	}

	private void addControl(Control control) {
		setDebugColor(control);
		controls.add(control);
	}

	/**
	 * @param parent the
	 * @return composite
	 */
	protected Composite createModelElementInformationComposite(Composite parent) {
		// create composite to put other widgets on
		Composite composite = createComposite(parent, SWT.TOP, new GridLayout(2, false), new GridData(SWT.FILL,
			SWT.TOP, true, false));
		// create model element icon
		createIconLabel(composite, getRefactoringWizard().getLabelProvider().getImage(
			getRefactoringWizard().getInvalidModelElement()));
		// create affected model element text
		createText(composite, "Affected model element: " + getRefactoringWizard().getLabelProvider().getText(getRefactoringWizard().getInvalidModelElement()),
			true);
		// create creator icon
		createIconLabel(composite, "filtertouser.png");
		// create affected model element creator text
		String creator = getRefactoringWizard().getInvalidModelElement().getCreator();
		if(creator == null) {
			creator = "unknown";
		}
		createText(composite, "Creator: " + creator, true);
		// create date icon
		createIconLabel(composite, "date.png");
		// create affected model element created text
		createText(composite, "Created: "
			+ getRefactoringWizard().getInvalidModelElement().getCreationDate().toString(), true);
		return composite;
	}
	
	/**
	 * @param parent the
	 */
	protected void createModelElementInformationCompositeWithDescription(Composite parent) {
		// create model element information composite without description
		Composite composite = createModelElementInformationComposite(parent);
		// create date icon
		createIconLabel(composite, "pencil.png");
		// create affected model element description
		createText(composite, "Description: "
			+ ((UnicaseModelElement) getRefactoringWizard().getInvalidModelElement()).getDescriptionPlainText(), true);
	}

	/**
	 * @param parent the
	 * @param swt parameters
	 * @param layout the
	 * @param layoutData the
	 * @return the composite
	 */
	protected Composite createComposite(Composite parent, int swt, Layout layout, Object layoutData) {
		Composite composite = new Composite(parent, swt);
		composite.setLayout(layout);
		composite.setLayoutData(layoutData);
		addControl(composite);
		return composite;
	}

	/**
	 * @param parent the
	 * @param information text
	 * @param fileName the
	 * @return the composite
	 */
	protected Composite createExplanatoryTextComposite(Composite parent, String information, String fileName) {
		Composite composite = createComposite(parent, SWT.NONE, new GridLayout(2, false), new GridData(SWT.FILL,
			SWT.TOP, true, false));
		createIconLabel(composite, fileName);
		Text text = new Text(composite, SWT.MULTI | SWT.WRAP);
		text.setText(information);
		text.setLayoutData(new GridData(SWT.NONE, SWT.TOP, true, true));
		text.setEditable(false);
		addControl(text);
		return composite;
	}

	/**
	 * @param composite the
	 * @param name text
	 * @return the text
	 */
	protected Text createText(Composite composite, String name) {
		return createText(composite, name, false);
	}
	
	/**
	 * 
	 * @param parent the
	 * @return label
	 */
	protected Label createSeparator(Composite parent) {
		Label label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		return label;
	}

	/**
	 * @param composite the
	 * @param name text
	 * @param grabHorizontal if
	 * @return the text
	 */
	protected Text createText(Composite composite, String name, boolean grabHorizontal) {
		Text text = new Text(composite, SWT.WRAP | SWT.MULTI);
		text.setText(name);
		text.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, grabHorizontal, false));
		text.setEditable(false);
		addControl(text);
		return text;
	}

	/**
	 * @param parent the
	 * @param fileName the
	 * @return the icon label
	 */
	protected Label createIconLabel(Composite parent, String fileName) {
		return createIconLabel(parent, getImageForFileName(fileName));
	}

	/**
	 * @param parent the
	 * @param image the
	 * @return the icon label
	 */
	protected Label createIconLabel(Composite parent, Image image) {
		Label label = new Label(parent, SWT.NONE);
		label.setImage(image);
		setIconLabelData(label);
		addControl(label);
		return label;
	}

	/**
	 * @param control the
	 * @param parent the
	 * @param modelElement the
	 * @param feature the
	 * @return the control
	 */
	protected Control createMEControl(AbstractMEControl control, Composite parent, UnicaseModelElement modelElement,
		String feature) {
		Control modelElementControl = control.createControl(parent, SWT.FILL, new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getPropertyDescriptor(
			modelElement, feature), modelElement, UnicaseActionHelper.getContext(modelElement), new FormToolkit(Display.getCurrent()));
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		if (control instanceof MERichTextControlWithoutToolbar) {
			gridData.heightHint = 120;
		}
		modelElementControl.setLayoutData(gridData);
		abstractControls.add(control);
		controls.add(modelElementControl);
		return modelElementControl;
	}
	
	/**
	 * @param parent the
	 * @return the label
	 */
	protected Label createIconLabel(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		setIconLabelData(label);
		addControl(label);
		return label;
	}

	private void setIconLabelData(Label label) {
		GridData gridData = new GridData(SWT.BEGINNING, SWT.TOP, false, false);
		gridData.widthHint = 20;
		gridData.heightHint = 16;
		label.setLayoutData(gridData);
	}

	/**
	 * @param fileName the
	 * @return the image
	 */
	protected Image getImageForFileName(String fileName) {
		return Activator.getImageDescriptor("icons/" + fileName).createImage();
	}

	/**
	 * To be called when the page is selected.
	 */
	public void pageSelected() {
		parent.layout(true);
	}

	/**
	 * @return can finish
	 */
	public boolean canFinish() {
		return false;
	}

	/**
	 * Debug method.
	 * 
	 * @param control the
	 */
	protected void setDebugColor(Control control) {
		control.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
//		control.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_CYAN));
	}

	/**
	 * @return the editing domain
	 */
	protected EditingDomain getEditingDomain() {
		return WorkspaceManager.getInstance().getCurrentWorkspace().getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.DialogPage#dispose()
	 */
	@Override
	public void dispose() {
		disposeMEControls();
		for (Control control : controls) {
			if (!control.isDisposed()) {
				control.dispose();
			}
		}
		super.dispose();
	}

	/**
	 * Dispose ME controls.
	 */
	protected void disposeMEControls() {
		for (AbstractMEControl control : abstractControls) {
			control.dispose();
		}
		for(UnicaseModelElement modelElement : modelElementChangeListeners.keySet()) {
			modelElement.removeModelElementChangeListener(modelElementChangeListeners.get(modelElement));
		}
	}

	/**
	 * Override for more functionality.
	 * 
	 * @return true
	 */
	public boolean performFinish() {
		return true;
	}

	/**
	 * @param modelElement the
	 * @param modelElementChangeListener the
	 */
	public void addModelElementChangeListener(UnicaseModelElement modelElement, ModelElementChangeListener modelElementChangeListener) {
		modelElementChangeListeners.put(modelElement, modelElementChangeListener);
	}
}