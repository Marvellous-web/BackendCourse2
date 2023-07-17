package com.stackroute.example.MangoRepositoryDemo.controller;

import com.stackroute.example.MangoRepositoryDemo.domain.Customer;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerAlreadyExistingException;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerNotFoundException;
import com.stackroute.example.MangoRepositoryDemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerapp/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //http://localhost:9090/customerapp/v1/customer   [GET]
    @GetMapping("/customer")
    public ResponseEntity<?> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
    //http://localhost:9090/customerapp/v1/customer  [POST]
    @PostMapping("/customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer)throws CustomerAlreadyExistingException {
        try {
            return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.OK);
        }catch (CustomerAlreadyExistingException e){
            throw new CustomerAlreadyExistingException();
        }
    }
    //http://localhost:9090/customerapp/v1/get-customer-by-id/
    @GetMapping("/get-customer-by-id/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable String customerId) throws CustomerNotFoundException{
        try {
            return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
        }catch (CustomerNotFoundException e){
            throw new CustomerNotFoundException();
        }
    }
    //http://localhost:9090/customerapp/v1/get-customer-by-city/Nashik
    @GetMapping("/get-customer-by-city/{city}")
    public ResponseEntity<?>getCustomerByCity(@PathVariable String city){
        return new ResponseEntity<>(customerService.getCustomerBycity(city),HttpStatus.OK);
    }
}
