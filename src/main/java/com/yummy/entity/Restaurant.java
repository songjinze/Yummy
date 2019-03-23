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

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Set<Product> productSet;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Discount discount;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private MemberAddress address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Set<Order> orders;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private Set<FinishedOrder> finishedOrders;

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

    public MemberAddress getAddress() {
        return address;
    }

    public void setAddress(MemberAddress address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
