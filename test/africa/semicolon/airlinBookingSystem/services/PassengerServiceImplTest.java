package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.*;
import africa.semicolon.airlinBookingSystem.data.repositories.PassengerDataBase;
import africa.semicolon.airlinBookingSystem.exceptions.AirlineSystemException;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceImplTest {
    PassengerService passengerService;
    AdminService adminService;


    @BeforeEach
    void setUp() {
        passengerService = new PassengerServiceImpl();
        adminService = new AdminServiceImpl();

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
    void testThatPassengerCanSearchForBookingOfFlight() throws AirlineSystemException {
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
        Airplane peace = new Airplane(1,"peace flight","kano","lagos",
                "25/10/2021","1;30pm","4:00pm",5000);
        Airplane love = new Airplane(2,"love flight","delta","turkey",
                "26/10/2021","3:30pm","9:00pm",6500);
        Airplane excel = new Airplane(3,"excel flight","delta","turkey",
                "26/10/2021","3:25pm","5:22pm",5390);
        Airplane eagle = new Airplane(4,"eagle flight","kano","turkey",
                "25/11/2021","2:15am","7:00am",10000);
        adminService.addAirplane(peace);
        adminService.addAirplane( love);
        adminService.addAirplane( excel);
        adminService.addAirplane( eagle);
        BookingEnquiry booker = new BookingEnquiry("kelvin@yahoo.com","delta","turkey","Flight oversea");
        List<Airplane> onFlight = passengerService.airlineBookingEnquiries(booker);
        System.out.println(onFlight);
       assertEquals(love,onFlight.get(0));
       assertEquals(excel,onFlight.get(1));
    }
    @Test
    @DisplayName("Passenger can select and book available flight")
    void passengerCanSelectAndBookAvaFlight() throws AirlineSystemException {
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
        Airplane peace = new Airplane(1,"peace flight","kano","lagos",
                "25/10/2021","1;30pm","4:00pm",5000);
        Airplane love = new Airplane(2,"love flight","delta","turkey",
                "26/10/2021","3:30pm","9:00pm",6500);
        Airplane excel = new Airplane(3,"excel flight","delta","turkey",
                "26/10/2021","3:25pm","5:22pm",5390);
        Airplane eagle = new Airplane(4,"eagle flight","kano","turkey",
                "25/11/2021","2:15am","7:00am",10000);
        adminService.addAirplane(peace);
        adminService.addAirplane( love);
        adminService.addAirplane( excel);
        adminService.addAirplane( eagle);
        BookingEnquiry booker = new BookingEnquiry("kelvin@yahoo.com","delta","turkey","Flight oversea");
        passengerService.airlineBookingEnquiries(booker);
        Ticket ticket = passengerService.bookAirline(booker);
        System.out.println(ticket);
        assertEquals(1,Passenger.getTickets().size());
    }
}