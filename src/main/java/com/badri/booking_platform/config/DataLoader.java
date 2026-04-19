package com.badri.booking_platform.config;

import com.badri.booking_platform.model.*;
import com.badri.booking_platform.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    private final ShowRepository showRepository;
    private final SeatRepository seatRepository;

    @Override
    public void run(String... args) {

        // 1. Movie
        Movie movie = new Movie();
        movie.setName("Avengers");
        movie.setLanguage("English");
        movie.setGenre("Action");
        movieRepository.save(movie);

        // 2. Theatre
        Theatre theatre = new Theatre();
        theatre.setName("PVR");
        theatre.setCity("Chennai");
        theatreRepository.save(theatre);

        // 3. Show
        Show show = new Show();
        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setShowDate(LocalDate.now());
        show.setShowTime(LocalTime.of(18, 0));
        showRepository.save(show);

        // 4. Seats
        List<Seat> seats = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber("A" + i);
            seat.setShow(show);
            seat.setStatus(SeatStatus.AVAILABLE);
            seats.add(seat);
        }

        seatRepository.saveAll(seats);

        System.out.println("✅ Seed data loaded");
    }
}