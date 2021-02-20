package filter_api.property.base;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import filter_api.exceptions.PropertyMissingException;
import filter_api.property.PropertyFilter;

public class EqualsFilterTest {

	private Map<String, String> resource;

	@Before
	public void setUp() throws Exception {
		this.resource = new LinkedHashMap<String, String>();
		
		resource.put("property1", "111");
		resource.put("property2", "valuevalue");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatches() {
		PropertyFilter filter;
		boolean result;
		
		filter = new EqualsFilter("property1", "111");
		result = filter.matches(this.resource);
		
		assertEquals(true, result);
		
		
		filter = new EqualsFilter("property1", "222");
		result = filter.matches(this.resource);
		
		assertEquals(false, result);
	}

	@Test(expected = PropertyMissingException.class)
	public void testStrictMissingProperty() {
		PropertyFilter filter = new EqualsFilter("missing property", "111");
		filter.setStrict(true);
		filter.matches(this.resource);
	}
	
}
