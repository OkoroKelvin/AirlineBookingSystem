package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.*;
import africa.semicolon.airlinBookingSystem.exceptions.AirlineSystemException;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;

import java.util.List;

public interface PassengerService {
    void registerPassenger(Passenger passenger) throws PassengerAlreadyRegisteredException;

    void login(String email, String password);

    void logout(Passenger passenger1);

    void clearPassenger();

   List<Airplane> airlineBookingEnquiries(BookingEnquiry newBookingEnquiry) throws AirlineSystemException;

    Ticket bookAirline(BookingEnquiry booker);
}
