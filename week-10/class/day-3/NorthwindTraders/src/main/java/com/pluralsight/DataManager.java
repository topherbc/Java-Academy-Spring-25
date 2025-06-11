package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic DataManager class that serves as a simple middleman for getting data
 * from different tables. This demonstrates a rudimentary approach before
 * implementing proper DAO patterns.
 */
public class DataManager {
    private BasicDataSource dataSource;

    /**
     * Constructor that initializes the BasicDataSource with database connection parameters
     */
    public DataManager(String url, String username, String password) {
        this.dataSource = new BasicDataSource();
        this.dataSource.setUrl(url);
        this.dataSource.setUsername(username);
        this.dataSource.setPassword(password);
    }

    /**
     * Get all products - simple approach
     */
    public void getAllProducts() {
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.printf("%-10s %-35s %-12s %-15s%n", "ProductId", "ProductName", "UnitPrice", "UnitsInStock");
            System.out.println("------------------------------------------------------------------------");

            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");
                System.out.printf("%-10s %-35s %-12s %-15s%n", productId, productName, unitPrice, unitsInStock);
            }
        } catch (SQLException e) {
            System.err.println("Error getting products: " + e.getMessage());
        }
    }

    /**
     * Get all categories - simple approach
     */
    public void getAllCategories() {
        String query = "SELECT CategoryID, CategoryName, Description FROM Categories";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.printf("%-12s %-20s %-50s%n", "CategoryId", "CategoryName", "Description");
            System.out.println("--------------------------------------------------------------------------------");

            while (results.next()) {
                int categoryId = results.getInt("CategoryID");
                String categoryName = results.getString("CategoryName");
                String description = results.getString("Description");
                if (description != null && description.length() > 47) {
                    description = description.substring(0, 47) + "...";
                }
                System.out.printf("%-12s %-20s %-50s%n", categoryId, categoryName, description);
            }
        } catch (SQLException e) {
            System.err.println("Error getting categories: " + e.getMessage());
        }
    }

    /**
     * Get all employees - simple approach
     */
    public void getAllEmployees() {
        String query = "SELECT EmployeeID, FirstName, LastName, Title FROM Employees";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.printf("%-12s %-15s %-15s %-30s%n", "EmployeeId", "FirstName", "LastName", "Title");
            System.out.println("------------------------------------------------------------------------");

            while (results.next()) {
                int employeeId = results.getInt("EmployeeID");
                String firstName = results.getString("FirstName");
                String lastName = results.getString("LastName");
                String title = results.getString("Title");
                System.out.printf("%-12s %-15s %-15s %-30s%n", employeeId, firstName, lastName, title);
            }
        } catch (SQLException e) {
            System.err.println("Error getting employees: " + e.getMessage());
        }
    }

    /**
     * Get all customers - simple approach
     */
    public void getAllCustomers() {
        String query = "SELECT CustomerID, CompanyName, ContactName, Country FROM Customers";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            System.out.printf("%-12s %-25s %-25s %-15s%n", "CustomerId", "CompanyName", "ContactName", "Country");
            System.out.println("--------------------------------------------------------------------------------");

            while (results.next()) {
                String customerId = results.getString("CustomerID");
                String companyName = results.getString("CompanyName");
                String contactName = results.getString("ContactName");
                String country = results.getString("Country");

                // Truncate long names for display
                if (companyName != null && companyName.length() > 22) {
                    companyName = companyName.substring(0, 22) + "...";
                }
                if (contactName != null && contactName.length() > 22) {
                    contactName = contactName.substring(0, 22) + "...";
                }

                System.out.printf("%-12s %-25s %-25s %-15s%n", customerId, companyName, contactName, country);
            }
        } catch (SQLException e) {
            System.err.println("Error getting customers: " + e.getMessage());
        }
    }

    /**
     * Get the BasicDataSource instance (useful for DAOs)
     * @return BasicDataSource instance
     */
    public BasicDataSource getDataSource() {
        return dataSource;
    }

    /**
     * Close the data source and release all connections
     */
    public void close() throws SQLException {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}