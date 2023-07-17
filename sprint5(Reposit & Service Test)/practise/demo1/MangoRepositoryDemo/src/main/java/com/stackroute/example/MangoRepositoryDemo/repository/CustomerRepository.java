package com.stackroute.example.MangoRepositoryDemo.repository;


import com.stackroute.example.MangoRepositoryDemo.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{'address.city':{$in:[?0]}}")
    public abstract List<Customer> getCustomersByCity(String city);

}
