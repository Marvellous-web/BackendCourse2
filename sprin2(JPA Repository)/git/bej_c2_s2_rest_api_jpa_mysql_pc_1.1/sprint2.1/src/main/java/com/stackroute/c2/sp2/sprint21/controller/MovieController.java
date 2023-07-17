package com.stackroute.c2.sp2.sprint21.controller;


import com.stackroute.c2.sp2.sprint21.model.Movie;
import com.stackroute.c2.sp2.sprint21.service.MovieService;
import com.stackroute.c2.sp2.sprint21.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/movieapp/v1")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/get-movie")
    public ResponseEntity<?> getMovies()
    {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);

    }

    @PostMapping("/get-movie")
    public ResponseEntity<?> addMovies(@RequestBody Movie movie)
    {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.OK);

    }
    @PutMapping("/get-movie")
    public ResponseEntity<?> updateMovies(@RequestBody Movie movie)
    {
        return new ResponseEntity<>(movieService.updateMovie(movie), HttpStatus.OK);

    }
    @DeleteMapping("/get-movie/{id}")
    public ResponseEntity<?> deleteMovies(@PathVariable String id)
    {
        movieService.deleteMovie(id);
    return new ResponseEntity<>("Deleted", HttpStatus.OK);

    }

    @GetMapping("/get-movie-by-name-genre/{genre}")


    public ResponseEntity<?> getBookByGenre(@PathVariable String genre)
    {
        return new ResponseEntity<>(movieService.getMovieByGenre(genre),HttpStatus.OK);
    }
    @GetMapping("/get-movie-by-name-movie/{moviename}")
    public ResponseEntity<?> getBookByMovieName(@PathVariable String moviename)
    {
        return new ResponseEntity<>(movieService.getMovieByName(moviename),HttpStatus.OK);
    }
}
