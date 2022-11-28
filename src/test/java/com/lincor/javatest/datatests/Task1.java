package com.lincor.javatest.datatests;

import com.lincor.excercise.DbManager;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {

    @Test
    void testAllExpenseUserByDate()throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT cost, value FROM expense  WHERE user_id = 1 AND DATE between '2022/01/01' and '2022/01/02';";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("COST") + ", " +
                             rs.getInt("VALUE"));

        }
        rs.close();
        statement.close();
        assertEquals(0, counter);
    }

    @Test
    void testAllExpenseUserByCategory()throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT cost, value FROM expense  WHERE category = 'general' and user_id = 1;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("COST") + ", " +
                    rs.getInt("VALUE"));

        }
        rs.close();
        statement.close();
        assertEquals(0, counter);
    }
    @Test
    void testAllExpenseUserByPayment()throws SQLException{
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT cost, value FROM expense  WHERE payment = 'card' and user_id = 1;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("COST") + ", " +
                    rs.getInt("VALUE"));

        }
        rs.close();
        statement.close();
        assertEquals(0, counter);
    }




}

