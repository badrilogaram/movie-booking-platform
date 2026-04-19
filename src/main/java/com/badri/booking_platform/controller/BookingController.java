package com.badri.booking_platform.controller;

import com.badri.booking_platform.dto.BookingRequest;
import com.badri.booking_platform.model.Booking;
import com.badri.booking_platform.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking book(@RequestBody BookingRequest request) {
        return bookingService.bookTickets(request);
    }
}