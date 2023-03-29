package com.example.demo.myTests;

import java.sql.*;

public class MyMainClass {
    static final String DB_URL = "jdbc:mysql://localhost/mydatabase?user=user&password=1234";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Selecting all records from the table...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Age: " + age);
            }

            System.out.println("Selecting only the first element of the table...");
            sql = "SELECT * FROM student LIMIT 1";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", Name: " + firstName + " " + lastName + ", Age: " + age);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se3) {
                se3.printStackTrace();
            }
        }
        System.out.println("Connections are closed");
    }
}
