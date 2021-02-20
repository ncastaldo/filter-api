package filter_api;

import java.util.Map;
import org.json.simple.JSONObject;

public class BooleanFilter implements Filter {
	
	private boolean value;
	
	public BooleanFilter(boolean value) {
		this.value = value;
	}
	
	public boolean matches(Map<String, String> resource) {
		return value;
	}
	
	public void parse(JSONObject json) {
		this.value = (boolean) json.get("value");
	}
	
}
