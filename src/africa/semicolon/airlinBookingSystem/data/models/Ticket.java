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

