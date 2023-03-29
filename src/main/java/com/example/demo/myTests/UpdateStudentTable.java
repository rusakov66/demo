package com.example.demo.myTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudentTable {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
    static final String USER = "user";
    static final String PASS = "1234";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();

            System.out.println("Inserting a new entry into the table...");
            String sql = "INSERT INTO student VALUES (11, 'Jane', 'Doe', 22)";
            stmt.executeUpdate(sql);

            String firstName = "Ion";
            int id = 3;
            System.out.println("Updating first name for student with id=" + id + " to " + firstName);
            sql = "UPDATE student SET first_name='" + firstName + "' WHERE id=" + id;
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
        }
        System.out.println("Connections are closed");
    }
}
