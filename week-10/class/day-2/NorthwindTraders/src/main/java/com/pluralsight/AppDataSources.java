package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;

public class AppDataSources {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/northwind";
        String user = args[0];
        String password = args[1];

        String query = "SELECT * FROM Products";

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);) {
            // Executing query
            try(ResultSet results = statement.executeQuery()) {
                System.out.printf("%-10s %-35s %-12s %-15s%n", "ProductId", "ProductName", "UnitPrice", "UnitsInStock");
                System.out.println("------------------------------------------------------------------------");

                // Processing the result set
                while (results.next()) {
                    int productId = results.getInt("ProductID");
                    String productName = results.getString("ProductName");
                    double unitPrice = results.getDouble("UnitPrice");
                    int unitsInStock = results.getInt("UnitsInStock");
                    System.out.printf("%-10s %-35s %-12s %-15s%n", productId, productName, unitPrice, unitsInStock);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
