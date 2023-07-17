package com.stackroute.example1.sprint71.controller;


import com.stackroute.example1.sprint71.domain.Product;
import com.stackroute.example1.sprint71.exception.ProductAlreadyExistingException;
import com.stackroute.example1.sprint71.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productapp/v1/")
public class ProductController {
    @Autowired
    private ProductService productService;

    //http://localhost:9198/productapp/v1/product
    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product)throws ProductAlreadyExistingException
    {
        try {
            return new ResponseEntity<>(productService.addProduct(product),HttpStatus.OK);
        }catch (ProductAlreadyExistingException e){
            throw new ProductAlreadyExistingException();
        }

    }
    //http:/localhost:9080/productapp/v1/product/P001
    @DeleteMapping("/product/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable String productId){
    productService.deleteProduct(productId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    //http://localhost:9080/productapp/v1/product
    @PutMapping("/product")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.OK);
    }

    @GetMapping("/get-product-by-stock")
    public ResponseEntity<?> getByStock(){
        return new ResponseEntity<>(productService.getByStock(),HttpStatus.OK);
    }
}
