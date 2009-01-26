package org.unicase.docExport.exportModel.renderers.elements;

import org.unicase.docExport.exportModel.renderers.options.TextOption;

/**
 * This class represents an entry in an UTable.
 * 
 * @see UTable
 * @author Sebastian Hoecht
 */
public class UTableCell extends UCompositeSection {
	private UDocument content;
	private int colspan = 1;

	/**
	 * @param text the content of the cell
	 */
	public UTableCell(String text) {
		setContent(new UParagraph(text));
	}

	/**
	 * @param text the content of the cell
	 * @param textOption the textOption which shall decorate the table entry
	 */
	public UTableCell(String text, TextOption textOption) {
		UParagraph par = new UParagraph(text);
		par.setOption(textOption);
		setContent(par);
	}

	/**
	 * @param content the content of the tableCell .. mostly a UParagraph, but could also be a list or another
	 *            UCompositeSection
	 */
	public UTableCell(UDocument content) {
		this.content = content;
	}

	/**
	 * @param colspan the colspan to set
	 */
	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	/**
	 * @return the colspan
	 */
	public int getColspan() {
		return colspan;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(UDocument content) {
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public UDocument getContent() {
		return content;
	}
}
