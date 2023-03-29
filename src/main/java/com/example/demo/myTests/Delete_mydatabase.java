package com.example.demo.myTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_mydatabase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "user";
    static final String PASS = "1234";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating database...");
            statement = connection.createStatement();
            String sql = "DROP DATABASE mydatabase";
            statement.executeUpdate(sql);
            System.out.println("Database deleted successfully!");

            statement.close();
            connection.close();
        } catch (SQLException se) {
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
