package com.stackroute.example.sprint11.controller;

import com.stackroute.example.sprint11.domain.Movie;
import com.stackroute.example.sprint11.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//http//:localhost:8080/movieapp/v1/movie
@RestController@RequestMapping("/movieapp/v1")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movie")
    public ResponseEntity<?> getMoviedata() {
        List<Movie> movies = movieService.getAllMovie();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
        Movie result=movieService.addMovie(movie);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @PutMapping("/movie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie){
        Movie result=movieService.updateMovie(movie);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
    @GetMapping("/get-movie-by-id/{id}")
    public ResponseEntity<?> getMoviebyId(@PathVariable String movieId){
        Movie result=movieService.getMovieById(movieId);
        return new ResponseEntity<>(result,HttpStatus.OK);

    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
}
