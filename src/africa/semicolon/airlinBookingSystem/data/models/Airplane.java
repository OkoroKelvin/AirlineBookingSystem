package africa.semicolon.airlinBookingSystem.data.models;

public class Airplane {
    private int airPlaneId;
    private String flightName;
    private String origin;
    private String destination;
    private Boolean[] seats;

    public Airplane(int airPlaneId,String flightName, String origin, String destination) {
        this.airPlaneId = airPlaneId;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.seats = new Boolean[20];
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

    public Boolean[] getSeats() {
        return seats;
    }

    public void setSeats(Boolean[] seats) {
        this.seats = seats;
    }

    public int getAirPlaneId() {
        return airPlaneId;
    }

    public void setAirPlaneId(int airPlaneId) {
        this.airPlaneId = airPlaneId;
    }
}
