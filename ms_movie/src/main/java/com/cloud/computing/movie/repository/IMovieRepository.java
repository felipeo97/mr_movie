package com.cloud.computing.movie.repository;

import com.cloud.computing.movie.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends CrudRepository<MovieEntity, Long> {
}
