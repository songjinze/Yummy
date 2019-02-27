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

    private int mid;

    private int rid;

    @OneToOne(cascade = ALL)
    private Address address;

    @OneToMany(orphanRemoval = true,cascade = ALL)
    private Set<Product> productList;

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

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProductList() {
        return productList;
    }

    public void setProductList(Set<Product> productList) {
        this.productList = productList;
    }
}
