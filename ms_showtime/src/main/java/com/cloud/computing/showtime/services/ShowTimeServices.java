package com.cloud.computing.showtime.services;

import com.cloud.computing.showtime.entity.ShowTimeEntity;
import com.cloud.computing.showtime.model.Showtime;
import com.cloud.computing.showtime.repository.IShowTimeRepository;
import com.cloud.computing.showtime.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowTimeServices {

    @Autowired
    private IShowTimeRepository showTimeRepository;

    @Autowired
    private Util util;

    public ResponseEntity<List<Showtime>> getShowTime() {

        Iterable<ShowTimeEntity> showTimeEntityIterable = showTimeRepository.findAll();
        List<Showtime> showtimeList = new ArrayList<>();

        for (ShowTimeEntity iterator: showTimeEntityIterable) {
            showtimeList.add(util.convertShowtimeEntityToShowtime(iterator));
        }

        return new ResponseEntity<>(showtimeList, HttpStatus.OK);
    }

    public ResponseEntity<String> createShowTime(Showtime showtime) {

        ShowTimeEntity showTimeEntity = util.convertShowtimeToEntity(showtime);

        ShowTimeEntity showTimeEntityResponse = showTimeRepository.save(showTimeEntity);

        return new ResponseEntity(showTimeEntityResponse, HttpStatus.OK);
    }

    public ResponseEntity getShowTimeId(long idShowtime) {

        Optional<ShowTimeEntity> showTimeEntityOptional = showTimeRepository.findById(idShowtime);

        return new ResponseEntity<>(showTimeEntityOptional.get() ,HttpStatus.OK);
    }

    public ResponseEntity updateShowTime(long idShowtime, Showtime showtime) {

        Optional<ShowTimeEntity> showTimeEntityOptional = showTimeRepository.findById(idShowtime);
        showTimeEntityOptional.get().setDate(showtime.getDate());

        ShowTimeEntity showTimeEntityResponse = showTimeRepository.save(showTimeEntityOptional.get());

        return new ResponseEntity<>(showTimeEntityResponse, HttpStatus.OK);
    }
}