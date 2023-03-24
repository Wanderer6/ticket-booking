package com.example.ticketbooking.movie;

import java.util.List;


public interface MovieRepository {


    List<MovieView> findMovies();
}
