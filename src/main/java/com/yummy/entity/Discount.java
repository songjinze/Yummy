package com.yummy.entity;

import javax.persistence.*;
import java.util.Date;

/*
 * author: SJZ
 * date: 2019/2/21
 */
@Entity
@Table(name="discount")
public class Discount {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="descrip")
    private String descrip;
    @Column(name="limittime")
    private String limitTime;
    @Column(name="discount")
    private int discount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
