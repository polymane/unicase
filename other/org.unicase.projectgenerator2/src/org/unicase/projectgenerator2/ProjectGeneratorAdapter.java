package org.unicase.projectgenerator2;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.unicase.metamodel.Project;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

public class ProjectGeneratorAdapter implements IProjectGenerator {

private IProjectGenerator projectGeneratorObj;

	protected ProjectGeneratorAdapter(IProjectGenerator projectGeneratorImpl) {
		this.projectGeneratorObj = projectGeneratorImpl;
	}
	
	public void generateValues() {
		
		new UnicaseCommand() {
			@Override
			protected void doRun() {
				final Project project = WorkspaceManager.getInstance().getCurrentWorkspace().createLocalProject("Generated Project", "Generated").getProject();
				
				/*
				EObject rootElement = ProjectGeneratorUtil.createEObject(ProjectGeneratorUtil.getModelElementEClasses(pckge, "CompositeSection"));
				ProjectGeneratorImpl impl = new ProjectGeneratorImpl(pckge, 2, 5, 5);
				impl.setRootObject(rootElement);
				impl.generateValues();
				*/
				projectGeneratorObj.generateValues();
				project.addModelElement(projectGeneratorObj.getRootObject());
			}
		}.run();
	}

	public long getHierachyDepth() {
		
		return this.projectGeneratorObj.getHierachyDepth();
	}

	public long getNoOfExampleValues() {
		return this.projectGeneratorObj.getNoOfExampleValues();
	}

	public EObject getRootObject() {
		return projectGeneratorObj.getRootObject();
	}

	public EPackage getRootPackage() {
		return projectGeneratorObj.getRootPackage();
	}

	public long getSeed() {
		return projectGeneratorObj.getSeed();
	}

	public void setHierachyDepth(long hierachyDepth) {
		projectGeneratorObj.setHierachyDepth(hierachyDepth);
		
	}

	public void setNoOfExampleValues(long noOfExampleValues) {
		projectGeneratorObj.setNoOfExampleValues(noOfExampleValues);
	}

	public void setRootObject(EObject root) {
		projectGeneratorObj.setRootObject(root);
	}

	public void setRootPackage(EPackage rootPackage) {
		projectGeneratorObj.setRootPackage(rootPackage);
	}

	public void setSeed(long seed) {
		projectGeneratorObj.setSeed(seed);
	}

	
}
