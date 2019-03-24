package com.yummy.module.responsemodule.memberResponse;
/*
 * author: SJZ
 * date: 2019/3/16
 */

public class MemberOrderModule {

    private String date;
    private String restaurantName;
    private String isPaid;
    private double totalPrice;

    public MemberOrderModule(){}

    public MemberOrderModule(String date, String restaurantName, String isPaid, double totalPrice) {
        this.date = date;
        this.restaurantName = restaurantName;
        this.isPaid = isPaid;
        this.totalPrice = totalPrice;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(String isPaid) {
        this.isPaid = isPaid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
