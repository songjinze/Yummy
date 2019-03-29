package com.yummy.entity;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import javax.persistence.*;

@Entity
@Table(name="pay")
public class Pay {
    @Id
    @GeneratedValue
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="accountBalance")
    private double accountBalance;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
