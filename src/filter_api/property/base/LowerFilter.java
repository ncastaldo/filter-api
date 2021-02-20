package filter_api.property.base;

import java.util.Map;

public class LowerFilter extends BasePropertyFilter {

	public LowerFilter(String property, String value) {
		super(property, value);
	}

	public boolean doMatch(Map<String, String> resource) {
		return resource.get(this.property).compareTo(this.value) < 0;
	}
	
}
