/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.implementation.ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.ui.celleditor.ExtendedComboBoxCellEditor;
import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.emf.edit.ui.provider.PropertyDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.emfstore.esmodel.versioning.operations.semantic.SemanticCompositeOperation;
import org.unicase.implementation.operations.util.OperationHelper;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;

/**
 * Viewer for operation parameters.
 * 
 * @author herrmi
 */
public class ParameterViewer extends TableViewer {

	/**
	 * Editing support for operations.
	 * 
	 * @author herrmi
	 */
	private final class ValueEditingSupport extends EditingSupport {
		private ValueEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		protected boolean canEdit(Object element) {
			return true;
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			final EStructuralFeature feature = (EStructuralFeature) element;

			if (feature instanceof EAttribute) {
				return getAttributeCellEditor((EAttribute) feature);
			}
			return getReferenceCellEditor((EReference) feature);
		}

		private CellEditor getReferenceCellEditor(final EReference reference) {
			if (reference.isMany()) {
				return new ExtendedDialogCellEditor(getTable(), valueLabelProvider) {

					@SuppressWarnings("unchecked")
					@Override
					protected Object openDialogBox(Control cellEditorWindow) {

						FeatureEditorDialog dialog = new FeatureEditorDialog(cellEditorWindow.getShell(),
							labelProvider, operation, reference.getEType(), (List) getFeatureValue(reference),
							getEditorTitle(reference), OperationHelper.getPossibleValues(operation, reference, project));

						dialog.open();
						return dialog.getResult();
					}

				};
			}
			return new ExtendedComboBoxCellEditor(getTable(), OperationHelper.getPossibleValues(operation, reference,
				project), valueLabelProvider, true);
		}

		private CellEditor getAttributeCellEditor(final EAttribute attribute) {
			if (attribute.isMany()) {
				return new ExtendedDialogCellEditor(getTable(), valueLabelProvider) {

					@SuppressWarnings("unchecked")
					@Override
					protected Object openDialogBox(Control cellEditorWindow) {
						FeatureEditorDialog dialog = new FeatureEditorDialog(cellEditorWindow.getShell(),
							labelProvider, attribute, (EDataType) attribute.getEType(),
							(List) getFeatureValue(attribute), getEditorTitle(attribute), null);
						dialog.open();
						return dialog.getResult();
					}

				};
			}
			EDataType dataType = (EDataType) attribute.getEType();
			if (dataType.getInstanceClass() == Boolean.class || dataType.getInstanceClass() == Boolean.TYPE) {
				return new ExtendedComboBoxCellEditor(getTable(), Arrays.asList(new Object[] { Boolean.FALSE,
					Boolean.TRUE }), valueLabelProvider, false);
			}
			return new PropertyDescriptor.EDataTypeCellEditor((EDataType) attribute.getEType(), getTable());
		}

		@Override
		protected Object getValue(Object element) {
			EStructuralFeature feature = (EStructuralFeature) element;
			return getFeatureValue(feature);
		}

		@Override
		protected void setValue(Object element, Object value) {
			EStructuralFeature feature = (EStructuralFeature) element;
			setFeatureValue(feature, value);
			refresh();
		}
	}

	/**
	 * Label provider for operation parameters.
	 * 
	 * @author herrmi
	 */
	private final class ValueLabelProvider extends LabelProvider {
		@SuppressWarnings("unchecked")
		@Override
		public Image getImage(Object element) {
			if (element instanceof Collection) {
				Collection collection = (Collection) element;
				if (!collection.isEmpty()) {
					return dialog.getLabelProvider().getImage(collection.iterator().next());
				}
			} else {
				if (element != null) {
					return dialog.getLabelProvider().getImage(element);
				}
			}
			return null;
		}

		@SuppressWarnings("unchecked")
		@Override
		public String getText(Object element) {
			if (element instanceof Collection) {
				String label = "";
				Collection c = (Collection) element;
				for (Iterator i = c.iterator(); i.hasNext();) {
					label += dialog.getLabelProvider().getText(i.next());
					if (i.hasNext()) {
						label += ", ";
					}
				}
				return label;
			}
			return dialog.getLabelProvider().getText(element);
		}
	}

	private final Project project;

	private SemanticCompositeOperation operation;

	private LabelProvider valueLabelProvider;

	private final ExecuteOperationDialog dialog;

	/**
	 * Constructor.
	 * 
	 * @param dialog the dialog
	 * @param parent the parent composite
	 * @param project the project to run in
	 */
	public ParameterViewer(ExecuteOperationDialog dialog, Composite parent, Project project) {
		super(parent, SWT.FULL_SELECTION | SWT.BORDER);

		this.project = project;
		this.dialog = dialog;
		init();
	}

	private void init() {
		valueLabelProvider = new ValueLabelProvider();

		initContentProvider();
		initNameColumn();
		initValueColumn();
	}

	private void initContentProvider() {
		setContentProvider(new IStructuredContentProvider() {

			public Object[] getElements(Object inputElement) {
				SemanticCompositeOperation operation = (SemanticCompositeOperation) inputElement;
				EList<EStructuralFeature> features = operation.eClass().getEStructuralFeatures();
				return features.toArray();
			}

			public void dispose() {
				// not required
			}

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				// not required
			}

		});
	}

	private void initNameColumn() {
		TableViewerColumn nameColumn = new TableViewerColumn(this, SWT.None);
		nameColumn.getColumn().setWidth(200);
		nameColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public Image getImage(Object element) {
				return null;
			}

			@Override
			public String getText(Object element) {
				EStructuralFeature feature = (EStructuralFeature) element;
				return feature.getName();
			}
		});
	}

	private void initValueColumn() {
		TableViewerColumn valueColumn = new TableViewerColumn(this, SWT.None);
		valueColumn.getColumn().setWidth(200);
		valueColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				EStructuralFeature feature = (EStructuralFeature) element;
				return valueLabelProvider.getImage(getFeatureValue(feature));
			}

			@Override
			public String getText(Object element) {
				EStructuralFeature feature = (EStructuralFeature) element;
				return valueLabelProvider.getText(getFeatureValue(feature));
			}
		});

		valueColumn.setEditingSupport(new ValueEditingSupport(this));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.AbstractTableViewer#inputChanged(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void inputChanged(Object input, Object oldInput) {
		this.operation = (SemanticCompositeOperation) input;
		super.inputChanged(input, oldInput);
	}

	@SuppressWarnings("unchecked")
	private Object getFeatureValue(EStructuralFeature feature) {
		Object value = operation.eGet(feature);
		if (feature instanceof EReference) {
			if (feature.isMany()) {
				value = OperationHelper.getElements(project, (List<ModelElementId>) value);
			} else {
				value = OperationHelper.getElement(project, (ModelElementId) value);
			}
		}
		return value;
	}

	@SuppressWarnings("unchecked")
	private void setFeatureValue(EStructuralFeature feature, Object value) {
		if (feature instanceof EReference) {
			if (feature.isMany()) {
				value = OperationHelper.getIds((List<? extends ModelElement>) value);
			} else {
				value = OperationHelper.getId((ModelElement) value);
			}
		}
		operation.eSet(feature, value);
		dialog.validate();
	}

	private String getEditorTitle(EStructuralFeature feature) {
		String result = "Parameter ";
		result += feature.getName();
		result += " : ";
		if (feature.isMany()) {
			result += "<" + feature.getEType().getName() + ">";
		} else {
			result += feature.getEType().getName();
		}
		return result;
	}

}
