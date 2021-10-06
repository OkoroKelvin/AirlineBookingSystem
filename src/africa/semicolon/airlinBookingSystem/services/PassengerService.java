package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.Airplane;
import africa.semicolon.airlinBookingSystem.data.models.BookingEnquiry;
import africa.semicolon.airlinBookingSystem.data.models.FlightInformation;
import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.exceptions.AirlineSystemException;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;

import java.util.List;

public interface PassengerService {
    void registerPassenger(Passenger passenger) throws PassengerAlreadyRegisteredException;

    void login(String email, String password);

    void logout(Passenger passenger1);

    void clearPassenger();

   List<Airplane> airlineBookingEnquiries(BookingEnquiry newBookingEnquiry) throws AirlineSystemException;
}
