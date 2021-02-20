package filter_api.property;

import java.util.Map;

public class ExistsFilter extends PropertyFilter {
	
	public ExistsFilter(String property) {
		super(property); // no value
		this.strict = false;
	}


	@Override
	public boolean propertyMatches(Map<String, String> resource) {
		return true;
	}
	
	@Override
	public ExistsFilter setStrict(boolean strict) {
		return this;
	}
	
}
