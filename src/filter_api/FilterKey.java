package filter_api;

/**
 * The Enumeration defines all and possible key values
 * representing the supported Filters.
 * 
 * To add a new Filter, a FilterKey must be added to this Enumeration.
 *
 */
public enum FilterKey {
	BOOLEAN,
	
	EXISTS,
	
	LT,
	EQ,
	GT,
	REGEX,
	
	AND,
	OR,
	NOT,
}
