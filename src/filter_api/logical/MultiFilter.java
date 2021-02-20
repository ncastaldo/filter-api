package filter_api.logical;


import filter_api.Filter;

public abstract class MultiFilter implements Filter {
	
	protected Filter[] filters;
	
	public MultiFilter(Filter... filters) {
		this.filters = filters;
	}

	public Filter[] getFilters() {
		return filters;
	}

	public MultiFilter setFilters(Filter[] filters) {
		this.filters = filters;
		
		return this;
	}

}
