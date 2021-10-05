package africa.semicolon.airlinBookingSystem.services;


import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.data.repositories.PassengerDataBase;
import africa.semicolon.airlinBookingSystem.exceptions.UserNotFoundException;

public class AdminServiceImpl implements AdminService {
    PassengerDataBase passengerDataBase = PassengerDataBase.getInstance();


    @Override
    public void deletePassenger(String email) {
        passengerDataBase.deletePassenger(email);
    }

    @Override
    public Passenger searchPassenger(String email) throws UserNotFoundException {
        Passenger foundPassenger = passengerDataBase.searchPassenger(email);
        if(foundPassenger == null){
            throw new UserNotFoundException("Passenger with the email not found");
        }
        return foundPassenger;
    }

    @Override
    public Airplane addAirplane(Airplane airplane) {

        return null;
    }
}
