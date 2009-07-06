package org.unicase.docExport;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.unicase.docExport.docWriter.DocWriter;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.DocumentRenderer;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;

/**
 * 
 * @author Sebastian Höcht
 *
 */
public class DocumentExport implements IRunnableWithProgress{

	private ModelElement modelElement;
	private DocWriter docWriter;
	private Template template;
	private DocumentRenderer renderer;
	private String fileLocation;
	
	private static HashSet<ModelElementId> renderedModelElements;
	private static HashSet<ModelElement> linkedModelElements;
	
	/**
	 * 
	 * @param modelElement the ModelElement you want to export
	 * @param docWriter the docWriter used to write the document
	 * @param documentTemplate the template which defines how the modelElement is rendered
	 * @param renderer the DocumentRenderer which renders the modelElement using the template
	 */
	public DocumentExport(
			ModelElement modelElement, 
			DocWriter docWriter, 
			Template documentTemplate,
			DocumentRenderer renderer
	) {
		this.modelElement = modelElement;
		this.docWriter = docWriter;
		this.template = documentTemplate;
		this.renderer = renderer;
		
		renderedModelElements = new HashSet<ModelElementId>();
		linkedModelElements = new HashSet<ModelElement>();
	}
	
	/**
	 * exports a the ModelElement to the file.
	 * @param fileLocation the location where the modelElement shall be exported.
	 */
	public void export(String fileLocation) {
		UCompositeSection doc = renderer.render(modelElement, template);
		//TODO change return type of all renderers to URootCompositeSection
		docWriter.export(fileLocation, (URootCompositeSection) doc);

	}
	
	/**
	 * @param monitor i dunno what this param is for, because i don't use it ;)
	 * @throws InterruptedException .
	 * @throws InvocationTargetException .
	 */
	public void run(IProgressMonitor monitor) 
		throws InvocationTargetException, InterruptedException {
		
		monitor.beginTask("Exporting Document", IProgressMonitor.UNKNOWN);
		export(this.fileLocation);
		
		if (monitor.isCanceled()) {
			throw new InterruptedException("The export has been canceled");
		}
		
		monitor.done();
	}

	/**
	 * @param fileLocation the fileLocation to set
	 */
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	/**
	 * If a ModelElement is linked in the Document, it should be added with this function.
	 * This is required for the appendix.
	 * @param me The ModelElement to add
	 */
	public static void addLinkedModelElement(ModelElement me) {
		linkedModelElements.add(me);
	}
	
	/**
	 * 
	 * @return a set of ModelElements which have been linked in the ongoing DocumentExport
	 */
	public static HashSet<ModelElement> getLinkedModelElements() {
		return linkedModelElements;
	}
	
	/**
	 * This function is required, to avoid recursive ModelElement rendering.
	 * 
	 * @param me the ModelElement which has been rendered to the Document
	 */
	public static void addRenderedModelElement(ModelElement me) {
		renderedModelElements.add(me.getModelElementId());
	}
	
	/**
	 * 
	 * @param me the ModelElement which shall be tested, if it has already been rednered
	 * 	to the document
	 * @return true, if the ModelElement has been rendered yet
	 */
	public static boolean hasAlreadyBeenRendered(ModelElement me) {
		return renderedModelElements.contains(me.getModelElementId());
	}
	
	/**
	 * Resets all HashSets. This function should be called before any document rendering is started.
	 */
	public static void initiateRenderedModelElements() {
		renderedModelElements = new HashSet<ModelElementId>();
		linkedModelElements = new HashSet<ModelElement>();
	}	
	
}
