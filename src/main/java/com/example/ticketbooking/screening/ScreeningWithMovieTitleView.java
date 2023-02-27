package com.example.ticketbooking.screening;

import com.example.ticketbooking.movie.Movie;

import java.time.LocalDate;

public interface ScreeningWithMovieTitleView {

    LocalDate getMovieDate();
    String getMovieStartTime();
    Movie getMovie();
}
