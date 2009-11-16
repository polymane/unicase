/*******************************************************************************
 * Copyright (c) 2007, 2008 OnPositive Technologies (http://www.onpositive.com/) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     OnPositive Technologies (http://www.onpositive.com/) - initial API and implementation
 *******************************************************************************/

package com.onpositive.richtexteditor.io;




/**
 * @author 32kda
 * Basic lexical event
 */
public class LexEvent //Lexem (key word) 
{ 
	/**
	 * lexem word 
	 */
	public String l;
	int beg;
	
	/**
	 * Number of line
	 * Unused yet
	 */
	public int line;

	
	/**
	 * Basic constructor (by word)
	 * @param l word of lexem
	 */
	public LexEvent(String l)
	{
		this.l = l;
	}
	
	
	/**
	 * Default constructor
	 */
	public LexEvent()
	{
		l = "";
	}
}

