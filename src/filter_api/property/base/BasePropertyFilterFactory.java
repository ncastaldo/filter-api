package filter_api.property.base;

import filter_api.FilterKey;
import filter_api.property.PropertyFilter;

public class BasePropertyFilterFactory {
	public static PropertyFilter getFilter(String property, FilterKey key, String value) {
		switch (key) {
			case LT:	return new LowerFilter(property, value);
			case EQ:	return new EqualsFilter(property, value);
			case GT:	return new GreaterFilter(property, value);
			
			default: 	return null; // Unreachable, ComparisonType is an Enumeration
		}
	}
	
	public static PropertyFilter getFilter(String property, FilterKey key, String value, boolean strict) {
		PropertyFilter filter = BasePropertyFilterFactory.getFilter(property, key, value);
		filter.setStrict(strict);
		return filter;
	}
}
