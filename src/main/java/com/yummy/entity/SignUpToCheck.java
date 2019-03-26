package com.yummy.entity;

import javax.persistence.*;

@Entity
@Table(name="signuptocheck")
public class SignUpToCheck {
    @Id
    @GeneratedValue
    private int id;

    private String email;

    private String address;

    private String type;

    private String name;

    public SignUpToCheck(){}
    public SignUpToCheck(String email,String address, String type, String name) {
        this.email=email;
        this.address = address;
        this.type = type;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
