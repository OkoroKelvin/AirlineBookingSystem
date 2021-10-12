package africa.semicolon.airlinBookingSystem.data.models;

import africa.semicolon.airlinBookingSystem.data.repositories.AirplaneDataBase;

import java.util.ArrayList;
import java.util.List;

public class AvailableAirplanes {

    List<Airplane> newAvailableAirplanes = new ArrayList<>();
    private static AvailableAirplanes instance = null;
    public static AvailableAirplanes getInstance() {
        if (instance == null) instance = new AvailableAirplanes();
        return instance;
    }


    public List<Airplane> getAvailableAirplanes() {
        return newAvailableAirplanes;
    }

    public void addAvailableAirplanes(Airplane airplane) {
        newAvailableAirplanes.add(airplane);

    }
}
