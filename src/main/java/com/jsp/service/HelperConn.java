package com.jsp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperConn {
    // Update these details based on your MySQL server configuration
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hotelcalifornia";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "";

    // This method establishes a database connection and returns the Connection object
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }

        return connection;
    }

    // This method closes the database connection
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle or log the exception appropriately
            }
        }
    }
}
