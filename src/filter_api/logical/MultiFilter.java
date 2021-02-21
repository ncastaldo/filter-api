package filter_api.logical;

import filter_api.Filter;

/**
 * 
 * The class the structure of a Filter class capable 
 * of combining the logical output of other Filters.
 *
 */
public abstract class MultiFilter implements Filter {
	
	protected Filter[] filters;
	
	public MultiFilter(Filter... filters) {
		this.filters = filters;
	}

	public Filter[] getFilters() {
		return filters;
	}

	public MultiFilter setFilters(Filter... filters) {
		this.filters = filters;
		
		return this;
	}

}
