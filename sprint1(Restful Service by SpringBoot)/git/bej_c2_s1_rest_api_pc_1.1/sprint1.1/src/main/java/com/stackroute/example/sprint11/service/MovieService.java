package com.stackroute.example.sprint11.service;

import com.stackroute.example.sprint11.domain.Movie;

import java.util.List;

public interface MovieService {
    public abstract Movie addMovie(Movie movie);
    public abstract List<Movie> getAllMovie();
    public abstract Movie updateMovie(Movie movie);
    public abstract void deleteMovie(String id);
    public abstract Movie getMovieById(String id);

}
