package com.stackroute.c2.sp2.sprint21.service;

import com.stackroute.c2.sp2.sprint21.model.Movie;


import java.util.List;

public interface MovieService {
    public abstract Movie addMovie(Movie movie);
    public abstract List<Movie> getAllMovies();
    public abstract Movie updateMovie(Movie movie);
    public abstract void  deleteMovie(String id);
    public abstract List<Movie> getMovieByGenre(String genre);
    public abstract List<Movie> getMovieByName(String moviename);

}
