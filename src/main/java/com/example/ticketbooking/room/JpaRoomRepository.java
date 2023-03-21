package com.example.ticketbooking.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface JpaRoomRepository extends RoomRepository, JpaRepository<Room, Integer> {

    @Override
    @Query("Select r from Room r where id in :ids")
    Set<Room> findRoomsByIdIn(List<Integer> ids);

    @Override
    @Query("Select distinct r from Room r " +
            "left join fetch r.seats s " +
            "where r.id = 1")
    List<RoomWithSeatsView> test3();

    @Override
    List<RoomWithSeatsView> findProjectionsBy();
}
