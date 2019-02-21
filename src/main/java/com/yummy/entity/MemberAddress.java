package com.yummy.entity;

import com.yummy.util.Address;

import javax.persistence.*;

/*
 * author: SJZ
 * date: 2019/2/21
 */
@Entity
@Table(name="memberaddress")
public class MemberAddress {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="mid")
    private int mid;
    @Column(name="address")
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
