package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.Airplane;
import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.exceptions.UserNotFoundException;

public interface AdminService {
    void deletePassenger(String email);
    Passenger searchPassenger(String email) throws UserNotFoundException;

    void addAirplane(Airplane airplane);

    void deleteAirplane(Airplane airplane);
}
