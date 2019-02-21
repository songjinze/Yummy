package com.yummy.entity;

import com.yummy.util.Address;
import com.yummy.util.ProductList;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name="time")
    private Date time;
    @Column(name="address")
    private Address address;
    @Column(name="ispaied")
    private boolean isPaied;
    @Column(name="totalprice")
    private double totalPrice;
    @Column(name="mid")
    private int mid;
    @Column(name="pList")
    private ProductList productList;
    @Column(name="rid")
    private int rid;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }
}
