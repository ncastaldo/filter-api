package filter_api.logical;

import java.util.Map;

import filter_api.Filter;

/**
 * 
 * The class to perform a logical AND on the input Filters.
 *
 */
public class AndFilter extends MultiFilter {
	
	public AndFilter(Filter... filters) {
		super(filters);
	}

	@Override
	public boolean matches(Map<String, String> resource) {
		for (Filter filter: this.filters) {
			if (!filter.matches(resource)) {
				return false;
			}
		}
		return true;
	}

}
