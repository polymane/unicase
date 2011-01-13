package org.unicase.xmi.views;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.unicase.xmi.commands.ImportProjectHandler;

public class ImportProjectDialog extends XMIDialog {
	
	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent shell
	 */
	public ImportProjectDialog(Shell parent, ImportProjectHandler handler) {
		super(parent, "Import Project", "Please enter the name of your project-file and its location.");
		setHandler(handler);
	}

	@Override
	protected
	SelectionListener getBrowseWorkspaceListener() {
		return new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// opens up a new dialog to browse the "eclipse" workspace
				WorkspaceResourceDialog workspaceDialog = new WorkspaceResourceDialog(shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
				workspaceDialog.setAllowMultiple(false);
				workspaceDialog.setTitle("Select a Project File");
				workspaceDialog.setMessage("Please select an XMI file with project contents.");
				workspaceDialog.loadContents();
				int dialogRes = workspaceDialog.open();
				
				// dialog results
				String fileName = null;
				if(dialogRes == WorkspaceResourceDialog.OK) {
					IFile[] selectedFiles = workspaceDialog.getSelectedFiles();
					if(selectedFiles.length != 0) {
						fileName = selectedFiles[0].getLocation().toOSString(); // index 0 because multi option is off and it can import only one or no files 
					}
				}
				
				if(fileName == null || fileName == "") {
					String path = DEFAULT_LOCATION;
					
					if(txtProjectName.getText() == null || txtProjectName.getText() == "") {
						path += File.separator + System.currentTimeMillis() + ".ucw"; // prevents the system from having twice the same filename or at least it's unlikely.
					}
					else {
						path += File.separator + txtProjectName.getText() + ".ucw";
					}
					
					fileName = path;
				}
				
				// set the textfield to a fitting project name
				txtProjectLocation.setText(fileName);
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}

	@Override
	protected SelectionListener getBrowseFilesystemListener() {
		return new SelectionListener() {

			FileDialog projectLocation = new FileDialog(shell, SWT.OPEN);
			String path = Platform.getLocation().toOSString();
		
			public void widgetDefaultSelected(SelectionEvent e) {
				
				projectLocation.setFilterNames(new String[] {"XMI Project Resources (*.ucw)",
					"XML Model Resources (*.xml)",
					"XMI Model Resources (*.xmi)"});
				projectLocation.setFilterExtensions(new String[] {"*.ucw", "*.xml", "*.xmi"});
				
				path = projectLocation.open();
				if(path == null) {
					path = DEFAULT_LOCATION;
					
					if(txtProjectName.getText() == null || txtProjectName.getText() == "") {
						path += File.separator + System.currentTimeMillis() + ".ucw"; // prevents the system from having twice the same filename or at least it's unlikely.
					}
					else {
						path += File.separator + txtProjectName.getText() + ".ucw";
					}
				}
				txtProjectLocation.setText(path);
			}

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}
			
		};
	}


}
