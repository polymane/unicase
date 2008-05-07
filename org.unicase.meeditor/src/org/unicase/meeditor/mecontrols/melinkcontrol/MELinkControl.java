package org.unicase.meeditor.mecontrols.melinkcontrol;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.meeditor.mecontrols.AbstractMEControl;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class MELinkControl extends AbstractMEControl {

	private Composite linkComposite;
	private EObject contextModelElement;
	private EReference reference;
	
	public MELinkControl(EditingDomain editingDomain, EObject modelElement,
			FormToolkit toolkit, EObject contextModelElement, EReference reference) {
		super(editingDomain, modelElement, toolkit);
		this.contextModelElement=contextModelElement;
		this.reference=reference;
	}

	public Control createControl(Composite parent, int style) {
		linkComposite = toolkit.createComposite(parent,
				style);
		linkComposite.setLayout(new GridLayout(3, false));
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				new ModelItemProviderAdapterFactory());
		Image image = labelProvider.getImage(modelElement);
		ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(
				linkComposite, style);
		imageHyperlink.setImage(image);
		Hyperlink hyperlink = toolkit.createHyperlink(linkComposite,labelProvider.getText(modelElement), style);
		IHyperlinkListener listener = new MEHyperLinkAdapter((ModelElement)modelElement);
		hyperlink.addHyperlinkListener(listener);
		imageHyperlink.addHyperlinkListener(listener);
		ImageHyperlink deleteLink = toolkit.createImageHyperlink(
				linkComposite, style);
		deleteLink.setImage(PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_TOOL_DELETE));

		deleteLink.addHyperlinkListener(new MEHyperLinkDeleteAdapter(
				contextModelElement, reference, modelElement));
		return linkComposite;
	}

}
