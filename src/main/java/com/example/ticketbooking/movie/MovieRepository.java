package com.example.ticketbooking.movie;

import com.example.ticketbooking.user.User;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<Movie> findAll();

    List<Movie> findByTitle(String title);

    List<Movie> findAllByDate(String date);

    Optional<Movie> findById(Integer id);

    Movie save(Movie entity);
}
