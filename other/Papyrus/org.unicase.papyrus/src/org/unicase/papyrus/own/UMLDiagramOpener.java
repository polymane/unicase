package org.unicase.papyrus.own;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.unicase.papyrus.UMLModel;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.ui.util.ModelElementOpener;

public class UMLDiagramOpener implements ModelElementOpener {
	
	private static Map<UMLDiagramType, String> diagramTypeToEditorID;
	
	private static boolean isInitialized;

	public int canOpen(EObject eObject) {
		if(eObject instanceof UMLModel) {
			return 2;
		}
		return DONOTOPEN;
	}

	public void openModelElement(EObject eObject) {
		if(eObject instanceof UMLModel) {
			final UMLModel model = (UMLModel) eObject;
			//TODO: Find a better place to put this!
			if(!isInitialized) {
				model.eResource().eAdapters().add(new UnicaseModelSetQueryAdapter());
				isInitialized = true;
			}
			if(model.getGmfDiagram() == null) {
				initializePackage(model);
			}
			String id = getDiagramTypeToEditorID().get(model.getDiagramType()); 
			if(id == null) {
				return;
			}
			URI uri = EcoreUtil.getURI(model);
			URIEditorInput input = new URIEditorInput(uri, model.getName());
			try {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(input, id, true);
			} catch (PartInitException e) {
				ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
						e.getMessage(), e.getStatus());
			}
		}
		
	}

	private void initializePackage(final UMLModel model) {
		Shell shell = Display.getCurrent().getActiveShell();
		UMLDiagramTypeSelectionDialog dialog = new UMLDiagramTypeSelectionDialog(shell);
		if(dialog.open() == Dialog.OK) {
			final UMLDiagramType selectedElement = (UMLDiagramType) dialog.getFirstResult();
			new ECPCommand(model) {

				@Override
				protected void doRun() {
					model.setDiagramType(selectedElement);
					model.setName(selectedElement.getName());
				}
				
			}.run(true);
			
		}
	}

	private Map<UMLDiagramType, String> getDiagramTypeToEditorID() {
		if(diagramTypeToEditorID == null) {
			diagramTypeToEditorID = new LinkedHashMap<UMLDiagramType, String>();
			diagramTypeToEditorID.put(UMLDiagramType.ACTIVITY, "org.unicase.papyrus.activity.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.CLASS, "org.unicase.papyrus.clazz.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.COMMUNICATION, "org.unicase.papyrus.communication.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.COMPOSITE, "org.unicase.papyrus.composite.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.SEQUENCE, "org.unicase.papyrus.sequence.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.STATE_MACHINE, "org.unicase.papyrus.statemachine.UMLDiagramEditorID");
			diagramTypeToEditorID.put(UMLDiagramType.USE_CASE, "org.unicase.papyrus.usecase.UMLDiagramEditorID");
		}
		return diagramTypeToEditorID;
	}

}
