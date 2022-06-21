package com.example.ticketbooking.movie;

import com.example.ticketbooking.exceptions.ResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

//    @GetMapping
//    List<Movie> findMoviesOnGivenDay() {
//        return movieRepository.
//    }

    @GetMapping("/titles/{title}")
    List<Movie> findByTitle(@PathVariable String title) {
        return movieRepository.findByTitle(title);
    }

    @GetMapping("/movies/{id}")
    Movie findById(@PathVariable int id) {
        return movieRepository.findById(id).orElseThrow( () -> new ResourceException(HttpStatus.NOT_FOUND, "Did not find movie with id = " + id));
    }

    @PostMapping("/movies")
    Movie addMovie(@RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }
}
