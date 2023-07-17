package com.stackroute.c2.sp2.sprint21.service;

import com.stackroute.c2.sp2.sprint21.model.Movie;
import com.stackroute.c2.sp2.sprint21.respository.Movie_Respoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private Movie_Respoitory movie_respoitory;

    @Override
    public Movie addMovie(Movie movie) {
        return movie_respoitory.save(movie) ;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movie_respoitory.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movie_respoitory.save(movie);
    }

    @Override
    public void deleteMovie(String id) {
        movie_respoitory.deleteById(id);

    }

    @Override
    public List<Movie> getMovieByGenre(String genre) {
        return movie_respoitory.findByGenre(genre);
    }

    @Override
    public List<Movie> getMovieByName(String moviename) {
        return movie_respoitory.findByMoviename(moviename);
    }
}
