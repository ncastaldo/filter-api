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
	
	public final boolean matches(Map<String, String> resource) {
		boolean exists = this.checkExistence(resource);
		if (!exists) {
			if (!strict) { return false; }
			throw new PropertyMissingException("Missing property: " + this.property);
		}
		return doMatch(resource);
	}
	
	public abstract boolean doMatch(Map<String, String> resource);
		
	public boolean isStrict() {
		return strict;
	}

	public void setStrict(boolean strict) {
		this.strict = strict;
	}
	
}