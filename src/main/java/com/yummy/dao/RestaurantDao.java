package com.yummy.dao;

import com.yummy.entity.Restaurant;

import java.util.List;

public interface RestaurantDao extends Dao<Restaurant>{

    List<Restaurant> getAllRestaurant();

    Restaurant getRestaurantByIdCode(String idCode);

    Restaurant getRestaurantByNameAndAddress(String restaurantName,String restaurantAddress);
}
