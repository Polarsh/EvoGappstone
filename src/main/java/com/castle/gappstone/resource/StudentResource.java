package com.castle.gappstone.resource;

public class StudentResource {

    private Long id;
    private String email;
    private String name;

    public Long getId() {
        return id;
    }

    public StudentResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentResource setName(String name) {
        this.name = name;
        return this;
    }
}
