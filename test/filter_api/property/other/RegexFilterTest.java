package filter_api.property.other;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegexFilterTest {

	Map<String, String> resource;

	@Before
	public void setUp() throws Exception {
		
		this.resource = new LinkedHashMap<String, String>();
		
		resource.put("firstname", "Nicola");
		resource.put("surname", "Castaldo");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatches() {

		RegexFilter regexFilter;
		boolean result;
		
		regexFilter = new RegexFilter("firstname", "^Nic");
		result = regexFilter.matches(this.resource);
		
		assertEquals(true, result);
		
		regexFilter = new RegexFilter("firstname", "Nicola C.");
		result = regexFilter.matches(this.resource);
		
		assertEquals(false, result);
	}

}



