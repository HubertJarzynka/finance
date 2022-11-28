package com.lincor.excercise;

import java.sql.*;


public enum DbManager {

    INSTANCE;

    private Connection conn;
    private Statement stmt;

    DbManager() {

                 try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javatest?serverTimezone=Europe/Warsaw&useSSL=False&allowPublicKeyRetrieval=true",
                    "root", "12345678");

        } catch (SQLException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static DbManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return conn;
    }

}



