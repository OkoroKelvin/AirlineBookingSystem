package africa.semicolon.airlinBookingSystem.data.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Passenger {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String id;
    private String address;
    private boolean isActive;
    private String password;
    private static final List<BookingEnquiry> bookingEnquiries = new ArrayList<>();


    public Passenger(String email){
        this.email = email;
    }

    public Passenger(String email, String password){
        this.email = email;
        this.password = password;
    }


    public Passenger(String id, String firstName, String lastName, String email, String password, String address, String phoneNumber) {
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(id, passenger.id)
                || Objects.equals(email, passenger.email)
                || Objects.equals(phoneNumber, passenger.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, phoneNumber);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static List<BookingEnquiry> getBookingEnquiries() {
        return bookingEnquiries;
    }

    public void setBookingEnquiries(BookingEnquiry bookingEnquiry) {
        bookingEnquiries.add(bookingEnquiry);
    }
}