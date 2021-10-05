package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.Admin;
import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;
import africa.semicolon.airlinBookingSystem.exceptions.UserNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceImplTest {
    AdminService adminService;
    Admin admin;
    Passenger passenger1;
    Passenger passenger2;
    PassengerService passengerService;

    @BeforeEach
    void setUp() {
        adminService = new AdminServiceImpl();
        admin = new Admin("kelvin1405","admin1234");
        passengerService = new PassengerServiceImpl();
        passenger1 = new Passenger("1","Kelvin","Okoro","kelvin@yahoo.com",
                "1123","street","08163091749");
        passenger2 = new Passenger("2","Ovie","Okoro","ovie@yahoo.com",
                "1123","street","99999999999");

    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @DisplayName("Admin Can Login")
    void testThatAdminCanLogin(){

    }
    @Test
    @DisplayName("Admin can search for Passengers")
    void testThatAdminCanSearchForPassengers() throws UserNotFoundException {

        try {
            passengerService.registerPassenger(passenger1);
            passengerService.registerPassenger(passenger2);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        try {
         adminService.searchPassenger("ovie@yahoo.com");
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(passenger2,adminService.searchPassenger("ovie@yahoo.com"));
    }

    @Test
    @DisplayName("Admin can delete passenger")
    void testThatAdminCanDeletePassenger() throws UserNotFoundException {

        try {
            passengerService.registerPassenger(passenger1);
            passengerService.registerPassenger(passenger2);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }
        adminService.deletePassenger("like@yahoo.com");


        try {
           Passenger foundPassenger= adminService.searchPassenger("like@yahoo.com");
           assertNull(foundPassenger);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        UserNotFoundException exception = assertThrows(UserNotFoundException.class,
                () -> adminService.searchPassenger("like@yahoo.com"));
        assertEquals("Passenger with the email not found",
                exception.getLocalizedMessage());

    }
    @Test
    @DisplayName("Admin can add Airplane for services")
    void testThatAdminCanAddAirplaneForPassengersToBook(){
        Airplane airplane = new Airplane("Ark","Delta","Lagos");
        adminService.addAirplane(airplane);
    }

}