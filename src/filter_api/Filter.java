package filter_api;

import java.util.Map;

public interface Filter {
	public boolean matches(Map<String, String> resource);
}
