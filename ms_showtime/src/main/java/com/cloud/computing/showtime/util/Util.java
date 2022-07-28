package com.cloud.computing.showtime.util;

import com.cloud.computing.showtime.entity.ShowTimeEntity;
import com.cloud.computing.showtime.model.Showtime;
import org.springframework.stereotype.Component;

@Component
public class Util {

    public ShowTimeEntity convertShowtimeToEntity(Showtime showtime) {

        ShowTimeEntity showTimeEntity = new ShowTimeEntity();

        showTimeEntity.setDate(showtime.getDate());

        return showTimeEntity;
    }

    public Showtime convertShowtimeEntityToShowtime(ShowTimeEntity showTimeEntity){
        Showtime showtime = new Showtime();

        showtime.setIdShowTime(showTimeEntity.getId());
        showtime.setDate(showTimeEntity.getDate());

        return showtime;
    }

}
