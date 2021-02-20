package filter_api.property.other;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import filter_api.property.PropertyFilter;

public class RegexFilter extends PropertyFilter {
	
	private Pattern pattern; 

	public RegexFilter (String property, Pattern pattern) {
		super(property);
		this.pattern = pattern;
	}
	
	public RegexFilter (String property, String patternString) {
		super(property);
		this.setPatternString(patternString);
	}

	public boolean propertyMatches(Map<String, String> resource) {
		String value = resource.get(this.property);
		Matcher matcher = this.pattern.matcher(value.toLowerCase());
		return matcher.find();
	}

	public Pattern getPattern() {
		return pattern;
	}

	public RegexFilter setPattern(Pattern pattern) {
		this.pattern = pattern;
		
		return this;
	}
	
	
	public RegexFilter setPatternString(String patternString) {
		this.pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		
		return this;
	}
	
	
}
