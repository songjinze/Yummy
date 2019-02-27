package com.yummy.module;
/*
 * author: SJZ
 * date: 2019/2/27
 */

import java.util.Date;

public class ProductModule {
    private String name;
    private String limitTime;
    private double price;
    private int leftNum;
    private String descrip;
    private String restaurantIdCode;

    public String getRestaurantIdCode() {
        return restaurantIdCode;
    }

    public void setRestaurantIdCode(String restaurantIdCode) {
        this.restaurantIdCode = restaurantIdCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(int leftNum) {
        this.leftNum = leftNum;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
