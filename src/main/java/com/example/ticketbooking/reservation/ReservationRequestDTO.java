package com.example.ticketbooking.reservation;

import com.example.ticketbooking.seat.SeatRequestDTO;

import java.util.List;

public class ReservationRequestDTO {

    private int screeningId;
    private String name;
    private String surname;

    private List<SeatRequestDTO> seats;

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<SeatRequestDTO> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatRequestDTO> seats) {
        this.seats = seats;
    }
}
