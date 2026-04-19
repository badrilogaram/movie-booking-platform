package com.badri.booking_platform.service;

import com.badri.booking_platform.dto.ShowResponse;
import com.badri.booking_platform.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    public List<ShowResponse> getShows(Long movieId, String city, LocalDate date) {
        return showRepository
                .findByMovieIdAndTheatreCityAndShowDate(movieId, city, date)
                .stream()
                .map(s -> new ShowResponse(
                        s.getId(),
                        s.getTheatre().getName(),
                        s.getShowTime()))
                .toList();
    }
}