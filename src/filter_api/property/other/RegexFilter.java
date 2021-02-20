package filter_api.property.other;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import filter_api.property.PropertyFilter;

public class RegexFilter extends PropertyFilter {
	
	private final Pattern pattern; 

	public RegexFilter (String property, Pattern pattern) {
		super(property);
		this.pattern = pattern;
	}
	
	public RegexFilter (String property, String patternString) {
		super(property);
		this.pattern = Pattern.compile(patternString);
	}

	public boolean doMatch(Map<String, String> resource) {
		String name = resource.get(this.property);
		Matcher matcher = this.pattern.matcher(name);
		return matcher.find();
	}
}
