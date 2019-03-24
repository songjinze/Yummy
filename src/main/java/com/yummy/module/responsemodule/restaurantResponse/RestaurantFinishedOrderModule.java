package com.yummy.module.responsemodule.restaurantResponse;
/*
 * author: SJZ
 * date: 2019/3/22
 */

public class RestaurantFinishedOrderModule {
    private int orderId;
    private String date;
    private double totalPrice;

    public RestaurantFinishedOrderModule(){}
    public RestaurantFinishedOrderModule(int orderId, String date, double totalPrice) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
