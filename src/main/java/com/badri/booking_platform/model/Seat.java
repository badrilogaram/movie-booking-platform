package com.badri.booking_platform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

    private String seatNumber;

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;
}