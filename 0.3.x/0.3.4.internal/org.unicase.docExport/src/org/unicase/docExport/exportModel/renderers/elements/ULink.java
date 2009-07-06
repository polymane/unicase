/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.elements;

/**
 * @author Sebastian Hoecht
 */
public class ULink extends UParagraph {

	private String internalLinkId;
	private boolean hideLinkedPage;

	/**
	 * constructor.
	 * 
	 * @param text the Text of the Paragraph of the link
	 * @param internalLinkId the internalID which should be unique in the whole document
	 */
	public ULink(String text, String internalLinkId) {
		super(text);
		// TODO Auto-generated constructor stub
		this.setInternalLinkId(internalLinkId);
	}

	/**
	 * @param internalLinkId the internalLinkId to set
	 */
	public void setInternalLinkId(String internalLinkId) {
		this.internalLinkId = internalLinkId;
	}

	/**
	 * @return the internalLinkId
	 */
	public String getInternalLinkId() {
		return internalLinkId;
	}

	/**
	 * @param hideLinkedPage the hideLinkedPage to set
	 */
	public void setHideLinkedPage(boolean hideLinkedPage) {
		this.hideLinkedPage = hideLinkedPage;
	}

	/**
	 * @return the hideLinkedPage
	 */
	public boolean isHideLinkedPage() {
		return hideLinkedPage;
	}

}
