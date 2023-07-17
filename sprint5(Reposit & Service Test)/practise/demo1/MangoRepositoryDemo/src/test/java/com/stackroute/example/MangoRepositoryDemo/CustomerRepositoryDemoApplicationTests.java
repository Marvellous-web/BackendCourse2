package com.stackroute.example.MangoRepositoryDemo;

import com.stackroute.example.MangoRepositoryDemo.domain.Address;
import com.stackroute.example.MangoRepositoryDemo.domain.Customer;
import com.stackroute.example.MangoRepositoryDemo.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)@DataMongoTest
public class CustomerRepositoryDemoApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;
    private Address address;

    @BeforeEach
    public void setup(){
        address=new Address("102","Rajeev Nagar1","Patiala1");
        customer=new Customer("C2","ABC1","abc1@gmail.com","8887984699",address);

    }

    @AfterEach
    public void clean(){
        address=null;
        customer=null;
        customerRepository.deleteAll();
    }

    @Test
    public void getAllCustomer(){
        customerRepository.insert(customer);//for first record
        customer.setCustomerId("C3");
        customerRepository.insert(customer);//for second record
        List<Customer> customerList=customerRepository.findAll();
        assertEquals(2,customerList.size());
    }

    @Test
    public void givenCustomerToSaveReturnCustomer()
    {
        customerRepository.insert(customer);
        Customer result=customerRepository.findById(customer.getCustomerId()).get();
        System.out.println(result.equals(customer));
        assertEquals(result,customer);
    }
    @Test
    public void givenCustomerToDelete()
    {
        customerRepository.insert(customer);
        if(customerRepository.findById(customer.getCustomerId()).isPresent())
        {
            System.out.println("customer present");
        }
        else System.out.println("No Customer present");
        customerRepository.deleteById(customer.getCustomerId());
        if(customerRepository.findById(customer.getCustomerId()).isPresent())
        {
            System.out.println("customer present");
        }
        else System.out.println("No Customer present");
        System.out.println(Optional.empty());

        assertEquals(Optional.empty(),customerRepository.findById(customer.getCustomerId()));

    }


}
