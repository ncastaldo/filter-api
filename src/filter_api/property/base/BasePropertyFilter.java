package filter_api.property.base;

import filter_api.property.PropertyFilter;

/**
 * 
 * The class defines the structure of a PropertyFilter class
 * that enables the a basic String comparison between 
 * the resouce property and a value.
 *
 */
public abstract class BasePropertyFilter extends PropertyFilter {
	protected String value;

	public BasePropertyFilter(String property, String value) {
		super(property);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public BasePropertyFilter setValue(String value) {
		this.value = value;
		
		return this;
	}
	
	
}
	

