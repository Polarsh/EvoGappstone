package com.castle.gappstone.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sessions" )
public class Session extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String date;

    @NotNull
    private String description;


    @NotNull
    private String place;


    public Session() {
    }

    public Session(@NotNull String date, @NotNull String description, @NotNull String place) {
        this.date = date;
        this.description = description;
        this.place = place;
    }

    public long getId() {
        return id;
    }

    public Session setId(long id) {
        this.id = id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Session setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Session setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public Session setPlace(String place) {
        this.place = place;
        return this;
    }
}
