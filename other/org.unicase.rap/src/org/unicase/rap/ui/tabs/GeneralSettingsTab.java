package org.unicase.rap.ui.tabs;

import org.eclipse.swt.SWT;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.IDialogConstants;

import config.ConfigEntity;
import org.unicase.rap.LoginDialog;
import org.unicase.rap.config.IValidator;
import org.unicase.rap.config.ConfigEntityStore;
import org.unicase.rap.config.GeneralSettingsConfigEntity;
import org.unicase.rap.ui.views.ConfigurationTabView;


/**
 * General settings tab.
 * 
 * @author Edgar M�ller, Fatih Ulusoy
 */
public class GeneralSettingsTab extends ConfigurationTabView {
	
	private GeneralSettingsConfigEntity cfgEntity;
	
	private Text adminUserNameTextField;
	private Text passwordTextField;
	private Text passwordConfirmationTextField;

	public void createTab(Composite parent) {
		
//		if(!login())
//			return;
		
		GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 2;
	    gridLayout.makeColumnsEqualWidth = true;
	    parent.setLayout(gridLayout);
			
		Label l = new Label(parent, SWT.NONE); 
		l.setText("Admin user name:");
		
		GridData d = new GridData();
		d.horizontalAlignment = GridData.FILL;

		adminUserNameTextField = new Text(parent, SWT.BORDER);
		adminUserNameTextField.setLayoutData(d);
	
		l = new Label(parent, SWT.NONE);
		l.setText("Admin password");
		
		passwordTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		passwordTextField.setLayoutData(d);
		
		l = new Label(parent, SWT.NONE);
		l.setText("Admin password confirmation");
		passwordConfirmationTextField = new Text(parent, SWT.BORDER | SWT.PASSWORD);
		passwordConfirmationTextField.setLayoutData(d);
		
		addValidator(new IValidator() {
			
			public boolean validate() {
				return passwordTextField.getText().equals(passwordConfirmationTextField.getText());
			}
			
			public String getValidationErrorMessage() {
				return "The passwords you've provided do not match.";
			}
		});
		
		loadSettings();
	}

	@Override
	public ConfigEntity getConfigEntity() {
		cfgEntity = new GeneralSettingsConfigEntity();
		cfgEntity.setAdminPassword(passwordTextField.getText());
		cfgEntity.setAdminUsername(adminUserNameTextField.getText());
		return cfgEntity;
	}

	@Override
	public void loadSettings() {
		
		 GeneralSettingsConfigEntity configEntity = new GeneralSettingsConfigEntity();
		
		 ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity,
				 configEntity.eClass());
		 
		 if (entity != null) {
			 adminUserNameTextField.setText((String) entity.getProperties()
					 .get(GeneralSettingsConfigEntity.Keys.ADMIN_USER_NAME_KEY));

			 String password = (String) entity.getProperties().get(
					 GeneralSettingsConfigEntity.Keys.ADMIN_PASSWORD_KEY);

			 passwordTextField.setText(password);
			 passwordConfirmationTextField.setText(password);
		 }
	}
	
	/**
	 * Logins to configuration view.
	 * 
	 * @return
	 */
    private boolean login() {
    	
    	boolean isLoggedIn = false;
		Display display = PlatformUI.createDisplay();
		LoginDialog loginDialog = new LoginDialog(display.getActiveShell(), "Login Window");
		boolean returnValue = false;
		
		while (!returnValue) {
            returnValue = loginDialog.open() == IDialogConstants.OK_ID ? true : false;
            
			if (returnValue) {
				// validate user
				GeneralSettingsConfigEntity configEntity = new GeneralSettingsConfigEntity();
				ConfigEntity entity = ConfigEntityStore.loadConigEntity(configEntity,
					new GeneralSettingsConfigEntity().eClass());
				String userName = (String) entity.getProperties().get(
					GeneralSettingsConfigEntity.Keys.ADMIN_USER_NAME_KEY);
				String password = (String) entity.getProperties().get(
					GeneralSettingsConfigEntity.Keys.ADMIN_PASSWORD_KEY);

				if (loginDialog.getUsername().equals(userName) 
						&& loginDialog.getPassword().equals(password)) {
					isLoggedIn = true;
					returnValue = true;
				} else {
					MessageDialog.openError(display.getActiveShell(), "Error",
						"Aunthenticaiton failed \n Invalid username and password");
					returnValue = false;
				}
			} else {
				MessageDialog.openError(display.getActiveShell(), "Error",
					"Aunthenticaiton failed \n Please enter valid username and password");
			}
		}
		return isLoggedIn;
	}
    
	
}


