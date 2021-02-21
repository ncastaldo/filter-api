package filter_api;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import filter_api.logical.MultiFilterFactory;
import filter_api.property.base.BasePropertyFilterFactory;

public class FilterApiTest {
	
	private Map<String, String> user;

	@Before
	public void setUp() throws Exception {
		
		// Create user resource having various properties
		this.user = new LinkedHashMap<String, String>();
		
		user.put("firstname", "Joe");
		user.put("surname", "Bloggs");
		user.put("role", "administrator");
		user.put("age", "35");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Create a filter which matches all administrators older than 30
	 */
	@Test
	public void test() {
		boolean result;
		
		// Create a filter using your API.
		Filter adminFilter = BasePropertyFilterFactory.getFilter("role", FilterKey.EQ, "administrator");
		Filter ageFilter = BasePropertyFilterFactory.getFilter("age", FilterKey.GT, "30");
		Filter filter = MultiFilterFactory.getFilter(FilterKey.AND, adminFilter, ageFilter);
		
		// Filter should match.
		result = filter.matches(this.user); 
		assertEquals(true, result);
		
		user.put("age", "25");
	
		// Filter should not match.
		result = filter.matches(this.user);	
		assertEquals(false, result);
		
	}

}


