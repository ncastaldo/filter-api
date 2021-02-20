package filter_api.property;

import java.util.Map;

public class ExistsFilter extends PropertyFilter {
	
	public ExistsFilter(String property) {
		super(property); // no value
		this.strict = false;
	}


	@Override
	public boolean doMatch(Map<String, String> resource) {
		return true;
	}
	
	@Override
	public void setStrict(boolean strict) {}
	
}
