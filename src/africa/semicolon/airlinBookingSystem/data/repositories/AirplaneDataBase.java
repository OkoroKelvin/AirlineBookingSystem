package africa.semicolon.airlinBookingSystem.data.repositories;

import africa.semicolon.airlinBookingSystem.data.models.Airplane;
import africa.semicolon.airlinBookingSystem.data.models.BookingEnquiry;
import africa.semicolon.airlinBookingSystem.exceptions.AirlineSystemException;

import java.util.*;

public class AirplaneDataBase {
    private final Map<Integer, Airplane> airplanes = new HashMap<>();
    private static AirplaneDataBase instance = null;

    public static AirplaneDataBase getInstance() {
        if (instance == null) instance = new AirplaneDataBase();
        return instance;
    }

    public void save(Airplane airplane) {
        airplanes.put(airplane.getAirPlaneId(), airplane);
    }
    public Airplane searchAirplane(int airPlaneId) {
        return airplanes.get(airPlaneId);
    }

    public int getSize() {
        return airplanes.size();
    }

    public void deleteAirplane(int airplaneId) {
        Airplane foundAirplane = searchAirplane(airplaneId);
        airplanes.remove(foundAirplane.getAirPlaneId(), foundAirplane);
    }

    public List<Airplane> searchFlight(BookingEnquiry newBooker) {
        List<Airplane> listOfPlanes = new ArrayList<>(airplanes.values());
        List<Airplane> foundAirplane = new ArrayList<>();
        for (Airplane airplane : listOfPlanes){
            if(Objects.equals(airplane.getOrigin(), newBooker.getOrigin()) &&
                    Objects.equals(airplane.getDestination(),
                            newBooker.getDestination()) &&
                    airplane.getDateOfFlight()==newBooker.getDepartureDate()){
                foundAirplane.add(airplane);
            }

        }
        return foundAirplane;
    }
}
