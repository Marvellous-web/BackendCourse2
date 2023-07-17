package com.stackroute.example.sprint11.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    private String id;
    private String movie_name,director,release_year,rating;

    public Movie() {
    }

    public Movie(String id, String movie_name, String director, String release_year, String rating) {
        this.id = id;
        this.movie_name = movie_name;
        this.director = director;
        this.release_year = release_year;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movie_name='" + movie_name + '\'' +
                ", director='" + director + '\'' +
                ", release_year='" + release_year + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
