package com.yummy.dao.impl;

import com.yummy.dao.FinishedOrderDao;
import com.yummy.entity.FinishedOrder;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class FinishedOrderDaoImpl extends DaoImpl<FinishedOrder> implements FinishedOrderDao {
    public FinishedOrderDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
