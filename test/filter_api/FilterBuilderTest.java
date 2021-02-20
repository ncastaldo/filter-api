package filter_api;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilterBuilderTest {
	
	private JSONObject json;

	private Map<String, String> user;

	@Before
	public void setUp() throws Exception {
		
		String userDir = System.getProperty("user.dir");
		String filePath = Paths.get(userDir, "resources", "filter-config.json").toString();
		
		FileReader reader = new FileReader(filePath);
	    JSONParser jsonParser = new JSONParser();
	    this.json = (JSONObject) jsonParser.parse(reader);
	    
	    
	    this.user = new LinkedHashMap<String, String>();
		
		user.put("username", "ncastaldo");
		user.put("city", "Udine");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFilter() {
		
		Filter filter = FilterBuilder.getFilter(this.json);
		
		assertEquals(true, filter.matches(this.user));		
		
		this.user.put("city", "New York");
	
		assertEquals(false, filter.matches(this.user));		
		
	}

}
