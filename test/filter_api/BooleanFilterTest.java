package filter_api;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BooleanFilterTest {

	private BooleanFilter booleanFilter;
	
	private Map<String, String> user;
	
	@Before
	public void setUp() throws Exception {
		this.booleanFilter = new BooleanFilter(true);
		
		this.user = new LinkedHashMap<String, String>();
		
		user.put("firstname", "Joe");
		user.put("surname", "Bloggs");
		user.put("role", "administrator");
		user.put("age", "35");
	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatches() {
		
		boolean result = this.booleanFilter.matches(this.user);
		
		assertEquals(true, result);
	}

}
