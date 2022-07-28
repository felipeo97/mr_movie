package com.cloud.computing.showtime.api;

import com.cloud.computing.showtime.model.Showtime;
import com.cloud.computing.showtime.services.ShowTimeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ShowtimeController implements IShowtimeApi {

    private final HttpServletRequest request;

    @Autowired
    private ShowTimeServices showTimeServices;

    @org.springframework.beans.factory.annotation.Autowired
    public ShowtimeController(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public ResponseEntity<List<Showtime>> movie() {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return showTimeServices.getShowTime();
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> createShowTime(Showtime showtime) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return showTimeServices.createShowTime(showtime);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> getShowTimeId(long id) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return showTimeServices.getShowTimeId(id);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<String> updateShowTimeId(long id, Showtime showtime) {
        String accept = request.getHeader("Accept");

        if (accept != null && accept.contains("application/json")) {

            return showTimeServices.updateShowTime(id, showtime);
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
