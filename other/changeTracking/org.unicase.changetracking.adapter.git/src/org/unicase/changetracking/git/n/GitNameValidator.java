package org.unicase.changetracking.git.n;

import org.unicase.changetracking.git.GitNameUtil;
import org.unicase.changetracking.git.GitRepoFindUtil;
import org.unicase.changetracking.vcs.NameValidator;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.git.GitRepository;

public class GitNameValidator implements NameValidator{

	@Override
	public String cleanName(String name) {
		return GitNameUtil.cleanName(name);
	}

	@Override
	public String isNewTagNameValid(String text, RepositoryLocation repoLoc) {
		return GitNameUtil.isNewTagNameValid(text, GitRepoFindUtil.findAssociatedLocalRepo((GitRepository) repoLoc));
	}

}
