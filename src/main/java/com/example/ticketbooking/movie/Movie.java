package com.example.ticketbooking.movie;

import javax.persistence.*;

@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
//    private LocalDateTime screeningTime;
    private int roomNumber;

    public Movie() {
    }

    public Movie(String title, int roomNumber) {
        this.title = title;
        this.roomNumber = roomNumber;
    }



//    public Movie(String title, LocalDateTime screeningTime, int roomNumber) {
//        this.title = title;
//        this.screeningTime = screeningTime;
//        this.roomNumber = roomNumber;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //    public LocalDateTime getScreeningTime() {
//        return screeningTime;
//    }
//
//    public void setScreeningTime(LocalDateTime screeningTime) {
//        this.screeningTime = screeningTime;
//    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
