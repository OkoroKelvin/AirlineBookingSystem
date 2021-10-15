package africa.semicolon.airlinBookingSystem.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        this(message, null);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
