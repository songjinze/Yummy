package com.yummy.entity;

import javax.persistence.*;

@Entity
@Table(name="signuptocheck")
public class SignUpToCheck {
    @Id
    @GeneratedValue
    private long id;

    private String address;

    private String type;

    private String name;

    public SignUpToCheck(){}
    public SignUpToCheck(String address, String type, String name) {
        this.address = address;
        this.type = type;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
