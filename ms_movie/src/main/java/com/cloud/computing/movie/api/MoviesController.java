package com.cloud.computing.movie.api;

import com.cloud.computing.movie.model.Movie;
import com.cloud.computing.movie.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MoviesController implements IMovieApi{

    private final HttpServletRequest request;

    @Autowired
    private MovieServices movieServices;

    @org.springframework.beans.factory.annotation.Autowired
    public MoviesController(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<List<Movie>> movie() {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return movieServices.getMovie();
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> createMovie(Movie movie) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return movieServices.createMovie(movie);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> getMovieId(long id) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return movieServices.getMovieId(id);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> deleteMovie(long id) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return movieServices.deleteMovie(id);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
