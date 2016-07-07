package Demo;

import java.sql.*;

/**
 * Created by cerebro on 07/07/16.
 */
public class Abcd {
    public static void main(String[] args) {

        // www.w3schools.com/sql

        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC doesn't exit.");
        }

        // 1. register appropriate Driver
        // 2. Get Database connection from DriverManager
        // 3. create statement
        // 4. execute query

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/Demo/codekamp.sqlite");

            Statement stmt = connection.createStatement();

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println("name: " + resultSet.getString("name") + " , age: " + resultSet.getInt("age"));
            }


//            Statement stmt1 = connection.createStatement();

//            stmt1.execute("INSERT INTO students  ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
