package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for Products table
 * Provides CRUD operations and search functionality for products
 */
public class ProductDAO {
    private BasicDataSource dataSource;

    /**
     * Constructor that takes a DataManager to get the data source
     */
    public ProductDAO(DataManager dataManager) {
        this.dataSource = dataManager.getDataSource();
    }

    /**
     * Get all products from the database
     * @return List of all products
     */
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT ProductID, ProductName, SupplierID, CategoryID, " +
                "QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, " +
                "ReorderLevel, Discontinued FROM Products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet results = statement.executeQuery()) {

            while (results.next()) {
                Product product = createProductFromResultSet(results);
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error getting all products: " + e.getMessage());
        }

        return products;
    }

    /**
     * Get a product by its ID
     * @param productId The ID of the product to retrieve
     * @return Product object or null if not found
     */
    public Product getProductById(int productId) {
        String query = "SELECT ProductID, ProductName, SupplierID, CategoryID, " +
                "QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, " +
                "ReorderLevel, Discontinued FROM Products WHERE ProductID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, productId);

            try (ResultSet results = statement.executeQuery()) {
                if (results.next()) {
                    return createProductFromResultSet(results);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting product by ID: " + e.getMessage());
        }

        return null;
    }

    /**
     * Get products by category ID
     * @param categoryId The category ID to search for
     * @return List of products in the specified category
     */
    public List<Product> getProductsByCategoryId(int categoryId) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT ProductID, ProductName, SupplierID, CategoryID, " +
                "QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, " +
                "ReorderLevel, Discontinued FROM Products WHERE CategoryID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, categoryId);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    Product product = createProductFromResultSet(results);
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting products by category ID: " + e.getMessage());
        }

        return products;
    }

    /**
     * Create a new product
     * @param product The product to create
     * @return true if successful, false otherwise
     */
    public boolean createProduct(Product product) {
        String query = "INSERT INTO Products (ProductName, SupplierID, CategoryID, " +
                "QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, " +
                "ReorderLevel, Discontinued) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, product.getProductName());
            statement.setObject(2, product.getSupplierId(), Types.INTEGER);
            statement.setObject(3, product.getCategoryId(), Types.INTEGER);
            statement.setString(4, product.getQuantityPerUnit());
            statement.setBigDecimal(5, product.getUnitPrice());
            statement.setObject(6, product.getUnitsInStock(), Types.SMALLINT);
            statement.setObject(7, product.getUnitsOnOrder(), Types.SMALLINT);
            statement.setObject(8, product.getReorderLevel(), Types.SMALLINT);
            statement.setBoolean(9, product.isDiscontinued());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        product.setProductId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error creating product: " + e.getMessage());
        }

        return false;
    }

    /**
     * Update an existing product
     * @param product The product to update
     * @return true if successful, false otherwise
     */
    public boolean updateProduct(Product product) {
        String query = "UPDATE Products SET ProductName = ?, SupplierID = ?, CategoryID = ?, " +
                "QuantityPerUnit = ?, UnitPrice = ?, UnitsInStock = ?, UnitsOnOrder = ?, " +
                "ReorderLevel = ?, Discontinued = ? WHERE ProductID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, product.getProductName());
            statement.setObject(2, product.getSupplierId(), Types.INTEGER);
            statement.setObject(3, product.getCategoryId(), Types.INTEGER);
            statement.setString(4, product.getQuantityPerUnit());
            statement.setBigDecimal(5, product.getUnitPrice());
            statement.setObject(6, product.getUnitsInStock(), Types.SMALLINT);
            statement.setObject(7, product.getUnitsOnOrder(), Types.SMALLINT);
            statement.setObject(8, product.getReorderLevel(), Types.SMALLINT);
            statement.setBoolean(9, product.isDiscontinued());
            statement.setInt(10, product.getProductId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error updating product: " + e.getMessage());
        }

        return false;
    }

    /**
     * Delete a product by ID
     * @param productId The ID of the product to delete
     * @return true if successful, false otherwise
     */
    public boolean deleteProduct(int productId) {
        String query = "DELETE FROM Products WHERE ProductID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, productId);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
        }

        return false;
    }

    /**
     * Helper method to create a Product object from a ResultSet
     */
    private Product createProductFromResultSet(ResultSet results) throws SQLException {
        Product product = new Product();
        product.setProductId(results.getInt("ProductID"));
        product.setProductName(results.getString("ProductName"));

        // Handle nullable integers
        int supplierId = results.getInt("SupplierID");
        product.setSupplierId(results.wasNull() ? null : supplierId);

        int categoryId = results.getInt("CategoryID");
        product.setCategoryId(results.wasNull() ? null : categoryId);

        product.setQuantityPerUnit(results.getString("QuantityPerUnit"));
        product.setUnitPrice(results.getBigDecimal("UnitPrice"));

        short unitsInStock = results.getShort("UnitsInStock");
        product.setUnitsInStock(results.wasNull() ? null : unitsInStock);

        short unitsOnOrder = results.getShort("UnitsOnOrder");
        product.setUnitsOnOrder(results.wasNull() ? null : unitsOnOrder);

        short reorderLevel = results.getShort("ReorderLevel");
        product.setReorderLevel(results.wasNull() ? null : reorderLevel);

        product.setDiscontinued(results.getBoolean("Discontinued"));

        return product;
    }
}