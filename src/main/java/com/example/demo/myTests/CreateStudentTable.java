package com.example.demo.myTests;

import java.sql.*;

public class CreateStudentTable {
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

            String sql = "CREATE TABLE student " +
                    "(id INT PRIMARY KEY, " +
                    "first_name VARCHAR(50), " +
                    "last_name VARCHAR(50), " +
                    "age INT)";
            stmt.executeUpdate(sql);

            System.out.println("Inserting records into the table...");
            for (int i = 1; i <= 10; i++) {
                sql = "INSERT INTO student VALUES (" + i + ", 'John', 'Doe',  20" +
                        ")";
                stmt.executeUpdate(sql);
            }

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
