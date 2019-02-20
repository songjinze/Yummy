package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/20
 */

import com.yummy.pojo.Restaurant;

public interface RestaurantDao {
    int insertRestaurant(Restaurant restaurant);
    boolean updateRestaurant(Restaurant restaurant);
    boolean deleteRestaurant(Restaurant restaurant);
    Restaurant getRestaurantByIdCode(Restaurant restaurant);
}
