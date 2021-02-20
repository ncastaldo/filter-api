package filter_api.property.base;

import java.util.Map;


public class EqualsFilter extends BasePropertyFilter {
		
	public EqualsFilter(String property, String value) {
		super(property, value);
	}

	public boolean doMatch(Map<String, String> resource) {
		// exception management needed, or initial check
		return resource.get(this.property).equals(this.value);
	}
	
}
