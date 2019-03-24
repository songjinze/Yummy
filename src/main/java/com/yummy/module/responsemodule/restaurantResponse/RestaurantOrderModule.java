package com.yummy.module.responsemodule.restaurantResponse;
/*
 * author: SJZ
 * date: 2019/3/22
 */

public class RestaurantOrderModule {
    private int orderId;
    private String date;
    private String isPaid;
    private double totalPrice;

    public RestaurantOrderModule(){}
    public RestaurantOrderModule(int orderId, String date, String isPaid, double totalPrice) {
        this.orderId = orderId;
        this.date = date;
        this.isPaid = isPaid;
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
