package com.company;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

    private  String firstName;
    private  String lastName;
    private String userEmail;
    private static String userName;
    private String userPassword;



    public User() {
    }



    public User(String userName, String userPassword) {
        this.userName = userName;  
        this.userPassword = userPassword;
    }



    public User(String firstName, String lastName, String userEmail, String userName, String userPassword) {
       setFirstName(firstName);
       setLastName(lastName);
       setUserEmail(userEmail);
       setUserName(userName);
       setUserPassword(userPassword);
    }



    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public static String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }


}
