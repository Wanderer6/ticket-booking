package com.example.ticketbooking.movie;

import com.example.ticketbooking.exceptions.ResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

  @GetMapping("/intertest")
    List<MovieView> findInterTest() {
        return movieRepository.findInter();
    }

    @GetMapping("/movieinterface")
    List<MovieView> findWithInterface() {
        return movieRepository.findTitles();
    }

    @GetMapping("/moviestest")
    List<Object[]> getTitle() {
        return movieRepository.getTitle();
    }

    @GetMapping("/movies")
    List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/movieTitles")
    List<String> findAllTitles() {
        return movieRepository.findAllTitles();
    }

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
