package com.yummy.entity;
/*
 * author: SJZ
 * date: 2019/2/16
 */

import org.hibernate.annotations.LazyToOne;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="email",unique = true)
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="name")
    private String name;
    @Column(name="phone")
    private String phone;
    @Column(name="level")
    private int memberLevel;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "member")
    private Pay pay;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    private MemberAddress memberAddress;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    private Set<Order> orders;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
    private Set<FinishedOrder> finishedOrders;


    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public MemberAddress getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(MemberAddress memberAddress) {
        this.memberAddress = memberAddress;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<FinishedOrder> getFinishedOrders() {
        return finishedOrders;
    }

    public void setFinishedOrders(Set<FinishedOrder> finishedOrders) {
        this.finishedOrders = finishedOrders;
    }

    public int getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
