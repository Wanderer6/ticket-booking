package com.example.ticketbooking.reservation;

import com.example.ticketbooking.seat.SeatView;

import java.util.List;

public class ReservationResponseDTO {
    private double ticketCost;
    private String userName;
    private String userSurname;
    private List<SeatView> seats;

    public ReservationResponseDTO(double ticketCost, String userName, String userSurname, List<SeatView> seats) {
        this.ticketCost = ticketCost;
        this.userName = userName;
        this.userSurname = userSurname;
        this.seats = seats;
    }

    public double getTicketCost() {
        return ticketCost;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public List<SeatView> getSeats() {
        return seats;
    }
}
