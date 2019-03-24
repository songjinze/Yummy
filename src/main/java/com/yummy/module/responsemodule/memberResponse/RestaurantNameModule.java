package com.yummy.module.responsemodule.memberResponse;
/*
 * author: SJZ
 * date: 2019/3/1
 */

public class RestaurantNameModule {
    private String restaurantName;
    private String restaurantAddress;

    public RestaurantNameModule(String restaurantName, String restaurantAddress) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
    }

    public RestaurantNameModule(){}

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }
}
