package com.example.ticketbooking.screening;

import com.example.ticketbooking.seat.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
