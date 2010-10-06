/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.events.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.unicase.emfstore.esmodel.versioning.events.util.EventsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class EventsItemProviderAdapterFactory extends EventsAdapterFactory implements ComposeableAdapterFactory,
	IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EventsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.events.Event}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EventItemProvider eventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.Event}. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createEventAdapter() {
		if (eventItemProvider == null) {
			eventItemProvider = new EventItemProvider(this);
		}

		return eventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ReadEventItemProvider readEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.ReadEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createReadEventAdapter() {
		if (readEventItemProvider == null) {
			readEventItemProvider = new ReadEventItemProvider(this);
		}

		return readEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergeEventItemProvider mergeEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.MergeEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createMergeEventAdapter() {
		if (mergeEventItemProvider == null) {
			mergeEventItemProvider = new MergeEventItemProvider(this);
		}

		return mergeEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected CheckoutEventItemProvider checkoutEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.CheckoutEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createCheckoutEventAdapter() {
		if (checkoutEventItemProvider == null) {
			checkoutEventItemProvider = new CheckoutEventItemProvider(this);
		}

		return checkoutEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExceptionEventItemProvider exceptionEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.ExceptionEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createExceptionEventAdapter() {
		if (exceptionEventItemProvider == null) {
			exceptionEventItemProvider = new ExceptionEventItemProvider(this);
		}

		return exceptionEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected PluginStartEventItemProvider pluginStartEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.PluginStartEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPluginStartEventAdapter() {
		if (pluginStartEventItemProvider == null) {
			pluginStartEventItemProvider = new PluginStartEventItemProvider(this);
		}

		return pluginStartEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.UpdateEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected UpdateEventItemProvider updateEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.UpdateEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createUpdateEventAdapter() {
		if (updateEventItemProvider == null) {
			updateEventItemProvider = new UpdateEventItemProvider(this);
		}

		return updateEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected AnnotationEventItemProvider annotationEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.AnnotationEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createAnnotationEventAdapter() {
		if (annotationEventItemProvider == null) {
			annotationEventItemProvider = new AnnotationEventItemProvider(this);
		}

		return annotationEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.RevertEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected RevertEventItemProvider revertEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.RevertEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createRevertEventAdapter() {
		if (revertEventItemProvider == null) {
			revertEventItemProvider = new RevertEventItemProvider(this);
		}

		return revertEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ShowHistoryEventItemProvider showHistoryEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createShowHistoryEventAdapter() {
		if (showHistoryEventItemProvider == null) {
			showHistoryEventItemProvider = new ShowHistoryEventItemProvider(this);
		}

		return showHistoryEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PerspectiveEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected PerspectiveEventItemProvider perspectiveEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.PerspectiveEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPerspectiveEventAdapter() {
		if (perspectiveEventItemProvider == null) {
			perspectiveEventItemProvider = new PerspectiveEventItemProvider(this);
		}

		return perspectiveEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DNDEventItemProvider dndEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.DNDEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createDNDEventAdapter() {
		if (dndEventItemProvider == null) {
			dndEventItemProvider = new DNDEventItemProvider(this);
		}

		return dndEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.events.LinkEvent}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected LinkEventItemProvider linkEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.LinkEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createLinkEventAdapter() {
		if (linkEventItemProvider == null) {
			linkEventItemProvider = new LinkEventItemProvider(this);
		}

		return linkEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.TraceEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected TraceEventItemProvider traceEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.TraceEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createTraceEventAdapter() {
		if (traceEventItemProvider == null) {
			traceEventItemProvider = new TraceEventItemProvider(this);
		}

		return traceEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NavigatorCreateEventItemProvider navigatorCreateEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.NavigatorCreateEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createNavigatorCreateEventAdapter() {
		if (navigatorCreateEventItemProvider == null) {
			navigatorCreateEventItemProvider = new NavigatorCreateEventItemProvider(this);
		}

		return navigatorCreateEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected PluginFocusEventItemProvider pluginFocusEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.PluginFocusEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPluginFocusEventAdapter() {
		if (pluginFocusEventItemProvider == null) {
			pluginFocusEventItemProvider = new PluginFocusEventItemProvider(this);
		}

		return pluginFocusEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PresentationSwitchEventItemProvider presentationSwitchEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.PresentationSwitchEvent}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createPresentationSwitchEventAdapter() {
		if (presentationSwitchEventItemProvider == null) {
			presentationSwitchEventItemProvider = new PresentationSwitchEventItemProvider(this);
		}

		return presentationSwitchEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.events.UndoEvent}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UndoEventItemProvider undoEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.UndoEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createUndoEventAdapter() {
		if (undoEventItemProvider == null) {
			undoEventItemProvider = new UndoEventItemProvider(this);
		}

		return undoEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.events.Validate}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ValidateItemProvider validateItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.Validate}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createValidateAdapter() {
		if (validateItemProvider == null) {
			validateItemProvider = new ValidateItemProvider(this);
		}

		return validateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected ShowChangesEventItemProvider showChangesEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.ShowChangesEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createShowChangesEventAdapter() {
		if (showChangesEventItemProvider == null) {
			showChangesEventItemProvider = new ShowChangesEventItemProvider(this);
		}

		return showChangesEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NotificationReadEventItemProvider notificationReadEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.NotificationReadEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createNotificationReadEventAdapter() {
		if (notificationReadEventItemProvider == null) {
			notificationReadEventItemProvider = new NotificationReadEventItemProvider(this);
		}

		return notificationReadEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent} instances. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NotificationGenerationEventItemProvider notificationGenerationEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.NotificationGenerationEvent}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createNotificationGenerationEventAdapter() {
		if (notificationGenerationEventItemProvider == null) {
			notificationGenerationEventItemProvider = new NotificationGenerationEventItemProvider(this);
		}

		return notificationGenerationEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected NotificationIgnoreEventItemProvider notificationIgnoreEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.NotificationIgnoreEvent}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createNotificationIgnoreEventAdapter() {
		if (notificationIgnoreEventItemProvider == null) {
			notificationIgnoreEventItemProvider = new NotificationIgnoreEventItemProvider(this);
		}

		return notificationIgnoreEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.unicase.emfstore.esmodel.versioning.events.URLEvent}
	 * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected URLEventItemProvider urlEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.URLEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createURLEventAdapter() {
		if (urlEventItemProvider == null) {
			urlEventItemProvider = new URLEventItemProvider(this);
		}

		return urlEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent} instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergeChoiceEventItemProvider mergeChoiceEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.MergeChoiceEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createMergeChoiceEventAdapter() {
		if (mergeChoiceEventItemProvider == null) {
			mergeChoiceEventItemProvider = new MergeChoiceEventItemProvider(this);
		}

		return mergeChoiceEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all
	 * {@link org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent} instances. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MergeGlobalChoiceEventItemProvider mergeGlobalChoiceEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.unicase.emfstore.esmodel.versioning.events.MergeGlobalChoiceEvent}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter createMergeGlobalChoiceEventAdapter() {
		if (mergeGlobalChoiceEventItemProvider == null) {
			mergeGlobalChoiceEventItemProvider = new MergeGlobalChoiceEventItemProvider(this);
		}

		return mergeGlobalChoiceEventItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void dispose() {
		if (eventItemProvider != null)
			eventItemProvider.dispose();
		if (readEventItemProvider != null)
			readEventItemProvider.dispose();
		if (mergeEventItemProvider != null)
			mergeEventItemProvider.dispose();
		if (checkoutEventItemProvider != null)
			checkoutEventItemProvider.dispose();
		if (exceptionEventItemProvider != null)
			exceptionEventItemProvider.dispose();
		if (pluginStartEventItemProvider != null)
			pluginStartEventItemProvider.dispose();
		if (updateEventItemProvider != null)
			updateEventItemProvider.dispose();
		if (annotationEventItemProvider != null)
			annotationEventItemProvider.dispose();
		if (revertEventItemProvider != null)
			revertEventItemProvider.dispose();
		if (showHistoryEventItemProvider != null)
			showHistoryEventItemProvider.dispose();
		if (perspectiveEventItemProvider != null)
			perspectiveEventItemProvider.dispose();
		if (dndEventItemProvider != null)
			dndEventItemProvider.dispose();
		if (linkEventItemProvider != null)
			linkEventItemProvider.dispose();
		if (traceEventItemProvider != null)
			traceEventItemProvider.dispose();
		if (navigatorCreateEventItemProvider != null)
			navigatorCreateEventItemProvider.dispose();
		if (pluginFocusEventItemProvider != null)
			pluginFocusEventItemProvider.dispose();
		if (presentationSwitchEventItemProvider != null)
			presentationSwitchEventItemProvider.dispose();
		if (undoEventItemProvider != null)
			undoEventItemProvider.dispose();
		if (validateItemProvider != null)
			validateItemProvider.dispose();
		if (showChangesEventItemProvider != null)
			showChangesEventItemProvider.dispose();
		if (notificationReadEventItemProvider != null)
			notificationReadEventItemProvider.dispose();
		if (notificationGenerationEventItemProvider != null)
			notificationGenerationEventItemProvider.dispose();
		if (notificationIgnoreEventItemProvider != null)
			notificationIgnoreEventItemProvider.dispose();
		if (urlEventItemProvider != null)
			urlEventItemProvider.dispose();
		if (mergeChoiceEventItemProvider != null)
			mergeChoiceEventItemProvider.dispose();
		if (mergeGlobalChoiceEventItemProvider != null)
			mergeGlobalChoiceEventItemProvider.dispose();
	}

}
