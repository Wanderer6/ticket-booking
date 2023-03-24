package com.example.ticketbooking.seat;

public class SeatView {

    private int seatRow;
    private int seatNumber;
    private String ticketType;

    public SeatView(int seatRow, int seatNumber, String ticketType) {
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
