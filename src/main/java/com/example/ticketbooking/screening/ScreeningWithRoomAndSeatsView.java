package com.example.ticketbooking.screening;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningWithRoomAndSeatsView {
    @Value("#{target.movie.title}")
    String getMovieTitle();
    LocalDate getMovieDate();
    String getMovieStartTime();
    @Value("#{target.rooms.iterator().next().roomNumber}")
    int getRoomNumber();
//    @JsonProperty("seats")
    @Value("#{target.rooms.iterator().next().seats}")
    List<SeatView> getSeats();

    interface SeatView {
        @Value("#{target.seatRow}")
        int getSeatRow();
        @Value("#{target.seatNumber}")
        int getSeatNumber();
        @Value("#{target.availability}")
        boolean isAvailability();
    }
}
