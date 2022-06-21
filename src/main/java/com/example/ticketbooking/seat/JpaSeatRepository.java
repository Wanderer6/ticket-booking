package com.example.ticketbooking.seat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface JpaSeatRepository extends JpaRepository<Seat, Integer> {
}
