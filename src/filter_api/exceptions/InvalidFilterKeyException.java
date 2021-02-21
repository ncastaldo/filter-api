package filter_api.exceptions;

/**
 * 
 * The class represents a RuntimeException and must be thrown
 * when a FilterKey property is invalid in the execution contest.
 * 
 */
public class InvalidFilterKeyException extends RuntimeException {
	public InvalidFilterKeyException(String errorMessage) {
        super(errorMessage);
    }
}
