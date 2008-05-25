package org.unicase.emfstore;

import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.change.ChangeFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.EsmodelFactory;
import org.unicase.esmodel.ProjectHistory;
import org.unicase.esmodel.ProjectId;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.ServerSpace;
import org.unicase.esmodel.SessionId;
import org.unicase.esmodel.changemanagment.ChangePackage;
import org.unicase.esmodel.changemanagment.ChangemanagmentFactory;
import org.unicase.esmodel.changemanagment.HeadVersionSpec;
import org.unicase.esmodel.changemanagment.HistoryInfo;
import org.unicase.esmodel.changemanagment.LogMessage;
import org.unicase.esmodel.changemanagment.PrimaryVersionSpec;
import org.unicase.esmodel.changemanagment.TagVersionSpec;
import org.unicase.esmodel.changemanagment.Version;
import org.unicase.esmodel.changemanagment.VersionSpec;
import org.unicase.esmodel.changemanagment.impl.ChangemanagmentFactoryImpl;
import org.unicase.model.CompositeSection;
import org.unicase.model.FunctionalRequirement;
import org.unicase.model.LeafSection;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelFactory;
import org.unicase.model.Project;

public class EmfStoreStub implements EmfStore {

	public PrimaryVersionSpec createVersion(SessionId sessionId,
			ProjectId projectId, PrimaryVersionSpec baseVersionSpec,
			ChangePackage changePackage, LogMessage logMessage)
			throws EmfStoreException {
		// MK Auto-generated method stub
		return null;
	}

	public List<ChangePackage> getChanges(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// MK Auto-generated method stub
		return null;
	}

	public List<HistoryInfo> getHistoryInfo(SessionId sessionId,
			ProjectId projectId, VersionSpec source, VersionSpec target)
			throws EmfStoreException {
		// MK Auto-generated method stub
		return null;
	}

	public Project getProject(SessionId sessionId, ProjectId projectId,
			VersionSpec versionSpec) throws EmfStoreException {
		return createDummyProject();
	}

	public List<ProjectInfo> getProjectList(SessionId sessionId)
			throws EmfStoreException {
		EList<ProjectInfo> ret = new BasicEList<ProjectInfo>();
		
		ProjectId projectId = EsmodelFactory.eINSTANCE.createProjectId();
		
		HeadVersionSpec headVersionSpec = ChangemanagmentFactoryImpl.eINSTANCE.createHeadVersionSpec();
		
		ProjectInfo projectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
		projectInfo.setName("TestProject");
		projectInfo.setDescription("A test Project");
		projectInfo.setProjectId(projectId);
		projectInfo.setVersion(ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec());
		
		ret.add(projectInfo);
		return ret;
	}

	public PrimaryVersionSpec resolveVersionSpec(SessionId sessionId,
			VersionSpec versionSpec) throws EmfStoreException {
		PrimaryVersionSpec primaryVersionSpec = ChangemanagmentFactory.eINSTANCE.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(1);
		return primaryVersionSpec;
	}
	
	private Project createDummyProject() {
		// Generate the elements of the model
		
		ModelFactory factory = ModelFactory.eINSTANCE;
		Project project = factory.createProject();
		CompositeSection rootSection = factory.createCompositeSection();
		rootSection.setName("RAD");
		rootSection
				.setDescription("The requirements analysis document of the project");

		LeafSection reqLeafSection = factory.createLeafSection();
		reqLeafSection.setName("Functional Requirements");
		reqLeafSection
				.setDescription("Lists all functional requirements in this project");
		reqLeafSection.setElementClass(FunctionalRequirement.class);

		reqLeafSection.setParent(rootSection);

		LeafSection scenLeafSection = factory.createLeafSection();
		scenLeafSection.setName("Scenarios");
		scenLeafSection.setDescription("Lists all scenarios of this project.");
		scenLeafSection.setParent(rootSection);
		scenLeafSection.setElementClass(FunctionalRequirement.class);
		
		CompositeSection ucmCompositeSection = factory.createCompositeSection();
		ucmCompositeSection.setName("Use Case Modeling");
		ucmCompositeSection
				.setDescription("Contains sections concerning use cases.");
		ucmCompositeSection.setParent(rootSection);

		LeafSection actorLeafSection = factory.createLeafSection();
		actorLeafSection.setName("Actors");
		actorLeafSection.setDescription("Lists all actors of this project.");
		actorLeafSection.setParent(ucmCompositeSection);
		actorLeafSection.setElementClass(FunctionalRequirement.class);

		LeafSection useCaseLeafSection = factory.createLeafSection();
		useCaseLeafSection.setName("Use Cases");
		useCaseLeafSection
				.setDescription("Lists all use cases of this project.");
		useCaseLeafSection.setParent(ucmCompositeSection);
		useCaseLeafSection.setElementClass(FunctionalRequirement.class);

		LeafSection useCaseDiagramLeafSection = factory.createLeafSection();
		useCaseDiagramLeafSection.setName("Use Case Diagrams");
		useCaseDiagramLeafSection
				.setDescription("Lists all use case diagrams of this project.");
		useCaseDiagramLeafSection.setParent(ucmCompositeSection);
		useCaseDiagramLeafSection.setElementClass(FunctionalRequirement.class);
		
		
		useCaseDiagramLeafSection.setName("Use Case Diagrams");
		useCaseDiagramLeafSection
				.setDescription("Lists all use case diagrams of this project.");
		useCaseDiagramLeafSection.setParent(ucmCompositeSection);
		useCaseDiagramLeafSection.setElementClass(FunctionalRequirement.class);

		FunctionalRequirement fr = factory.createFunctionalRequirement();
		fr.setName("My Reuirement");
		
		FunctionalRequirement fr2 = factory.createFunctionalRequirement();
		fr2.setName("My Reuirement2");
		
		


		EList<ModelElement> projectElements = project.getModelElements();
		projectElements.add(fr);
		projectElements.add(fr2);
		projectElements.add(rootSection);
		return project;
		// end of generation
	}

	public void createDummyProjectHistories(ServerSpace serverSpace) {
		EsmodelFactory esmodelFactory = EsmodelFactory.eINSTANCE;
		ProjectHistory projectHistory = esmodelFactory.createProjectHistory();
		projectHistory.setProjectDescription("This is a autogen test project");
		projectHistory.setProjectId(esmodelFactory.createProjectId());
		projectHistory.setProjectName("TestProject1");
		ChangemanagmentFactory changemanagmentFactory = ChangemanagmentFactory.eINSTANCE;
		
		//create Version
		ChangemanagmentFactory changemanagmentFactory2 = changemanagmentFactory;
		Version version = changemanagmentFactory2.createVersion();
		TagVersionSpec tagVersionSpec = changemanagmentFactory2.createTagVersionSpec();
		tagVersionSpec.setName("InitialVersion");
		version.getTagSpecs().add(tagVersionSpec);
		LogMessage logMessage = changemanagmentFactory2.createLogMessage();
		logMessage.setDate(new Date());
		logMessage.setAuthor("es");
		logMessage.setMessage("Auto generated");
		version.setLogMessage(logMessage);
		PrimaryVersionSpec primaryVersionSpec = changemanagmentFactory.createPrimaryVersionSpec();
		primaryVersionSpec.setIdentifier(0);
		version.setPrimarySpec(primaryVersionSpec);
		//version.setProjectState(createDummyProject());
		
		projectHistory.getVersions().add(version);
		serverSpace.getProjects().add(projectHistory);
	}


}
