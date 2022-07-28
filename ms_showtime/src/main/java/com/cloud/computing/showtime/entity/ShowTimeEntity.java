package com.cloud.computing.showtime.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity(name = "TShow_Times")
public class ShowTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
