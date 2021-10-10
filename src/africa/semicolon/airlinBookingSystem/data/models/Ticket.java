package africa.semicolon.airlinBookingSystem.data.models;

import java.time.LocalDateTime;

public class Ticket {
    private String passengerName;
    private String passengerEmail;
    private String passengerNum;
    private String ticketDescription;
    private LocalDateTime ticketDate;

    public Ticket(String passengerName,String passengerEmail,String passengerNum, String ticketDescription) {
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;
        this.ticketDescription = ticketDescription;
        this.passengerNum = passengerNum;
        this.ticketDate = LocalDateTime.now();
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
                 """,
        passengerName,  passengerEmail,  passengerNum, ticketDescription);
    }
}

