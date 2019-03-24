package com.yummy.module;
/*
 * author: SJZ
 * date: 2019/3/22
 */

public class DiscountModule {
    private String restaurantIdCode;
    private String LimitTime;
    private int discount;

    public DiscountModule(){
    }

    public DiscountModule(String restaurantIdCode, String limitTime, int discount) {
        this.restaurantIdCode = restaurantIdCode;
        LimitTime = limitTime;
        this.discount = discount;
    }

    public String getRestaurantIdCode() {
        return restaurantIdCode;
    }

    public void setRestaurantIdCode(String restaurantIdCode) {
        this.restaurantIdCode = restaurantIdCode;
    }

    public String getLimitTime() {
        return LimitTime;
    }

    public void setLimitTime(String limitTime) {
        LimitTime = limitTime;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
