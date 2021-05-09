package com.castle.gappstone.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;


    public Student() {    }

    public Student(@NotNull String email, @NotNull String name) {
        this.email = email;
        this.name = name;
    }

    public Long getId()                 {   return id;   }

    public Student setId(Long id)          {   this.id = id;   return this;}

    public String getEmail()            {  return email;  }

    public Student setEmail(String email)  {   this.email = email;   return this; }

    public String getName()              {    return name;    }

    public Student setName(String name)      {  this.name = name;   return this; }
}
