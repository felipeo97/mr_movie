package com.cloud.computing.movie.services;

import com.cloud.computing.movie.entity.MovieEntity;
import com.cloud.computing.movie.model.Movie;
import com.cloud.computing.movie.repository.IMovieRepository;
import com.cloud.computing.movie.util.Util;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MovieServicesTest {

    @InjectMocks
    private MovieServices movieServices;

    @Mock
    private IMovieRepository movieRepository;

    @Mock
    private Util util;

    private Iterable<MovieEntity> movieEntityIterable;
    private Movie movie;
    private MovieEntity movieEntity;

    @Before
    public void init() {
        movieEntityIterable = new ArrayList<>();
        movieServices = new MovieServices(movieRepository, util);

        movieEntity = new MovieEntity();
        movieEntity.setId(1L);
        movieEntity.setTitle("Prueba Name");
        movieEntity.setDirector("Luck");
        movieEntity.setRating(1);

        movie = new Movie();
        movie.setTitle("Pruba Name");
        movie.setDirector("Luck");
        movie.setRating(1);
    }

    @Test
    public void whenCorrectDataIsSentTheUsersConsultedCorrectly(){

        Mockito.when(movieRepository.findAll()).thenReturn(movieEntityIterable);

        ResponseEntity<List<Movie>> responseEntity = movieServices.getMovie();

        assertEquals(responseEntity.getStatusCodeValue(),200);
    }

    @Test
    public void whenCorrectDataIsSentTheUsersCreateCorrectly(){

        Mockito.when(util.convertUserToEntity(movie)).thenReturn(movieEntity);
        Mockito.when(movieRepository.save(movieEntity)).thenReturn(movieEntity);

        ResponseEntity<List<Movie>> responseEntity = movieServices.createMovie(movie);

        assertEquals(responseEntity.getStatusCodeValue(),200);
    }
}
