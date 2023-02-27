package com.example.ticketbooking.room;

import com.example.ticketbooking.screening.Screening;
import com.example.ticketbooking.seat.Seat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int roomNumber;
    @JsonIgnore
    @ManyToMany(mappedBy = "rooms")
    private Set<Screening> screenings;
    @OneToMany(mappedBy = "room")
    private Set<Seat> seats;

    public Room() {
    }

    public Room(int id, int roomNumber) {
        Id = id;
        this.roomNumber = roomNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }


    @Override
    public String toString() {
        return "Room{" +
                "Id=" + Id +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
