package com.castle.gappstone.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "teachers")
public class Teacher extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;


    public Teacher() {    }

    public Teacher(@NotNull String email, @NotNull String name) {
        this.email = email;
        this.name = name;
    }

    public Long getId()                 {   return id;   }

    public Teacher setId(Long id)          {   this.id = id;   return this;}

    public String getEmail()            {  return email;  }

    public Teacher setEmail(String email)  {   this.email = email;   return this; }

    public String getName()              {    return name;    }

    public Teacher setName(String name)      {  this.name = name;   return this; }
}
