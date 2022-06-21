package com.example.ticketbooking.movieStart;

import javax.persistence.*;

@Entity
@Table
public class MovieStart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieDate;
    private String startTime;

    public MovieStart() {
    }

    public MovieStart(int id, String movieDate, String startTime) {
        this.id = id;
        this.movieDate = movieDate;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(String movieDate) {
        this.movieDate = movieDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "MovieStart{" +
                "id=" + id +
                ", movieDate='" + movieDate + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
