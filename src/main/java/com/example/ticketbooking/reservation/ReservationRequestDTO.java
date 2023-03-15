package com.example.ticketbooking.reservation;

import java.util.List;

public class ReservationRequestDTO {

//    private String ticketType;
    private int screeningId;
//    private List<Integer> seatIds;
    private String name;
    private String surname;

    private List<SeatRequestDTO> seats;

//    public String getTicketType() {
//        return ticketType;
//    }

//    public void setTicketType(String ticketType) {
//        this.ticketType = ticketType;
//    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

//    public List<Integer> getSeatIds() {
//        return seatIds;
//    }

//    public void setSeatIds(List<Integer> seatIds) {
//        this.seatIds = seatIds;
//    }

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
