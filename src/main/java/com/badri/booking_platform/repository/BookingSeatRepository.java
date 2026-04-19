package com.badri.booking_platform.repository;

import com.badri.booking_platform.model.BookingSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, Long> {}