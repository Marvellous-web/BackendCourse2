package com.stackroute.example1.sprint71.repository;


import com.stackroute.example1.sprint71.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String > {

    @Query("{'productDetails.productStock':{$gte:1}}")
    public abstract List<Product> getProductStock();
}
