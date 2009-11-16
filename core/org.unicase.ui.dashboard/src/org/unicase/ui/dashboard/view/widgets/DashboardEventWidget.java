/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dashboard.widgets;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.meeting.Meeting;
import org.unicase.model.meeting.MeetingPackage;
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.WorkPackage;
import org.unicase.ui.common.util.ModelElementClassTooltip;
import org.unicase.ui.common.util.ModelElementTooltip;
import org.unicase.ui.common.util.URLHelper;
import org.unicase.ui.common.util.URLSelectionListener;
import org.unicase.workspace.ProjectSpace;

/**
 * A dashboard widget displaying the upcoming events.
 * 
 * @author Shterev
 */
public class DashboardEventWidget extends AbstractDashboardWidget {

	private static final String WIDGET_ID = "DashboardEventWidget";

	/**
	 * Default constructor.
	 */
	public DashboardEventWidget() {
		super();
		setTitle("Upcoming events");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createContentPanel() {
		super.createContentPanel();
		EList<ModelElement> items = initItems();

		Composite panel = getContentPanel();
		GridLayoutFactory.fillDefaults().numColumns(2).equalWidth(false)
				.spacing(3, 2).applyTo(panel);
		final int count = items.size();

		SimpleDateFormat day = new SimpleDateFormat("EEE, d MMM");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		if (count > 0) {
			for (int i = 0; i < Math.min(10, count); i++) {
				ModelElement modelElement = items.get(i);
				ImageHyperlink image = new ImageHyperlink(panel, SWT.TOP);
				image.setImage(getLabelProvider().getImage(modelElement));
				image.setData(modelElement.eClass());
				ModelElementClassTooltip.enableFor(image);
				GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING)
						.applyTo(image);
				Link link = new Link(panel, SWT.WRAP | SWT.MULTI);
				link.setData(modelElement);
				ModelElementTooltip.enableFor(link);
				String msg = "";
				if (modelElement instanceof WorkItem) {
					msg = "  is due on ";
				} else if (modelElement instanceof Meeting) {
					msg = "  starts on ";
				}
				Date date = getDate(modelElement);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(URLHelper.getHTMLLinkForModelElement(
						modelElement, getDashboard().getProjectSpace(), 20));
				stringBuilder.append(msg);
				stringBuilder.append(day.format(date));
				stringBuilder.append(" at ");
				stringBuilder.append(time.format(date));
				link.setText(stringBuilder.toString());
				link.addSelectionListener(URLSelectionListener
						.getInstance(getDashboard().getProjectSpace()));
				GridDataFactory.fillDefaults().hint(
						getComposite().computeSize(SWT.DEFAULT, SWT.DEFAULT).x,
						SWT.DEFAULT).grab(true, false).applyTo(link);
			}
		} else {
			Label label = new Label(panel, SWT.WRAP);
			label.setText("No upcoming events");
		}
	}

	private Date getDate(ModelElement modelElement) {
		Date date = null;
		if (modelElement instanceof WorkItem) {
			date = ((WorkItem) modelElement).getDueDate();
		} else if (modelElement instanceof WorkPackage) {
			date = ((WorkPackage) modelElement).getEndDate();
		} else if (modelElement instanceof Meeting) {
			date = ((Meeting) modelElement).getStarttime();
		}
		return date;
	}

	private EList<ModelElement> initItems() {
		ProjectSpace projectSpace = getDashboard().getProjectSpace();

		EList<ModelElement> total = new BasicEList<ModelElement>();

		EList<WorkItem> workItems = new BasicEList<WorkItem>();
		EList<Meeting> meetings = new BasicEList<Meeting>();

		projectSpace.getProject().getAllModelElementsbyClass(
				TaskPackage.eINSTANCE.getWorkItem(), workItems, true);
		projectSpace.getProject().getAllModelElementsbyClass(
				MeetingPackage.eINSTANCE.getMeeting(), meetings);

		final Date now = new Date();
		addUpcomingEvents(total, workItems, now);
		addUpcomingEvents(total, meetings, now);

		Collections.sort(total, new Comparator<ModelElement>() {
			public int compare(ModelElement o1, ModelElement o2) {
				Date d1 = getDate(o1);
				Date d2 = getDate(o2);
				if (d1 != null && d2 == null) {
					return -1;
				} else if (d1 == null && d2 != null) {
					return 1;
				} else if (d1 != null && d2 != null) {
					return d1.compareTo(d2);
				}
				return 0;
			}
		});

		return total;
	}

	private void addUpcomingEvents(EList<ModelElement> target,
			EList<? extends ModelElement> source, Date now) {
		for (ModelElement modelElement : source) {
			Date date = getDate(modelElement);
			if (date != null && date.after(now)) {
				target.add(modelElement);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getId() {
		return WIDGET_ID;
	}
}
