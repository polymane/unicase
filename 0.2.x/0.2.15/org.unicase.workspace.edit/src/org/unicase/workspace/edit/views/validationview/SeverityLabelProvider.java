package org.unicase.workspace.edit.views.validationview;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Label Provider to show the severity.
 * 
 * @author helming
 * 
 */
public class SeverityLabelProvider extends ColumnLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			int severity = constraint.getSeverity();
			String imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			switch (severity) {
			case IMarker.SEVERITY_ERROR:
				imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
				break;
			case IMarker.SEVERITY_WARNING:
				imageName = ISharedImages.IMG_OBJS_WARN_TSK;
				break;
			default:
				imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			}
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					imageName);

		}
		return super.getImage(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof IConstraintStatus) {
			IConstraintStatus constraint = (IConstraintStatus) element;
			return "" + constraint.getSeverity();
		}
		return super.getText(element);
	}

}
