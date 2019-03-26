package com.yummy.module;

public class SignUpToCheckModule {
    private int id;
    private String email;
    private String address;
    private String name;
    private String type;

    public SignUpToCheckModule(String email,String address, String name, String type) {
        this.email=email;
        this.address = address;
        this.name = name;
        this.type = type;
    }
    public SignUpToCheckModule(){}

    public SignUpToCheckModule(int id, String email,String address, String name, String type) {
        this.email=email;
        this.id = id;
        this.address = address;
        this.name = name;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
