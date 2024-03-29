package com.example.ticketbooking.screening;

import java.time.LocalDate;

public class ScreeningWithMovieTitleDTO {
    private String movieTitle;
    private LocalDate movieDate;
    private String movieStartTime;

    public ScreeningWithMovieTitleDTO(String movieTitle, LocalDate movieDate, String movieStartTime) {
        this.movieTitle = movieTitle;
        this.movieDate = movieDate;
        this.movieStartTime = movieStartTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public LocalDate getMovieDate() {
        return movieDate;
    }

    public String getMovieStartTime() {
        return movieStartTime;
    }
}
