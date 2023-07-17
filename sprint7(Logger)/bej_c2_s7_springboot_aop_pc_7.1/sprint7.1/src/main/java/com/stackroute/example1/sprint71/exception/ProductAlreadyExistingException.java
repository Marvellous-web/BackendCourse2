package com.stackroute.example1.sprint71.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Product already exists")
public class ProductAlreadyExistingException extends Exception{
    public ProductAlreadyExistingException(){
        super("Product already exists");
    }
}
