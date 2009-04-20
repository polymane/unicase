/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.editors.tabItems;

import java.io.File;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.IFileSystem;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.unicase.docExport.TemplateRegistry;
import org.unicase.docExport.editors.TemplateEditor;
import org.unicase.docExport.editors.TemplateEditorTabItem;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A TemplateEditor TabItem containing some SWT Elements for changing the logo image of a template.
 * 
 * @author Sebastian Hoecht
 */
public class LayoutOptionsLogoTabItem extends TemplateEditorTabItem {

	/**
	 * @param parent SWT Composite parent
	 * @param template the Template containing the options
	 * @param editor the TemplateEditor
	 */
	public LayoutOptionsLogoTabItem(CTabFolder parent, final Template template, final TemplateEditor editor) {
		super(parent, template, editor);

		setText("Logo");

		final LayoutOptions layoutOptions = template.getLayoutOptions();

		((GridLayout) getContainer().getLayout()).numColumns = 2;
		Button selectImage = new Button(getContainer(), SWT.PUSH);
		selectImage.setText("select logo");

		final Browser browser = new Browser(getContainer(), SWT.NONE);
		GridLayout layout2 = new GridLayout();
		GridData data2 = new GridData(GridData.FILL_BOTH);
		browser.setLayout(layout2);
		browser.setLayoutData(data2);

		if (layoutOptions.getLogoImage() != null && !layoutOptions.getLogoImage().equals("")) {
			browser.setText("<img src=\"" + TemplateRegistry.TEMPLATE_IMAGE_FOLDER + layoutOptions.getLogoImage()
				+ "\" />");
		}

		selectImage.addSelectionListener(new ImageSelectionListener(template, browser));

		new Label(getContainer(), SWT.NONE).setText("width");
		Text width = new Text(getContainer(), SWT.BORDER);
		width.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(getContainer(), SWT.None).setText("height");
		Text height = new Text(getContainer(), SWT.BORDER);
		height.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		width.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				template.getLayoutOptions().setLogoWidth(Integer.valueOf(((Text) e.widget).getText()));
				editor.testDirty();
			}
		});

		height.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				template.getLayoutOptions().setLogoHeight(Integer.parseInt(((Text) e.widget).getText()));
				editor.testDirty();
			}
		});
		width.setText(String.valueOf(template.getLayoutOptions().getLogoWidth()));
		height.setText(String.valueOf(template.getLayoutOptions().getLogoHeight()));
		width.setSize(width.computeSize(100, SWT.DEFAULT));
		width.getParent().pack(true);
		width.getParent().layout(true, true);

		layoutAndPackAll();
	}

	/**
	 * A SelectionListener for the image selection.
	 * 
	 * @author Sebastian Hoecht
	 */
	class ImageSelectionListener implements SelectionListener {

		private Template template;
		private Browser browser;

		/**
		 * @param template the template containing some layoutOptions
		 * @param browser the SWT Browser where the logo image is shown.
		 */
		public ImageSelectionListener(Template template, Browser browser) {
			this.template = template;
			this.browser = browser;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {
			FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), SWT.OPEN);
			dialog.setText("select a logo image");
			dialog.setFilterExtensions(new String[] { "*.*", "*.jpg", "*.gif", "*.png", "*.svg" });
			String image = dialog.open();
			if (image != null) {
				Path imagePath = new Path(image);
				File imageFile = new File(image);
				File targetFile = new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER + template.getName() + "."
					+ imagePath.getFileExtension());
				File imageFolder = new File(TemplateRegistry.TEMPLATE_IMAGE_FOLDER);
				imageFolder.mkdirs();

				IFileSystem fileSystem = EFS.getLocalFileSystem();
				IFileStore src = fileSystem.getStore(imageFile.toURI());
				IFileStore dst = fileSystem.getStore(targetFile.toURI());
				// Will recursively copy the home directory to the backup directory,
				// but if any files are in place on the destination matching files to
				// be copied an exception will be thrown with that given file name.
				try {
					src.copy(dst, EFS.OVERWRITE, null);
				} catch (CoreException e1) {
					WorkspaceUtil.log("The selected logo image of the template could not be copied", e1, IStatus.ERROR);
				}

				template.getLayoutOptions().setLogoImage(template.getName() + "." + imagePath.getFileExtension());

				browser.setText("<img src=\"" + TemplateRegistry.TEMPLATE_IMAGE_FOLDER
					+ template.getLayoutOptions().getLogoImage() + "\" />");
				getEditor().testDirty();
			}
		}
	}

}