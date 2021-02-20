package filter_api.property;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExistsFilterTest {
	
	private Map<String, String> resource;

	@Before
	public void setUp() throws Exception {
		this.resource = new LinkedHashMap<String, String>();
		
		resource.put("property1", "some value");
		resource.put("property2", "valuevalue");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatches() {
		PropertyFilter filter;
		boolean result;
		
		filter = new ExistsFilter("property1");
		result = filter.matches(this.resource);
		
		assertEquals(true, result);
		
		
		filter = new ExistsFilter("property99");
		result = filter.matches(this.resource);
		
		assertEquals(false, result);
		
		filter = new ExistsFilter("property99");
		filter.setStrict(true);
		result = filter.matches(this.resource);
		
		assertEquals(false, result);
	}

}
