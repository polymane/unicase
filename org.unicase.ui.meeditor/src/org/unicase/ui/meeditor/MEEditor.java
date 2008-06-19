/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * GUI view for editing MEs.
 * @author helming
 *
 */
public class MEEditor extends SharedHeaderFormEditor {

	/**
	 * The Id for MEEditor. We need this to open a model element.
	 */
	public static final String ID = "org.unicase.ui.meeditor";
	private ModelElement modelElement;
	private ComposedAdapterFactory adapterFactory;
	private TransactionalEditingDomain editingDomain;
	private ILabelProvider labelProvider;
	private CommandStack commandStack;
	private ControlFactory controlFactory;
	private boolean dirty;

	/**
	 * Default constructor.
	 */
	public MEEditor() {
		// initializeEditingDomain();
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void addPages() {

		FormPage form = new MEEditorPage(this, "1", "Standard View",
				editingDomain, modelElement);
		try {
			addPage(form);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void doSave(IProgressMonitor monitor) {

		monitor.beginTask("Saving...", 1);
		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						WorkspaceManager.getInstance().getCurrentWorkspace()
								.save();

					}

				});

		commandStack.flush();
		editorDirtyStateChanged();
		monitor.done();
		dirty = false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void doSaveAs() {
	}

	/**
	 * Save is not allowed as the editor can only modify model elements.
	 * @return false
	 */
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		if (input instanceof MEEditorInput) {
			setInput(input);
			MEEditorInput meInput = (MEEditorInput) input;
			setPartName(input.getName());
			setTitleImage(input.getImageDescriptor().createImage());

			modelElement = meInput.getModelElement();
			// AS: confirm that the method should be placed here.
			initializeEditingDomain();
		} else {
			throw new PartInitException(
					"MEEditor is only appliable for MEEditorInputs");
		}
	}

	/**
	 * Initializes the editing domain for this model element.
	 */
	protected void initializeEditingDomain() {
		this.adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ModelItemProviderAdapterFactory());
		this.adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// command stack that will notify this editor as commands are executed
		this.editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(modelElement.eResource().getResourceSet());

		this.commandStack = editingDomain.getCommandStack();
		// Add a listener to set the editor dirty of commands have been executed
		// editingDomain.getCommandStack().addCommandStackListener(new
		// CommandStackListener() {
		// public void commandStackChanged(final EventObject event) {
		// getContainer().getDisplay().asyncExec(new Runnable() {
		// public void run() {
		// dirty = true;
		// editorDirtyStateChanged();
		// }
		// });
		// }
		// });

		// Create the editing domain with our adapterFactory and command stack.

		// These provide access to the model items, their property source and
		// label
		this.labelProvider = new TransactionalAdapterFactoryLabelProvider(
				editingDomain, adapterFactory);

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isDirty() {
		return true;
	}

}
