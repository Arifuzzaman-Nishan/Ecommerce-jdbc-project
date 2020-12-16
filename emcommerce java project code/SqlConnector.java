package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class SqlConnector {

    private static Connection conn = null;

    static Connection getInstance()
    {
        if(conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/ecommerce" ,"root","");
                System.out.println("Connection Established.....");
            } catch (SQLException e) {
                System.err.println("DATABASE_CONNECTION_ERR");
                e.printStackTrace();
            }
        }
        return conn;
    }


}
