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

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "member",fetch = FetchType.LAZY)
    private Pay pay=null;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member",fetch = FetchType.EAGER)
    private Set<MemberAddress> memberAddress=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member",fetch = FetchType.EAGER)
    private Set<Order> orders=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "member",fetch = FetchType.EAGER)
    private Set<FinishedOrder> finishedOrders=new HashSet<>();

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

    public Pay getPay() {
        return pay;
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
