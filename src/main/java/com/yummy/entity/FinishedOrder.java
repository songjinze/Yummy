package com.yummy.entity;

import javax.persistence.*;
import java.util.Date;

/*
 * author: SJZ
 * date: 2019/2/21
 */
@Entity
@Table(name="finishedorder")
public class FinishedOrder {
    @Id
    @GeneratedValue
    private int id;

    private String finiedTime;

    private double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;

    @OneToOne(cascade = CascadeType.ALL)
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFiniedTime() {
        return finiedTime;
    }

    public void setFiniedTime(String finiedTime) {
        this.finiedTime = finiedTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
