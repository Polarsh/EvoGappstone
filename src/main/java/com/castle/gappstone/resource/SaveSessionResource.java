package com.castle.gappstone.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveSessionResource {
    @NotNull
    @NotBlank
    @Size(max = 50)
    private String date;

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String description;

    @NotNull
    @NotBlank
    private String place;


    public String getDate() {
        return date;
    }

    public SaveSessionResource setDate(String date) {
        this.date = date;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SaveSessionResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public SaveSessionResource setPlace(String place) {
        this.place = place;
        return this;
    }
}
