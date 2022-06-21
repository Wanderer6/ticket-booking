package com.example.ticketbooking.seat;

import com.example.ticketbooking.room.Room;

import javax.persistence.*;

@Entity
@Table(name = "Seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seatRow;
    private int seatNumber;
    private boolean availability;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Seat() {
    }

    public Seat(int id, int seatRow, int seatNumber, boolean availability, Room room) {
        this.id = id;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.availability = availability;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatRow=" + seatRow +
                ", seatNumber=" + seatNumber +
                ", availability=" + availability +
                ", room=" + room +
                '}';
    }
}
