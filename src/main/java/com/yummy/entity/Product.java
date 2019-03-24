package com.yummy.entity;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="limittime")
    private String limitTime;
    @Column(name="price")
    private double price;
    @Column(name="leftnum")
    private int leftNum;
    @Column(name="descrip")
    private String descrip;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurantId")
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

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

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
