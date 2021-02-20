package filter_api;

import java.util.Map;

/**
 * 
 * @author Nicola
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
