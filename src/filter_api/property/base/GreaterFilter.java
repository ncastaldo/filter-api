package filter_api.property.base;

import java.util.Map;

/**
 * 
 * The class permits the 'greater than' comparison between
 * a String property and a String value. 
 *
 */
public class GreaterFilter extends BasePropertyFilter {

	public GreaterFilter(String property, String value) {
		super(property, value);
	}

	public boolean propertyMatches(Map<String, String> resource) {
		
		return resource.get(this.property).toLowerCase().compareTo(this.value.toLowerCase()) > 0;
	}
	
}
