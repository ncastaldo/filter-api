package filter_api;

import java.util.Map;

/**
 * 
 * This class implements a Filter that only supports true/false values.
 *
 */
public class BooleanFilter implements Filter {
	
	private boolean value;
	
	public BooleanFilter(boolean value) {
		this.value = value;
	}
	
	public boolean matches(Map<String, String> resource) {
		return value;
	}

	public boolean isValue() {
		return value;
	}

	public BooleanFilter setValue(boolean value) {
		this.value = value;
		
		return this;
	}
	
}
