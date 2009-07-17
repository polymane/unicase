/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.dataanalyzer;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.VersionIterator;
import org.unicase.emfstore.esmodel.util.EsModelUtil;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent;
import org.unicase.emfstore.esmodel.versioning.events.Event;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.emfstore.esmodel.versioning.events.UpdateEvent;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElementId;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Check the time of the Commit, update, and read event for the same ME.
 * @author liya
 *
 */
public class CommitUpdateReadEventAnalyzer implements TwoDDataAnalyzer {

	/**
	 * @param data {@link ProjectAnalysisData}
	 * @param it {@link VersionIterator}
	 * @return @see org.unicase.analyzer.dataanalyzer.TwoDDataAnalyzer#get2DValue(org.unicase.analyzer.ProjectAnalysisData, org.unicase.analyzer.VersionIterator)
	 *
	 */
	public List<List<Object>> get2DValue(ProjectAnalysisData data, VersionIterator it) {
		List<List<Object>> values = new ArrayList<List<Object>>();
		
		PrimaryVersionSpec base;
		PrimaryVersionSpec target;
		Map<ModelElementId, Date> meIdMap = null;
		Map<ModelElementId, Date> commitMap = null;
		String user;
		
		for(ChangePackage change : data.getChangePackages()){
			user = change.getLogMessage().getAuthor();
			meIdMap = new HashMap<ModelElementId, Date>();
			commitMap = new HashMap<ModelElementId, Date>();
			for(Event event : change.getEvents()){
				//UpdateEvent
				if(event instanceof UpdateEvent || event instanceof CheckoutEvent){
					if(event instanceof UpdateEvent){
						base = ((UpdateEvent) event).getBaseVersion();
						target = ((UpdateEvent) event).getTargetVersion();
					}
					else{
						base = ((CheckoutEvent) event).getBaseVersion();
						target = EsModelUtil.clone(base);
						if(base.getIdentifier()- 20 > 0){
							target.setIdentifier(base.getIdentifier()- 20); //just consider the last 20 revisions
						}
						else{
							target.setIdentifier(0);
						}
					}
					try {
						List<ChangePackage> updateChanges = it.getConnectionManager().getChanges(it.getUsersession().getSessionId(), 
							it.getProjectId(), base, target);
						//Map for the ModelElement candidates
						for(ChangePackage updateChange : updateChanges){
							for(AbstractOperation op : updateChange.getOperations()){
								meIdMap.put(op.getModelElementId(), event.getTimestamp());
								commitMap.put(op.getModelElementId(), updateChange.getLogMessage().getDate());
							}
						}

					} catch (EmfStoreException e) {
						String message = "Could not get changes from server";
						WorkspaceUtil.logException(message, e);
						throw new NoSuchElementException(message + ":\n" + e);
					}
				}

				//ReadEvent
				if(event instanceof ReadEvent){
					ReadEvent readEvent = (ReadEvent) event;
					ModelElementId meId = readEvent.getModelElement();
					if(meIdMap != null){
						if(meIdMap.containsKey(meId)){
							List<Object> line = addLine(meId, user, commitMap, meIdMap, readEvent);						
							values.add(line);
						}
					}
				}
			}
		}
		return values;
	}
	

	private List<Object> addLine(ModelElementId meId, String user, Map<ModelElementId, Date> commitMap, Map<ModelElementId, Date> meIdMap, ReadEvent readEvent){
		List<Object> line = new ArrayList<Object>();
		line.add(meId);
		line.add(user);
		line.add(commitMap.get(meId));//commit time
		line.add(meIdMap.get(meId));//update time
		line.add(readEvent.getTimestamp());//read time
		
		long time = readEvent.getTimestamp().getTime() - commitMap.get(meId).getTime();
		Date diff = new Date(time);		
		line.add(diff.getTime());

		time = meIdMap.get(meId).getTime() - commitMap.get(meId).getTime();
		diff.setTime(time);//Time difference between update and commit the same ME
		line.add(diff.getTime());
		
		return line;
	}

	/**
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("ModelElementId");	
		names.add("User");
		names.add("Commit Time");
		names.add("Update Time");
		names.add("Read Time");
		names.add("Commit-Read Time Difference");
		names.add("Update-Commit Time Difference");
		return names;
	}

	/**
	 * @param data {@link ProjectAnalysisData}
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		throw new UnsupportedOperationException();
	}

}
