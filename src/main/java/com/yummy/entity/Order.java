package com.yummy.entity;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/*
 * author: SJZ
 * date: 2019/2/16
 */
@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String time;

    private boolean isPaied;

    private double totalPrice;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @OneToOne(cascade = ALL )
    @JoinColumn(name="memberAddress_id")
    private MemberAddress address;

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

    public MemberAddress getAddress() {
        return address;
    }

    public void setAddress(MemberAddress address) {
        this.address = address;
    }
}
