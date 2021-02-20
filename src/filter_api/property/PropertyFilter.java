package filter_api.property;

import java.util.Map;

import filter_api.Filter;
import filter_api.exceptions.PropertyMissingException;

public abstract class PropertyFilter implements Filter {

	protected String property;

	protected boolean strict = false;	
	
	public PropertyFilter(String property) {
		this.property = property;
	}
	
	public boolean checkExistence(Map<String, String> resource) {
		return resource.containsKey(this.property);
	}
	
	@Override
	public final boolean matches(Map<String, String> resource) {
		boolean exists = this.checkExistence(resource);
		if (!exists) {
			if (!strict) { return false; }
			throw new PropertyMissingException("Missing property: " + this.property);
		}
		return propertyMatches(resource);
	}
	
	public abstract boolean propertyMatches(Map<String, String> resource);
	
	public String getProperty() {
		return property;
	}

	public PropertyFilter setProperty(String property) {
		this.property = property;
		
		return this;
	}
		
	public boolean isStrict() {
		return strict;
	}

	public PropertyFilter setStrict(boolean strict) {
		this.strict = strict;
		
		return this;
	}
	
}