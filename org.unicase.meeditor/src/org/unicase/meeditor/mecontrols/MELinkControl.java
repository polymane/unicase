package org.unicase.meeditor.mecontrols;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;

public class MELinkControl extends AbstractMEControl {

	FormToolkit toolkit;
	final EReference eReference;
	EObject modelElement;
	Section section;
	Composite composite;
	EList<EObject> value;
	HyperlinkGroup hyperLinkGroup;
	List<Composite> linkComposites;
	Composite linkArea;
	int style;

	public MELinkControl(EObject modelElement, EReference reference,
			FormToolkit toolkit) {
		super();
		this.modelElement = modelElement;
		this.eReference = reference;
		this.toolkit = toolkit;
		linkComposites = new ArrayList<Composite>();
		modelElement.eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getFeature().equals(eReference)) {
					setLinks();
				}
				super.notifyChanged(msg);
			}

		});
	}

	public Control createControl(final Composite parent, int style) {
		this.style = style;
		section = toolkit.createSection(parent, Section.DESCRIPTION
				| Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(eReference.getName());
		composite = toolkit.createComposite(section, style);
		composite.setLayout(new GridLayout());

		linkArea = toolkit.createComposite(composite, style);
		linkArea.setLayout(new GridLayout());

		hyperLinkGroup = new HyperlinkGroup(composite.getDisplay());

		setLinks();

		// TODO: move Button in the titlebar
		Button editButton = toolkit.createButton(composite, "Add", SWT.PUSH);
		editButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				Class<? extends EObject> clazz = (Class<? extends EObject>) eReference
						.getEReferenceType().getInstanceClass();
				ElementListSelectionDialog dlg = new ElementListSelectionDialog(
						parent.getShell(), new AdapterFactoryLabelProvider(
								new ModelItemProviderAdapterFactory()));
				dlg.setElements(((ModelElement) modelElement).getProject()
						.getElementsByClass(clazz).toArray());
				// ((ModelElement) modelElement).getProject(), new
				// AdapterFactoryContentProvider(new
				// ModelItemProviderAdapterFactory()),
				// new AdapterFactoryLabelProvider(new
				// ModelItemProviderAdapterFactory()),
				// "Select the modelelements.");
				dlg.setTitle("Select Elements");
				dlg.setBlockOnOpen(true);
				if (dlg.open() == Window.OK) {
					Object objectList = modelElement.eGet(eReference);
					if (objectList instanceof EList) {
						EList<EObject> list = (EList<EObject>) objectList;
						Object[] result = dlg.getResult();
						for (Object object : result) {
							if (object instanceof EObject) {
								EObject eObject = (EObject) object;
								list.add(eObject);
							}
						}
					}

				}
				// MultipleReferenceDialog dialog = new MultipleReferenceDialog(
				// parent.getShell(), toolkit,
				// (EList<EObject>) modelElement.eGet(reference),
				// ((ModelElement) modelElement).getProject(),clazz,
				// modelElement
				// );
				// dialog.setBlockOnOpen(true);
				// if (dialog.open() == Window.OK) {
				// modelElement.eSet(reference, dialog.getResult());
				// setLinks();
				// }

			}

		});

		section.setClient(composite);
		return section;
	}

	public void setLinks() {
		value = (EList<EObject>) modelElement.eGet(eReference);
		if (linkComposites != null) {
			for (Composite composite : linkComposites) {
				composite.dispose();
			}
		}
		for (EObject object : value) {
			if (object instanceof ModelElement) {

				ModelElement me = (ModelElement) object;
				Composite linkComposite = toolkit.createComposite(linkArea,
						style);
				linkComposite.setLayout(new GridLayout(3, false));
				ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
						new ModelItemProviderAdapterFactory());
				Image image = labelProvider.getImage(me);
				ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(
						linkComposite, style);
				imageHyperlink.setImage(image);
				Hyperlink hyperlink = toolkit.createHyperlink(linkComposite, me
						.getName(), style);
				linkComposites.add(linkComposite);
				hyperLinkGroup.add(hyperlink);
				IHyperlinkListener listener = new MEHyperLinkAdapter(me);
				hyperlink.addHyperlinkListener(listener);
				imageHyperlink.addHyperlinkListener(listener);
				ImageHyperlink deleteLink = toolkit.createImageHyperlink(
						linkComposite, style);
				deleteLink.setImage(PlatformUI.getWorkbench().getSharedImages()
						.getImage(ISharedImages.IMG_TOOL_DELETE));

				deleteLink.addHyperlinkListener(new MEHyperLinkDeleteAdapter(
						modelElement, eReference, me));
			}
		}
		// Force relayout.
		section.setExpanded(false);
		section.setExpanded(true);

	}

}
