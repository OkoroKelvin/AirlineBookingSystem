package africa.semicolon.airlinBookingSystem.data.repositories;

import africa.semicolon.airlinBookingSystem.data.models.Airplane;
import africa.semicolon.airlinBookingSystem.data.models.Passenger;

import java.util.HashMap;
import java.util.Map;

public class AirplaneDataBase {
    private final Map<Integer, Airplane> airplanes = new HashMap<>();

    private static AirplaneDataBase instance = null;


    public static AirplaneDataBase getInstance(){
        if (instance == null){
            instance = new AirplaneDataBase();
        }
        return instance;
    }

    public void save(Airplane airplane) {
        airplanes.put(airplane.getAirPlaneId(),airplane);
    }

    public Airplane searchAirplane(int airPlaneId) {
        return airplanes.get(airPlaneId);
    }

    public int getSize() {
        return airplanes.size();
    }

    public void deleteAirplane(int airplaneId) {
       Airplane foundAirplane =  searchAirplane(airplaneId);
       airplanes.remove(foundAirplane.getAirPlaneId(),foundAirplane);
    }
}
