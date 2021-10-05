package africa.semicolon.airlinBookingSystem.data.repositories;


import africa.semicolon.airlinBookingSystem.data.models.Passenger;

import java.util.*;

public class PassengerDataBase {
    private final Map<String, Passenger> passengers = new HashMap<>();

    private static PassengerDataBase instance = null;


    public static PassengerDataBase getInstance(){
        if (instance == null){
            instance = new PassengerDataBase();
        }
        return instance;
    }


    public void save(Passenger passenger) {
        passengers.put(passenger.getEmail(), passenger);
    }

    public int getSize() {
        return passengers.size();
    }

    public Map<String, Passenger> getPassengers() {
        return passengers;
    }

    public Passenger searchPassenger(String email) {
        return passengers.get(email);
    }


    public void deletePassenger(String email) {
        passengers.remove(email,passengers.get(email));
    }
}
