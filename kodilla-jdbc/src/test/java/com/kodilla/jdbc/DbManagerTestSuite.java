package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void SelectUsers() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();

        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, COUNT(*) AS POSTS_NUMBER \n" +
                "FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID\n" +
                "GROUP BY U.ID \n" +
                "HAVING COUNT(*) > 1;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        System.out.println("Users having at least two posts:");
        int iterator = 0;
        while(rs.next()) {
            System.out.println("\t- " + rs.getString("FIRSTNAME") + " " +
                    rs.getString("LASTNAME"));
            iterator++;
        }

        assertEquals(1, iterator);
    }
}
