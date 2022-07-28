package com.cloud.computing.movie.util;

import com.cloud.computing.movie.entity.MovieEntity;
import com.cloud.computing.movie.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public MovieEntity convertUserToEntity(Movie movie) {

        MovieEntity movieEntity = new MovieEntity();

        movieEntity.setTitle(movie.getTitle());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setRating(movie.getRating());

        return movieEntity;
    }

    public Movie convertMovieEntityToMovie(MovieEntity movieEntity){
        Movie movie = new Movie();

        movie.setIdMovie(movieEntity.getId());
        movie.setTitle(movieEntity.getTitle());
        movie.setDirector(movieEntity.getDirector());
        movie.setRating(movieEntity.getRating());

        return movie;
    }
}
