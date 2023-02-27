package com.example.ticketbooking.movie;

import com.example.ticketbooking.user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface MovieRepository {


    List<MovieView> findInter();

//    List<MovieView> findAllMoviesByDate(LocalDate date);

//    List<MovieView> findInterByDate(String date);


    List<MovieView> findTitles();

    List<Object[]> getTitle();

    List<Movie> findAll();

    List<String> findAllTitles();

    List<Movie> findByTitle(String title);



    Optional<Movie> findById(Integer id);

    Movie getById(Integer id);

    Movie save(Movie entity);
}
