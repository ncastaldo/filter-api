package filter_api.property;

import java.util.Map;

/**
 * 
 * The class represents a Filter on the existence of a property
 * in the input resource.
 * 
 * It extends the PropertyFilter class, forcing the 'strict'
 * variable to be set to false.
 *
 */
public class ExistsFilter extends PropertyFilter {
	
	public ExistsFilter(String property) {
		super(property); // no value
		this.strict = false;
	}


	/**
	 * The method returns true because the actual existence check
	 * is handled in the super-method 'matches' by default.
	 */
	@Override
	public boolean propertyMatches(Map<String, String> resource) {
		return true;
	}
	
	/**
	 * The method forces the 'strict' variable to be set to false.
	 */
	@Override
	public ExistsFilter setStrict(boolean strict) {
		return this;
	}
	
}
