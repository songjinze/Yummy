package com.yummy.dao.impl;

import com.yummy.dao.DiscountDao;
import com.yummy.entity.Discount;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DiscountDaoImpl extends DaoImpl<Discount> implements DiscountDao {
    public DiscountDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
