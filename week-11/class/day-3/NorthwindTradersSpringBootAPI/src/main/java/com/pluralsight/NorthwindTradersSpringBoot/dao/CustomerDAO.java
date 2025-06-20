package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getAll();
    public List<Customer> getByCompanyName();
    public List<Customer> getByContactName();
    public List<Customer> getByAddress();
    public Customer getByCustomerID(String id);
    public boolean add(Customer customer);
    public boolean update(String id, Customer customer);
    public void delete(int id, Customer customer);
}
