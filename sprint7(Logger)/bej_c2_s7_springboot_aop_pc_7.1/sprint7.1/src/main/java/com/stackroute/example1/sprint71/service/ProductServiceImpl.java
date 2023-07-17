package com.stackroute.example1.sprint71.service;


import com.stackroute.example1.sprint71.domain.Product;
import com.stackroute.example1.sprint71.exception.ProductAlreadyExistingException;
import com.stackroute.example1.sprint71.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistingException {
        if (productRepository.findById(product.getProductId()).isPresent()){
            throw new ProductAlreadyExistingException();
        }else {
            return productRepository.insert(product);
        }

    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getByStock() {
        return productRepository.getProductStock();
    }
}
