package com.stackroute.example;

import com.stackroute.example.domain.Product;
import com.stackroute.example.domain.ProductDetails;
import com.stackroute.example.repository.Product_Repository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class) @DataMongoTest
public class ProductRepositoryTest {
    @Autowired
    private Product_Repository product_repository;
    private Product product;
    private ProductDetails productDetails;

    @BeforeEach
    public void setup() {
        product = new Product("101", "Laptop-Bag", productDetails);
        productDetails = new ProductDetails("3.5", "999", 241);
    }

        @AfterEach
        public void clean()
        {
            product=null;
            productDetails=null;
            product_repository.deleteAll();
        }
        @Test

        public void getAllProduct()
        {
//            product_repository.insert(product);
            product.setId("105");

//            product.setProduct_name("XYZ");
            product_repository.insert(product);
//            product.setId("106");
//            product_repository.insert(product);
            List<Product> productList=new ArrayList<>();
            productList=product_repository.findAll();
            assertEquals(1,productList.size());
    }
        @Test
        public void givenProductDetailsToSaveReturnProduct()
        {
            product_repository.insert(product);
            Product result=product_repository.findById(product.getId()).get();
            System.out.println(result.equals(product));
            assertEquals(result,product);
        }

        @Test
        public void givenProductToDelete()
        {
            product_repository.insert(product);
            product_repository.deleteById(product.getId());
            assertEquals(Optional.empty(),product_repository.findById(product.getId()));
        }
        //Optional.empty equals to null
}
