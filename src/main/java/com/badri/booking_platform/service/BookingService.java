package com.badri.booking_platform.service;

import com.badri.booking_platform.dto.BookingRequest;
import com.badri.booking_platform.model.*;
import com.badri.booking_platform.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;
    private final BookingSeatRepository bookingSeatRepository;
    private final ShowRepository showRepository;

    @Transactional
    public Booking bookTickets(BookingRequest request) {

        List<Seat> seats = seatRepository
                .findByShowIdAndSeatNumberIn(request.getShowId(), request.getSeats());

        for (Seat seat : seats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seat not available: " + seat.getSeatNumber());
            }
        }

        seats.forEach(seat -> seat.setStatus(SeatStatus.LOCKED));
        seatRepository.saveAll(seats);

        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setShow(showRepository.findById(request.getShowId()).orElseThrow());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setTotalAmount(seats.size() * 200);

        bookingRepository.save(booking);

        for (Seat seat : seats) {
            seat.setStatus(SeatStatus.BOOKED);

            BookingSeat bs = new BookingSeat();
            bs.setBooking(booking);
            bs.setSeat(seat);
            bookingSeatRepository.save(bs);
        }

        return booking;
    }
}