package africa.semicolon.airlinBookingSystem.exceptions;

public class AirlineSystemException extends Exception{
    public AirlineSystemException() {
    }

    public AirlineSystemException(String message) {
        this(message, null);
    }

    public AirlineSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirlineSystemException(Throwable cause) {
        this(null,cause);
    }
}
