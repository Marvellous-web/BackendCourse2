package com.stackroute.example1.sprint71.service;




import com.stackroute.example1.sprint71.domain.Product;
import com.stackroute.example1.sprint71.exception.ProductAlreadyExistingException;

import java.util.List;

public interface ProductService {
    public abstract List<Product> getAllProducts();

    public abstract Product addProduct(Product product) throws ProductAlreadyExistingException;

    public abstract void deleteProduct(String productId);

    public abstract Product updateProduct(Product product);

    public abstract List<Product> getByStock();


}
