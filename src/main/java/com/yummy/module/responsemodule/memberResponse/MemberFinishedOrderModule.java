package com.yummy.module.responsemodule.memberResponse;
/*
 * author: SJZ
 * date: 2019/3/17
 */

public class MemberFinishedOrderModule {
    private String restaurantName;
    private String date;
    private String totalPrice;

    public MemberFinishedOrderModule(){}
    public MemberFinishedOrderModule(String restaurantName, String date, String totalPrice) {
        this.restaurantName = restaurantName;
        this.date = date;
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

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
