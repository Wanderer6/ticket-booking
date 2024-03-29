package com.example.ticketbooking.reservation;

import com.example.ticketbooking.screening.Screening;
import com.example.ticketbooking.seat.Seat;
import com.example.ticketbooking.user.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;
    @JsonManagedReference
    @OneToMany(mappedBy = "reservation")
    private Set<Seat> seats;

    public Reservation() {
    }

    public Reservation(User user, Screening screening, Set<Seat> seats) {
        this.user = user;
        this.screening = screening;
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", screening=" + screening +
                ", seats=" + seats +
                '}';
    }
}
