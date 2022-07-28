package com.cloud.computing.booking.services;

import com.cloud.computing.booking.entity.BookingEntity;
import com.cloud.computing.booking.model.Booking;
import com.cloud.computing.booking.repository.IBookingRepository;
import com.cloud.computing.booking.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServices {

    @Autowired
    private IBookingRepository bookingRepository;

    @Autowired
    private Util util;

    public ResponseEntity<List<Booking>> getBooking() {

        Iterable<BookingEntity> bookingEntityIterable = bookingRepository.findAll();
        List<Booking> bookingList = new ArrayList<>();

        for (BookingEntity iterator: bookingEntityIterable) {
            bookingList.add(util.convertBookingEntityToBooking(iterator));
        }

        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }

    public ResponseEntity createBooking(Booking booking) {

        BookingEntity bookingEntity = util.convertBookingToEntity(booking);

        BookingEntity bookingEntityResponse = bookingRepository.save(bookingEntity);

        return new ResponseEntity(bookingEntityResponse, HttpStatus.OK);
    }

    public ResponseEntity getBookingId(long idBooking) {

        Optional<BookingEntity> bookingEntityOptional = bookingRepository.findById(idBooking);

        return new ResponseEntity<>(bookingEntityOptional.get() ,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteBooking(long idBooking) {

        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setId(idBooking);

        bookingRepository.delete(bookingEntity);

        return new ResponseEntity<>("Eliminado la movie con el ID ".concat(String.valueOf(idBooking)),HttpStatus.OK);
    }

    public ResponseEntity<String> getBookingUserId(long userid) {

        return new ResponseEntity<>(HttpStatus.OK); //TODO::
    }
}