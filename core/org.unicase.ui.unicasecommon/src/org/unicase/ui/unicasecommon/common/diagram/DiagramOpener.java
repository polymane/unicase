package org.unicase.ui.unicasecommon.common.diagram;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.diagram.MEDiagram;

public class DiagramOpener {

	public void openDiagram(MEDiagram diagram, String id) {
		URI uri = EcoreUtil.getURI(diagram);
		uri.appendFragment(diagram.eResource().getURIFragment(diagram));
		URIEditorInput input = new URIEditorInput(uri, diagram.getName());

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, id, true);
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(
				"org.eclipse.ui.views.PropertySheet");
		} catch (PartInitException e) {
			ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error", e
				.getMessage(), e.getStatus());
		}

	}

}
