package com.stackroute.example.sprint11.respository;

import com.stackroute.example.sprint11.domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,String> {

}
