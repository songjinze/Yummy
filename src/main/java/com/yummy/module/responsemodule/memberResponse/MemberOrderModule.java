package com.yummy.module.responsemodule.memberResponse;
/*
 * author: SJZ
 * date: 2019/3/16
 */

public class MemberOrderModule {

    private int oid;
    private int mid;
    private String date;
    private String restaurantName;
    private String restaurantAddress;
    private String memberAddress;
    private String isPaid;
    private double totalPrice;

    public MemberOrderModule(){}

    public MemberOrderModule(int oid, int mid, String date, String restaurantName, String isPaid, double totalPrice) {
        this.oid = oid;
        this.mid = mid;
        this.date = date;
        this.restaurantName = restaurantName;
        this.isPaid = isPaid;
        this.totalPrice = totalPrice;
    }

    public MemberOrderModule(int mid, String date, String restaurantName, String isPaid, double totalPrice) {
        this.mid = mid;
        this.date = date;
        this.restaurantName = restaurantName;
        this.isPaid = isPaid;
        this.totalPrice = totalPrice;
    }

    public MemberOrderModule(String date, String restaurantName, String isPaid, double totalPrice) {
        this.date = date;
        this.restaurantName = restaurantName;
        this.isPaid = isPaid;
        this.totalPrice = totalPrice;
    }

    public int getOid() {
        return oid;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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
