package com.example.ticketbooking.seat;

import com.example.ticketbooking.reservation.Reservation;
import com.example.ticketbooking.room.Room;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int seatRow;
    private int seatNumber;
    private String ticketType;
    private boolean availability;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Seat() {
    }

    public Seat(int id, int seatRow, int seatNumber, String ticketType, boolean availability, Reservation reservation, Room room) {
        this.id = id;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.ticketType = ticketType;
        this.availability = availability;
        this.reservation = reservation;
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

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatRow=" + seatRow +
                ", seatNumber=" + seatNumber +
                ", ticketType='" + ticketType + '\'' +
                ", availability=" + availability +
                ", reservation=" + reservation +
                ", room=" + room +
                '}';
    }
}
