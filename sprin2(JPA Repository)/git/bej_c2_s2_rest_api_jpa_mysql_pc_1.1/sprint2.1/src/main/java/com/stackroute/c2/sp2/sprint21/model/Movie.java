package com.stackroute.c2.sp2.sprint21.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor @NoArgsConstructor
@Data @Entity
public class Movie {

    @Id
    private String id;
    private String moviename,director,releaseyear,genre;
}
