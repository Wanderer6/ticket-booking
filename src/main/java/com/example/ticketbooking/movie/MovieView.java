package com.example.ticketbooking.movie;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Set;

public interface MovieView {

    String getTitle();

//    @Value("#{new com.example.ticketbooking.movie.MovieSTView(target.movieDate, target.startTime)}")
    Set<StartView> getMovieStarts();

    interface StartView {
        LocalDate getMovieDate();
        String getStartTime();
    }
}
