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
        Airplane peace = new Airplane(1,"peace flight","kano","lagos",
                "25/10/2021","1;30pm","4:00pm",5000);
        Airplane love = new Airplane(2,"love flight","delta","turkey",
                "26/10/2021","3:30pm","9:00pm",6500);
        Airplane excel = new Airplane(3,"excel flight","delta","turkey",
                "26/10/2021","3:25pm","5:22pm",5390);
        Airplane eagle = new Airplane(4,"eagle flight","kano","turkey",
                "25/11/2021","2:15am","7:00am",10000);
        adminService.addAirplane(peace);
        adminService.addAirplane(love);
        assertEquals(2,AirplaneDataBase.getInstance().getSize());
    }


    @Test
    @DisplayName("Admin can Delete Airplane from Service")
    void testThatAdminCanDeleteAirplaneFromPassengerService(){
        Airplane peace = new Airplane(1,"peace flight","kano","lagos",
                "25/10/2021","1;30pm","4:00pm",5000);
        Airplane love = new Airplane(2,"love flight","delta","turkey",
                "26/10/2021","3:30pm","9:00pm",6500);
        Airplane excel = new Airplane(3,"excel flight","delta","turkey",
                "26/10/2021","3:25pm","5:22pm",5390);
        Airplane eagle = new Airplane(4,"eagle flight","kano","turkey",
                "25/11/2021","2:15am","7:00am",10000);
        adminService.addAirplane(peace);
        adminService.addAirplane(love);
        adminService.deleteAirplane(peace);
        assertEquals(1,AirplaneDataBase.getInstance().getSize());
    }
}