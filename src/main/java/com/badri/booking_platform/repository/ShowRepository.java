package com.badri.booking_platform.repository;

import com.badri.booking_platform.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByMovieIdAndTheatreCityAndShowDate(
            Long movieId,
            String city,
            LocalDate date);
}