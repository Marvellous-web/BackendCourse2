package com.stackroute.example1.sprint71.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Product Not Found")
public class ProductNotFoundException extends Exception{
}
