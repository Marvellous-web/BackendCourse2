package com.stackroute.example.MangoRepositoryDemo.service;

import com.stackroute.example.MangoRepositoryDemo.domain.Customer;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerAlreadyExistingException;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    public abstract List<Customer> getAllCustomer();

    public abstract Customer addCustomer(Customer customer) throws CustomerAlreadyExistingException;

    public abstract Customer getCustomerById(String customerId) throws CustomerNotFoundException;

    public abstract List<Customer> getCustomerBycity(String city);

    boolean deleteCustomerById(String customerId);
}
