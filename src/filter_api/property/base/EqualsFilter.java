package filter_api.property.base;

import java.util.Map;

/**
 * 
 * The class permits the equality comparison between
 * a String property and a String value. 
 *
 */
public class EqualsFilter extends BasePropertyFilter {
		
	public EqualsFilter(String property, String value) {
		super(property, value);
	}

	public boolean propertyMatches(Map<String, String> resource) {
		return resource.get(this.property).toLowerCase().equals(this.value.toLowerCase());
	}
	
}
