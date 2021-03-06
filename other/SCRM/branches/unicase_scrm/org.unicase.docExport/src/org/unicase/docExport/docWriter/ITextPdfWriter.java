/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.docWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.unicase.docExport.exceptions.DocumentExportException;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Uses iText to render a PDF document.
 * 
 * @author Sebastian Höcht
 */
public class ITextPdfWriter extends ITextWriter implements DocWriter {

	private static final String FILE_TYPE = "pdf";

	/**
	 * {@inheritDoc}
	 */
	public String getFileType() {
		return FILE_TYPE;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws DocumentExportException
	 * @see org.unicase.docExport.docWriter.DocWriter#export(java.lang.String,
	 *      org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection)
	 */
	public void export(String fileName, URootCompositeSection uDoc) throws DocumentExportException {

		try {
			PdfWriter.getInstance(getDoc(), new FileOutputStream(fileName));
			getDoc().open();

			writeUDocument(getDoc(), uDoc);

			getDoc().close();
		} catch (FileNotFoundException e) {
			throw new DocumentExportException("File access error", e);
		} catch (DocumentException e) {
			throw new DocumentExportException("iText error", e);
		}
	}
}
