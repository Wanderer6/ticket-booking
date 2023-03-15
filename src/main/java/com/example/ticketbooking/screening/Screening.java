package com.example.ticketbooking.screening;

import com.example.ticketbooking.movie.Movie;
import com.example.ticketbooking.reservation.Reservation;
import com.example.ticketbooking.room.Room;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate movieDate;
    private String movieStartTime;
//    @OneToOne(mappedBy = "screening")
    @OneToMany(mappedBy = "screening")
    private Set<Reservation> reservations;
    @JsonIgnore
//    @JsonBackReference
//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "screening_room",
            joinColumns = @JoinColumn(name = "screening_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    private Set<Room> rooms;


    public Screening() {
    }

    public Screening(LocalDate movieDate, String movieStartTime, Movie movie, Set<Room> rooms) {
        this.movieDate = movieDate;
        this.movieStartTime = movieStartTime;
        this.movie = movie;
        this.rooms = rooms;
    }

//    public Screening(Movie movie, Set<Room> rooms) {
//        this.movie = movie;
//        this.rooms = rooms;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(LocalDate movieDate) {
        this.movieDate = movieDate;
    }

    public String getMovieStartTime() {
        return movieStartTime;
    }

    public void setMovieStartTime(String movieStartTime) {
        this.movieStartTime = movieStartTime;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

//    public Reservation getReservation() {
//        return reservation;
//    }
//
//    public void setReservation(Reservation reservation) {
//        this.reservation = reservation;
//    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", movieDate=" + movieDate +
                ", movieStartTime='" + movieStartTime + '\'' +
                ", reservations=" + reservations +
                ", movie=" + movie +
                ", rooms=" + rooms +
                '}';
    }
}
