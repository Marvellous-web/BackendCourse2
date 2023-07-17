package com.stackroute.example.MangoRepositoryDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT,reason = "Customer Already Exists")
public class CustomerAlreadyExistingException extends Exception{
}
