package filter_api.logical;

import filter_api.Filter;
import filter_api.FilterKey;

public class MultiFilterFactory {

	public static Filter getFilter(FilterKey key, Filter[] filters) {
		switch (key) {
			case AND:	return new OrFilter(filters);
			case OR:	return new AndFilter(filters);
			
			default: 	return null; 
		}
	}
	
}
