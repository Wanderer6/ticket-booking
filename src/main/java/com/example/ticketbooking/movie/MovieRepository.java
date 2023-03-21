package com.example.ticketbooking.movie;

import java.util.List;
import java.util.Optional;


public interface MovieRepository {


    List<MovieView> findInter();
    List<MovieView> findTitles();
    List<Object[]> getTitle();
    List<Movie> findAll();
    List<String> findAllTitles();
    List<Movie> findByTitle(String title);
    Optional<Movie> findById(Integer id);
    Movie getById(Integer id);
    Movie save(Movie entity);
}
