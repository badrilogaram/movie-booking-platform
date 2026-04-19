package com.badri.booking_platform.controller;

import com.badri.booking_platform.dto.ShowResponse;
import com.badri.booking_platform.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping
    public List<ShowResponse> getShows(
            @RequestParam Long movieId,
            @RequestParam String city,
            @RequestParam String date) {

        return showService.getShows(movieId, city, LocalDate.parse(date));
    }
}