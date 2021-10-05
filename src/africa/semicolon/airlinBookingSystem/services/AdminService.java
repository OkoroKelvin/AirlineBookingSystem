package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.exceptions.UserNotFoundException;

import java.util.List;

public interface AdminService {
    void deletePassenger(String email);
    Passenger searchPassenger(String email) throws UserNotFoundException;
}
