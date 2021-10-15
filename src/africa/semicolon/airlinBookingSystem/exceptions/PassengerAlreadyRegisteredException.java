package africa.semicolon.airlinBookingSystem.exceptions;

public class PassengerAlreadyRegisteredException extends Exception {
    public PassengerAlreadyRegisteredException(String message) {
        this(message, null);
    }

    public PassengerAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

}
