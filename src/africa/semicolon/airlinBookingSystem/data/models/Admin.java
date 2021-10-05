package africa.semicolon.airlinBookingSystem.data.models;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(String userName, String password) {
        this.username = userName;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
