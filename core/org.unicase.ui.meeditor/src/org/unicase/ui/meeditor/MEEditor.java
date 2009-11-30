/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.provider.ShortLabelProvider;
import org.unicase.metamodel.util.ModelElementChangeListener;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * GUI view for editing MEs.
 * 
 * @author helming
 * @author naughton
 */
public class MEEditor extends SharedHeaderFormEditor {

	/**
	 * Updates necessary UI elements on model changes.
	 * 
	 * @author Shterev
	 */
	private final class MEEditorListener implements ModelElementChangeListener {
		private final IEditorInput input;

		private MEEditorListener(IEditorInput input) {
			this.input = input;
		}

		public void onChange(final Notification msg) {
			if (msg.isTouch()) {
				return;
			}
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					updateIcon(input);
					setPartName((new ShortLabelProvider()).getText(modelElement));
					if (mePage != null) {
						mePage.updateSectionTitle();
					}

				}
			});

		}

		public void onRuntimeExceptionInListener(RuntimeException exception) {
			modelElement.removeModelElementChangeListener(eAdapter);
		}
	}

	/**
	 * The Id for MEEditor. We need this to open a model element.
	 */
	public static final String ID = "org.unicase.ui.meeditor";

	private ModelElement modelElement;
	private TransactionalEditingDomain editingDomain;
	private MEEditorPage mePage;

	private ModelElementChangeListener eAdapter;

	private String creatorHint;

	private ILabelProviderListener labelProviderListener;

	/**
	 * Default constructor.
	 */
	public MEEditor() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addPages() {
		MEEditorInput editorInput = (MEEditorInput) getEditorInput();
		if (editorInput.getProblemFeature() != null) {
			mePage = new MEEditorPage(this, "Edit", "Standard View", editingDomain, modelElement, editorInput
				.getProblemFeature());
		} else {
			mePage = new MEEditorPage(this, "Edit", "Standard View", editingDomain, modelElement);
		}

		try {
			addPage(mePage);
		} catch (PartInitException e) {
			// JH Auto-generated catch block
			e.printStackTrace();
		}
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.pages");
		for (IConfigurationElement e : config) {
			try {
				AbstractMEEditorPage newPage = (AbstractMEEditorPage) e.createExecutableExtension("class");
				newPage.init(this, editingDomain, modelElement);
				addPage(newPage);
			} catch (CoreException e1) {
				WorkspaceUtil.logException("Unable to create a page for MEEditor", e1);
			}
		}
		// commentsPage = new METhreadPage(this, "Discussion", "Discussion", editingDomain, modelElement);
		// descriptionPage = new MEDescriptionPage(this, "Description", "Description", editingDomain, modelElement);
		// addPage(descriptionPage);
		// addPage(commentsPage);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		// do nothing (Jonas said so)
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSaveAs() {
	}

	/**
	 * Save is not allowed as the editor can only modify model elements.
	 * 
	 * @return false
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);
		if (input instanceof MEEditorInput) {
			setInput(input);
			final MEEditorInput meInput = (MEEditorInput) input;
			modelElement = meInput.getModelElement();
			setPartName((new ShortLabelProvider()).getText(modelElement));
			setTitleImage(input.getImageDescriptor().createImage());

			initializeEditingDomain();
			eAdapter = new MEEditorListener(input);
			this.modelElement.addModelElementChangeListener(eAdapter);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			StringBuffer stringBuffer = new StringBuffer();
			Date creationDate = modelElement.getCreationDate();
			creatorHint = "";
			if (creationDate != null) {
				creationDate = modelElement.getCreationDate();
				stringBuffer.append("Created on ");
				stringBuffer.append(dateFormat.format(creationDate));
				stringBuffer.append(" at ");
				stringBuffer.append(timeFormat.format(creationDate));
				stringBuffer.append(" by ");
				stringBuffer.append(modelElement.getCreator());
				creatorHint = stringBuffer.toString();
			}
			updateCreatorHint();

			labelProviderListener = new ILabelProviderListener() {
				public void labelProviderChanged(LabelProviderChangedEvent event) {
					updateIcon(meInput);
				}
			};
			meInput.getLabelProvider().addListener(labelProviderListener);

		} else {
			throw new PartInitException("MEEditor is only appliable for MEEditorInputs");
		}
	}

	private void updateCreatorHint() {
		getEditorSite().getActionBars().getStatusLineManager().setMessage(creatorHint);
	}

	/**
	 * Initializes the editing domain for this model element.
	 */
	protected void initializeEditingDomain() {

		this.editingDomain = Configuration.getEditingDomain();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		// we do always save immediately so we are never dirty
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {

		super.setFocus();
		mePage.setFocus();
		updateCreatorHint();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		modelElement.removeModelElementChangeListener(eAdapter);
		((MEEditorInput) getEditorInput()).getLabelProvider().removeListener(labelProviderListener);
		super.dispose();
	}

	private void updateIcon(IEditorInput input) {
		Image titleImage = input.getImageDescriptor().createImage();
		setTitleImage(titleImage);
		// TODO AS: Debug why sometimes the page is null - not disposed Adapter?
		if (mePage != null) {
			mePage.getManagedForm().getForm().setImage(titleImage);
		}
	}

}
