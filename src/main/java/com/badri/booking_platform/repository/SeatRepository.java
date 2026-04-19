package com.badri.booking_platform.repository;

import com.badri.booking_platform.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByShowIdAndSeatNumberIn(Long showId, List<String> seats);
}