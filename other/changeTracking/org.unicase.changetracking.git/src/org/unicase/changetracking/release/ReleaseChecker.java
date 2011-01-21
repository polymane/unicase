package org.unicase.changetracking.release;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.unicase.changetracking.common.PrintfFormat;
import org.unicase.changetracking.release.Problem.Severity;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.ChangeTrackingRelease;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.Stream;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;

public class ReleaseChecker {

	private static final String WARNING_REPO_NOT_UP_TO_DATE = "Your local repository is not up to date. Some information might be outdated.";
	private static final String ERROR_INCOMPATIBLE_CHANGE_PACKAGE = 
		"The change package '%s' is not a Git branch change package." +
		"Only these are allowed at the moment";
	private static final String ERROR_MISSING_BRANCH = 
		"The change package '%s' has no branch set.";
	private static final String ERROR_MISSING_LOCATION = "The branch '%s' which is used by the change package '%s' has no repository location.";
	private static final String ERROR_DIFFERENT_LOCATIONS = "The change packages use different locations. All change packages must use the same location.\nLocations used:\n%s\n%s";
	private static final String ERROR_BRANCH_NOT_IN_LOCAL_REPO = "The branch 'refs/heads/%s' (label: '%s', used by change package '%s') was not found in the local repository. If you haven't updated, the branch might not be pulled yet. Please update.";
	private static final String ERROR_DUPLICATE_BRANCH = "The branch '%s' is used by more than one change package (%s, %s).";
	private static final String ERROR_DUPLICATE_BRANCH_MAPPING = "Two unicase branches (%s, %s) use the same git branch (%s).";
	private static final String ERROR_RELEASE_HAS_NO_STREAM = "No stream is assigned to the release.";
	private static final String ERROR_STREAM_HAS_NO_REPO_STREAM = "The stream %s of the release has not associated a repository stream.";
	private static final String ERROR_INCOMPATIBLE_REPO_STREAM = "The repository stream '%s' associated with the stream of the release is no Git branch. Only these are supported at the moment.";
	private static final String ERROR_LOCATION_MISMATCH = "The repository location '%s' used for the change packages is not the same as the stream location of the release (%s).";
	private static final String ERROR_RELEASE_STREAM_IS_MISSING_LOCATION = "The repository stream '%s' which is associated with the stream of the release has no repository location.";
	private static final String ERROR_IO_EXCEPTION_WHILE_PARSING_COMMIT = "An IO Exception occurred while parsing the branch '%s' from the local repository. Retry and check that the local repository is not inaccessible.";
	private static final String ERROR_REF_IS_NO_COMMIT = "The branch head '%s' is no commit. Your local repository seems to be severly damaged. Reclone from remote.";
	private static final String ERROR_MISSING_COMMIT = "The commit to which the branch head '%s' points is missing.  Your local repository seems to be severly damaged. Reclone from remote." ;
	private static final String ERROR_RELEASE_BRANCH_NOT_FOUND = "The git branch associated with the stream of the release does not exist in the local repository.";
	
	private ChangeTrackingRelease release;
	private Repository localRepo;
	private List<Problem> errorMessages = new ArrayList<Problem>();
	private RepositoryLocation releaseStreamLocation;
	private GitBranch releaseBranch;
	private RevWalk revWalk;
	private Map<String, Ref> refMap;
	private boolean repoIsUpToDate;
	
	public static ReleaseCheckReport check(Repository localRepo, ChangeTrackingRelease release, boolean repoIsUpToDate){
		return new ReleaseChecker(localRepo, release, repoIsUpToDate).check();
	}
	
	private ReleaseChecker(Repository localRepo, ChangeTrackingRelease release, boolean repoIsUpToDate){
		this.localRepo = localRepo;
		this.release = release;
		this.repoIsUpToDate = repoIsUpToDate;
		if(localRepo != null){
			this.revWalk = new RevWalk(localRepo);
			this.refMap = localRepo.getAllRefs();
		}
	}
	
	private void addError(String errorString){
		errorMessages.add(new Problem(Severity.ERROR,errorString));
	}
	
	private void addError(String formatString, String argument){
		errorMessages.add(new Problem(Severity.ERROR,new PrintfFormat(formatString).sprintf(argument)));
	}
	
	private void addError(String formatString, Object... arguments){
		errorMessages.add(new Problem(Severity.ERROR,new PrintfFormat(formatString).sprintf(arguments)));
	}
	
	private void addWarning(String errorString){
		errorMessages.add(new Problem(Severity.WARNING,errorString));
	}
	
	public ReleaseCheckReport check(){
		//Retrieve all change packages
		List<ChangePackage> changePackages = ReleaseUtil.getChangePackagesFromRelease(release);
	
		//Check the release itself (its stream and the streams location)
		checkRelease();
		
		//Check the change packages and their referenced branches and locations
		Map<GitBranch, ChangePackage> branchMap = checkChangePackages(changePackages);
		
		//If the repository is not checked out, we cannot do further checks.
		if(localRepo == null){
			return new ReleaseCheckReport(changePackages, errorMessages,false);
		}
		
		//If a repo exists and is not up to date, add this as error Message
		addWarning(WARNING_REPO_NOT_UP_TO_DATE);
		
		//Check if the branches exist in the local repository and do not collide
		Map<Ref, GitBranch> branchMapping = checkLocalBranches(branchMap);
		
		//Check that all referenced Refs are actually commits and build
		//the mapping from RevCommit to change package which will be used
		//to determine which packages are merged.
		Map<RevCommit, List<ChangePackage>> commitMapping = checkForCommits(branchMap,branchMapping);
		
		//Check release branch
		RevCommit releaseBranchHead = checkReleaseBranch();
		
		//Using all the gathered information,
		//we can now check which branches are already merged
		Map<RevCommit, BranchState> mergeStatus = calcMergeState(releaseBranchHead,commitMapping);
		
		//From the branch state mapping, we can infer the state mapping of the change packages
		Map<ChangePackage, BranchState> changePackageState = calcChangePackageState(commitMapping, mergeStatus, changePackages);
		
		//All relevant information has been gathered, create and return a report
		return new ReleaseCheckReport(changePackages, errorMessages, true, repoIsUpToDate, changePackageState);
	}



	private Map<ChangePackage, BranchState> calcChangePackageState(
			Map<RevCommit, List<ChangePackage>> commitMapping,
			Map<RevCommit, BranchState> mergeStatus, List<ChangePackage> changePackages) {
		
		Map<ChangePackage, BranchState> result = new HashMap<ChangePackage, BranchState>();
		
		//For the registered commits, register the packages
		for(Entry<RevCommit, BranchState> e: mergeStatus.entrySet()){
			BranchState mergeState = e.getValue();
			for(ChangePackage cp : commitMapping.get(e.getKey())){
				result.put(cp, mergeState);
			}
		}
		
		//For all other packages, add the error state
		for(ChangePackage cp : changePackages){
			if(!result.containsKey(cp)){
				result.put(cp, BranchState.ERROR);
			}
		}
		
		return result;
	}

	private RevCommit checkReleaseBranch() {
		//If either the release branch or its location couldn't be calculated,
		//the commit cannot be inferred.
		if(releaseBranch == null || releaseStreamLocation == null)
			return null;
		
		String branchName = releaseBranch.getBranchName();
		String refName = "refs/heads/" + branchName;
		
		Ref ref = refMap.get(refName);
		if(ref == null){
			addError(ERROR_RELEASE_BRANCH_NOT_FOUND);
			return null;
		}
		
		RevCommit c;
		try {
			c = revWalk.parseCommit(ref.getObjectId());
		} catch (MissingObjectException e) {
			addError(ERROR_MISSING_COMMIT,ref.getName());
			return null;
		} catch (IncorrectObjectTypeException e) {
			addError(ERROR_REF_IS_NO_COMMIT,ref.getName());
			return null;
		} catch (IOException e) {
			addError(ERROR_IO_EXCEPTION_WHILE_PARSING_COMMIT,ref.getName());
			return null;
		}
		
		return c;
	}

	private Map<RevCommit, BranchState> calcMergeState(
			RevCommit releaseBranchHead, Map<RevCommit, List<ChangePackage>> commitMapping) {
		if(releaseBranchHead == null){
			return new HashMap<RevCommit, BranchState>();
		}
		
		return new GitMergeHistoryBuilder(localRepo).build(releaseBranchHead, commitMapping.keySet());
		
	}

	private Map<RevCommit, List<ChangePackage>> checkForCommits(
			Map<GitBranch, ChangePackage> branchMap,
			Map<Ref, GitBranch> branchMapping) {
		Map<RevCommit, List<ChangePackage>> result = new HashMap<RevCommit, List<ChangePackage>>();
		
		
		for(Entry<Ref, GitBranch> e : branchMapping.entrySet()){
			
			//Check that this ref is a valid commit
			Ref ref = e.getKey();
			RevCommit commit;
			try {
				commit = revWalk.parseCommit(ref.getObjectId());
			} catch (MissingObjectException e1) {
				addError(ERROR_MISSING_COMMIT,ref.getName());
				continue;
			} catch (IncorrectObjectTypeException e1) {
				addError(ERROR_REF_IS_NO_COMMIT,ref.getName());
				continue;
			} catch (IOException e1) {
				addError(ERROR_IO_EXCEPTION_WHILE_PARSING_COMMIT,ref.getName());
				continue;
			}
			
			//No error. Build the mapping for this commit
			ChangePackage changePackage = branchMap.get(e.getValue());
			List<ChangePackage> list = result.get(commit);
			if(list == null){
				list = new ArrayList<ChangePackage>();
				result.put(commit, list);
			}
			list.add(changePackage);
		}
		
		return result;
	}

	private void checkRelease() {
		
		//Release has a stream assigned?
		Stream stream = release.getStream();
		if(stream == null){
			addError(ERROR_RELEASE_HAS_NO_STREAM);
			return;
		}
		
		//Stream has a repository stream?
		RepositoryStream repoStream = stream.getRepositoryStream();
		if(repoStream == null){
			addError(ERROR_STREAM_HAS_NO_REPO_STREAM,stream.getName());
			return;
		}
		
		//Repo stream is a git branch?
		if(!(repoStream instanceof GitBranch)){
			addError(ERROR_INCOMPATIBLE_REPO_STREAM,repoStream.getName());
			return;
		}
		releaseBranch = (GitBranch) repoStream;
		
		//Repo stream has a location?
		releaseStreamLocation = repoStream.getLocation();
		if(releaseStreamLocation == null){
			addError(ERROR_RELEASE_STREAM_IS_MISSING_LOCATION,repoStream.getName());
			return;
		}
	}

	private Map<GitBranch, ChangePackage> checkChangePackages(List<ChangePackage> changePackages) {
		Map<GitBranch, ChangePackage> branchMap = new HashMap<GitBranch, ChangePackage>();
		RepositoryLocation lastLocation = null;
		for(ChangePackage cp: changePackages ){
			
			//Only git branch change packages are allowed at the moment
			if(!(cp instanceof GitBranchChangePackage)){
				addError(ERROR_INCOMPATIBLE_CHANGE_PACKAGE, cp.getName());
				continue;
			}
						
			//The branch may not be missing
			GitBranchChangePackage gbcp = (GitBranchChangePackage) cp;
			GitBranch branch = gbcp.getBranch();
			if(branch == null){
				addError(ERROR_MISSING_BRANCH, cp.getName());
				continue;
			}
			
			//The branch needs a location
			RepositoryLocation location = branch.getLocation();
			if(location == null){
				addError(ERROR_MISSING_LOCATION,branch.getName(),cp.getName());
				continue;
			}
			
			//All locations must match
			if(lastLocation != null && lastLocation != location){
				addError(ERROR_DIFFERENT_LOCATIONS,location.getName(),lastLocation.getName());
				continue;
			}
			lastLocation = location;
			
			//Check that the locations of the branches match the location of the release stream.
			if(releaseStreamLocation != null && location != releaseStreamLocation){
				addError(ERROR_LOCATION_MISMATCH,lastLocation.getName(), releaseStreamLocation.getName());
			}
			
			
			//No two changepackages may use the same branch
			if(branchMap.containsKey(branch)){
				addError(ERROR_DUPLICATE_BRANCH,branch.getName(),branchMap.get(branch).getName(),cp.getName());
				continue;
			}
			
			//No errors? Then add to branch map.
			branchMap.put(branch, cp);
			
		}
		
	
		return branchMap;
	}
	
	private Map<Ref, GitBranch> checkLocalBranches(Map<GitBranch, ChangePackage> branchMap) {
		
		Map<Ref, GitBranch> result = new HashMap<Ref, GitBranch>(); 

		for(Entry<GitBranch, ChangePackage> e : branchMap.entrySet()){
			GitBranch branch = e.getKey();
			String refName = "refs/heads/" + branch.getBranchName();
			
			//Check that the branch exists in the repo
			if(!refMap.containsKey(refName)){
				addError(ERROR_BRANCH_NOT_IN_LOCAL_REPO, branch.getBranchName(), branch.getName(),e.getValue().getName());
				continue;
			}
			
			//Check for duplicate branch mappings
			Ref ref = refMap.get(refName);
			if(result.containsKey(ref)){
				addError(ERROR_DUPLICATE_BRANCH_MAPPING,branch.getName(),result.get(ref).getName(),ref.getName());
				continue;
			}
			
			//Everything okay. So put it into the result
			result.put(ref,branch);
		}
		
		return result;
	}


}