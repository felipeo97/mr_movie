package com.cloud.computing.showtime.repository;

import com.cloud.computing.showtime.entity.ShowTimeEntity;
import org.springframework.data.repository.CrudRepository;

public interface IShowTimeRepository extends CrudRepository<ShowTimeEntity, Long> {

}