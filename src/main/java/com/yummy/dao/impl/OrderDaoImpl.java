package com.yummy.dao.impl;

import com.yummy.dao.OrderDao;
import com.yummy.entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl extends DaoImpl<Order> implements OrderDao {
    public OrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
