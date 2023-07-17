package com.stackroute.example.MangoRepositoryDemo.service;

import com.stackroute.example.MangoRepositoryDemo.domain.Customer;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerAlreadyExistingException;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerNotFoundException;
import com.stackroute.example.MangoRepositoryDemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) throws CustomerAlreadyExistingException {
        if(customerRepository.findById(customer.getCustomerId()).isPresent()){
            throw new CustomerAlreadyExistingException();
        }else {
            return customerRepository.insert(customer);
        }

    }

    @Override
    public Customer getCustomerById(String customerId) throws CustomerNotFoundException {
        if(customerRepository.findById(customerId).isPresent()){
            return customerRepository.findById(customerId).get();
        }else {
            throw new CustomerNotFoundException();
        }

    }

    @Override
    public List<Customer> getCustomerBycity(String city) {
        return customerRepository.getCustomersByCity(city);
    }

    @Override
    public boolean deleteCustomerById(String customerId) {
        return true;
    }


}
