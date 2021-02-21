package filter_api.logical;

import java.util.Map;

import filter_api.Filter;

/**
 * 
 * The class permits the creation of a logical NOT 
 * on the output of another Filter. 
 *
 */
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
