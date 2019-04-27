package ogame.exceptions;

public class OGameNoSuchWebElementException extends RuntimeException {

    /**
     * Default Message Exception
     */
    private static final String DEFAULT_MESSAGE_ERROR = "No such web element on page";

    public OGameNoSuchWebElementException() {
        super(DEFAULT_MESSAGE_ERROR);
    }

    public OGameNoSuchWebElementException(String message) {
        super(message);

    }

    public OGameNoSuchWebElementException(Throwable cause) {
        super(cause);

    }

    public OGameNoSuchWebElementException(String message, Throwable cause) {
        super(message, cause);

    }
}
