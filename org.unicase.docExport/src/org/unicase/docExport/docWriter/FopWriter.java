/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.IStatus;
import org.unicase.docExport.DocumentExport;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.UDocument;
import org.unicase.docExport.exportModel.renderers.elements.UImage;
import org.unicase.docExport.exportModel.renderers.elements.ULink;
import org.unicase.docExport.exportModel.renderers.elements.UList;
import org.unicase.docExport.exportModel.renderers.elements.UPageNumber;
import org.unicase.docExport.exportModel.renderers.elements.UParagraph;
import org.unicase.docExport.exportModel.renderers.elements.URef;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.USection;
import org.unicase.docExport.exportModel.renderers.elements.UTable;
import org.unicase.docExport.exportModel.renderers.elements.UTableCell;
import org.unicase.docExport.exportModel.renderers.elements.UTableOfContents;
import org.unicase.docExport.exportModel.renderers.elements.UTextPart;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.PageCitationStyle;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.workspace.util.WorkspaceUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Sebastian Hoecht
 */
public abstract class FopWriter implements DocWriter {

	private static final int INDENTION_WIDTH = 15;
	private Element root;
	private Document doc;
	private Element pageSequence;
	private URootCompositeSection uRoot;

	/**
	 * @param uDoc the rootSection which contains all information needed to render a Document
	 * @return an XML File containing an XML tree with XSL-FO syntax ready to be transformed to a Document
	 */
	protected File createFOFile(URootCompositeSection uDoc) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			setDoc(parser.newDocument());

			root = getDoc().createElement("fo:root");
			getDoc().appendChild(root);
			root.setAttribute("xmlns:fo", "http://www.w3.org/1999/XSL/Format");
			createLayoutMasterSet();

			pageSequence = getDoc().createElement("fo:page-sequence");
			root.appendChild(pageSequence);
			pageSequence.setAttribute("master-reference", "document");

			insertHeaderAndFooter(uDoc.getHeader(), uDoc.getFooter());

			Element content = getDoc().createElement("fo:flow");
			pageSequence.appendChild(content);
			content.setAttribute("flow-name", "xsl-region-body");

			writeUDocument(content, uDoc);

			final File tmpFoFile = File.createTempFile("docExportFoFile", null);

			Transformer tFormer = TransformerFactory.newInstance().newTransformer();
			// Output Types (text/xml/html)
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			// Write the document to a file
			Source source = new DOMSource(getDoc());
			// Create File to view your xml data as vk.txt/vk.doc/vk.xls/vk.shtml/vk.html)
			Result result = new StreamResult(tmpFoFile);
			tFormer.transform(source, result);

			return tmpFoFile;

		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param parent the xml fo Element
	 * @param uDoc the document which shall be written
	 */
	protected void writeUDocument(Element parent, UDocument uDoc) {
		if (uDoc instanceof USection) {
			writeSection(parent, (USection) uDoc);
		} else if (uDoc instanceof UTextPart) {
			writeUTextPart(parent, (UTextPart) uDoc);
		} else if (uDoc instanceof UTableOfContents) {
			UTableOfContents tableOfContents = (UTableOfContents) uDoc;
			writeUTableOfContents(parent, tableOfContents.getRootSection(), tableOfContents.getTextOption());
		} else if (uDoc instanceof URef) {
			writeURef(parent, (URef) uDoc);
		} else if (uDoc instanceof ULink) {
			writeULink(parent, (ULink) uDoc);
		} else if (uDoc instanceof UPageNumber) {
			writePageNumber(parent, (UPageNumber) uDoc);
		} else if (uDoc instanceof UParagraph) {
			writeUParagraph(parent, (UParagraph) uDoc);
		} else if (uDoc instanceof UList) {
			writeUList(parent, (UList) uDoc);
		} else if (uDoc instanceof UTable) {
			writeUTable(parent, (UTable) uDoc);
		} else if (uDoc instanceof UImage) {
			writeUImage(parent, (UImage) uDoc);
		} else if (uDoc instanceof UCompositeSection) {
			writeUCompositeSection(parent, (UCompositeSection) uDoc);
		} else {
			WorkspaceUtil.log(uDoc.getClass().getSimpleName() + "not implemented yet", new Exception(), IStatus.ERROR);
		}
	}

	private void writeUTextPart(Element parent, UTextPart child) {
		Element text = getDoc().createElement("fo:inline");
		parent.appendChild(text);
		setTextOption(text, child.getOption());
		text.setTextContent(child.getText());
	}

	private void writeUTableOfContents(Element parent, USection uSection, TextOption textOption) {
		Element toc = getDoc().createElement("fo:block");
		toc.setAttribute("id", "table_of_contents");
		toc.setAttribute("font-size", "22pt");
		toc.setTextContent("Table of Contents");
		toc.setAttribute("text-align", "center");
		toc.setAttribute("break-before", "page");
		parent.appendChild(toc);

		Element table = getDoc().createElement("fo:table");
		parent.appendChild(table);
		table.setAttribute("margin-top", "10pt");

		Element sectionColumn = getDoc().createElement("fo:table-column");
		Element sectionTitleColumn = getDoc().createElement("fo:table-column");
		Element sectionPageColumn = getDoc().createElement("fo:table-column");
		table.appendChild(sectionColumn);
		table.appendChild(sectionTitleColumn);
		table.appendChild(sectionPageColumn);

		sectionColumn.setAttribute("column-width", "15%");
		sectionTitleColumn.setAttribute("column-width", "75%");
		sectionPageColumn.setAttribute("column-width", "10%");

		Element tableBody = getDoc().createElement("fo:table-body");
		table.appendChild(tableBody);

		writeUTableOfContentsEntry(tableBody, uSection, textOption);
	}

	private void writeUTableOfContentsEntry(Element tableBody, USection uSection, TextOption textOption) {
		for (USection section : uSection.getSubSections()) {
			if (!section.getSectionOption().isLeaveOutPreviousSectionNumbering()) {
				Element tableRow = getDoc().createElement("fo:table-row");
				tableBody.appendChild(tableRow);
				setTextOption(tableRow, textOption);

				Element sectionNumberCell = getDoc().createElement("fo:table-cell");
				Element sectionTitleCell = getDoc().createElement("fo:table-cell");
				Element sectionPageCell = getDoc().createElement("fo:table-cell");
				tableRow.appendChild(sectionNumberCell);
				tableRow.appendChild(sectionTitleCell);
				tableRow.appendChild(sectionPageCell);

				Element sectionNumberBlock = getDoc().createElement("fo:block");
				Element sectionTitleBlock = getDoc().createElement("fo:block");
				Element sectionPageBlock = getDoc().createElement("fo:block");
				sectionNumberCell.appendChild(sectionNumberBlock);
				sectionTitleCell.appendChild(sectionTitleBlock);
				sectionPageCell.appendChild(sectionPageBlock);
				setTextOption(sectionNumberBlock, textOption);
				setTextOption(sectionTitleBlock, textOption);
				setTextOption(sectionPageBlock, textOption);

				sectionNumberBlock.setAttribute("text-align", "right");
				sectionNumberBlock.setAttribute("margin-right", "15pt");
				sectionPageBlock.setAttribute("text-align", "right");
				sectionPageBlock.setAttribute("margin-left", "5pt");

				if (section.getDepth() == 1 && !section.getSectionNumberAsString().equals("")) {
					sectionNumberBlock.setTextContent("Chapter  " + section.getFullSectionNumbering());
				} else {
					sectionNumberBlock.setTextContent(section.getFullSectionNumbering());
				}

				Element page = getDoc().createElement("fo:page-number-citation");
				sectionPageBlock.appendChild(page);
				page.setAttribute("ref-id", String.valueOf(section.hashCode()));

				Element link = getDoc().createElement("fo:basic-link");
				sectionTitleBlock.appendChild(link);
				link.setAttribute("internal-destination", String.valueOf(section.hashCode()));
				link.setTextContent(section.getTitlParagraph().getText());

				if (section.getDepth() == 1) {
					sectionNumberBlock.setAttribute("margin-top", "10pt");
					sectionTitleBlock.setAttribute("margin-top", "10pt");
					sectionPageBlock.setAttribute("margin-top", "10pt");
				} else {
					sectionNumberBlock.setAttribute("color", "rgb(0,0,0)");
					sectionTitleBlock.setAttribute("color", "rgb(0,0,0)");
					sectionPageBlock.setAttribute("color", "rgb(0,0,0)");
				}

				writeUTableOfContentsEntry(tableBody, section, textOption);
			}
		}
	}

	private void writeUImage(Element parent, UImage uImage) {
		Element block = getDoc().createElement("fo:block");
		applyBoxModel(block, uImage.getBoxModel());
		block.setAttribute("text-align", uImage.getTextAlign().getLiteral());
		parent.appendChild(block);
		Element image = getDoc().createElement("fo:external-graphic");
		image.setAttribute("src", uImage.getPath().toString());
		image.setAttribute("text-align", uImage.getTextAlign().getLiteral());
		if (uImage.isFitToPage()) {
			image.setAttribute("content-width", "scale-to-fit");
			image.setAttribute("content-height", "100%");
			image.setAttribute("width", "100%");

		} else {
			if (uImage.getWidth() > 0) {
				image.setAttribute("content-width", uImage.getWidth() + "pt");
			}

			if (uImage.getHeight() > 0) {
				image.setAttribute("content-height", uImage.getHeight() + "pt");
			}
		}
		image.setAttribute("scaling", "uniform");

		if (uImage.isCenter()) {
			block.setAttribute("text-align", "center");
		}

		block.appendChild(image);
	}

	private void writeURef(Element parent, URef uRef) {
		Element text = getDoc().createElement("fo:block");
		parent.appendChild(text);
		text.setAttribute("id", uRef.getRefId());
	}

	private void writeULink(Element parent, ULink uLink) {
		Element blockContainer = getDoc().createElement("fo:block");
		parent.appendChild(blockContainer);

		setParagraphOptions(blockContainer, uLink);

		Element text = getDoc().createElement("fo:basic-link");
		applyBoxModel(text, uLink.getBoxModel());
		blockContainer.appendChild(text);
		setParagraphOptions(text, uLink);
		text.setAttribute("internal-destination", uLink.getInternalLinkId());
		text.setTextContent(uLink.getText());

		if (!uLink.isHideLinkedPage()) {
			Element pageRefBlock = getDoc().createElement("fo:inline");
			text.appendChild(pageRefBlock);
			setParagraphOptions(pageRefBlock, uLink);
			pageRefBlock.setAttribute("font-style", "italic");
			pageRefBlock.setAttribute("font-size", uLink.getOption().getFontSize() - 3 + "pt");
			if (DocumentExport.hasAlreadyBeenRendered(uLink.getInternalLinkId())) {
				pageRefBlock.setTextContent("  Page ");
			}

			Element pageRef = getDoc().createElement("fo:page-number-citation");
			pageRef.setAttribute("ref-id", uLink.getInternalLinkId());
			pageRefBlock.appendChild(pageRef);
		}

		for (UDocument subChild : uLink.getChildren()) {
			writeUDocument(text, subChild);
		}
	}

	/**
	 * @param parent the parent xml fo Element
	 * @param uTable the table which shall be written to the document
	 */
	protected void writeUTable(Element parent, UTable uTable) {
		// Element tableAndCaption = doc.createElement("fo:table-and-caption");
		// parent.appendChild(tableAndCaption);

		Element table = getDoc().createElement("fo:table");
		applyBoxModel(table, uTable.getBoxModel());
		parent.appendChild(table);
		table.setAttribute("border-collapse", "collpase");

		for (float width : uTable.getColumnsWidths()) {
			Element col1 = getDoc().createElement("fo:table-column");
			table.appendChild(col1);
			col1.setAttribute("column-width", width + "%");
		}

		Element tableBody = getDoc().createElement("fo:table-body");
		table.appendChild(tableBody);

		int i = 0;
		Element row = getDoc().createElement("fo:table-row");
		tableBody.appendChild(row);

		for (UTableCell entry : uTable.getEntries()) {
			if (i % uTable.getColumnsCount() == 0 && i != 0) {
				row = getDoc().createElement("fo:table-row");
				tableBody.appendChild(row);
			}

			Element tableCell = getDoc().createElement("fo:table-cell");
			// tableCell.setAttribute("width", "400pt");
			row.appendChild(tableCell);
			applyBoxModel(tableCell, entry.getBoxModel());
			if (entry.getColspan() > 1) {
				tableCell.setAttribute("number-columns-spanned", String.valueOf(entry.getColspan()));
				i = i + entry.getColspan() - 1;
			}

			tableCell.setAttribute("keep-together", "auto");

			writeUDocument(tableCell, entry.getContent());
			i++;
		}

	}

	private void writeUList(Element parent, UList list) {
		Element listBlock = getDoc().createElement("fo:list-block");
		parent.appendChild(listBlock);

		for (String entry : list.getContents()) {

			Element listItem = getDoc().createElement("fo:list-item");
			listBlock.appendChild(listItem);

			Element listItemLabel = getDoc().createElement("fo:list-item-label");
			listItem.appendChild(listItemLabel);
			listItemLabel.setAttribute("end-indent", "label-end()");

			Element bulletBlock = getDoc().createElement("fo:block");
			listItemLabel.appendChild(bulletBlock);

			Element bulletSymbol = getDoc().createElement("fo:inline");
			bulletBlock.appendChild(bulletSymbol);
			setTextOption(bulletSymbol, list.getTextOption());
			// bulletSymbol.setAttribute("font-family", "Symbol");
			bulletSymbol.setTextContent("-");

			Element listItemBody = getDoc().createElement("fo:list-item-body");
			listItem.appendChild(listItemBody);
			listItemBody.setAttribute("start-indent", "body-start()");

			Element textBlock = getDoc().createElement("fo:block");
			setTextOption(textBlock, list.getTextOption());
			listItemBody.appendChild(textBlock);
			textBlock.setTextContent(entry);
		}

	}

	private void writeUCompositeSection(Element parent, UCompositeSection uDoc) {

		for (UDocument child : uDoc.getChildren()) {
			writeUDocument(parent, child);
		}
	}

	private void writeUParagraph(Element parent, UParagraph child) {
		Element text = getDoc().createElement("fo:block");
		applyBoxModel(text, child.getBoxModel());
		parent.appendChild(text);
		setParagraphOptions(text, child);

		int emptyBlockCount = 0;
		if (child.getText() != null) {
			for (String textPart : child.getText().split("\n")) {
				if (textPart.equals("")) {
					emptyBlockCount++;
				} else {
					Element text2 = getDoc().createElement("fo:block");
					text2.setAttribute("white-space-collapse", "false");
					text2.setAttribute("margin-top", child.getOption().getFontSize() * emptyBlockCount + "pt");
					emptyBlockCount = 0;
					text.appendChild(text2);
					setParagraphOptions(text2, child);
					text2.setTextContent(textPart);
				}
			}
		}

		for (UDocument subChild : child.getChildren()) {
			writeUDocument(text, subChild);
		}
	}

	private void writeSection(Element parent, USection child) {
		Element section = getDoc().createElement("fo:block");
		section.setAttribute("white-space-collapse", "false");
		section.setAttribute("id", String.valueOf(child.hashCode()));

		parent.appendChild(section);
		setTextOption(section, child.getTitlParagraph().getOption());
		applyBoxModel(section, child.getBoxModel());
		section.setTextContent(child.getFullSectionNumbering() + " " + child.getTitlParagraph().getText());

		for (UDocument subChild : child.getTitlParagraph().getChildren()) {
			writeUDocument(section, subChild);
		}

		for (UDocument subChild : child.getChildren()) {
			writeUDocument(section, subChild);
		}
	}

	private void insertHeaderAndFooter(UDocument headerDoc, UDocument footerDoc) {
		// header
		Element header = getDoc().createElement("fo:static-content");
		pageSequence.appendChild(header);
		header.setAttribute("flow-name", "xsl-region-before");
		header.setAttribute("margin-left", "30pt");
		header.setAttribute("margin-right", "30pt");

		writeUDocument(header, headerDoc);

		// footer
		Element footer = getDoc().createElement("fo:static-content");
		pageSequence.appendChild(footer);
		footer.setAttribute("flow-name", "xsl-region-after");
		footer.setAttribute("margin-left", "30pt");
		footer.setAttribute("margin-right", "30pt");

		writeUDocument(footer, footerDoc);
	}

	private void writePageNumber(Element parent, UPageNumber uPageNumber) {
		if (uPageNumber.getPageCitationStyle().equals(PageCitationStyle.EMPTY)) {
			return;
		}

		Element page = getDoc().createElement("fo:inline");
		page.setTextContent("");
		parent.appendChild(page);

		Element pageNumber = getDoc().createElement("fo:page-number");
		page.appendChild(pageNumber);

		if (uPageNumber.getPageCitationStyle().equals(PageCitationStyle.PAGE_AND_LAST_PAGE)) {
			Element of = getDoc().createElement("fo:inline");
			of.setTextContent(" / ");
			page.appendChild(of);

			Element pageRef = getDoc().createElement("fo:page-number-citation");
			pageRef.setAttribute("ref-id", "last_page");
			page.appendChild(pageRef);
		}
	}

	private void createLayoutMasterSet() {
		Element layoutMasterSet = getDoc().createElement("fo:layout-master-set");
		root.appendChild(layoutMasterSet);

		// cover page
		Element coverPage = getDoc().createElement("fo:simple-page-master");
		layoutMasterSet.appendChild(coverPage);
		coverPage.setAttribute("master-name", "coverPage");

		// master page
		Element content = getDoc().createElement("fo:simple-page-master");
		layoutMasterSet.appendChild(content);
		content.setAttribute("master-name", "content");

		createBodyRegion(coverPage);
		createBodyRegion(content);

		createHeaderAndFooterRegion(content);

		if (!uRoot.getLayoutOptions().isHideHeaderAndFooterOnCoverPage()) {
			createHeaderAndFooterRegion(coverPage);
		}

		// page sequence master
		Element pageSequenceMaster = getDoc().createElement("fo:page-sequence-master");
		pageSequenceMaster.setAttribute("master-name", "document");
		layoutMasterSet.appendChild(pageSequenceMaster);

		Element alternatives = getDoc().createElement("fo:repeatable-page-master-alternatives");
		pageSequenceMaster.appendChild(alternatives);

		Element coverMaster = getDoc().createElement("fo:conditional-page-master-reference");
		coverMaster.setAttribute("master-name", "covcerPage");
		coverMaster.setAttribute("page-position", "first");
		coverMaster.setAttribute("master-reference", "coverPage");
		alternatives.appendChild(coverMaster);

		Element contentMaster = getDoc().createElement("fo:conditional-page-master-reference");
		contentMaster.setAttribute("master-name", "content");
		contentMaster.setAttribute("page-position", "rest");
		contentMaster.setAttribute("master-reference", "content");
		alternatives.appendChild(contentMaster);

		// it is recommended to do this
		Element fallBack = getDoc().createElement("fo:conditional-page-master-reference");
		fallBack.setAttribute("master-name", "content");
		fallBack.setAttribute("master-reference", "content");
		alternatives.appendChild(fallBack);
	}

	private void createHeaderAndFooterRegion(Element parent) {
		// header
		Element regionBefore = getDoc().createElement("fo:region-before");
		parent.appendChild(regionBefore);
		// buggy.. this doesn't work..
		// regionBefore.setAttribute("extent", "100pt");

		// footer
		Element regionAfter = getDoc().createElement("fo:region-after");
		parent.appendChild(regionAfter);
		regionAfter.setAttribute("extent", "25pt");
	}

	private void createBodyRegion(Element parent) {
		// body
		Element regionBody = getDoc().createElement("fo:region-body");
		parent.appendChild(regionBody);
		regionBody.setAttribute("margin-top", "55pt");
		regionBody.setAttribute("margin-bottom", "45pt");
		regionBody.setAttribute("margin-left", "45pt");
		regionBody.setAttribute("margin-right", "45pt");

	}

	private void setTextOption(Element element, TextOption option) {
		if (option.isBold()) {
			element.setAttribute("font-weight", "bold");
		} else {
			element.setAttribute("font-weight", "normal");
		}

		if (option.isUnderline()) {
			element.setAttribute("text-decoration", "underline");
		}

		if (option.isItalics()) {
			element.setAttribute("font-style", "italic");
		}

		element.setAttribute("font-size", option.getFontSize() + "pt");
		element.setAttribute("font-family", option.getFontFamily().getLiteral());

		if (option.getFontColor() != null) {
			element.setAttribute("color", "rgb(" + option.getFontColor().getRed() + ", "
				+ option.getFontColor().getGreen() + ", " + option.getFontColor().getBlue() + ")");
		}

		element.setAttribute("text-align", option.getTextAlign().getLiteral());

	}

	private void setParagraphOptions(Element block, UParagraph par) {
		String indentionLeft = par.getIndentionLeft() * INDENTION_WIDTH + "pt";
		block.setAttribute("margin-left", indentionLeft);
		setTextOption(block, par.getOption());
	}

	/**
	 * @param uRoot the uRoot to set
	 */
	protected void setURoot(URootCompositeSection uRoot) {
		this.uRoot = uRoot;
	}

	/**
	 * @return the uRoot
	 */
	protected URootCompositeSection getURoot() {
		return uRoot;
	}

	/**
	 * @param option the option which containts padding, border and margin
	 * @param foElement the formating objects DOM element
	 */
	protected void applyBoxModel(Element foElement, BoxModelOption option) {
		setAttribute(foElement, "padding", option.getPadding());
		setAttribute(foElement, "padding-top", option.getPaddingTop());
		setAttribute(foElement, "padding-left", option.getPaddingLeft());
		setAttribute(foElement, "padding-bottom", option.getPaddingBottom());
		setAttribute(foElement, "padding-right", option.getPaddingRight());

		// the border always has to be set, because if only one side of the border is set, the rest
		// have the default border width = 1..
		foElement.setAttribute("border", String.valueOf(option.getBorder()) + "pt");
		setAttribute(foElement, "border-top", option.getBorderTop());
		setAttribute(foElement, "border-left", option.getBorderLeft());
		setAttribute(foElement, "border-bottom", option.getBorderBottom());
		setAttribute(foElement, "border-right", option.getBorderRight());
		foElement.setAttribute("margin", String.valueOf(option.getMargin()));
		setAttribute(foElement, "margin-top", option.getMarginTop());
		setAttribute(foElement, "margin-left", option.getMarginLeft());
		setAttribute(foElement, "margin-bottom", option.getMarginBottom());
		setAttribute(foElement, "margin-right", option.getMarginRight());

		if (option.isKeepTogether()) {
			foElement.setAttribute("keep-together", "always");
		}

		if (option.isKeepWithNext()) {
			foElement.setAttribute("keep-with-next", "always");
		}

		if (option.isKeepWithPrevious()) {
			foElement.setAttribute("keep-with-previous", "always");
		}

		if (option.getBorderStyle() != UBorderStyle.HIDDEN) {
			foElement.setAttribute("border-style", option.getBorderStyle().getLiteral());
		}

		foElement.setAttribute("border-color", "rgb(" + option.getBorderColor().getRed() + ", "
			+ option.getBorderColor().getGreen() + ", " + option.getBorderColor().getBlue() + ")");

		if (option.getBackgroundColor() != null) {
			foElement.setAttribute("background-color", "rgb(" + option.getBackgroundColor().getRed() + ", "
				+ option.getBackgroundColor().getGreen() + ", " + option.getBackgroundColor().getBlue() + ")");
		}

		if (option.isBreakBefore()) {
			foElement.setAttribute("break-before", "page");
		}

		if (option.getWidth() > 0) {
			foElement.setAttribute("width", option.getWidth() + "pt");
		}
	}

	private void setAttribute(Element foElement, String foAttributeName, double foAttributeValue) {
		if (foAttributeValue != 0) {
			foElement.setAttribute(foAttributeName, String.valueOf(foAttributeValue) + "pt");
		}
	}

	/**
	 * @param doc the doc to set
	 */
	protected void setDoc(Document doc) {
		this.doc = doc;
	}

	/**
	 * @return the doc
	 */
	protected Document getDoc() {
		return doc;
	}
}
