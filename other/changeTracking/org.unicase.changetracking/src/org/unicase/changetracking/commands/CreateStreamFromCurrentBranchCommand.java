package org.unicase.changetracking.commands;

import org.eclipse.core.resources.IProject;
import org.unicase.changetracking.common.ChangeTrackingUtil;
import org.unicase.changetracking.common.IDecisionProvider;
import org.unicase.changetracking.common.IDecisionProvider.PlacementAndNameDecision;
import org.unicase.changetracking.exceptions.CancelledByUserException;
import org.unicase.changetracking.exceptions.VCSException;
import org.unicase.changetracking.vcs.VCSAdapter;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.changetracking.ChangetrackingFactory;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;

public class CreateStreamFromCurrentBranchCommand extends CreateStreamCommand {

	private IProject workspaceProject;
	private IDecisionProvider decisionProvider;
	private VCSAdapter vcs;
	private Stream stream;

	public CreateStreamFromCurrentBranchCommand(VCSAdapter vcs, IDecisionProvider decisionProvider,IProject workspaceProject) {
		this.workspaceProject = workspaceProject;
		this.decisionProvider = decisionProvider;
		this.vcs = vcs;
	}
	
	@Override
	protected ChangeTrackingCommandResult doRun() {
		
		try {
			
			stream = ChangetrackingFactory.eINSTANCE.createStream();
			
			PlacementAndNameDecision placementDecision = decisionProvider.decideModelElementPlacementAndName(stream, "");
		
			
			Project project = ModelUtil.getProject(placementDecision.getDestination());
			
			//Find a matching repository location in the project
			RepositoryLocation repoLocation = vcs.findRepoLocation(workspaceProject, project);
			
			//Ask the version control adapter to create a repository stream from the current branch
			RepositoryStream repoStream = vcs.createRepositoryStream(workspaceProject, repoLocation);
			
			
			//No repo found? Ask the user what to do...
			if(repoLocation == null){
				if(decisionProvider.decideCreateRepoLocation()){
					repoLocation = vcs.createRepositoryLocation(workspaceProject);
					ChangeTrackingUtil.putInto(repoLocation, placementDecision.getDestination());
					
				}
			}
			
			//*** Create and add the stream and the branch.
			//1. place the stream
			placementDecision.executeDecision();
			
			//2. link and place the branch (in the same folder)
			repoStream.setLocation(repoLocation);
			stream.setRepositoryStream(repoStream);
			ChangeTrackingUtil.putInto(repoStream, placementDecision.getDestination());

		} catch (CancelledByUserException e) {
			return cancelResult();
		} catch (VCSException e) {
			return errorResult(e);
		}

		return successResult("Stream successfully created.");
	}
	



	@Override
	public boolean needsProgressMonitor() {
		return false;
	}

	@Override
	public Stream getCreatedStream() {
		return stream;
	}

}
