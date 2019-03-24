package com.yummy.dao.impl;

import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Restaurant;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantDaoImpl extends DaoImpl<Restaurant> implements RestaurantDao {
    public RestaurantDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return getByQuery("from Restaurant");
    }

    @Override
    public Restaurant getRestaurantByIdCode(String idCode) {
        List<Restaurant> restaurants=getByQuery("from Restaurant where idCode=\'"+idCode+"\'");
        if(restaurants.size()==0){
            return null;
        }
        return restaurants.get(0);
    }

    @Override
    public Restaurant getRestaurantByNameAndAddress(String restaurantName, String restaurantAddress) {
        List<Restaurant> restaurants=getByQuery("from Restaurant where name=\'"+
                restaurantName+"\'");
        for(Restaurant restaurant:restaurants){
            if(restaurant.getRestaurantAddress().getAddress().equals(restaurantAddress)){
                return restaurant;
            }
        }
        return null;
    }
}
