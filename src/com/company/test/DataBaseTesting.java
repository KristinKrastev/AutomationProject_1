package com.company.test;

import com.company.configuration.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.*;

public class DataBaseTesting {
    //Connection object
    static Connection conn = null;
    //Statement object
    private static Statement stmt = null;

    @BeforeTest
    public void setUp() throws Exception{
        try {
            Configuration.loadConfigurations();
            String USER = Configuration.readDBUsername();
            String PASS = Configuration.readDBPass();
            String DB_URL = Configuration.readDBUrl();
            //Make the database connection
            String dbClass = "com.mysql.cj.jdbc.Driver";
           Class.forName(dbClass).newInstance();
           // Class.forName(dbClass).getDeclaredConstructor().newInstance();
            //Get connection to DB
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //Statement object to send the SQL statement to the Database
            stmt = conn.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllUsers() {
        try {
            String query = "SELECT * FROM user";
            // Get the contents of user table from DB
            ResultSet res = stmt.executeQuery(query);
            //Print the results until all the records are printed
            while (res.next()) {
                // Retrieve by column name
                System.out.print("User: " + res.getString("username"));
                System.out.print(", Email: " + res.getString("email"));
                System.out.println(", Password: " + res.getString("password"));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    @Test
    public void insertOneEntry () {
        try{
            String query = "INSERT INTO `automation_skillo_db`.`user` (`iduser`, `username`, `email`, `password`) VALUES ('3', 'Ivan', 'ivan@ivan.com', 'IvanPass1')";
            stmt.executeUpdate(query);
            System.out.println(stmt.getUpdateCount() + " Entries were added to the database");

        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
    }

    @Test
    public void deleteOneEntry(){
        try{
            String query = "DELETE FROM `automation_skillo_db`.`user` WHERE (`iduser` = '3')";
            stmt.executeUpdate(query);
            System.out.println(stmt.getUpdateCount() + " Entries were deleted from the database");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Test
    public void createTable(){

        try {
            String query = "CREATE TABLE food ( id INT, " +
                    "typeOfFood VARCHAR(45)," +
                    "quantity INT);";
            stmt.executeUpdate(query);
            System.out.println("A new Table was added to the DB");
        }catch(SQLException e){
        e.printStackTrace();
        }
    }

    @Test
    public void dropTable(){
        try {
            String query = "DROP TABLE food;";
            stmt.executeUpdate(query);
            System.out.println("A Table was dropped from the DB");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @AfterTest
    public void tearDown() throws Exception{
        //Close DB connection
        if (stmt !=null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }

    }
}
