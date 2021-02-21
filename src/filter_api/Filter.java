package filter_api;

import java.util.Map;

/**
 * 
 * The Filter interface defines the blueprint of all the filters. 
 * 
 * All setters should have 'this' as return value, 
 * in order to enable Method Chaining 
 *
 */
public interface Filter {
	/**
	 * The function performs the match between the resource 
	 * and the Filter itself.
	 * 
	 * @param resource	the resource to filter, not null
	 * @return true if the filter is successful, false otherwise
	 */
	public boolean matches(Map<String, String> resource);
}
