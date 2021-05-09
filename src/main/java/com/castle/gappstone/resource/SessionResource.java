package com.castle.gappstone.resource;

import com.castle.gappstone.domain.model.AuditModel;

public class SessionResource extends AuditModel {

    private long id;
    private String date;
    private String description;
    private String place;

    public long getId() {
        return id;
    }

    public SessionResource setId(long id) {
        this.id = id;
        return this;
    }

    public String getDate() {
        return date;
    }

    public SessionResource setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SessionResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public SessionResource setPlace(String place) {
        this.place = place;
        return this;
    }
}
