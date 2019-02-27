package com.yummy.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/*
 * author: SJZ
 * date: 2019/2/21
 */
@Entity
public class MemberAddress {
    @Id
    @GeneratedValue
    private int MA_ID;
    private int mid;

    @OneToMany(orphanRemoval = true,cascade = ALL)
    private Set<Address> address;

    public int getMA_ID() {
        return MA_ID;
    }

    public void setMA_ID(int MA_ID) {
        this.MA_ID = MA_ID;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
