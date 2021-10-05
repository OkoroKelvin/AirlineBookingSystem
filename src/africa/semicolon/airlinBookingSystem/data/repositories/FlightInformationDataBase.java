package africa.semicolon.airlinBookingSystem.data.repositories;

import africa.semicolon.airlinBookingSystem.data.models.FlightInformation;

import java.util.HashMap;
import java.util.Map;

public class FlightInformationDataBase {
    private final Map<String, FlightInformation> airlineEnquiries = new HashMap<>();

    private static FlightInformationDataBase instance = null;


    public static FlightInformationDataBase getInstance(){
        if (instance == null){
            instance = new FlightInformationDataBase();
        }
        return instance;
    }

    public FlightInformation searchFlight(String origin, String destination) {
        return null;
    }
}
