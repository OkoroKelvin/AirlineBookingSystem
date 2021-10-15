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

    public Airplane searchFlight(BookingEnquiry newBooker) {
        List<Airplane> listOfPlanes = new ArrayList<>(airplanes.values());
        for (Airplane airplane : listOfPlanes) {
            if (airplane.getOrigin().equals(newBooker.getOrigin()) && airplane.getDestination().equals(newBooker.getDestination())&&
            airplane.getDateOfFlight().equals(newBooker.getDepartureDate())) {
                return airplane;
            }
        }
        return null;
    }
}
