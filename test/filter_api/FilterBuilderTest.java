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

import filter_api.logical.MultiFilter;

public class FilterBuilderTest {
	
	private JSONObject[] jsons = new JSONObject[2];

	private Map<String, String> user;

	@Before
	public void setUp() throws Exception {
		
		String userDir = System.getProperty("user.dir");
		JSONParser jsonParser = new JSONParser();
		FileReader reader;
		String filePath;
		
		filePath = Paths.get(userDir, "resources", "filterConfig1.json").toString();
		reader = new FileReader(filePath);
	    this.jsons[0] = (JSONObject) jsonParser.parse(reader);
	    
	    filePath = Paths.get(userDir, "resources", "filterConfig2.json").toString();
		reader = new FileReader(filePath);
	    this.jsons[1] = (JSONObject) jsonParser.parse(reader);
	     
	    
	    this.user = new LinkedHashMap<String, String>();
		
		user.put("username", "ncastaldo");
		user.put("city", "Udine");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetFilter() {
		Filter filter; 
		
		filter = FilterBuilder.getFilter(this.jsons[0]);
		
		assertEquals(true, filter.matches(this.user));		
		
		this.user.put("city", "New York");
	
		assertEquals(false, filter.matches(this.user));	
		
		filter = FilterBuilder.getFilter(this.jsons[1]);
		
		MultiFilter multiFilter = (MultiFilter) filter;
		
		assertEquals(multiFilter.getFilters().length, 2);
		
	}

}
