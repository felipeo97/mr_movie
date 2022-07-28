package com.cloud.computing.booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Booking {

    @JsonProperty("id")
    private long idBooking;

    @NotNull
    @JsonProperty("userId")
    private long userId;

    @NotNull
    @JsonProperty("showTimeId")
    private long showTimeId;

    @JsonProperty("movies")
    private String movies; //TODO: validar bien este parametro

    public long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(long idBooking) {
        this.idBooking = idBooking;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getShowTimeId() {
        return showTimeId;
    }

    public void setShowTimeId(long showTimeId) {
        this.showTimeId = showTimeId;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }
}
