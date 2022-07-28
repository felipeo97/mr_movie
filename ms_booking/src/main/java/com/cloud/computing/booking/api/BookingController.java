package com.cloud.computing.booking.api;

import com.cloud.computing.booking.model.Booking;
import com.cloud.computing.booking.services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BookingController implements IBookingApi {

    private final HttpServletRequest request;

    @Autowired
    private BookingServices bookingServices;

    @org.springframework.beans.factory.annotation.Autowired
    public BookingController(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<List<Booking>> booking() {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return bookingServices.getBooking();
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> createBooking(Booking booking) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return bookingServices.createBooking(booking);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> getBookingId(long id) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return bookingServices.getBookingId(id);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> deleteBooking(long id) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return bookingServices.deleteBooking(id);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> getBookingUserId(long userid) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return bookingServices.getBookingUserId(userid);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
