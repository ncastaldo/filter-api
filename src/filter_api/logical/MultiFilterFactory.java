package filter_api.logical;

import filter_api.Filter;
import filter_api.FilterKey;
import filter_api.exceptions.InvalidFilterKeyException;

/**
 * 
 * The class follows the principle of the Factory Design Pattern,
 * offering a static method to instantiate a MultiFilter.
 *
 */
public class MultiFilterFactory {

	/**
	 * The static method to delegate the instantiation 
	 * of a MultiFilter object.
	 * 
	 * @param key		the FilterKey type defining the Filter, not null
	 * @param filters	one or more Filters to chain
	 * @return			the new MultiFilter
	 */
	public static Filter getFilter(FilterKey key, Filter... filters) {
		switch (key) {
			case OR:	return new OrFilter(filters);
			case AND:	return new AndFilter(filters);
			
			default: 	throw new InvalidFilterKeyException("Filter key not found: " + key);
		}
	}
	
}
