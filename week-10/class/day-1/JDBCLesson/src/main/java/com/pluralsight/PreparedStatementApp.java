package com.pluralsight;

import java.sql.*;

public class PreparedStatementApp {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/northwind";
        String user = "root";
        String password = "        ";

        String query = "SELECT * FROM Products WHERE ProductName LIKE ? OR ProductID = ?";
        try {
            // Establishing connection
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "%Okra%");
            statement.setInt(2, 20);

            // Executing query
            ResultSet results = statement.executeQuery();

            // Processing the result set
            while (results.next()) {
                // Replace with your column names and types
                System.out.println(results.getString("ProductName"));
            }

            // Closing resources
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
