package com.badri.booking_platform.repository;

import com.badri.booking_platform.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {}