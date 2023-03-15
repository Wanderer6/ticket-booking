package com.example.ticketbooking.seat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface JpaSeatRepository extends JpaRepository<Seat, Integer> {
    Seat findBySeatRowAndSeatNumber(int seatRow, int seatNumber);
}
