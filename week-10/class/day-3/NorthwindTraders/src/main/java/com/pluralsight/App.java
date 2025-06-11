package com.pluralsight;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {

        // Get database connection parameters from environment variables
        String url = System.getenv("DB_URL");
        String user = args[0];
        String password = args[1];

        // Provide default values if environment variables are not set
        if (url == null) {
            url = "jdbc:mysql://127.0.0.1:3306/northwind";
        }
        if (user == null || password == null) {
            System.err.println("Please set DB_USER and DB_PASSWORD environment variables");
            return;
        }

        // Create DataManager instance
        DataManager dataManager = new DataManager(url, user, password);

        try {

            dataManager.getAllProducts();


            ProductDAO productDAO = new ProductDAO(dataManager);


//            demonstrateAdvancedDAO(productDAO);

        } finally {
            // Clean up resources
            try {
                dataManager.close();
                System.out.println("\nDataManager resources cleaned up successfully.");
            } catch (SQLException e) {
                System.err.println("Error closing DataManager: " + e.getMessage());
            }
        }
    }

    private static void demonstrateAdvancedDAO(ProductDAO productDAO) {
        System.out.println("1. Get all products:");
        List<Product> products = productDAO.getAllProducts();
        System.out.println("Found " + products.size() + " products");

        System.out.println("\n2. Search by ID:");
        Product product = productDAO.getProductById(1);
        System.out.println("Product 1: " + (product != null ? product.getProductName() : "Not found"));

        System.out.println("\n3. Search by category:");
        List<Product> beverages = productDAO.getProductsByCategoryId(1);
        System.out.println("Found " + beverages.size() + " beverages");

        System.out.println("\n4. Create new product:");
        Product newProduct = new Product("Test Product", 1, 1, "1 unit",
                new BigDecimal("19.99"), (short) 10, (short) 0, (short) 5, false);
        boolean created = productDAO.createProduct(newProduct);
        System.out.println("Created: " + created);

        if (created) {
            System.out.println("\n5. Update product:");
            newProduct.setProductName("Updated Test Product");
            boolean updated = productDAO.updateProduct(newProduct);
            System.out.println("Updated: " + updated);

            System.out.println("\n6. Delete product:");
            boolean deleted = productDAO.deleteProduct(newProduct.getProductId());
            System.out.println("Deleted: " + deleted);
        }
    }
}