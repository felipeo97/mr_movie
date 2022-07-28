package com.cloud.computing.movie.services;

import com.cloud.computing.movie.entity.MovieEntity;
import com.cloud.computing.movie.model.Movie;
import com.cloud.computing.movie.repository.IMovieRepository;
import com.cloud.computing.movie.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServices {

    public MovieServices(IMovieRepository movieRepository, Util util) {
        this.movieRepository = movieRepository;
        this.util = util;
    }

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private Util util;

    public ResponseEntity<List<Movie>> getMovie(){

        Iterable<MovieEntity> movieEntityIterable =movieRepository.findAll();
        List<Movie> moveList = new ArrayList<>();

        for (MovieEntity iterator: movieEntityIterable) {
            moveList.add(util.convertMovieEntityToMovie(iterator));
        }

        return new ResponseEntity<>(moveList, HttpStatus.OK);
    }

    public ResponseEntity createMovie(Movie movie){

        MovieEntity movieEntity = util.convertUserToEntity(movie);

        MovieEntity movieEntityResponse = movieRepository.save(movieEntity);

        return new ResponseEntity(movieEntityResponse, HttpStatus.OK);
    }

    public ResponseEntity getMovieId(long idMovie){

        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(idMovie);

        return new ResponseEntity<>(movieEntityOptional.get() ,HttpStatus.OK);
    }

    public ResponseEntity deleteMovie(long idMovie){

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(idMovie);

        movieRepository.delete(movieEntity);

        return new ResponseEntity<>("Eliminado la movie con el ID ".concat(String.valueOf(idMovie)),HttpStatus.OK);
    }
}
