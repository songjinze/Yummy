package com.yummy.module.responsemodule.memberResponse;
/*
 * author: SJZ
 * date: 2019/3/18
 */

public class RestaurantProducts {
    private int pId;
    private String date;
    private String leftNum;
    private String productName;
    private String productDescription;
    private double productPrice;

    public RestaurantProducts(){

    }
    public RestaurantProducts(int pId, String date, String leftNum, String productName, String productDescription, double productPrice) {
        this.pId = pId;
        this.date = date;
        this.leftNum = leftNum;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(String leftNum) {
        this.leftNum = leftNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
