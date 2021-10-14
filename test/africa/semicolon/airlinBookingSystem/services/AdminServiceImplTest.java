package africa.semicolon.airlinBookingSystem.services;

import africa.semicolon.airlinBookingSystem.data.models.Admin;
import africa.semicolon.airlinBookingSystem.data.models.Airplane;
import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.data.repositories.AirplaneDataBase;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;
import africa.semicolon.airlinBookingSystem.exceptions.UserNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceImplTest {
    AdminService adminService;
    Admin admin;
    Passenger passenger1;
    Passenger passenger2;
    PassengerService passengerService;
//    AirplaneDataBase planeDataBase;

    @BeforeEach
    void setUp() {
        adminService = new AdminServiceImpl();
        admin = new Admin("kelvin1405","admin1234");
        passengerService = new PassengerServiceImpl();
        passenger1 = new Passenger("1","Kelvin","Okoro","kelvin@yahoo.com",
                "1123","street","08163091749");
        passenger2 = new Passenger("2","Ovie","Okoro","ovie@yahoo.com",
                "1123","street","99999999999");

//        planeDataBase = new AirplaneDataBase();
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
        adminService.addAirplane(love);
        assertEquals(2,AirplaneDataBase.getInstance().getSize());
    }


    @Test
    @DisplayName("Admin can Delete Airplane from Service")
    void testThatAdminCanDeleteAirplaneFromPassengerService(){
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
        adminService.addAirplane(love);
        adminService.deleteAirplane(peace);
        assertEquals(1,AirplaneDataBase.getInstance().getSize());
    }
}