package org.unicase.ui.componentDiagram.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class ModelSheetLabelProvider extends DecoratingLabelProvider {

	/**
	 * @generated
	 */
	public ModelSheetLabelProvider() {
		super(new AdapterFactoryLabelProvider(
				org.unicase.ui.componentDiagram.part.ModelDiagramEditorPlugin
						.getInstance().getItemProvidersAdapterFactory()), null);
	}

	/**
	 * @generated
	 */
	@Override
	public String getText(Object element) {
		Object selected = unwrap(element);
		if (selected instanceof org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup) {
			return ((org.unicase.ui.componentDiagram.navigator.ModelNavigatorGroup) selected)
					.getGroupName();
		}
		return super.getText(selected);
	}

	/**
	 * @generated
	 */
	@Override
	public Image getImage(Object element) {
		return super.getImage(unwrap(element));
	}

	/**
	 * @generated
	 */
	private Object unwrap(Object element) {
		if (element instanceof IStructuredSelection) {
			return unwrap(((IStructuredSelection) element).getFirstElement());
		}
		if (element instanceof EditPart) {
			return unwrapEditPart((EditPart) element);
		}
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null) {
				return unwrapView(view);
			}
		}
		return element;
	}

	/**
	 * @generated
	 */
	private Object unwrapEditPart(EditPart p) {
		if (p.getModel() instanceof View) {
			return unwrapView((View) p.getModel());
		}
		return p.getModel();
	}

	/**
	 * @generated
	 */
	private Object unwrapView(View view) {
		return view.getElement() == null ? view : view.getElement();
	}

}
