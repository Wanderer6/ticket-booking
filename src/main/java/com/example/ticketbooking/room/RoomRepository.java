package com.example.ticketbooking.room;

import java.util.List;
import java.util.Set;

public interface RoomRepository {
    Set<Room> findRoomsByIdIn(List<Integer> ids);
    List<RoomWithSeatsView> test3();
    List<RoomWithSeatsView> findProjectionsBy();
}
