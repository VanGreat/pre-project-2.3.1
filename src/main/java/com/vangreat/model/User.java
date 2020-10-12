package com.vangreat.model;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "pre-project-web")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "activity")
    private String activity;

    @Column(name = "email")
    private String email;

    public User() {}

    public User(String name, String surname, String activity, String country) {
        this.name = name;
        this.surname = surname;
        this.activity = activity;
        this.email = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String country) {
        this.email = country;
    }

    @Override
    public String toString() {
        return "User: id = " + id + ", name = " + name + ", surname = " + surname
                + ", activity = " + activity +", email = " + email;
    }
}
