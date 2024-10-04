package com.shopping.mall.User.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Mission {

    @Id
    @GeneratedValue
    private int Id;

    private String name;

    public Mission() {
    }

    public Mission(int id, String name, int duration) {
        Id = id;
        this.name = name;
        this.duration = duration;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    private int duration;

    @ManyToMany(mappedBy = "mission")
    private List<User> user;


}
