package com.stackroute.example.MangoRepositoryDemo;

import com.stackroute.example.MangoRepositoryDemo.domain.Address;
import com.stackroute.example.MangoRepositoryDemo.domain.Customer;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerAlreadyExistingException;
import com.stackroute.example.MangoRepositoryDemo.exception.CustomerNotFoundException;
import com.stackroute.example.MangoRepositoryDemo.repository.CustomerRepository;
import com.stackroute.example.MangoRepositoryDemo.service.CustomerService;
import com.stackroute.example.MangoRepositoryDemo.service.CustomerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest1 {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer;
    private Address address;

    @BeforeEach
    public void init(){
        address=new Address("123","s1","city1");
        customer=new Customer("C1","Krishna","nomail@gmail.com","7890",address);

    }

    @AfterEach
    public void clean()
    {
        address=null;
        customer=null;

    }

    @Test
    public void addCustomerService() throws CustomerAlreadyExistingException
    {
        //if reposit. find by id(customer.customerid):return Optional object with no content object
        //if reposit.insert(customer) : then return same parameter object
        System.out.println(Optional.ofNullable(null));
//        System.out.println(customerRepository.findById(customer.getCustomerId()));
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.empty());
        when(customerRepository.insert(customer)).thenReturn(customer);
//        System.out.println(customer);
//        System.out.println(customerService.addCustomer(customer));
        assertEquals(customer,customerService.addCustomer(customer));
        //we can check how many timesmock object method called
        verify(customerRepository,times(1)).findById(customer.getCustomerId());
        verify(customerRepository,times(1)).insert(customer);

    }

    @Test
    public void addCustomerFailure() throws CustomerAlreadyExistingException
    {
        //if reposit. find by id(customer.customerid):return Optional object with no content object
        //if reposit.insert(customer) : then return same parameter object
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));
        assertThrows(CustomerAlreadyExistingException.class,()->customerService.addCustomer(customer));
        //we can check how many timesmock object method called
        verify(customerRepository,times(1)).findById(customer.getCustomerId());
        verify(customerRepository,times(0)).insert(customer);

    }
    @Test
    public void deleteCustomerByIdSuccess()
    {
        //if reposit. find by id(customer.customerid):return Optional object with no content object
        //if reposit.insert(customer) : then return same parameter object
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(customer));

        boolean result=customerService.deleteCustomerById(customer.getCustomerId());
        assertEquals(true,result);

        //we can check how many timesmock object method called
        verify(customerRepository,times(1)).findById(customer.getCustomerId());
        verify(customerRepository,times(1)).deleteById(customer.getCustomerId());

    }
    @Test
    public void deleteCustomerIdFailure()
    {
        //if reposit. find by id(customer.customerid):return Optional object with no content object
        //if reposit.insert(customer) : then return same parameter object
        when(customerRepository.findById(customer.getCustomerId())).thenReturn(Optional.ofNullable(null));
        boolean result=customerService.deleteCustomerById(customer.getCustomerId());
        assertEquals(false,result);

        //we can check how many timesmock object method called
        verify(customerRepository,times(1)).findById(customer.getCustomerId());
        verify(customerRepository,times(0)).deleteById(customer.getCustomerId());

    }

}
