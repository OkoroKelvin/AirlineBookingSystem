package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.Admin;
import africa.semicolon.airlinBookingSystem.data.models.BookingEnquiry;
import africa.semicolon.airlinBookingSystem.data.models.FlightInformation;
import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.data.repositories.PassengerDataBase;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceImplTest {
    PassengerService passengerService;


    @BeforeEach
    void setUp() {
        passengerService = new PassengerServiceImpl();

    }

    @AfterEach
    void tearDown() {
        passengerService.clearPassenger();
    }

    @Test
    @DisplayName("Passenger can register")
    void testThatPassengerCanRegister() {
        Passenger passenger1;
        Passenger passenger2;

        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "street", "07127619876");
        try {
            passengerService.registerPassenger(passenger1);
            passengerService.registerPassenger(passenger2);

        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        assertEquals(2, PassengerDataBase.getInstance().getSize());
    }


    @Test
    @DisplayName("No duplicate passenger can register")
    void testThatThrowsAssertionExceptionForDuplicatePassenger() {
        Passenger passenger1;
        Passenger passenger2;

        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("1", "Theophilus", "Sunday", "kelvin@yahoo.com",
                "1223", "street", "08163091749");

        try {
            passengerService.registerPassenger(passenger1);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        PassengerAlreadyRegisteredException exception = assertThrows(PassengerAlreadyRegisteredException.class,
                () -> passengerService.registerPassenger(passenger2));
        assertEquals("Passenger already registered",
                exception.getLocalizedMessage());
    }

    @Test
    @DisplayName("Registered passenger can login")
    void registeredPassengerCanLogin() {
        Passenger passenger1;
        Passenger passenger2;

        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "street", "07127619876");

        try {
            passengerService.registerPassenger(passenger1);
            passengerService.registerPassenger(passenger2);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        passengerService.login("kelvin@yahoo.com", "1123");
        assertTrue(passenger1.isActive());
        passengerService.logout(passenger1);
        assertFalse(passenger1.isActive());

    }

    @Test
    @DisplayName("Registered passenger can logout")
    void registeredPassengerCanLogout() {

        Passenger passenger1;
        Passenger passenger2;


        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "street", "07127619876");

        try {
            passengerService.registerPassenger(passenger1);
            passengerService.registerPassenger(passenger2);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        passengerService.login("kelvin@yahoo.com", "1123");
        passengerService.logout(passenger1);
        assertFalse(passenger1.isActive());
    }
    @Test
    @DisplayName("Passenger to Search for available flight")
    void testThatPassengerCanSearchForBookingOfFlight(){
        Passenger passenger1;
        Passenger passenger2;


        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "street", "07127619876");

        try {
            passengerService.registerPassenger(passenger1);
            passengerService.registerPassenger(passenger2);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        passengerService.login("kelvin@yahoo.com", "1123");
        BookingEnquiry booker = new BookingEnquiry();
        FlightInformation onFlight = passengerService.airlineBookingEnquiries(booker);
    }
}