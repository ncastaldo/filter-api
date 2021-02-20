package filter_api.property.base;

import filter_api.property.PropertyFilter;

public abstract class BasePropertyFilter extends PropertyFilter {
	protected final String value;

	public BasePropertyFilter(String property, String value) {
		super(property);
		this.value = value;
	}
}
	

