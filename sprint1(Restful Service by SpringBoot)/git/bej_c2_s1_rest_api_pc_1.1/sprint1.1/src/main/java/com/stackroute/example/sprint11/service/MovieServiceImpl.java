package com.stackroute.example.sprint11.service;

import com.stackroute.example.sprint11.domain.Movie;
import com.stackroute.example.sprint11.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovie() {
        return (List<Movie>)movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie getMovieById(String id) {
        if(movieRepository.findById(id).isPresent())
        {
            return movieRepository.findById(id).get();
        }
        else
        return null;
    }
}
