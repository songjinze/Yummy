package com.yummy.entity;
/*
 * author: SJZ
 * date: 2019/2/16
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="level")
    private int memberLevel;

    private double currentBalance;

    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER)
    private Set<MemberAddress> memberAddress=new HashSet<>();

    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER)
    private Set<Order> orders=new HashSet<>();

    @OneToMany(mappedBy = "member",fetch = FetchType.EAGER)
    private Set<FinishedOrder> finishedOrders=new HashSet<>();


    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setMemberAddress(Set<MemberAddress> memberAddress) {
        this.memberAddress = memberAddress;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setFinishedOrders(Set<FinishedOrder> finishedOrders) {
        this.finishedOrders = finishedOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }


    public Set<MemberAddress> getMemberAddress() {
        return memberAddress;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public Set<FinishedOrder> getFinishedOrders() {
        return finishedOrders;
    }

}
