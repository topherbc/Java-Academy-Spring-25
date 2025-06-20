package com.pluralsight.NorthwindTradersSpringBoot.controller;

import com.pluralsight.NorthwindTradersSpringBoot.model.Customer;
import com.pluralsight.NorthwindTradersSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //MVC

    // Model

    // View

    // Controller

    @RequestMapping(path="/customers", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(path="/customers/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getCustomerByID(@PathVariable String id) {
        return customerService.getByCustomerID(id);
    }

    @RequestMapping(path="/customers", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public boolean addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @RequestMapping(path="/customers", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public boolean updateCustomer(@RequestBody Customer customer) {
        return customerService.update(customer.getCustomerId(), customer);
    }


}
