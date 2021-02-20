package filter_api.property.base;

import java.util.Map;


public class GreaterFilter extends BasePropertyFilter {

	public GreaterFilter(String property, String value) {
		super(property, value);
	}

	public boolean doMatch(Map<String, String> resource) {
		
		return resource.get(this.property).compareTo(this.value) > 0;
	}
	
}
