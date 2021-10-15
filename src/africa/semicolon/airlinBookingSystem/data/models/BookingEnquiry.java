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

    public String getDestination() {
        return destination;
    }

    public String getBookingEnquiryDescription() {
        return bookingEnquiryDescription;
    }



    public String getPassengerEmail() {
        return passengerEmail;
    }


    public String getDepartureDate() {
            int year = departureDate.getYear();
            int month = departureDate.getMonthValue();
            int day = departureDate.getDayOfMonth();
            return year +"/"+month +"/"+day;
    }

}