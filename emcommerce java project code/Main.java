package com.company;

import java.io.IOException;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to our website....");
        Connection connection = SqlConnector.getInstance();
        Display_Method.menu();
        
    }
}
