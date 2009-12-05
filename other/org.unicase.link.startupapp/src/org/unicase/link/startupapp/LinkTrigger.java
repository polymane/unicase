/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.startupapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import it.sauronsoftware.junique.JUnique;
import it.sauronsoftware.junique.AlreadyLockedException;

/**
 * <code>LinkTrigger</code> is executed at the point of UNICASE loading. It
 * controls run attempts of the UNICASE. There should be always one running 
 * ins
 * tance of UNICASE. <br>There are two use cases: <br> 
 * 1-) UNICASE is not running and you click a UNCASE link.
 * <br>
 * UNICASE is opened and related model element is opened.<br><br>
 * 
 * 2-) UNICASE is running and you click a UNICASE link.
 * <br>
 * New instance of UNICASE is not opened. But, the clicked link is send to 
 * current running UNICASE instance.  
 * 
 * @author jfinis, fxulusoy
 */
public final class LinkTrigger {
	
	/**
	 * The path to the config file which contains the command to startup UNICASE
	 */
	private static final String CONFIG_FILE_PATH = "./unicaseLink.conf";

	/**
	 * The Application ID. It is used to lock UNICASE application to enable to
	 * run one instance of UNICASE.
	 */
	public static final String APPLICATION_ID = "org.unicase.link";
	
	/** 
	 * Prefix of UNICASE links. Example Link: <br/>
	 * unicase://localhost:1099/My-Project-1%_VDIRUdqAEd60k9Qw1XsJiA/ActionItem-1%_p-c0sNqAEd6PJoFq3iT2Rg 
	 */
	public static final String UNICASE_LINK_PREFIX = "unicase://";

	public static String readConfigFile() throws IOException{
		BufferedReader b = new BufferedReader(new FileReader(new File(CONFIG_FILE_PATH)));
		String link = b.readLine();
		b.close();
		if(link==null) throw new IOException("No content found in the configuration file!");
		return link;
	}
	
	/**
	 * Locks the application id and sets up a trigger to get arguments from
	 * other run attempts of UNICASE.
	 * 
	 * @return false if id was not locked. Otherwise, false
	 */
	public static void main(String[] args) {
		
		//Was a unicase link handed to the app?
		if(args.length < 1 || !args[0].toLowerCase().startsWith(UNICASE_LINK_PREFIX)) {
			System.out.println("No unicase link handed to startupapp!");
			return;
		}

		String linkArgument = args[0];
	
		
		boolean isAlreadyRunning = false;
		try {
			JUnique.acquireLock(APPLICATION_ID);
			JUnique.releaseLock(APPLICATION_ID);
		} catch (AlreadyLockedException e) {
			// One instance of an UNICASE is already running.
			isAlreadyRunning = true;
		}


		/* 
		 * if UNICASE is already running, we should send link argument to the instance.
		 * Then, we should not let to run 
		 * second instance. Second instance should kill itself.
		 */ 
		if (isAlreadyRunning) {
			JUnique.sendMessage(APPLICATION_ID, linkArgument);
			return;
		} 
		/* If UNICASE is not running, we let this instance to run.  */ 
		else {
			/* 
			 * If it is started with link argument, we will open model 
			 * element which is defined in the link. Therefore, we assign
			 * link argument to the handledUrl variable. handledUrl will 
			 * be checked in link plugin to to open element.
			 */
			String command;
			try {
				command = readConfigFile().replace("<LINK>","\"" + linkArgument + "\"");
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
			try {
				Runtime.getRuntime().exec(command);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
	}

}


