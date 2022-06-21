package com.example.ticketbooking.screening;

import javax.persistence.*;

@Entity
@Table(name = "Screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Screening() {
    }

    public Screening(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
