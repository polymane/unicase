/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */

package org.unicase.ui.common.util;

import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

/**
 * Utility class for the unicase project. 
 * @author shterev
 * @author hodaie
 *
 */
public final class UnicaseUiUtil {
	
	private UnicaseUiUtil(){
		//do nothing
	}
	
	/**.
	 * This shows a standard dialog with some given initial contents to
	 * select model elements.
	 * @param shell shell
	 * @param initialContent initilaContents
	 * @param title title
	 * @param multiSelection if multiSelection is allowed
	 * @return The selected objects
	 */
	//ZH Why does this return Objects?:
	public static Object[] showMESelectionDialog(Shell shell,
								Collection<?> initialContent,
								String title,
								boolean multiSelection){
		
		ElementListSelectionDialog dlg = new ElementListSelectionDialog(shell
				.getShell(), new AdapterFactoryLabelProvider(
							new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));

		dlg.setElements(initialContent.toArray(new Object[initialContent.size()]));
		dlg.setTitle(title);
		dlg.setBlockOnOpen(true);
		dlg.setMultipleSelection(multiSelection);
		Object[] result = new Object[0];
		if (dlg.open() == Window.OK) {
			result = dlg.getResult();
		}
		return result;
	}
}
