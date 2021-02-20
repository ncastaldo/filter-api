package filter_api.exceptions;

@SuppressWarnings("serial")
public class PropertyMissingException extends RuntimeException {
	public PropertyMissingException(String errorMessage) {
        super(errorMessage);
    }
}
