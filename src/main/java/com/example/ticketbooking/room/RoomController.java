package com.example.ticketbooking.room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping("/room")
    List<RoomWithSeatsView> test3() {
        return roomRepository.test3();
    }

    @GetMapping("/rooms")
    List<RoomWithSeatsView> findProjectionsBy() {
        return roomRepository.findProjectionsBy();
    }
}
