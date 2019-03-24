package com.yummy.dao.impl;

import com.yummy.dao.ProductDao;
import com.yummy.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl extends DaoImpl<Product> implements ProductDao {
    public ProductDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
