package com.example.ticketbooking.movie;

import java.time.LocalDate;
import java.util.Set;

public interface MovieView {

    String getTitle();
    Set<StartView> getMovieStarts();

    interface StartView {
        LocalDate getMovieDate();
        String getStartTime();
    }
}
