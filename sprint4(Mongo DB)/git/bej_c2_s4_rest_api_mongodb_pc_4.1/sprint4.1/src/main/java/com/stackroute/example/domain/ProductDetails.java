package com.stackroute.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @Document @AllArgsConstructor @NoArgsConstructor
public class ProductDetails {
    private String rating,price; private int stock;


}
