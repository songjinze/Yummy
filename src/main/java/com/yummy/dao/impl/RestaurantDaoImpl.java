package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/20
 */

import com.yummy.dao.RestaurantDao;
import com.yummy.pojo.Restaurant;
import com.yummy.util.exception.ExceptionRecorder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDaoImpl extends DaoCommonImpl implements RestaurantDao{

    @Autowired
    public RestaurantDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertRestaurant(Restaurant restaurant) {
        return super.insert(restaurant);
    }

    @Override
    public boolean updateRestaurant(Restaurant restaurant) {
        return false;
    }

    @Override
    public boolean deleteRestaurant(Restaurant restaurant) {
        return false;
    }

    @Override
    public Restaurant getRestaurantByIdCode(Restaurant restaurant) {
        return null;
    }
}
