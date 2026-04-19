package com.badri.booking_platform.repository;

import com.badri.booking_platform.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}