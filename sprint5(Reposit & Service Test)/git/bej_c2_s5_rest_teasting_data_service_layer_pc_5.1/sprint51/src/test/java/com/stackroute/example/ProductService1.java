package com.stackroute.example;

import com.stackroute.example.domain.Product;
import com.stackroute.example.domain.ProductDetails;
import com.stackroute.example.exception.ProductAlreadyExistException;
import com.stackroute.example.repository.Product_Repository;
import com.stackroute.example.service.ProductServiceImpl;
import com.stackroute.example.service.Product_Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(Extension.class)
public class ProductService1 {
    @Mock
    private Product_Repository product_repository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private ProductDetails productDetails;

    @BeforeEach
    public void init()
    {
        product=new Product("101","s1",productDetails);
        productDetails=new ProductDetails("4.4","1001",211);

    }

    @Test
    public void addProductSuccess() throws ProductAlreadyExistException
    {
        when(product_repository.findById(product.getId())).thenReturn(Optional.ofNullable(null));
        when(product_repository.insert(product)).thenReturn(product);
        assertEquals(productService.addProduct(product),product);
        verify(product_repository,times(1)).findById(product.getId());
        verify(product_repository,times(1)).insert(product);
    }
}
