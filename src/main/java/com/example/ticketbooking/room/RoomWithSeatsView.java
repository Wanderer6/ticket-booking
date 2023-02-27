package com.example.ticketbooking.room;

import java.util.List;

public interface RoomWithSeatsView {
    int getRoomNumber();
    List<SeatsView> getSeats();

    interface SeatsView {
        int getSeatRow();
        int getSeatNumber();
        boolean isAvailability();
    }
}

