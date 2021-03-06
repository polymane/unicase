/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ecpemfstorebridge;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.unicase.metamodel.AssociationClassElement;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.metamodel.util.ProjectChangeObserver;
import org.unicase.ui.common.ECPAssociationClassElement;
import org.unicase.ui.common.MetaModelElementContext;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.workspace.Configuration;

/**
 * Context for the EMFStore workspace.
 * 
 * @author helming
 */
public class EMFStoreModelelementContext extends ModelElementContext implements ProjectChangeObserver {

	private final Project project;
	private EObject modelelement;

	/**
	 * Constructor for the OpenModelelementdialog. Will be removed, when Navigator is refactored.
	 * 
	 * @deprecated
	 * @param project the Project
	 */
	@Deprecated
	public EMFStoreModelelementContext(Project project) {
		this.project = project;
		project.addProjectChangeObserver(this);
	}

	/**
	 * Default constructor.
	 * 
	 * @param me the {@link EObject}
	 */
	public EMFStoreModelelementContext(EObject me) {
		this(ModelUtil.getProject(me));
		this.modelelement = me;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementContext#getEditingDomain()
	 */
	@Override
	public EditingDomain getEditingDomain() {
		return Configuration.getEditingDomain();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementContext#getAllModelElements()
	 */
	@Override
	public Collection<EObject> getAllModelElements() {
		Collection<EObject> ret = new BasicEList<EObject>();
		ret.addAll(project.getAllModelElements());
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementContext#getAllModelElementsbyClass(org.eclipse.emf.ecore.EClass,
	 *      org.eclipse.emf.common.util.BasicEList)
	 */
	@Override
	public Collection<EObject> getAllModelElementsbyClass(EClass clazz, boolean association) {
		Collection<EObject> ret = new BasicEList<EObject>();
		for (EObject element : project.getAllModelElements()) {
			if (association || !isAssociationClassElement(element)) {
				ret.add(element);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementContext#isNonDomainElement(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean isNonDomainElement(EObject eObject) {
		return (eObject instanceof NonDomainElement);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementContext#contains(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean contains(EObject dropee) {
		Project p = ModelUtil.getProject(dropee);
		if (p != null) {
			return p.equals(project);
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementContext#getMetaModelElementContext()
	 */
	public MetaModelElementContext getMetaModelElementContext() {
		return EMFStoreMetaModelElementContext.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementAdded(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementAdded(Project project, EObject modelElement) {
		// Do nothing.

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#modelElementRemoved(org.unicase.metamodel.Project,
	 *      org.unicase.metamodel.ModelElement)
	 */
	public void modelElementRemoved(Project project, EObject modelElement) {
		if (modelElement.equals(this.modelelement)) {
			modelElementDeleted();
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#notify(org.eclipse.emf.common.notify.Notification,
	 *      org.unicase.metamodel.Project, org.unicase.metamodel.ModelElement)
	 */
	public void notify(Notification notification, Project project, EObject modelElement) {
		// Do nothing

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.metamodel.util.ProjectChangeObserver#projectDeleted(org.unicase.metamodel.Project)
	 */
	public void projectDeleted(Project project) {
		contextDeleted();

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.ModelElementContext#dispose()
	 */
	@Override
	public void dispose() {
		project.removeProjectChangeObserver(this);

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAssociationClassElement(EObject eObject) {
		return (eObject instanceof AssociationClassElement);
	}

	/**
	 * {@inheritDoc}
	 */
	public ECPAssociationClassElement getAssociationClassElement(EObject eObject) {
		if (isAssociationClassElement(eObject)) {
			AssociationClassElement ace = (AssociationClassElement) eObject;
			return new ECPAssociationClassElement(ace.getSourceFeature(), ace.getTargetFeature(), ace
				.getAssociationFeatures());
		}
		return null;
	}
}