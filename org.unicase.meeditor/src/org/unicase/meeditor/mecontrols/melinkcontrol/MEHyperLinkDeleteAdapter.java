package org.unicase.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.unicase.model.ModelElement;

public class MEHyperLinkDeleteAdapter extends HyperlinkAdapter implements
		IHyperlinkListener {

	private EObject modelElement;
	private EReference reference;
	private EObject opposite;

	public MEHyperLinkDeleteAdapter(EObject modelElement, EReference reference,
			EObject opposite) {
		this.modelElement = modelElement;
		this.reference= reference;
		this.opposite= opposite;
	}

	@Override
	public void linkActivated(HyperlinkEvent e) {
		EList<EObject> list = (EList<EObject>)modelElement.eGet(reference);
		list.remove(opposite);
	}
	

}
