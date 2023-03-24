package com.example.ticketbooking.seat;

public class SeatRequestDTO {
    private int id;
    private String ticketType;

    public SeatRequestDTO(int id, String ticketType) {
        this.id = id;
        this.ticketType = ticketType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
}
