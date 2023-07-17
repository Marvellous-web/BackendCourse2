package com.stackroute.example1.sprint71.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class ProductDetails {
    private String productRating;
    private String productPrice;
    private int productStock;

}
