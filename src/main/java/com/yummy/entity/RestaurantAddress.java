package com.yummy.entity;

import javax.persistence.*;

@Entity
@Table(name="restaurantaddress")
public class RestaurantAddress {
    @Id
    @GeneratedValue
    private int id;

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurant_Id")
    private Restaurant restaurant;

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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
