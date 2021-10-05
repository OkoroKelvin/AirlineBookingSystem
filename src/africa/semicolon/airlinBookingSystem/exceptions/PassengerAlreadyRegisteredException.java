package africa.semicolon.airlinBookingSystem.exceptions;

public class PassengerAlreadyRegisteredException extends Exception {
    public PassengerAlreadyRegisteredException() {
    }

    public PassengerAlreadyRegisteredException(String message) {
        this(message, null);
    }

    public PassengerAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public PassengerAlreadyRegisteredException(Throwable cause) {
        this(null,cause);
    }

}
