/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
/*******************************************************************************
 * Copyright (C) 2007, Dave Watson <dwatson@mimvista.com>
 * Copyright (C) 2008, Robin Rosenberg <robin.rosenberg@dewire.com>
 * Copyright (C) 2008, Roger C. Soares <rogersoares@intelinet.com.br>
 * Copyright (C) 2008, Shawn O. Pearce <spearce@spearce.org>
 * Copyright (C) 2008, Marek Zawirski <marek.zawirski@gmail.com>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.unicase.changetracking.git.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.egit.core.CoreText;
import org.eclipse.egit.core.EclipseGitProgressTransformer;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.Transport;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.osgi.util.NLS;

/**
 * Clones a repository from a remote location to a local location.
 * 
 * Copy Pasted from EGit (their implementation is in a non-exported
 * package, so I could not import it...)
 * 
 * @author jfinis
 */
 
// BEGIN COMPLEX CODE
public class GitCloneOperation {
	private final URIish uri;

	private final boolean allSelected;

	private final Collection<Ref> selectedBranches;

	private final File workdir;

	private final File gitdir;

	private final String branch;

	private final String remoteName;

	private final int timeout;

	private FileRepository local;

	private RemoteConfig remoteConfig;

	private FetchResult fetchResult;

	/**
	 * Create a new clone operation.
	 *
	 * @param uri
	 *            remote we should fetch from.
	 * @param allSelected
	 *            true when all branches have to be fetched (indicates wildcard
	 *            in created fetch refspec), false otherwise.
	 * @param selectedBranches
	 *            collection of branches to fetch. Ignored when allSelected is
	 *            true.
	 * @param workdir
	 *            working directory to clone to. The directory may or may not
	 *            already exist.
	 * @param branch
	 *            branch to initially clone from.
	 * @param remoteName
	 *            name of created remote config as source remote (typically
	 *            named "origin").
	 * @param timeout timeout in seconds
	 */
	public GitCloneOperation(final URIish uri, final boolean allSelected,
			final Collection<Ref> selectedBranches, final File workdir,
			final String branch, final String remoteName, int timeout) {
		this.uri = uri;
		this.allSelected = allSelected;
		this.selectedBranches = selectedBranches;
		this.workdir = workdir;
		this.gitdir = new File(workdir, Constants.DOT_GIT);
		this.branch = branch;
		this.remoteName = remoteName;
		this.timeout = timeout;
	}

	/**
	 * @param pm
	 *            the monitor to be used for reporting progress and responding
	 *            to cancellation. The monitor is never <code>null</code>
	 * @throws InvocationTargetException
	 * @throws InterruptedException
	 */
	public void run(final IProgressMonitor pm)
			throws InvocationTargetException, InterruptedException {
		final IProgressMonitor monitor;
		if (pm == null)
			monitor = new NullProgressMonitor();
		else
			monitor = pm;

		try {
			monitor.beginTask(NLS.bind(CoreText.CloneOperation_title, uri),
					5000);
			try {
				doInit(new SubProgressMonitor(monitor, 100));
				doFetch(new SubProgressMonitor(monitor, 4000));
				doCheckout(new SubProgressMonitor(monitor, 900));
			} finally {
				closeLocal();
			}
		} catch (final Exception e) {
			delete(workdir);
			if (monitor.isCanceled())
				throw new InterruptedException();
			else
				throw new InvocationTargetException(e);
		} finally {
			monitor.done();
		}
	}


	/**
	 * @return The git directory which will contain the repository
	 */
	public File getGitDir() {
		return gitdir;
	}

	private void closeLocal() {
		if (local != null) {
			local.close();
			local = null;
		}
	}

	private void doInit(final IProgressMonitor monitor)
			throws URISyntaxException, IOException {
		monitor.setTaskName(CoreText.CloneOperation_initializingRepository);

		local = new FileRepository(gitdir);
		local.create();

		final RefUpdate head = local.updateRef(Constants.HEAD);
		head.disableRefLog();
		head.link(branch);

		remoteConfig = new RemoteConfig(local.getConfig(), remoteName);
		remoteConfig.addURI(uri);

		final String dst = Constants.R_REMOTES + remoteConfig.getName();
		RefSpec wcrs = new RefSpec();
		wcrs = wcrs.setForceUpdate(true);
		wcrs = wcrs.setSourceDestination(Constants.R_HEADS
				+ "*", dst + "/*"); //$NON-NLS-1$ //$NON-NLS-2$

		if (allSelected) {
			remoteConfig.addFetchRefSpec(wcrs);
		} else {
			for (final Ref ref : selectedBranches)
				if (wcrs.matchSource(ref))
					remoteConfig.addFetchRefSpec(wcrs.expandFromSource(ref));
		}

		// we're setting up for a clone with a checkout
		local.getConfig().setBoolean(
				"core", null, "bare", false); //$NON-NLS-1$ //$NON-NLS-2$

		remoteConfig.update(local.getConfig());

		// branch is like 'Constants.R_HEADS + branchName', we need only
		// the 'branchName' part
		String branchName = branch.substring(Constants.R_HEADS.length());

		// setup the default remote branch for branchName
		local.getConfig().setString("branch", branchName, "remote", remoteName); //$NON-NLS-1$ //$NON-NLS-2$
		local.getConfig().setString("branch", branchName, "merge", branch); //$NON-NLS-1$ //$NON-NLS-2$

		local.getConfig().save();
	}

	private void doFetch(final IProgressMonitor monitor)
			throws NotSupportedException, TransportException {
		final Transport tn = Transport.open(local, remoteConfig);
		tn.setTimeout(this.timeout);
		try {
			final EclipseGitProgressTransformer pm;
			pm = new EclipseGitProgressTransformer(monitor);
			fetchResult = tn.fetch(pm, null);
		} finally {
			tn.close();
		}
	}

	private void doCheckout(final IProgressMonitor monitor) throws IOException {
		final Ref head = fetchResult.getAdvertisedRef(branch);
		if (head == null || head.getObjectId() == null)
			return;

		final RevWalk rw = new RevWalk(local);
		final RevCommit mapCommit;
		try {
			mapCommit = rw.parseCommit(head.getObjectId());
		} finally {
			rw.release();
		}

		final RefUpdate u;

		u = local.updateRef(Constants.HEAD);
		u.setNewObjectId(mapCommit.getId());
		u.forceUpdate();

		monitor.setTaskName(CoreText.CloneOperation_checkingOutFiles);
		DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(
				local, null, local.lockDirCache(), mapCommit.getTree());
		dirCacheCheckout.setFailOnConflict(true);
		boolean result = dirCacheCheckout.checkout();
		if (!result)
			// this should never happen when writing in an empty folder
			throw new IOException("Internal error occured on checking out files"); //$NON-NLS-1$
		monitor.setTaskName(CoreText.CloneOperation_writingIndex);
	}

	private static void delete(final File d) {
		if (d.isDirectory()) {
			final File[] items = d.listFiles();
			if (items != null) {
				for (final File c : items)
					delete(c);
			}
		}
		d.delete();
	}
	// END COMPLEX CODE
}