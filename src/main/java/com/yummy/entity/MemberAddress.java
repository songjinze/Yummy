package com.yummy.entity;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="memberaddress")
public class MemberAddress implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
