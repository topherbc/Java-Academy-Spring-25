package com.pluralsight.NorthwindTradersSpringBoot.service;

import com.pluralsight.NorthwindTradersSpringBoot.dao.CustomerDAO;
import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {


    private final CustomerDAO customerDao;

    @Autowired
    public CustomerService(CustomerDAO customerDao) {
        this.customerDao = customerDao;
    }

    public boolean addCustomer(Customer customer) {
        return customerDao.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAll();
    }

    public Customer getByCustomerID(String id) {
        return customerDao.getByCustomerID(id);
    }

    public boolean update(String id, Customer customer) {
        return customerDao.update(id, customer);
    }

    public void delete(int id, Customer customer) {
        customerDao.delete(id, customer);
    }

}
