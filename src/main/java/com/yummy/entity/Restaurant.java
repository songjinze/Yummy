package com.yummy.entity;
/*
 * author: SJZ
 * date: 2019/2/16
 */

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="idCode",length = 7,unique = true)
    private String idCode;

    @Column(name="type")
    private String type;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "restaurant",fetch = FetchType.EAGER)
    private Set<Product> productSet;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant",fetch = FetchType.EAGER)
    private Discount discount;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant",fetch = FetchType.EAGER)
    private Set<Order> orders;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant",fetch = FetchType.EAGER)
    private Set<FinishedOrder> finishedOrders;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
