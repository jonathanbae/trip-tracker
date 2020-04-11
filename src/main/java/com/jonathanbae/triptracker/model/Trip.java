package com.jonathanbae.triptracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String notes;

    public Trip() {
    }

    public Trip(String name, String notes) {
        this.name = name;
        this.notes = notes;
    }

    public Trip(Trip trip) {
        if (trip.id != null) this.id = trip.id;
        this.name = trip.name;
        this.notes = trip.notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
