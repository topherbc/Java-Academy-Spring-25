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
    public Customer getByCustomerID(int id) {
        Customer customer = null;
        String sql = "SELECT CustomerID, CompanyName, ContactName, ContactTitle FROM Customers WHERE customerId = ?;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
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
    public void add(Customer customer) {
        Customer createdCustomer = null;
        String sql = "INSERT INTO Customers (CompanyName, ContactName, ContactTitle) VALUES (?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, customer.getCompanyName());
            statement.setString(2, customer.getContactName());
            statement.setString(3, customer.getContactTitle());

            statement.executeUpdate();

            // Retrieve the generated key
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                createdCustomer = getByCustomerID(generatedKeys.getInt(1));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(int id, Customer customer) {
        int contactNamePos = 0;
        int companyNamePos = 0;
        int contactTitlePos = 0;
        int idPos = 0;
        String updateParamStatement = "";
        if(customer.getContactName() != null) {
            contactNamePos+=1;
            idPos++;
            updateParamStatement+=" ContactName=? ";
        }

        if(customer.getCompanyName() != null) {
            companyNamePos+=companyNamePos+1;
            idPos++;
            String comma = "";
            if (updateParamStatement.length() > 0) {
                comma=",";
            }
            updateParamStatement+=comma+" CompanyName=? ";
        }

        if(customer.getContactTitle() != null) {
            contactTitlePos+=companyNamePos+contactNamePos+1;
            idPos++;
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
                statement.setString(contactNamePos, customer.getContactName());
            }

            if(customer.getCompanyName() != null) {
                statement.setString(companyNamePos, customer.getCompanyName());
            }

            if(customer.getContactTitle() != null) {
                statement.setString(contactNamePos, customer.getContactTitle());
            }

            statement.setInt(idPos+1, id);

            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
