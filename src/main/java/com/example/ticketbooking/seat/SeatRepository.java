package com.example.ticketbooking.seat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat findBySeatRowAndSeatNumber(int seatRow, int seatNumber);
}
