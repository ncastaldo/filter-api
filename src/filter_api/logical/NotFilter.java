package filter_api.logical;

import java.util.Map;

import filter_api.Filter;

public class NotFilter implements Filter {
	
	private Filter filter;
	
	public NotFilter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public boolean matches(Map<String, String> resource) {
		return ! this.filter.matches(resource);
	}
	
}
