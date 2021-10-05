package africa.semicolon.airlinBookingSystem.data.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingEnquiry {
    private String origin;
    private String destination;
    private String bookingEnquiryDescription;
    private LocalDateTime bookingEnquiryDate;


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
}