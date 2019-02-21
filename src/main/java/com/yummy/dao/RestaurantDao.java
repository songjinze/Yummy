package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/20
 */

import com.yummy.entity.Restaurant;
import com.yummy.util.message.UpdateDataMessage;

public interface RestaurantDao {
    int insertRestaurant(Restaurant restaurant);
    UpdateDataMessage updateRestaurant(Restaurant restaurant);
    UpdateDataMessage deleteRestaurant(Restaurant restaurant);
    Restaurant getRestaurantByIdCode(String idCode);
}
