package africa.semicolon.airlinBookingSystem.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingEnquiry {
    private String passengerEmail;
    private String origin;
    private String destination;
    private String bookingEnquiryDescription;
    private LocalDateTime bookingEnquiryDate;
    private LocalDate departureDate;

    public BookingEnquiry(String passengerEmail, String origin, String destination, String bookingEnquiryDescription, LocalDate departureDate) {
        this.passengerEmail = passengerEmail;
        this.origin = origin;
        this.destination = destination;
        this.bookingEnquiryDescription = bookingEnquiryDescription;
        this.bookingEnquiryDate = LocalDateTime.now();
        this.departureDate = departureDate;
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

    public String getBookingEnquiryDescription() {
        return bookingEnquiryDescription;
    }

    public void setBookingEnquiryDescription(String bookingEnquiryDescription) {
        this.bookingEnquiryDescription = bookingEnquiryDescription;
    }

    public LocalDateTime getBookingEnquiryDate() {
        return bookingEnquiryDate;
    }

    public void setBookingEnquiryDate(LocalDateTime bookingEnquiryDate) {
        this.bookingEnquiryDate = bookingEnquiryDate;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}