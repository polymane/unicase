/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.unicase.ui.common.UnicaseColumnViewerSorter;

/**
 * This is editing support for columns showing integeral values.
 * 
 * @author zardosht
 */
public class IntegerEditingSupport extends EditingSupport {

	private EStructuralFeature feature;
	private TextCellEditor textCellEditor;

	/**
	 * Constructor.
	 * 
	 * @param viewer viewer
	 * @param feature structural feature being edited
	 */
	public IntegerEditingSupport(TableViewer viewer, EStructuralFeature feature) {
		super(viewer);
		this.feature = feature;
		this.textCellEditor = new TextCellEditor(viewer.getTable());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	@Override
	protected boolean canEdit(Object element) {
		return feature.getEType().equals(EcorePackage.Literals.EINT);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		return textCellEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 */
	@Override
	protected Object getValue(Object element) {

		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			if (!eObject.eClass().getEAllStructuralFeatures().contains(feature)) {
				return null;
			}
			Object value = eObject.eGet(feature);
			if (value != null && value instanceof Integer) {
				return value.toString();
				// return ((Integer)value).intValue();
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void setValue(Object element, Object value) {
		if (!(element instanceof EObject)) {
			return;
		}
		EObject eObject = (EObject) element;
		if (!eObject.eClass().getEAllStructuralFeatures().contains(feature)) {
			return;
		}
		if (value instanceof String) {
			String strValue = value.toString();
			if (strValue.matches("[0-9]*")) {
				doSetValue(eObject, Integer.parseInt(strValue));
				getViewer().update(element, null);
			}
		}

	}

	private void doSetValue(final EObject eObject, final Integer value) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(eObject);
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				eObject.eSet(feature, value);
			}
		});
		((UnicaseColumnViewerSorter) getViewer().getComparator()).setSortingEnabled(false);
		getViewer().update(eObject, null);
		// ((UnicaseColumnViewerSorter) getViewer().getComparator()).setSortingEnabled(true);
	}

}
