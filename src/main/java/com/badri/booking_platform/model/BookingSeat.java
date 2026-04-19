package com.badri.booking_platform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BookingSeat {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Booking booking;

    @ManyToOne
    private Seat seat;
}