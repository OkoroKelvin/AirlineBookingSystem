package africa.semicolon.airlinBookingSystem.data.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Airplane {
    private int airPlaneId;
    private String flightName;
    private String origin;
    private String destination;
    private LocalDate dateOfFlight;
    private LocalTime timeOfFLight;
    private LocalTime timeOfLanding;
    private static List<Boolean> seats = new ArrayList<>();


    public Airplane(int airPlaneId,String flightName, String origin, String destination,LocalDate dateOfFlight,LocalTime timeOfFLight,LocalTime timeOfLanding) {
        this.airPlaneId = airPlaneId;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.dateOfFlight = dateOfFlight;
        this.timeOfFLight = timeOfFLight;
        this.timeOfLanding = timeOfLanding;
    }

    public Airplane() {

    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public static int getSeats() {
        return seats.size();
    }

    public void setSeats() {
        Boolean state = true;
        if (seats.size() < 20) {
            seats.add(true);
        }
        else {
            System.out.println("The seat is filled up");
        }
    }

    public int getAirPlaneId() {
        return airPlaneId;
    }

    public void setAirPlaneId(int airPlaneId) {
        this.airPlaneId = airPlaneId;
    }

    public String getDateOfFlight() {
        int year = dateOfFlight.getYear();
        int month = dateOfFlight.getMonthValue();
        int day = dateOfFlight.getDayOfMonth();
        return year +"/"+month +"/"+day;
    }

    public void setDateOfFlight(LocalDate dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public LocalTime getTimeOfFLight() {
        return timeOfFLight;
    }

    public void setTimeOfFLight(LocalTime timeOfFLight) {
        this.timeOfFLight = timeOfFLight;
    }

    public LocalTime getTimeOfLanding() {
        return timeOfLanding;
    }

    public void setTimeOfLanding(LocalTime timeOfLanding) {
        this.timeOfLanding = timeOfLanding;
    }

    public void setSeats(List<Boolean> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return String.format("""
                        Airplane ID = %d
                        Flight Name = %s
                        Origin Location = %s
                        Destination Location = %s
                        Date Of Flight = %s
                        Time Of Flight = %s
                        Time Of Landing = %s""",
                airPlaneId, flightName,origin,destination,dateOfFlight,timeOfFLight,timeOfLanding);
    }
}
