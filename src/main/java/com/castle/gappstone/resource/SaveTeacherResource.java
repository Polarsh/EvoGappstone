package com.castle.gappstone.resource;

import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaveTeacherResource {

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String email;

    @NotNull
    @Lob
    private String name;

    public String getEmail() {
        return email;
    }

    public SaveTeacherResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveTeacherResource setName(String name) {
        this.name = name;
        return this;
    }

}
