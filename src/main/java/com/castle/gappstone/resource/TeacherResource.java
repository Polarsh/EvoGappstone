package com.castle.gappstone.resource;

public class TeacherResource {

    private Long id;
    private String email;
    private String name;

    public Long getId() {
        return id;
    }

    public TeacherResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TeacherResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeacherResource setName(String name) {
        this.name = name;
        return this;
    }

}
