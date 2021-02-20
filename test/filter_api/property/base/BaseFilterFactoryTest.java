package filter_api.property.base;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import filter_api.Filter;
import filter_api.FilterKey;

public class BaseFilterFactoryTest {

	Map<String, String> resource;

	@Before
	public void setUp() throws Exception {
		
		this.resource = new LinkedHashMap<String, String>();
		
		resource.put("username", "ncastaldo");
		resource.put("email", "nicolacastaldo123@gmail.com");
		resource.put("city", "Udine");
		resource.put("age", "26");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFilter() {
		Filter filter;
		boolean result; 
		
		filter = BasePropertyFilterFactory.getFilter("city", FilterKey.EQ, "Udine");
		result = filter.matches(this.resource);
		
		assertEquals(true, result);
		
		
		filter = BasePropertyFilterFactory.getFilter("age", FilterKey.GT, "");
		result = filter.matches(this.resource);
		
		assertEquals(true, result);
		
	}

}
