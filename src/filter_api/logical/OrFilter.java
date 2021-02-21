package filter_api.logical;

import java.util.Map;

import filter_api.Filter;

/**
 * 
 * The class to perform a logical OR on the input Filters.
 *
 */
public class OrFilter extends MultiFilter {
	
	public OrFilter(Filter... filters) {
		super(filters);
	}

	@Override
	public boolean matches(Map<String, String> resource) {
		for (Filter filter: this.filters) {
			if (filter.matches(resource)) {
				return true;
			}
		}
		return false;
	}

}
