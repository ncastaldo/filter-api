package filter_api.exceptions;

/**
 * 
 * The class represents a RuntimeException and must be thrown
 * when a mandatory property is not found in a filtered resource.
 * 
 */
public class PropertyMissingException extends RuntimeException {
	public PropertyMissingException(String errorMessage) {
        super(errorMessage);
    }
}
