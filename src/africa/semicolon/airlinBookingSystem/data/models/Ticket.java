package africa.semicolon.airlinBookingSystem.data.models;

import java.time.LocalDateTime;

public class Ticket {
    private String passengerName;
    private String passengerEmail;
    private String passengerNum;
    private String ticketDescription;
    private LocalDateTime ticketDate;
    private String dateOfDeparture;
    private String timeOfDeparture;
    private String timeOfLanding;
    private int seatNumber;

    public Ticket(String passengerName,String passengerEmail,String passengerNum, String ticketDescription, int seatNumber,String dateOfDeparture,String timeOfDeparture,String timeOfLanding) {
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;
        this.ticketDescription = ticketDescription;
        this.passengerNum = passengerNum;
        this.ticketDate = LocalDateTime.now();
        this.seatNumber = seatNumber;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfLanding = timeOfLanding;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public String getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(String passengerNum) {
        this.passengerNum = passengerNum;
    }

    public LocalDateTime getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(LocalDateTime ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public String getTimeOfLanding() {
        return timeOfLanding;
    }

    public void setTimeOfLanding(String timeOfLanding) {
        this.timeOfLanding = timeOfLanding;
    }

    @Override
    public String toString() {
        return String.format("""
                Airline Ticket
                ===================================
                ===================================\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                Passenger Name = %s
                Passenger Email = %s
                Passenger Number = %s
                Ticket Description = %s
                Ticket seat Number = %d
                Departure Date = %s
                Time of Departure= %s
                Time of Landing= %s
                 """,
        passengerName,  passengerEmail,  passengerNum, ticketDescription,seatNumber,dateOfDeparture,timeOfDeparture,timeOfLanding );
    }
}

