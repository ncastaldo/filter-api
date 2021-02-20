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
	
	public static Filter getFilter(String filterString) {
		
		JSONObject json;
		
		/* 
		 * TODO: code to parse the filterString and transform it into
		 * a VALID JSON representation
		 * 
		 * Here creating just an empty JSONObject.
		 */		
		json = new JSONObject();
		
		return FilterBuilder.getFilter(json);
	}
	
	public static Filter getFilter(JSONObject json) {
		
		FilterKey key = FilterKey.valueOf((String) json.get("key"));
		
		/* AND - OR */
		if (key == FilterKey.AND || key == FilterKey.OR) {
			List<Filter> filterList = new LinkedList<Filter>();
			
			for(Object object: (JSONArray) json.get("filters")) {
				filterList.add(FilterBuilder.getFilter((JSONObject) object));
			}
			
			Filter[] filters = filterList.stream().toArray(Filter[]::new);
			
			return MultiFilterFactory.getFilter(key, filters);
		}
		
		/* NOT */
		if (key == FilterKey.NOT) {
			Filter filter = FilterBuilder.getFilter((JSONObject) json.get("filter"));
			
			return new NotFilter(filter);	
		}
		
		/* BOOLEAN */
		if (key == FilterKey.BOOLEAN) {
			boolean value = (boolean) json.get("value");
			
			return new BooleanFilter(value);
		}

		String property = (String) json.get("property");
		
		/* EXISTS */
		if (key == FilterKey.EXISTS) {
			return new ExistsFilter(property);
		}
		
		String value = (String) json.get("value");
		
		boolean strict = false;
		if (json.containsKey("strict")) {
			strict = (boolean) json.get("strict");
		}
		
		/* LT - EQ - GT */
		if (key == FilterKey.LT || key == FilterKey.EQ || key == FilterKey.GT) {
			return BasePropertyFilterFactory.getFilter(property, key, value).setStrict(strict);
		}
		
		/* REGEX */
		if (key == FilterKey.REGEX) {
			return new RegexFilter(property, value).setStrict(strict);
		}
		
		/* Unreachable: all FilterKey cases MUST BE covered */
		return null; 
	}
	
}
