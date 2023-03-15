package com.example.ticketbooking.reservation;

public class SeatInfo {

    private int seatRow;
    private int seatNumber;
    private String ticketType;

    public SeatInfo(int seatRow, int seatNumber, String ticketType) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getTicketType() {
        return ticketType;
    }
}
