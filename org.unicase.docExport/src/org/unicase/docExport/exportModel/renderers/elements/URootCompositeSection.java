package org.unicase.docExport.exportModel.renderers.elements;

import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;

/**
 * @author Sebastian Hoecht
 */
public class URootCompositeSection extends UCompositeSection {

	private LayoutOptions option;
	private UDocument header;
	private UDocument footer;
	private UDocument coverPage;

	/**
	 * @return the layout options of the document.
	 */
	public LayoutOptions getLayoutOptions() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setLayoutOptions(LayoutOptions option) {
		this.option = option;
	}

	/**
	 * @param footer the footer to set
	 */
	public void setFooter(UDocument footer) {
		this.footer = footer;
	}

	/**
	 * @return the footer
	 */
	public UDocument getFooter() {
		return footer;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(UDocument header) {
		this.header = header;
	}

	/**
	 * @return the header
	 */
	public UDocument getHeader() {
		return header;
	}

	/**
	 * @param coverPage the coverPage to set
	 */
	public void setCoverPage(UDocument coverPage) {
		this.coverPage = coverPage;
	}

	/**
	 * @return the coverPage
	 */
	public UDocument getCoverPage() {
		return coverPage;
	}

}
