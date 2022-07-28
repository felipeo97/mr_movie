package com.cloud.computing.booking.util;

import com.cloud.computing.booking.entity.BookingEntity;
import com.cloud.computing.booking.model.Booking;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public BookingEntity convertBookingToEntity(Booking booking) {

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setId(booking.getIdBooking());
        bookingEntity.setUserId(booking.getUserId());
        bookingEntity.setShowTimeId(booking.getShowTimeId());

        return bookingEntity;
    }

    public Booking convertBookingEntityToBooking(BookingEntity bookingEntity){
        Booking booking = new Booking();

        booking.setIdBooking(bookingEntity.getId());
        booking.setUserId(bookingEntity.getUserId());
        booking.setShowTimeId(bookingEntity.getShowTimeId());

        return booking;
    }
}
