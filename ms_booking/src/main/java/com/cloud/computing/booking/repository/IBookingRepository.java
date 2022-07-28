package com.cloud.computing.booking.repository;

import com.cloud.computing.booking.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;

public interface IBookingRepository extends CrudRepository<BookingEntity, Long> {
}
