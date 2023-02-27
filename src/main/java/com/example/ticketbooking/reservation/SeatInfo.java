package com.example.ticketbooking.reservation;

public class SeatInfo {

    private int seatRow;
    private int seatNumber;

    public SeatInfo(int seatRow, int seatNumber) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
