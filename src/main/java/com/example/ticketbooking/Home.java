package com.example.ticketbooking;

import com.example.ticketbooking.movie.Movie;
import com.example.ticketbooking.movie.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class Home {

    private final MovieRepository repository;

    Home(MovieRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/home")
//    List<String> findAllMovies() {
//        return repository.findAll()
//                .stream()
//                .map(Movie::getMovieDate)
//                .toList()
//                ;
//    }

//    @GetMapping("/home/{date}")
//    List<String> findAllByDate(@PathVariable String date) {
//        return repository.findAllByDate(date).stream().map(movie -> movie.getTitle() + " " + movie.getStartTime()).toList();
//    }

//    @GetMapping("/home")
//    public int home() {
//        return LocalDateTime
//                .now()
//                .getDayOfMonth()
//                ;
//    }
}
