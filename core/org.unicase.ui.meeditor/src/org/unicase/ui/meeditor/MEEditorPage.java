/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.ContributionManager;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.ISourceProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IEvaluationService;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.provider.ShortLabelProvider;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.meeditor.mecontrols.FeatureHintTooltipSupport;
import org.unicase.ui.meeditor.mecontrols.METextControl;

/**
 * The editor page for the {@link MEEditor}.
 * 
 * @author helming
 * @author shterev
 * @author naughton
 */
public class MEEditorPage extends FormPage {

	private EditingDomain editingDomain;
	private ModelElement modelElement;
	private FormToolkit toolkit;
	private List<AbstractMEControl> meControls = new ArrayList<AbstractMEControl>();

	private static String activeModelelement = "activeModelelement";
	private ScrolledForm form;
	private List<IItemPropertyDescriptor> leftColumnAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> rightColumnAttributes = new ArrayList<IItemPropertyDescriptor>();
	private List<IItemPropertyDescriptor> bottomAttributes = new ArrayList<IItemPropertyDescriptor>();
	private Composite leftColumnComposite;
	private Composite rightColumnComposite;
	private Composite bottomComposite;
	private EStructuralFeature problemFeature;

	/**
	 * Default constructor.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param editingDomain the editingDomain
	 * @param modelElement the modelElement
	 */
	public MEEditorPage(MEEditor editor, String id, String title, EditingDomain editingDomain, ModelElement modelElement) {
		super(editor, id, title);
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
	}

	/**
	 * Default constructor.
	 * 
	 * @param editor a editor
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param editingDomain the editingDomain
	 * @param modelElement the modelElement
	 */
	public MEEditorPage(FormEditor editor, String id, String title, EditingDomain editingDomain,
		ModelElement modelElement) {
		super(editor, id, title);
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
	}

	/**
	 * Default constructor.
	 * 
	 * @param editor the {@link MEEditor}
	 * @param id the {@link FormPage#id}
	 * @param title the title
	 * @param editingDomain the editingDomain
	 * @param modelElement the modelElement
	 *@param problemFeature the problemFeature
	 */
	public MEEditorPage(MEEditor editor, String id, String title, TransactionalEditingDomain editingDomain,
		ModelElement modelElement, EStructuralFeature problemFeature) {
		this(editor, id, title, editingDomain, modelElement);
		this.problemFeature = problemFeature;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);

		toolkit = this.getEditor().getToolkit();
		form = managedForm.getForm();
		toolkit.decorateFormHeading(form.getForm());
		Composite body = form.getBody();
		body.setLayout(new GridLayout());
		SashForm globalSash = new SashForm(body, SWT.VERTICAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(globalSash);
		toolkit.adapt(globalSash, true, true);

		SashForm topSash = new SashForm(globalSash, SWT.HORIZONTAL);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).applyTo(topSash);
		toolkit.adapt(topSash, true, true);
		topSash.setSashWidth(4);

		leftColumnComposite = toolkit.createComposite(topSash, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(2, 5, 5, 5).applyTo(
			leftColumnComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(leftColumnComposite);

		rightColumnComposite = toolkit.createComposite(topSash, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 2, 5, 5).applyTo(
			rightColumnComposite);
		GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).applyTo(rightColumnComposite);

		int[] topWeights = { 50, 50 };
		topSash.setWeights(topWeights);

		bottomComposite = toolkit.createComposite(globalSash);
		GridLayoutFactory.fillDefaults().numColumns(1).equalWidth(false).extendedMargins(5, 5, 5, 5).applyTo(
			bottomComposite);
		GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.TOP).grab(true, false).applyTo(bottomComposite);

		// updateSectionTitle();
		form.setImage(new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE)).getImage(modelElement));

		// Sort and order attributes
		sortAndOrderAttributes();
		// Create attributes
		createAttributes(leftColumnComposite, leftColumnAttributes);
		createAttributes(rightColumnComposite, rightColumnAttributes);
		createAttributes(bottomComposite, bottomAttributes);
		// Create special ME Control
		// createSpecificMEControls();
		createToolbar();
		form.pack();
	}

	/**
	 * Updates the name of the section.
	 */
	public void updateSectionTitle() {
		// Layout form
		ShortLabelProvider shortLabelProvider = new ShortLabelProvider();
		String name = shortLabelProvider.getText(modelElement);

		name += " [" + modelElement.eClass().getName() + "]";
		form.setText(name);
	}

	private void createToolbar() {
		IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);
		ISourceProvider sourceProvider = new AbstractSourceProvider() {
			public void dispose() {
			}

			@SuppressWarnings("unchecked")
			public Map getCurrentState() {
				HashMap<Object, Object> map = new HashMap<Object, Object>();
				map.put(activeModelelement, modelElement);
				return map;
			}

			public String[] getProvidedSourceNames() {
				String[] namens = new String[1];
				namens[0] = activeModelelement;
				return namens;
			}

		};

		IEvaluationService service = (IEvaluationService) PlatformUI.getWorkbench()
			.getService(IEvaluationService.class);
		service.addSourceProvider(sourceProvider);
		menuService.populateContributionManager((ContributionManager) form.getToolBarManager(),
			"toolbar:org.unicase.ui.meeditor.MEEditorPage");
		form.getToolBarManager().update(true);
	}

	private void sortAndOrderAttributes() {

		AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		List<IItemPropertyDescriptor> propertyDescriptors = adapterFactoryItemDelegator
			.getPropertyDescriptors(modelElement);
		if (propertyDescriptors != null) {
			AnnotationPositionDescriptor positionDescriptor = new AnnotationPositionDescriptor();
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				String value = positionDescriptor.getValue(itemPropertyDescriptor, modelElement);
				if (value.equals("left")) {
					leftColumnAttributes.add(itemPropertyDescriptor);
				} else if (value.equals("right")) {
					rightColumnAttributes.add(itemPropertyDescriptor);
				} else if (value.equals("bottom")) {
					bottomAttributes.add(itemPropertyDescriptor);
				}
			}

			final HashMap<IItemPropertyDescriptor, Double> priorityMap = new HashMap<IItemPropertyDescriptor, Double>();
			AnnotationPriorityDescriptor priorityDescriptor = new AnnotationPriorityDescriptor();
			for (IItemPropertyDescriptor itemPropertyDescriptor : propertyDescriptors) {
				priorityMap.put(itemPropertyDescriptor, priorityDescriptor.getValue(itemPropertyDescriptor,
					modelElement));
			}

			Comparator<IItemPropertyDescriptor> comparator = new Comparator<IItemPropertyDescriptor>() {
				public int compare(IItemPropertyDescriptor o1, IItemPropertyDescriptor o2) {
					return Double.compare(priorityMap.get(o1), priorityMap.get(o2));
				}
			};
			Collections.sort(leftColumnAttributes, comparator);
			Collections.sort(rightColumnAttributes, comparator);
			Collections.sort(bottomAttributes, comparator);

		}

	}

	private void createAttributes(Composite column, List<IItemPropertyDescriptor> attributes) {
		Composite attributeComposite = toolkit.createComposite(column);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(attributeComposite);
		GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.BEGINNING).indent(10, 0).applyTo(
			attributeComposite);

		ControlFactory controlFactory = new ControlFactory(editingDomain, modelElement, this.getEditor().getToolkit());

		for (IItemPropertyDescriptor itemPropertyDescriptor : attributes) {
			AbstractMEControl meControl = controlFactory.createControl(itemPropertyDescriptor);
			if (meControl == null) {
				continue;
			}
			meControls.add(meControl);
			Control control;
			if (!itemPropertyDescriptor.isMany(modelElement)) {
				Label label = toolkit.createLabel(attributeComposite, itemPropertyDescriptor
					.getDisplayName(modelElement));
				label.setData(modelElement);
				FeatureHintTooltipSupport.enableFor(label, itemPropertyDescriptor);
				control = meControl.createControl(attributeComposite, SWT.WRAP);
				GridDataFactory.fillDefaults().align(SWT.LEFT, SWT.CENTER).applyTo(label);
				GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).indent(10, 0).applyTo(
					control);
				if (meControl instanceof AbstractMEControl) {
					(meControl).applyCustomLayoutData();
				}
			} else {
				control = meControl.createControl(attributeComposite, SWT.WRAP);
				control.setData(modelElement);
				FeatureHintTooltipSupport.enableFor(control, itemPropertyDescriptor);
				GridDataFactory.fillDefaults().span(2, 1).grab(true, false).align(SWT.FILL, SWT.BEGINNING)
					.indent(10, 0).applyTo(control);
			}
			if (itemPropertyDescriptor.getFeature(modelElement) == problemFeature) {
				ControlDecoration dec = new ControlDecoration(control, SWT.TOP | SWT.LEFT);
				dec.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
				dec.setDescriptionText("Problem detected.");
			}

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		for (AbstractMEControl control : meControls) {
			control.dispose();
		}
		super.dispose();
	}

	/**
	 * {@inheritDoc} This method is added to solve the focus bug of navigator. Every time that a ME is opened in editor,
	 * navigator has to lose focus so that its action contributions are set correctly for next time.
	 */
	@Override
	public void setFocus() {
		super.setFocus();
		// set keyboard focus on the first Text control
		for (AbstractMEControl meControl : this.meControls) {
			if (meControl instanceof METextControl) {
				((METextControl) meControl).setFocus();
				break;
			}
		}
	}

	private void createSpecificMEControls() {
		if (this.modelElement instanceof Issue) {
			AbstractMEControl meControl = ControlFactory.createMEIssueAssessmentMatrixControl(
				(Issue) this.modelElement, toolkit, editingDomain);
			if (meControl != null) {
				meControls.add(meControl);
				Control control;
				control = meControl.createControl(bottomComposite, SWT.WRAP);
				// control.setLayoutData(new
				// TableWrapData(TableWrapData.FILL_GRAB));
				GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).indent(10, 0)
					.applyTo(control);
			}
		}

	}

}