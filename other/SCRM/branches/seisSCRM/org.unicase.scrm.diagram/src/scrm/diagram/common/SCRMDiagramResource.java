package scrm.diagram.common;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.DOMHandler;
import org.eclipse.emf.ecore.xmi.DOMHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.ui.common.commands.ECPCommand;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.WorkspaceUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import scrm.SCRMDiagram;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.part.ScrmDiagramEditorPlugin;
import scrm.impl.DiagramLoadException;

public class SCRMDiagramResource extends ResourceImpl implements Resource, Resource.Factory, Resource.Internal,
	XMLResource {
	
	private boolean initialized;
	private SCRMDiagram scrmDiagram;
	private Diagram diagram;
	private EList<EObject> list;
	
	public SCRMDiagramResource() {
		super();
	}
	
	public SCRMDiagramResource(SCRMDiagram scrmDiagram) {
		super();
		this.scrmDiagram = scrmDiagram;
	}
	
	@Override
	public EList<EObject> getContents() {
		if (!initialized) {
			initialize();
			list = new BasicEList<EObject>();
			list.add(scrmDiagram);
			list.add(scrmDiagram.getGmfdiagram());
			initialized = true;
		}
		return list;
	}

	private void initialize() {
		new ECPCommand(scrmDiagram) {
			@Override
			protected void doRun() {
				try {
					scrmDiagram.loadDiagramLayout();
				} catch (DiagramLoadException e) {
					if (!(e.getCause() instanceof NullPointerException)) {
						WorkspaceUtil.logException("Loading diagram layout failed", e);
					}
				}
			}
		}.run(true);
		
		if (scrmDiagram.getGmfdiagram() == null) {
			createNewGMFDiagram();
		}
	}
	
	private void createNewGMFDiagram() {

		if (scrmDiagram.getGmfdiagram() != null) {
			return;
		}

		diagram = ViewService.createDiagram(scrmDiagram, SCRMDiagramEditPart.MODEL_ID,
				ScrmDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);

		diagram.setElement(scrmDiagram);

		new ECPCommand(scrmDiagram) {

			@Override
			protected void doRun() {
				scrmDiagram.setGmfdiagram(diagram);
			}

		}.run(true);
	}

	public Resource createResource(URI uri) {
		Resource resource = WorkspaceManager.getInstance().getCurrentWorkspace().eResource();
		ResourceSet rs = resource.getResourceSet();
		EObject object = rs.getEObject(uri, false);
		if (object instanceof SCRMDiagram) {
			return new SCRMDiagramResource((SCRMDiagram) object);
		} else {
			throw new IllegalArgumentException("Only SCRMDiagrams supported");
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void delete(Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public TreeIterator<EObject> getAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public EObject getEObject(String uriFragment) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public ResourceSet getResourceSet() {
		return scrmDiagram.eResource().getResourceSet();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public long getTimeStamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Forwards the URI of unicase Resource.
	 * 
	 * @return returns URI
	 */
	@Override
	public URI getURI() {
		return scrmDiagram.eResource().getURI();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public String getURIFragment(EObject object) {
		String uriFragment = super.getURIFragment(object);
		return uriFragment;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public EList<Diagnostic> getWarnings() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isLoaded() {

		return scrmDiagram.eResource().isLoaded();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isTrackingModification() {
		// JH has to be false, otherwise nullpointer
		return super.isTrackingModification();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void load(Map<?, ?> options) throws IOException {
		scrmDiagram.eResource().load(options);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void save(Map<?, ?> options) throws IOException {
		scrmDiagram.eResource().save(options);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setModified(boolean isModified) {
		scrmDiagram.eResource().setModified(isModified);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setTimeStamp(long timeStamp) {
		scrmDiagram.eResource().setTimeStamp(timeStamp);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setTrackingModification(boolean isTrackingModification) {
		scrmDiagram.eResource().setTrackingModification(isTrackingModification);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setURI(URI uri) {
		scrmDiagram.eResource().setURI(uri);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean eDeliver() {
		return scrmDiagram.eResource().eDeliver();
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void eNotify(Notification notification) {
		scrmDiagram.eResource().eNotify(notification);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void eSetDeliver(boolean deliver) {
		scrmDiagram.eResource().eSetDeliver(deliver);
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void attached(EObject object) {
		// JH Implement this?
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public NotificationChain basicSetResourceSet(ResourceSet resourceSet, NotificationChain notifications) {

		// JH Check what this is for. This is called and maybe causes trouble
		return super.basicSetResourceSet(resourceSet, notifications);

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void detached(EObject object) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean isLoading() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	public DOMHelper getDOMHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultLoadOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<Object, Object> getDefaultSaveOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<EObject, AnyType> getEObjectToExtensionMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<EObject, String> getEObjectToIDMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getID(EObject object) {
		// JH super?
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public Map<String, EObject> getIDToEObjectMap() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getPublicId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getSystemId() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public String getXMLVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public void load(Node node, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void load(InputSource inputSource, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void save(Writer writer, Map<?, ?> options) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public Document save(Document document, Map<?, ?> options, DOMHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * . {@inheritDoc}
	 */
	public void setDoctypeInfo(String publicId, String systemId) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setEncoding(String encoding) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setID(EObject object, String id) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setUseZip(boolean useZip) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	public void setXMLVersion(String version) {
		// TODO Auto-generated method stub

	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public boolean useZip() {
		// TODO Auto-generated method stub
		return super.useZip();
	}
	
}