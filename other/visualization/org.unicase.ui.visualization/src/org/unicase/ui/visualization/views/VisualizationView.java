/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.visualization.views;

import java.awt.Frame;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.observers.OperationListener;
import org.eclipse.emf.emfstore.client.ui.commands.ServerRequestCommandHandler;
import org.eclipse.emf.emfstore.server.exceptions.EmfStoreException;
import org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo;
import org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec;
import org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.ui.visualization.tree.UnicaseHyperbolicView;
import org.unicase.ui.visualization.tree.UnicaseNode;
import org.unicase.ui.visualization.tree.UnicaseSunburstView;
import org.unicase.ui.visualization.tree.UnicaseTree;
import org.unicase.ui.visualization.tree.UnicaseView;
import org.unicase.ui.visualization.util.VisualizationUtil;

/**
 * 
 * This view displays a visualization of the unicase projects.
 * 
 * @author Julian Sommerfeldt
 *
 */
public class VisualizationView extends ViewPart { 
	
	private ProjectSpace currentProjectSpace;
	private UnicaseNode selectedNode;
	
	private Composite parent;		
	private SashForm sashHor;
	
	private static final String CONTROL_SCALE = "controlScale";
	
	private HashMap<String, UnicaseView> views;
	private HashMap<String, Frame> frames;
	private HashMap<String, UnicaseTree> trees;
	
	private static final String LEFT = "left";
	private static final String RIGHT_UP_LEFT = "rightUpLeft";
	private static final String RIGHT_UP_RIGHT = "rightUpRight";
	private static final String RIGHT_DOWN_LEFT = "rightDownLeft";
	private static final String RIGHT_DOWN_RIGHT = "rightDownRight";
	
	private static final String MAIN_TREE = "mainTree";
	private static final String VERSION_1_TREE = "version1Tree";
	private static final String VERSION_2_TREE = "version2Tree";
	
	private List<String> locators;
	private List<String> treeIdentifier;
	
	private ISelectionListener selectionListener;
				
	/**
	 * Register the {@link SelectionListener}, to listen on Navigator selection.
	 * Also inits the UI.
	 * 
	 * @param p The parent control.
	 */
	@Override
	public void createPartControl(Composite p) {	
		this.parent = p;		
		parent.setLayout(new FillLayout(SWT.VERTICAL));		
				
		selectionListener =	new ISelectionListener() {
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {				
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				// check for project, build a tree and show it
				if (obj instanceof ProjectSpace) {										
					setProject((ProjectSpace) obj);	
					
				// check for other EObject and select the node in the visualization
				} else if(obj instanceof EObject){
					EObject eObj = (EObject)obj;										
					setProject(VisualizationUtil.getProjectSpace(eObj));										
					((UnicaseView)views.get(LEFT)).selectNode(trees.get(MAIN_TREE).getNodes().get(eObj));	
				}
			}
		};
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(selectionListener);
		
		views = new HashMap<String, UnicaseView>();	
		frames = new HashMap<String, Frame>();
		trees = new HashMap<String, UnicaseTree>();		
	}
	
	/**
	 * Updates the UI Structure. Differs between the normal one version and the two versions view.
	 * 
	 * @param twoVersions Display two versions at the same time?
	 */
	private void updateUIStructure(boolean twoVersions){
		// remove old controls 		
		for(Control c : parent.getChildren()){
			c.dispose();
		}
		getViewSite().getActionBars().getToolBarManager().remove(CONTROL_SCALE);
		getViewSite().getActionBars().updateActionBars();		
		
		// add new general structure
		sashHor = new SashForm(parent, SWT.HORIZONTAL);		
		frames.put(LEFT, SWT_AWT.new_Frame(new Composite(sashHor, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
		
		// differ between two and one version
		if(twoVersions){
			SashForm sashVerRight = new SashForm(sashHor, SWT.VERTICAL);
			SashForm sashVerRightHorUp = new SashForm(sashVerRight, SWT.HORIZONTAL);
			SashForm sashVerRightHorDown = new SashForm(sashVerRight, SWT.HORIZONTAL);
			
			frames.put(RIGHT_UP_LEFT, SWT_AWT.new_Frame(new Composite(sashVerRightHorUp, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
			frames.put(RIGHT_UP_RIGHT, SWT_AWT.new_Frame(new Composite(sashVerRightHorUp, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
				
			frames.put(RIGHT_DOWN_LEFT, SWT_AWT.new_Frame(new Composite(sashVerRightHorDown, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
			frames.put(RIGHT_DOWN_RIGHT, SWT_AWT.new_Frame(new Composite(sashVerRightHorDown, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
						
			locators = Arrays.asList(new String[]{LEFT, RIGHT_UP_LEFT, RIGHT_UP_RIGHT, RIGHT_DOWN_LEFT, RIGHT_DOWN_RIGHT});
			treeIdentifier = Arrays.asList(new String[]{MAIN_TREE, VERSION_1_TREE, VERSION_2_TREE});
		} else {
			frames.put(RIGHT_DOWN_LEFT, SWT_AWT.new_Frame(new Composite(sashHor, SWT.EMBEDDED | SWT.NO_BACKGROUND)));
			
			locators = Arrays.asList(new String[]{LEFT, RIGHT_DOWN_LEFT});
			treeIdentifier = Arrays.asList(new String[]{MAIN_TREE});
		}
		
		// re-layout the view
		parent.layout();
	}
	
	/**
	 * Resets the view completely.
	 */
	public void reset(){
		updateUIStructure(false);
		forceSetProject(currentProjectSpace);
	}
		
	/**
	 * Sets a {@link ProjectSpace}, when it is not already set.
	 * See {@link #forceSetProject(ProjectSpace)} to force the setting.
	 * 
	 * @param projectSpace The ProjectSpace to set.
	 */
	public void setProject(ProjectSpace projectSpace){
		if(projectSpace.equals(currentProjectSpace)){
			return;		
		}
		forceSetProject(projectSpace);
	}
	
	/**
	 * Forces setting a {@link ProjectSpace}.
	 * 
	 * @param projectSpace The new {@link ProjectSpace}.
	 */
	public void forceSetProject(ProjectSpace projectSpace){	
		if(currentProjectSpace != null){
			currentProjectSpace.getOperationManager().removeOperationListener(operationListener);
		}
		projectSpace.getOperationManager().addOperationListener(operationListener);
		
		currentProjectSpace = projectSpace;
		UnicaseTree tree = new UnicaseTree(new UnicaseNode(projectSpace));
		tree.addInfo("Version: " + projectSpace.getBaseVersion().getIdentifier());
		trees.put(MAIN_TREE, tree);
		
		updateUIStructure(false);
		
		for(String locator : locators) {
			views.put(locator, UnicaseSunburstView.createUnicaseSunburstView(tree, this));
		}
		setSelectedNode((UnicaseNode) tree.getRoot());
		updateView();
	}
	
	/**
	 * The {@link OperationListener}, which listens to the project, 
	 * to update the view on changes.
	 */
	private OperationListener operationListener = new OperationListener() {
		
		@Override
		public void operationUnDone(AbstractOperation operation) {
			forceSetProject(currentProjectSpace);
		}
		
		@Override
		public void operationExecuted(AbstractOperation operation) {
			forceSetProject(currentProjectSpace);
		}
	};
		
	/**
	 * Show two different versions of a project.
	 */
	public void showTwoVersionsView(){
		updateUIStructure(true);
		final VisualizationView vv = this;
		try {
			new ServerRequestCommandHandler() {
				
				@Override
				protected Object run() throws EmfStoreException {
					List<HistoryInfo> infos = trees.get(MAIN_TREE).getHistoryInfos();
					if(infos.size() != 2){
						return null;					
					}
										
					UnicaseTree tree = VisualizationUtil.getRevertedUnicaseTree(currentProjectSpace, infos.get(0).getPrimerySpec());
					trees.put(VERSION_1_TREE, tree);
					views.put(RIGHT_UP_LEFT, UnicaseSunburstView.createUnicaseSunburstView(tree, vv));
					
					tree = VisualizationUtil.getRevertedUnicaseTree(currentProjectSpace, infos.get(1).getPrimerySpec());
					trees.put(VERSION_2_TREE, tree);
					views.put(RIGHT_UP_RIGHT, UnicaseSunburstView.createUnicaseSunburstView(tree, vv));
					
					updateView();								
					return null;
				}
			}.execute(new ExecutionEvent());
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
	}
	
	private List<HistoryInfo> historyInfos;
	
	/**
	 * Show the version slider and get historyinfos for caching.
	 */
	public void showVersionSlider(){
		updateUIStructure(false);
		try {
			new ServerRequestCommandHandler() {
				
				@Override
				protected Object run() throws EmfStoreException {
					List<HistoryInfo> infos = trees.get(MAIN_TREE).getHistoryInfos();
					if(infos.size() != 2){
						return null;
					}
					updateUIForSliding(infos);						
					return null;
				}
			}.execute(new ExecutionEvent());
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}	
	}
	
	private void updateUIForSliding(List<HistoryInfo> infos){
		// save history infos
		historyInfos = VisualizationUtil.getHistoryInfos(currentProjectSpace, infos);
		
		// get selected versions
		final int min = infos.get(0).getPrimerySpec().getIdentifier();
		final int max = infos.get(1).getPrimerySpec().getIdentifier();
			
		// add scale with listener
		final ControlScale cs = new ControlScale(min < max ? min : max, max > min ? max : min);
		getViewSite().getActionBars().getToolBarManager().add(cs);					
		getViewSite().getActionBars().updateActionBars();
				
		final VisualizationView vv = this;
		cs.getScale().addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {        
				PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
				int version = cs.getScale().getSelection();
				versionSpec.setIdentifier(version);
				UnicaseTree tree = VisualizationUtil.getRevertedUnicaseTree(currentProjectSpace, versionSpec, historyInfos);			
//				tree.setChangedElements(
//						VisualizationUtil.getChangedElements(currentProjectSpace, 
//								VisualizationUtil.getHistoryInfos(currentProjectSpace, version, version)));
				trees.put(MAIN_TREE, tree);
				views.put(LEFT, UnicaseSunburstView.createUnicaseSunburstView(tree, vv));
				setSelectedNode(selectedNode);
				updateView();
            }
		});
							
		// update ui to max version
		PrimaryVersionSpec versionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		versionSpec.setIdentifier(max > min ? max : min);
		UnicaseTree tree = VisualizationUtil.getRevertedUnicaseTree(currentProjectSpace, versionSpec, historyInfos);
		trees.put(MAIN_TREE, tree);
		views.put(LEFT, UnicaseSunburstView.createUnicaseSunburstView(tree, this));
		updateView();
		
		parent.layout();		
	}
	
	/**
	 * Inner class to show slider in toolbar.
	 */
	class ControlScale extends ControlContribution {
				
		private int max;
		private int min;
		private ScaleWithText scaleWithText;
		 
		/**
		 * The Controlscale.
		 * 
		 * @param min The minimum of the scale.
		 * @param max The maximum of the scale.
		 */
	    ControlScale(int min, int max) {
	        super(CONTROL_SCALE);
	        this.max = max;
	        this.min = min;
	    }
	 
	    @Override
	    protected Control createControl(Composite parent) {
	    	scaleWithText = new ScaleWithText(parent, min, max);
	    	return scaleWithText;
	    }   
	    
	    /**
	     * @return The {@link Scale}.
	     */
	    Scale getScale(){
	    	return scaleWithText.scale;
	    }
	}
	
	/**
	 * A inner class to show the scale with the version.
	 */
	class ScaleWithText extends Canvas {
		 
        private Text text;
        private Scale scale;
        
        /**
         * @param parent The parent control
         * @param min The minimum of the scale.
         * @param max The maimum of the scale.
         */
        ScaleWithText(Composite parent, int min, int max) {
            super(parent, SWT.NONE);
            GridLayout gl = new GridLayout(2, false);
            this.setLayout(gl);
            text = new Text(this, SWT.NONE);
            text.setText(String.valueOf(max));
            
            scale = new Scale(this, SWT.NONE);            
            scale.setMinimum(min);
            scale.setMaximum(max);
            scale.setIncrement(1);
            scale.setSelection(max);
 
            scale.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {                    
                    text.setText(String.valueOf(scale.getSelection()));
                }
            });
 
            this.pack();
        }
    }
	
	/**
	 * Show a {@link UnicaseTree}, filtered by type.
	 * 
	 * @param eClassTypes The type to filter. Set to null to show non filtered tree.
	 */
	public void showFiltered(List<EClass> eClassTypes){
		for(String s : treeIdentifier){
			trees.put(s, getValidTree(s).getFilteredUnicaseTree(eClassTypes));		
		}
		setViews();
		updateView();
	}
		
	/**
	 * Set the currently selected {@link UnicaseNode}.
	 * 
	 * @param node The {@link UnicaseNode}, which is selected.
	 */
	public void setSelectedNode(UnicaseNode node){
		if(node == null){
			return;
		}
		selectedNode = node;
		views.put(RIGHT_DOWN_LEFT, new UnicaseHyperbolicView(getValidTree(VERSION_1_TREE), node));
		views.put(RIGHT_DOWN_RIGHT, new UnicaseHyperbolicView(getValidTree(VERSION_2_TREE), node));
		for(UnicaseView view : views.values()){
			view.selectNode(node);
		}
		updateView();
	}
	
	/**
	 * Reload and update all views.
	 */
	private void setViews(){
		views.put(LEFT, UnicaseSunburstView.createUnicaseSunburstView(trees.get(MAIN_TREE), this));
		views.put(RIGHT_UP_LEFT, UnicaseSunburstView.createUnicaseSunburstView(getValidTree(VERSION_1_TREE), this));
		views.put(RIGHT_UP_RIGHT, UnicaseSunburstView.createUnicaseSunburstView(getValidTree(VERSION_2_TREE), this));
	}
	
	/**
	 * Returns a not null tree. 
	 * 
	 * @param identifier The identifier to identify the tree.
	 * @return The {@link UnicaseTree}, which is identified by the identifier or the main tree if it is null.
	 */
	private UnicaseTree getValidTree(String identifier){
		return trees.get(identifier) == null ? trees.get(MAIN_TREE) : trees.get(identifier);
	}
	
	/**
	 * Update the UI.
	 */
	public void updateView() {
		Display.getDefault().syncExec(new Runnable() {
			
			@Override
			public void run() {
				parent.setRedraw(false);
				for(String locator : locators){
					Frame f = frames.get(locator);
					f.removeAll();
					UnicaseView view = views.get(locator);
					if(view != null) f.add(view.getView());
					f.validate();
				}		
				parent.setRedraw(true);
			}
		});
	}
	
	/**
	 * Repaints and updates all views.
	 */
	public void repaintAndUpdateViews(){
		for(UnicaseView view : views.values()){
			view.repaintView();
		}
		updateView();
	}
	
	/**
	 * Set focus to the main composite.
	 */
	@Override
	public void setFocus() {
		parent.setFocus();
	}
	
	@Override
	public void dispose(){
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().removeSelectionListener(selectionListener);
		super.dispose();
	}

	/**
	 * Get the {@link UnicaseView}.
	 *  
	 * @return the current {@link UnicaseView}.
	 */
	public UnicaseView getView() {
		return views.get(LEFT);
	}
	
	/**
	 * Get all Views. 
	 * 
	 * @return All {@link UnicaseView}s.
	 */
	public Collection<UnicaseView> getViews(){
		return views.values();
	}
}
