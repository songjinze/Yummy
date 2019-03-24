package com.yummy.dao.impl;

import com.yummy.dao.RestaurantAddressDao;
import com.yummy.entity.RestaurantAddress;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantAddressDaoImpl extends DaoImpl<RestaurantAddress> implements RestaurantAddressDao {
    public RestaurantAddressDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
