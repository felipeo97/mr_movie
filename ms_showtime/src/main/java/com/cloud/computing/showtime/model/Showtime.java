package com.cloud.computing.showtime.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
public class Showtime {

    @JsonProperty("id")
    private long idShowTime;

    @NotNull
    @DateTimeFormat(pattern="yyyy.MM.dd")
    @JsonProperty("date")
    private Date date;

    @JsonProperty("movies")
    private String movies; //TODO: validar bien este parametro

    public long getIdShowTime() {
        return idShowTime;
    }

    public void setIdShowTime(long idShowTime) {
        this.idShowTime = idShowTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }
}
