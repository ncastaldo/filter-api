package filter_api.property.base;

import java.util.Map;

public class LowerFilter extends BasePropertyFilter {

	public LowerFilter(String property, String value) {
		super(property, value);
	}

	public boolean propertyMatches(Map<String, String> resource) {
		return resource.get(this.property).toLowerCase().compareTo(this.value.toLowerCase()) < 0;
	}
	
}
