/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/

package org.eclipse.emf.ecp.editor.mecontrols;

import org.eclipse.core.databinding.observable.value.DateAndTimeObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

/**
 * An SWT-based date widget with an additional time field, which 
 * are both controlled by spinners.
 * 
 * @author Hunnilee
 *
 */
public class MESWTDateAndTimeControl extends AbstractMEControl implements IValidatableControl{

	private static final int PRIORITY = 3;
	
	private EAttribute attribute;
	private ImageHyperlink dateDeleteButton;
	private Composite dateComposite;
	private DateTime dateWidget;
	private DateTime timeWidget;
	
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		return PRIORITY;
	}

	@Override
	protected Control createControl(Composite parent, int style) {
		this.attribute = (EAttribute) getItemPropertyDescriptor().getFeature(getModelElement());
		dateComposite = getToolkit().createComposite(parent);
		dateComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		GridLayoutFactory.fillDefaults().numColumns(3).spacing(2, 0).applyTo(dateComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(dateComposite);
		
		createDateAndTimeWidget();
		
		IObservableValue model = EMFEditObservables.observeValue(getEditingDomain(), getModelElement(), attribute);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		IObservableValue dateObserver = SWTObservables.observeSelection(dateWidget);
		IObservableValue timeObserver = SWTObservables.observeSelection(timeWidget);
		dbc.bindValue(new DateAndTimeObservableValue(dateObserver, timeObserver), model, null, null);
		
		return dateComposite;
	}

	private void createDateAndTimeWidget() {
		dateWidget = new DateTime(dateComposite, SWT.DATE);
		dateWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		timeWidget = new DateTime(dateComposite, SWT.TIME | SWT.SHORT);
		timeWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		dateDeleteButton = new ImageHyperlink(dateComposite, SWT.TOP);
		dateDeleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		dateDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new ECPCommand(getModelElement()) {

					@Override
					protected void doRun() {
						getModelElement().eSet(attribute, null);
					}
				}.run(true);
			}
		});
	}
	
	/**.
	 * {@inheritDoc}}
	 * */
	public void handleValidation(Diagnostic diagnostic) {
		Device device = Display.getCurrent();
		if (diagnostic.getSeverity() == Diagnostic.ERROR || diagnostic.getSeverity() == Diagnostic.WARNING) {
			Color color = new Color(device, 255, 0 ,0);
			this.dateComposite.setBackgroundMode(SWT.INHERIT_DEFAULT);
			this.dateComposite.setBackground(color);
			this.dateWidget.setBackground(color);
			this.timeWidget.setBackground(color);
			this.dateWidget.setToolTipText(diagnostic.getMessage());
			this.timeWidget.setToolTipText(diagnostic.getMessage());
		}

	}

	/**.
	 * {@inheritDoc}}
	 * */
	public void resetValidation() {
		Device device = Display.getCurrent();
		Color color = new Color(device, 255, 255, 255);
		this.dateComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		this.dateWidget.setBackground(color);
		this.timeWidget.setBackground(color);
		this.dateWidget.setToolTipText("");
		this.timeWidget.setToolTipText("");
		
	}

}

