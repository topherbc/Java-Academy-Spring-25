package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

@Component
public class CustomerDAOJDBCImpl implements CustomerDAO {
    private List<Customer> customers;
    private DataSource dataSource;

    @Autowired
    public CustomerDAOJDBCImpl(DataSource dataSource) {
        this.customers = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> getAll() {
        this.customers.clear();
        String sql = "SELECT CustomerID, CompanyName, ContactName, ContactTitle FROM Customers;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.customers.add(new Customer(rows.getString(1), rows.getString(2), rows.getString(3),rows.getString(4)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.customers;
    }


    @Override
    public List<Customer> getByCompanyName() {
        return null;
    }

    @Override
    public List<Customer> getByContactName() {
        return null;
    }

    @Override
    public List<Customer> getByAddress() {
        return null;
    }

    @Override
    public Customer getByCustomerID(String id) {
        Customer customer = null;
        String sql = "SELECT CustomerID, CompanyName, ContactName, ContactTitle FROM Customers WHERE CustomerId = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                customer = new Customer(rows.getString(1), rows.getString(2), rows.getString(3),rows.getString(4));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void delete(int id, Customer customer) {

    }

    @Override
    public boolean add(Customer customer) {
        Customer createdCustomer = null;
        String sql = "INSERT INTO Customers (CustomerID, CompanyName, ContactName, ContactTitle) VALUES (?, ?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, customer.getCustomerId());
            statement.setString(2, customer.getCompanyName());
            statement.setString(3, customer.getContactName());
            statement.setString(4, customer.getContactTitle());

            if (statement.executeUpdate() != 0){
                return true;
            } else {
                return false;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(String id, Customer customer) {
        int idPos = 0;
        String updateParamStatement = "";
        if(customer.getContactName() != null) {
            updateParamStatement+=" ContactName=? ";
        }

        if(customer.getCompanyName() != null) {
            String comma = "";
            if (updateParamStatement.length() > 0) {
                comma=",";
            }
            updateParamStatement+=comma+" CompanyName=? ";
        }

        if(customer.getContactTitle() != null) {
            String comma = "";
            if (updateParamStatement.length() > 0) {
                comma=",";
            }
            updateParamStatement+=comma+" ContactTitle=? ";
        }

        String sql = "UPDATE Customers SET " + updateParamStatement + " WHERE CustomerID=?";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);

            // if we don't have 1 or more property populated, call getById to populate
            System.out.println(customer);

            if(customer.getContactName() != null) {
                idPos+=1;
                statement.setString(idPos, customer.getContactName());
            }

            if(customer.getCompanyName() != null) {
                idPos+=1;
                statement.setString(idPos, customer.getCompanyName());
            }

            if(customer.getContactTitle() != null) {
                idPos+=1;
                statement.setString(idPos, customer.getContactTitle());
            }

            idPos+=1;
            statement.setString(idPos, id);

            System.out.println(statement);

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
