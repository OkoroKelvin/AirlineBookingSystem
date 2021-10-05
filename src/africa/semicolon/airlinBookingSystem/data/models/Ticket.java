package africa.semicolon.airlinBookingSystem.data.models;

import java.time.LocalDateTime;

public class Ticket {
    private int id;
    private String ticketDescription;
    private Passenger passenger;
    private String passengerNum;
    private LocalDateTime ticketDate;
    private String ticketType;


    public Ticket(int id, String ticketDescription, Passenger passenger, String passengerNum, String ticketType) {
        this.id = id;
        this.ticketDescription = ticketDescription;
        this.passenger = passenger;
        this.passengerNum = passengerNum;
        this.ticketDate = LocalDateTime.now();
        this.ticketType = ticketType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}

