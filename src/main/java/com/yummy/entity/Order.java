package com.yummy.entity;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

/*
 * author: SJZ
 * date: 2019/2/16
 */
@Entity
@Table(name="unFinishedOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="date")
    private String time;

    @Column(name="isPaied")
    private boolean isPaied;

    @Column(name="totalPrice")
    private double totalPrice;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name="memberId")
    private Member member;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name="restaurantId")
    private Restaurant restaurant;

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPaied() {
        return isPaied;
    }

    public void setPaied(boolean paied) {
        isPaied = paied;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
