package com.yummy.module.responsemodule;
/*
 * author: SJZ
 * date: 2019/3/22
 */


public class DiscountResponseModule {
    private String LimitTime;
    private int discount;

    public DiscountResponseModule(String limitTime, int discount) {
        LimitTime = limitTime;
        this.discount = discount;
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
