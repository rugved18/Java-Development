package com.shopping.mall.User.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "app_user") // Updated table name
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String password;
    private Date date;

    // Default constructor
    public User() {}

    // Parameterized constructor
    public User(int id, String name, String password, Date date) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.date = date;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany
    @JoinTable(
            name ="employee_mission",
            joinColumns = @JoinColumn(name ="employee_id"),
            inverseJoinColumns = @JoinColumn(name ="mission_id")
    )
    private List<Mission> mission;
}
