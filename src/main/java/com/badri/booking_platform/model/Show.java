package com.badri.booking_platform.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Show {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theatre theatre;

    private LocalDate showDate;
    private LocalTime showTime;
}