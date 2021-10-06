package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.Airplane;
import africa.semicolon.airlinBookingSystem.data.models.BookingEnquiry;
import africa.semicolon.airlinBookingSystem.data.models.FlightInformation;
import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.data.repositories.AirplaneDataBase;
import africa.semicolon.airlinBookingSystem.data.repositories.FlightInformationDataBase;
import africa.semicolon.airlinBookingSystem.data.repositories.PassengerDataBase;
import africa.semicolon.airlinBookingSystem.exceptions.AirlineSystemException;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PassengerServiceImpl implements PassengerService {
    PassengerDataBase passengerDataBase = PassengerDataBase.getInstance();
    FlightInformationDataBase flightInfoDataBase = FlightInformationDataBase.getInstance();
    AirplaneDataBase planeDataBase = AirplaneDataBase.getInstance();


    @Override
    public void registerPassenger(Passenger newPassenger) throws PassengerAlreadyRegisteredException {
        if(passengerDataBase.getPassengers().containsValue(newPassenger)){
           throw new PassengerAlreadyRegisteredException("Passenger already registered");
        }
        passengerDataBase.save(newPassenger);
    }

    @Override
    public void login(String email, String password) {
        Map<String, Passenger> allPassengers = passengerDataBase.getPassengers();
        Passenger passenger = allPassengers.get(email);
        if(Objects.equals(passenger.getPassword(), password)){
            passenger.setActive(true);
        }
    }

    @Override
    public void logout(Passenger passenger1) {
        passenger1.setActive(false);
    }

    @Override
    public void clearPassenger() {
        passengerDataBase.getPassengers().clear();
    }

    @Override
    public List<Airplane> airlineBookingEnquiries(BookingEnquiry newBooker) {
        Passenger foundPassenger = passengerDataBase.searchPassenger(newBooker.getPassengerEmail());
        foundPassenger.setBookingEnquiries(newBooker);
        return planeDataBase.searchFlight(newBooker);
    }
}
