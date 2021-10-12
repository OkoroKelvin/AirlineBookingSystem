package africa.semicolon.airlinBookingSystem.data.models;

public class Airplane {
    private int airPlaneId;
    private String flightName;
    private String origin;
    private String destination;
    private String dateOfFlight;
    private String timeOfFLight;
    private String timeOfLanding;
    private double costOfFlight;
    private final Boolean[] seats = new Boolean[20];


    public Airplane(int airPlaneId,String flightName, String origin, String destination,String dateOfFlight,String timeOfFLight,String timeOfLanding,double costOfFlight) {
        this.airPlaneId = airPlaneId;
        this.flightName = flightName;
        this.origin = origin;
        this.destination = destination;
        this.dateOfFlight = dateOfFlight;
        this.timeOfFLight = timeOfFLight;
        this.timeOfLanding = timeOfLanding;
        this.costOfFlight = costOfFlight;
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

    public void setSeats() {
        for(int i = 0; i < seats.length; i++ ){
            if(!seats[i]){
                seats[i]=true;
                break;
            }
        }
    }

    public int getAirPlaneId() {
        return airPlaneId;
    }

    public void setAirPlaneId(int airPlaneId) {
        this.airPlaneId = airPlaneId;
    }

    public String getTimeOfFLight() {
        return timeOfFLight;
    }

    public void setTimeOfFLight(String timeOfFLight) {
        this.timeOfFLight = timeOfFLight;
    }

    public String getTimeOfLanding() {
        return timeOfLanding;
    }

    public void setTimeOfLanding(String timeOfLanding) {
        this.timeOfLanding = timeOfLanding;
    }

    public double getCostOfFlight() {
        return costOfFlight;
    }

    public void setCostOfFlight(double costOfFlight) {
        this.costOfFlight = costOfFlight;
    }

    public String getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(String dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
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
