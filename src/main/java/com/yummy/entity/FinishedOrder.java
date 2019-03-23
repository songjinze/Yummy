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

    private String finishedTime;

    private double totalPrice;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurantId")
    private Restaurant restaurant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="memberId")
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(String finishedTime) {
        this.finishedTime = finishedTime;
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
