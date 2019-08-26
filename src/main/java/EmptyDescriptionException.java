/**
 * Exception method for empty description in user input.
 */

public class EmptyDescriptionException extends Exception {
    public EmptyDescriptionException(String message) {
        super(message);
    }
}
