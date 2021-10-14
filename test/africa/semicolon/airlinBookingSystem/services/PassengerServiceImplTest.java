package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.*;
import africa.semicolon.airlinBookingSystem.data.repositories.PassengerDataBase;
import africa.semicolon.airlinBookingSystem.exceptions.AirlineSystemException;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
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
    void testThatPassengerCanRegister() throws PassengerAlreadyRegisteredException {
        Passenger passenger1;
        Passenger passenger2;

        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "27 Okunfolami Street", "08163091749");

        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "324 Zealous Street", "07127619876");
        passengerService.registerPassenger(passenger1);
        passengerService.registerPassenger(passenger2);
        assertEquals(2, PassengerDataBase.getInstance().getSize());
    }

    @Test
    @DisplayName("No duplicate passenger can register")
    void testThatThrowsAssertionExceptionForDuplicatePassenger() throws PassengerAlreadyRegisteredException {
        Passenger passenger1;
        Passenger passenger2;

        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "27 Okunfolami Street", "08163091749");
        passenger2 = new Passenger("1", "Theophilus", "Sunday", "kelvin@yahoo.com",
                "1223", "street", "08163091749");

        passengerService.registerPassenger(passenger1);
        PassengerAlreadyRegisteredException exception = assertThrows(PassengerAlreadyRegisteredException.class,
                () -> passengerService.registerPassenger(passenger2));
        assertEquals("Passenger already registered",
                exception.getLocalizedMessage());
    }

    @Test
    @DisplayName("Registered passenger can login")
    void registeredPassengerCanLogin() throws PassengerAlreadyRegisteredException {
        Passenger passenger1;
        Passenger passenger2;
        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "street", "07127619876");
        passengerService.registerPassenger(passenger1);
        passengerService.registerPassenger(passenger2);
        passengerService.login("kelvin@yahoo.com", "1123");
        assertTrue(passenger1.getIsActive());
        passengerService.logout("kelvin@yahoo.com");
        assertFalse(passenger1.getIsActive());
    }

    @Test
    @DisplayName("Registered passenger can logout")
    void registeredPassengerCanLogout() throws PassengerAlreadyRegisteredException {
        Passenger passenger1;
        Passenger passenger2;
        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "street", "07127619876");

        passengerService.registerPassenger(passenger1);
        passengerService.registerPassenger(passenger2);
        passengerService.login("kelvin@yahoo.com", "1123");
        passengerService.logout("kelvin@yahoo.com");
        assertFalse(passenger1.getIsActive());
    }

    @Test
    @DisplayName("Passenger to Search for available flight")
    void testThatPassengerCanSearchForBookingOfFlight() throws AirlineSystemException, PassengerAlreadyRegisteredException {
        Passenger passenger1;
        Passenger passenger2;
        passenger1 = new Passenger("1", "Kelvin", "Okoro", "kelvin@yahoo.com",
                "1123", "street", "08163091749");
        passenger2 = new Passenger("2", "Theophilus", "Sunday", "sunday@yahoo.com",
                "1223", "street", "07127619876");

        passengerService.registerPassenger(passenger1);
        passengerService.registerPassenger(passenger2);

        passengerService.login("kelvin@yahoo.com", "1123");

        LocalTime flightTime = LocalTime.of(1, 30);
        LocalTime landingTime = LocalTime.of(6, 30);
        LocalDate flightDate =  LocalDate.of(2020, 2, 12);
        Airplane peace = new Airplane(1,"peace flight","kano","lagos",flightDate, flightTime,landingTime);


        LocalTime flightTime2 = LocalTime.of(2, 30);
        LocalTime landingTime2 = LocalTime.of(7, 30);
        LocalDate flightDate2 =  LocalDate.of(2021, 2, 11);
        Airplane love = new Airplane(2,"love flight","delta","turkey", flightDate2 ,flightTime2,landingTime2);

        LocalTime flightTime3 = LocalTime.of(1, 10);
        LocalTime landingTime3 = LocalTime.of(1, 55);
        LocalDate flightDate3 =  LocalDate.of(2021, 9, 12);
        Airplane excel = new Airplane(3,"excel flight","delta","turkey",flightDate3,flightTime3 ,landingTime3);


        LocalTime flightTime4 = LocalTime.of(9, 10);
        LocalTime landingTime4 = LocalTime.of(12, 55);
        LocalDate flightDate4 =  LocalDate.of(2021, 8, 12);
        Airplane eagle = new Airplane(4,"eagle flight","kano","turkey",flightDate4,flightTime4,landingTime4);


        adminService.addAirplane(peace);
        adminService.addAirplane( love);
        adminService.addAirplane( excel);
        adminService.addAirplane( eagle);


        LocalDate departureDate =  LocalDate.of(2021, 8, 12);
        BookingEnquiry booker = new BookingEnquiry("kelvin@yahoo.com","delta","turkey",
                "Flight oversea",departureDate);
        List<Airplane> onFlight = passengerService.airlineBookingEnquiries(booker);
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

        passengerService.login("kelvin@yahoo.com", "1123");
        LocalTime flightTime = LocalTime.of(1, 30);
        LocalTime landingTime = LocalTime.of(6, 30);
        LocalDate flightDate =  LocalDate.of(2020, 2, 12);
        Airplane peace = new Airplane(1,"peace flight","kano","lagos",flightDate, flightTime,landingTime);


        LocalTime flightTime2 = LocalTime.of(2, 30);
        LocalTime landingTime2 = LocalTime.of(7, 30);
        LocalDate flightDate2 =  LocalDate.of(2021, 2, 11);
        Airplane love = new Airplane(2,"love flight","delta","turkey", flightDate2 ,flightTime2,landingTime2);

        LocalTime flightTime3 = LocalTime.of(1, 10);
        LocalTime landingTime3 = LocalTime.of(1, 55);
        LocalDate flightDate3 =  LocalDate.of(2021, 9, 12);
        Airplane excel = new Airplane(3,"excel flight","delta","turkey",flightDate3,flightTime3 ,landingTime3);


        LocalTime flightTime4 = LocalTime.of(9, 10);
        LocalTime landingTime4 = LocalTime.of(12, 55);
        LocalDate flightDate4 =  LocalDate.of(2021, 8, 12);
        Airplane eagle = new Airplane(4,"eagle flight","kano","turkey",flightDate4,flightTime4,landingTime4);

        adminService.addAirplane(peace);
        adminService.addAirplane( love);
        adminService.addAirplane( excel);
        adminService.addAirplane( eagle);

        LocalDate departureDate =  LocalDate.of(2021, 5, 12);
        BookingEnquiry booker = new BookingEnquiry("kelvin@yahoo.com","delta","turkey",
                "Flight oversea",departureDate);
        passengerService.airlineBookingEnquiries(booker);
        Ticket ticket = passengerService.bookAirline(booker);

    }
}