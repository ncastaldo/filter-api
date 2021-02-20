package filter_api;

import java.util.Map;

/**
 * 
 * @author Nicola
 *
 */
public interface Filter {
	public boolean matches(Map<String, String> resource);
}
