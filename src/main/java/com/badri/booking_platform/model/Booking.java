package com.badri.booking_platform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @ManyToOne
    private Show show;

    private double totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}