/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.nebula.widgets.cdatetime.CDT;
import org.eclipse.swt.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Standard widgets to edit a date attribute.
 * 
 * @author shterev
 */
public class MEDateControl extends AbstractMEControl implements MEControl {

	private AdapterImpl adapterImpl;
	private EAttribute attribute;
	private Composite dateComposite;

	private CDateTime dateWidget;
	private ImageHyperlink dateDeleteButton;
	private Label dateDummy;

	/**
	 * default constructor.
	 * 
	 * @param attribute the date attribute
	 * @param toolkit see {@link AbstractMEControl}
	 * @param modelElement see {@link AbstractMEControl}
	 * @param editingDomain see {@link AbstractMEControl}
	 */
	public MEDateControl(EAttribute attribute, FormToolkit toolkit, EObject modelElement, EditingDomain editingDomain) {
		super(editingDomain, modelElement, toolkit);
		this.attribute = attribute;
		adapterImpl = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature() != null && msg.getFeature().equals(MEDateControl.this.attribute)) {
					update();
				}
				super.notifyChanged(msg);
			}

		};
		modelElement.eAdapters().add(adapterImpl);
	}

	/**
	 * {@inheritDoc}
	 */
	public Control createControl(Composite parent, int style) {
		dateComposite = getToolkit().createComposite(parent);
		GridLayoutFactory.fillDefaults().numColumns(2).spacing(2, 0).applyTo(dateComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(dateComposite);
		dateComposite.setBackgroundMode(SWT.INHERIT_FORCE);
		update();
		return dateComposite;
	}

	private void createDateHint() {
		dateDummy = getToolkit().createLabel(dateComposite, "(Not Set)");
		dateDummy.setForeground(dateComposite.getShell().getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		dateDummy.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				new UnicaseCommand() {

					@Override
					protected void doRun() {
						getModelElement().eSet(attribute, new Date());
					}
				}.run();
			}

		});
	};

	private CDateTime createDateWidget() {
		// The picker (CDT.DROP_DOWN) is deactivated on purpose
		dateWidget = new CDateTime(dateComposite, CDT.BORDER);
		dateWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		dateWidget.setPattern("dd.MM.yyyy HH:mm");
		dateWidget.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				// nothing to do here
			}

			public void focusLost(FocusEvent e) {
				new UnicaseCommand() {

					@Override
					protected void doRun() {
						getModelElement().eSet(attribute, dateWidget.getSelection());
					}
				}.run();
			}

		});
		dateDeleteButton = new ImageHyperlink(dateComposite, SWT.TOP);
		dateDeleteButton.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE));
		dateDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new UnicaseCommand() {

					@Override
					protected void doRun() {
						getModelElement().eSet(attribute, null);
					}
				}.run();
			}
		});
		return dateWidget;
	}

	/**
	 * Remove adapter. {@inheritDoc}
	 */
	@Override
	public void dispose() {
		getModelElement().eAdapters().remove(adapterImpl);
		super.dispose();
	}

	private void update() {

		new UnicaseCommand() {

			@Override
			protected void doRun() {
				Date newDate = (Date) getModelElement().eGet(attribute);
				if (newDate == null) { // delete the date widget if it is present.
					if (dateWidget != null) {
						dateWidget.dispose();
						dateDeleteButton.dispose();
					}
					createDateHint(); // create a dummy
				} else if (dateWidget == null || dateWidget.isDisposed()) {
					if (dateDummy != null) { // delete the dummy if it is present.
						dateDummy.dispose();
					}
					createDateWidget(); // create a date widget and set its date.
					dateWidget.setSelection(newDate);
				}
				dateComposite.layout(true);
				dateComposite.getParent().layout(true);
				dateComposite.getParent().getParent().layout(true);
			}
		}.run();
	}
}
