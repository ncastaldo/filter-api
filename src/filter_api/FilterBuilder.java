package filter_api;

import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import filter_api.logical.MultiFilterFactory;
import filter_api.logical.NotFilter;
import filter_api.property.ExistsFilter;
import filter_api.property.base.BasePropertyFilterFactory;
import filter_api.property.other.RegexFilter;

/**
 * 
 * @author Nicola
 *
 */
public class FilterBuilder {
	
	// filterString
	
	public static Filter getFilter(JSONObject json) {
		
		FilterKey key = FilterKey.valueOf((String) json.get("key"));
		
		if (key == FilterKey.AND || key == FilterKey.OR) {
			
			List<Filter> filterList = new LinkedList<Filter>();
			
			for(Object object: (JSONArray) json.get("filters")) {
				filterList.add(FilterBuilder.getFilter((JSONObject) object));
			}
			
			Filter[] filters = filterList.stream().toArray(Filter[]::new);
			
			return MultiFilterFactory.getFilter(key, filters);
			
		}
		
		if (key == FilterKey.NOT) {
			
			Filter filter = FilterBuilder.getFilter((JSONObject) json.get("filter"));
			
			return new NotFilter(filter);
			
		}
		
		if (key == FilterKey.BOOLEAN) {
			
			boolean value = (boolean) json.get("value");
			
			return new BooleanFilter(value);
			
		}
		

		String property = (String) json.get("property");
		
		if (key == FilterKey.EXISTS) {
			
			return new ExistsFilter(property);
		}
		
		String value = (String) json.get("value");
		
		boolean strict = false;
		if (json.containsKey("strict")) {
			strict = (boolean) json.get("strict");
		}
		
		if (key == FilterKey.LT || key == FilterKey.EQ || key == FilterKey.GT) {
			
			return BasePropertyFilterFactory.getFilter(property, key, value).setStrict(strict);
		}
		
		if (key == FilterKey.REGEX) {
			
			return new RegexFilter(property, value).setStrict(strict);
			
		}
		
		return null; // all filter key cases are covered 
				
		
	}
	
}
