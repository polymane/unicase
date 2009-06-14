/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.core.subinterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.emfstore.EmfStoreController;
import org.unicase.emfstore.core.AbstractEmfstoreInterface;
import org.unicase.emfstore.core.AbstractSubEmfstoreInterface;
import org.unicase.emfstore.core.helper.HistoryCache;
import org.unicase.emfstore.esmodel.ProjectId;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.emfstore.exceptions.InvalidInputException;
import org.unicase.emfstore.exceptions.StorageException;
import org.unicase.model.ModelElementId;

/**
 * This subinterfaces implements all history related functionality for the EmfStoreImpl interface.
 * 
 * @author wesendon
 */
public class HistorySubInterfaceImpl extends AbstractSubEmfstoreInterface {

	/**
	 * Default constructor.
	 * 
	 * @param parentInterface parent interface
	 * @throws FatalEmfStoreException in case of failure
	 */
	public HistorySubInterfaceImpl(AbstractEmfstoreInterface parentInterface) throws FatalEmfStoreException {
		super(parentInterface);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<HistoryInfo> getHistoryInfo(ProjectId projectId, HistoryQuery historyQuery) throws EmfStoreException {
		synchronized (getMonitor()) {
			// if modelelements are added to the query, only history infos which are related to these modelelements will
			// be returned.
			if (historyQuery.getModelElements().size() > 0) {
				return getHistoryInfo(projectId, historyQuery.getModelElements(), historyQuery.isIncludeChangePackage());
			} else {
				List<HistoryInfo> result = getHistoryInfo(projectId, historyQuery.getSource(),
					historyQuery.getTarget(), historyQuery.isIncludeChangePackage());
				if (historyQuery.getSource().compareTo(historyQuery.getTarget()) < 0) {
					Collections.reverse(result);
				}
				return result;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTag(ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		synchronized (getMonitor()) {
			Version version = getSubInterface(VersionSubInterfaceImpl.class).getVersion(projectId, versionSpec);
			version.getTagSpecs().add(tag);
			try {
				save(version);
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeTag(ProjectId projectId, PrimaryVersionSpec versionSpec, TagVersionSpec tag)
		throws EmfStoreException {
		synchronized (getMonitor()) {
			Version version = getSubInterface(VersionSubInterfaceImpl.class).getVersion(projectId, versionSpec);
			Iterator<TagVersionSpec> iterator = version.getTagSpecs().iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getName().equals(tag.getName())) {
					iterator.remove();
				}
			}
			try {
				save(version);
			} catch (FatalEmfStoreException e) {
				throw new StorageException(StorageException.NOSAVE);
			}
		}
	}

	private List<HistoryInfo> getHistoryInfo(ProjectId projectId, List<ModelElementId> moList,
		boolean includeChangePackage) throws EmfStoreException {
		HistoryCache historyCache = EmfStoreController.getInstance().getHistoryCache();
		// TODO only the first modelelement is included in the request.
		ModelElementId modelElementId = moList.get(0);
		TreeSet<Version> elements = historyCache.getChangesForModelElement(projectId, modelElementId);
		ArrayList<Version> versions = new ArrayList<Version>(elements);
		if (versions.size() == 0) {
			return new ArrayList<HistoryInfo>();
		}
		// only the last 20 or less versions are considered
		int historyCount = Math.min(versions.size() - 1, 20);
		List<HistoryInfo> historyInfos = getHistoryInfo(versions.subList(0, historyCount), projectId,
			includeChangePackage);
		// filter operations to selected model element
		for (HistoryInfo historyInfo : historyInfos) {
			Set<AbstractOperation> operationsToRemove = new HashSet<AbstractOperation>();
			EList<AbstractOperation> operations = historyInfo.getChangePackage().getOperations();
			for (AbstractOperation operation : operations) {
				if (!operation.getAllInvolvedModelElements().contains(modelElementId)) {
					operationsToRemove.add(operation);
				}
			}
			operations.removeAll(operationsToRemove);

		}
		return historyInfos;
	}

	private List<HistoryInfo> getHistoryInfo(ProjectId projectId, PrimaryVersionSpec source, PrimaryVersionSpec target,
		boolean includeChangePackage) throws EmfStoreException {
		if (source == null || target == null) {
			throw new InvalidInputException();
		}
		return getHistoryInfo(getSubInterface(VersionSubInterfaceImpl.class).getVersions(projectId, source, target),
			projectId, includeChangePackage);
	}

	private List<HistoryInfo> getHistoryInfo(List<Version> versions, ProjectId projectId, boolean includeChangePackage)
		throws EmfStoreException {
		List<HistoryInfo> result = new ArrayList<HistoryInfo>();
		PrimaryVersionSpec headRevision = getSubInterface(ProjectSubInterfaceImpl.class).getProject(projectId)
			.getLastVersion().getPrimarySpec();
		for (Version version : versions) {
			HistoryInfo history = createHistoryInfo(headRevision, version, includeChangePackage);
			result.add(history);
		}
		return result;
	}

	/**
	 * Generates a history info from a version. If needed also adds the HEAD tag, which isn't persistent.
	 * 
	 * @param headRevision head revision
	 * @param version version
	 * @param includeChangePackage
	 * @return history info
	 */
	private HistoryInfo createHistoryInfo(PrimaryVersionSpec headRevision, Version version, boolean includeChangePackage) {
		HistoryInfo history = VersioningFactory.eINSTANCE.createHistoryInfo();
		if (includeChangePackage) {
			// null check for the initial commit
			if (version.getChanges() != null) {
				history.setChangePackage((ChangePackage) EcoreUtil.copy(version.getChanges()));
				history.getChangePackage().setLogMessage((LogMessage) EcoreUtil.copy(version.getLogMessage()));
			}
		} else {
			history.setLogMessage((LogMessage) EcoreUtil.copy(version.getLogMessage()));
		}
		history.setPrimerySpec((PrimaryVersionSpec) EcoreUtil.copy(version.getPrimarySpec()));
		for (TagVersionSpec tagSpec : version.getTagSpecs()) {
			history.getTagSpecs().add((TagVersionSpec) EcoreUtil.copy(tagSpec));
		}
		// add HEAD tag to history info
		if (version.getPrimarySpec().equals(headRevision)) {
			TagVersionSpec spec = VersioningFactory.eINSTANCE.createTagVersionSpec();
			spec.setName(VersionSpec.HEAD);
			history.getTagSpecs().add(spec);
		}
		return history;
	}
}
