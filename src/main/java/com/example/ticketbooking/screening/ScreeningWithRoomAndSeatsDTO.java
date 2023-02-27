package com.example.ticketbooking.screening;

import com.example.ticketbooking.seat.Seat;

import java.time.LocalDate;
import java.util.Set;

public class ScreeningWithRoomAndSeatsDTO {
    private String movieTitle;
    private LocalDate movieDate;
    private String movieStartTime;
    private int roomNumber;
    private Set<Seat> seats;

    public ScreeningWithRoomAndSeatsDTO(String movieTitle, LocalDate movieDate, String movieStartTime, int roomNumber, Set<Seat> seats) {
        this.movieTitle = movieTitle;
        this.movieDate = movieDate;
        this.movieStartTime = movieStartTime;
        this.roomNumber = roomNumber;
        this.seats = seats;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "ScreeningWithRoomAndSeatsDTO{" +
                "movieTitle='" + movieTitle + '\'' +
                ", movieDate=" + movieDate +
                ", movieStartTime='" + movieStartTime + '\'' +
                ", roomNumber=" + roomNumber +
                ", seats=" + seats +
                '}';
    }
}
