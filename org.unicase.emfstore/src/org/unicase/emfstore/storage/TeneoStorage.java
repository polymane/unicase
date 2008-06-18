/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian K�gel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.change.ChangePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.hibernate.cfg.Environment;
import org.unicase.emfstore.esmodel.EsmodelPackage;
import org.unicase.model.ModelPackage;

/**
 * Implementation of a {@link ResourceStorage} backed by a TeneoDBResource.
 * @author koegel
 *
 */
public class TeneoStorage implements ResourceStorage {

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.emfstore.storage.ResourceStorage#init(java.util.Properties)
	 */
	public URI init(Properties properties) {

		// create hb store
		final String hbStoreName = "modelStore";
		HbDataStore dataStore = HbHelper.INSTANCE
				.createRegisterDataStore(hbStoreName);

		// Set the hibernate properties
		final Properties props = new Properties();
		props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
		props.setProperty(Environment.USER, "root");
		props.setProperty(Environment.PASS, "pass");
		props.setProperty(Environment.URL, "jdbc:mysql://localhost/" + "model");
		props.setProperty(Environment.DIALECT,
				org.hibernate.dialect.MySQLInnoDBDialect.class.getName());
		// Lazy loading to avoid too many joins exception
		props.setProperty(Environment.MAX_FETCH_DEPTH, "0");

		props.setProperty(PersistenceOptions.INHERITANCE_MAPPING, "JOINED");
		dataStore.setProperties(props);

		// set epackages
		dataStore.setEPackages(getUnicaseModelPackages());

		dataStore.initialize();

		// logger.debug("Using hibernate mapping: " +
		// dataStore.getMappingXML());

		String uriStr = "hibernate://?" + HibernateResource.DS_NAME_PARAM + "="
				+ hbStoreName;
		return URI.createURI(uriStr);
	}

	/**
	 * Retrieve all unicase EPackages.
	 * @return a list of EPackages
	 */
	private EPackage[] getUnicaseModelPackages() {

		List<EPackage> packages = new ArrayList<EPackage>();

		// add model and its subpackages
		EPackage modelPackage = ModelPackage.eINSTANCE;
		packages.add(modelPackage);
		packages.addAll(getSubPackages(modelPackage));

		// add es model and its subpackages
		EPackage esmodelPackage = EsmodelPackage.eINSTANCE;
		packages.add(esmodelPackage);
		packages.addAll(getSubPackages(esmodelPackage));

		// add ecore packages
		EPackage changePackage = ChangePackage.eINSTANCE;
		packages.add(changePackage);
		EPackage ecorePackage = EcorePackage.eINSTANCE;
		packages.add(ecorePackage);

		// add gmf packages
		NotationPackage gmfPackage = NotationPackage.eINSTANCE;
		packages.add(gmfPackage);

		return packages.toArray(new EPackageImpl[packages.size()]);
	}

	/**
	 * Get all subpackages recursivly.
	 * 
	 * @param package1 parent package
	 * @return a set of sibling packages
	 * 
	 * @generated NOT
	 */
	private Set<EPackage> getSubPackages(EPackage package1) {
		Set<EPackage> subPackages = new HashSet<EPackage>();
		for (EPackage subPackage : package1.getESubpackages()) {
			subPackages.add(subPackage);
			subPackages.addAll(getSubPackages(subPackage));
		}
		return subPackages;
	}
}
