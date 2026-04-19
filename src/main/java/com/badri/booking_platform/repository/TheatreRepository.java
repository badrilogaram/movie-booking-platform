package com.badri.booking_platform.repository;

import com.badri.booking_platform.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {}