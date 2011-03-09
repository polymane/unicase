package org.unicase.codetrace.team.ui.wizards;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.model.ModelPackage;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.dialogs.ModelElementSelectionDialog;

public class AttacheeSelectionDialog extends ModelElementSelectionDialog{

	public AttacheeSelectionDialog(Project root) {
		super(false);
		EList<UnicaseModelElement> e = root.getAllModelElementsbyClass(ModelPackage.Literals.UNICASE_MODEL_ELEMENT,new BasicEList<UnicaseModelElement>());
		BasicEList<ModelElement> el = new BasicEList<ModelElement>();
		for(UnicaseModelElement elem: e){
			el.add(elem);
		}
		
		setModelElements(el);
	}

	
}