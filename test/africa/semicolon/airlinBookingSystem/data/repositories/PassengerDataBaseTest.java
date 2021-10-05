package africa.semicolon.airlinBookingSystem.data.repositories;

import africa.semicolon.airlinBookingSystem.data.models.Passenger;
import africa.semicolon.airlinBookingSystem.exceptions.PassengerAlreadyRegisteredException;
import africa.semicolon.airlinBookingSystem.services.AdminService;
import africa.semicolon.airlinBookingSystem.services.PassengerService;
import africa.semicolon.airlinBookingSystem.services.PassengerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerDataBaseTest {
    PassengerDataBase passengerDataBase;
    Passenger passenger1;
    Passenger passenger2;
    PassengerService passengerService;

    @BeforeEach
    void setUp() {
        passengerDataBase = PassengerDataBase.getInstance();
        passenger1 = new Passenger("1","Kel","love","kel@yahoo.com",
                "1234","street","08163091749");
        passenger2 = new Passenger("2","Kelly",
                "Bill","kelly@yahoo.com","1234",
                "toool","99888888");
        passengerService = new PassengerServiceImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Passenger DataBase Can Save Passenger")
    void testThatPassengerDatabaseCanSavePassenger(){
        try {
            passengerService.registerPassenger(passenger1);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }
        passengerDataBase.save(passenger1);
        assertEquals(1,passengerDataBase.getSize());

    }
    @Test
    @DisplayName("DataBase can search out users with their email")
    void testThatPassengerDatabaseCanSearchPassengerViaEmail(){
            try {
                passengerService.registerPassenger(passenger1);
                passengerService.registerPassenger(passenger2);
            } catch (PassengerAlreadyRegisteredException e) {
                e.printStackTrace();
            }

            Passenger foundPassenger =passengerDataBase.searchPassenger("kelly@yahoo.com");
            assertEquals(passenger2,foundPassenger);
    }
    @Test
    @DisplayName("Database can delete passenger")
    void testThatPassengerDataBaseCanDeletePassenger(){
        try {
            passengerService.registerPassenger(passenger1);
            passengerService.registerPassenger(passenger2);
        } catch (PassengerAlreadyRegisteredException e) {
            e.printStackTrace();
        }

        passengerDataBase.deletePassenger("kelly@yahoo.com");
        Passenger foundPassenger = passengerDataBase.searchPassenger("kelly@yahoo.com");
        assertNull(foundPassenger);
    }
}