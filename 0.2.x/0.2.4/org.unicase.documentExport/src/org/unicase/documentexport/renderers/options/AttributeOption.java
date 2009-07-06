package org.unicase.documentexport.renderers.options;


@SuppressWarnings("serial")
public abstract class AttributeOption extends RendererOption {
	
	/**
	 * hide the property (feature) of the ModelElement
	 */
	public boolean hide = false;

	/**
	 * @see globalOption
	 */
	public boolean overwrite = false;
	
	/**
	 * There are global options for each type of a ModelElement property. 
	 * If the overwrite property of this AttributeOption isn't set to true,
	 * the settings of the global option will be returned.
	 */
	public AttributeOption globalOption;
	
	
	/**
	 * shall the global option values be returned?
	 */
	protected boolean useGlobalOption() {
		return (!overwrite && (globalOption != null));
	}
}
