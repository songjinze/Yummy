package com.yummy.module;
/*
 * author: SJZ
 * date: 2019/2/27
 */

import java.util.Date;

public class ProductModule {
    private int id;
    private String name;
    private String limitTime;
    private double price;
    private int leftNum;
    private String descrip;
    private String restaurantIdCode;

    public ProductModule(){
    }

    public ProductModule(String name, String limitTime, double price, int leftNum, String descrip, String restaurantIdCode) {
        this.name = name;
        this.limitTime = limitTime;
        this.price = price;
        this.leftNum = leftNum;
        this.descrip = descrip;
        this.restaurantIdCode = restaurantIdCode;
    }

    public ProductModule(int id, String name, String limitTime, double price, int leftNum, String descrip, String restaurantIdCode) {
        this.id=id;
        this.name = name;
        this.limitTime = limitTime;
        this.price = price;
        this.leftNum = leftNum;
        this.descrip = descrip;
        this.restaurantIdCode = restaurantIdCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
