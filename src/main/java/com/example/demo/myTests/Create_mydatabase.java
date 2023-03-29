package com.example.demo.myTests;

import java.sql.*;

public class Create_mydatabase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "user";
    static final String PASS = "1234";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            // Open a connection to the database server
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create the database
            System.out.println("Creating database...");
            statement = connection.createStatement();
            String sql = "CREATE DATABASE mydatabase";
            statement.executeUpdate(sql);
            System.out.println("Database created successfully!");

            statement.close();
            connection.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
        System.out.println("Connections are closed");
    }
}
