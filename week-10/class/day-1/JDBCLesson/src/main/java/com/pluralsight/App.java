package com.pluralsight;

import java.sql.*;
import javax.sql.DataSource;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // load the MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 1. open a connection to the database
        // use the database URL to point to the correct database

        //hypertext transfer protocol - secure
        //yearup.brightspace.com - server

        //ip address
        //PUblic ip of network
        //public ip of device
        //internal ip
        //port

        //http :80

        //https :443

        // https://yearup.brightspace.com/d2l/le/lessons/9445/topics/192294

        //computer - building
        //floors - offices

        //floor 26
        //room 202

        //1-9999
        // alwasy in room 80, we run http
        //running in 3306 mysql

        //jdbc:mysql - protocol
        //localhost:3306
        //localhost - 127.0.0.1
        //protocol://ip:port/database
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "        ");

        // create statement
        // the statement is tied to the open connection
        Statement statement = connection.createStatement();
        // define your query
        String query = "SELECT CompanyName FROM Customers";
        // 2. Execute your query
        ResultSet results = statement.executeQuery(query);
        // process the results
        while (results.next()) {
            String name = results.getString("CompanyName");
            System.out.println(name);
        }
        // 3. Close the connection
        connection.close();


    }
}
