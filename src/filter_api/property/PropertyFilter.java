package filter_api.property;

import java.util.Map;

import filter_api.Filter;
import filter_api.exceptions.PropertyMissingException;

/**
 * 
 * This abstract class defines the blueprint of a Filter that 
 * acts on a specific property of the input resource.
 * 
 * It offers the possibility to toggle the strict mode,
 * which defines the behavior of the matching function in case
 * the searched property is not found in the resource.
 *
 */
public abstract class PropertyFilter implements Filter {

	protected String property;

	protected boolean strict = false;	
	
	public PropertyFilter(String property) {
		this.property = property;
	}
	
	public boolean checkExistence(Map<String, String> resource) {
		return resource.containsKey(this.property);
	}
	
	/**
	 * The function checks the existence of the property in the resource.
	 * 
	 * In case of missing property:
	 * - it returns false if 'strict' is set to false
	 * - it throws a PropertyMissingException otherwise
	 * 
	 * If the property exists, the function delegates the matching strategy
	 * to the 'propertyMatches' function.
	 * 
	 */
	@Override
	public final boolean matches(Map<String, String> resource) {
		boolean exists = this.checkExistence(resource);
		if (!exists) {
			if (!strict) { return false; }
			throw new PropertyMissingException("Missing property: " + this.property);
		}
		return propertyMatches(resource);
	}
	
	/**
	 * The function performs the match between the resource 
	 * and the Filter itself.
	 * 
	 * @param resource	the resource to filter
	 * @return true if the filter is successful, false otherwise
	 */
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