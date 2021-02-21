package filter_api.property.base;

import filter_api.FilterKey;
import filter_api.exceptions.InvalidFilterKeyException;
import filter_api.property.PropertyFilter;

/**
 * 
 * The class follows the principle of the Factory Design Pattern,
 * offering a static method to instantiate a PropertyFilter.
 *
 */
public class BasePropertyFilterFactory {
	
	/**
	 * The static method to delegate the instantiation 
	 * of a PropertyFilter object.
	 * 
	 * @param property	the property to match
	 * @param key		the FilterKey type defining the Filter, not null
	 * @param value		the String value to find
	 * @return			the new PropertyFilter
	 */
	public static PropertyFilter getFilter(String property, FilterKey key, String value) {
		switch (key) {
			case LT:	return new LowerFilter(property, value);
			case EQ:	return new EqualsFilter(property, value);
			case GT:	return new GreaterFilter(property, value);
			
			default: 	throw new InvalidFilterKeyException("Filter key not found: " + key);
		}
	}
}
