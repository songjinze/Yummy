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
    @Column(name="finishedtime")
    private String finiedTime;
    @Column(name="totalprice")
    private double totalPrice;
    @Column(name="rid")
    private int rid;
    @Column(name="mid")
    private int mid;

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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
