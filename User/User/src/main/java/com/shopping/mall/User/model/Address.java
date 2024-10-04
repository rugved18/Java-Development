package com.shopping.mall.User.model;


import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String streetName;

    private  String houseNumber;

    private  String zipCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Address(int id, String streetName, String houseNumber, String zipCode) {
        this.id = id;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public Address() {
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @OneToOne
    @JoinColumn(name = "address_id")
    private User user;
}
