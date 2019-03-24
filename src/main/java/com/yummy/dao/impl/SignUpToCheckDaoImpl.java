package com.yummy.dao.impl;

import com.yummy.dao.SignUpToCheckDao;
import com.yummy.entity.SignUpToCheck;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class SignUpToCheckDaoImpl extends DaoImpl<SignUpToCheck> implements SignUpToCheckDao {
    public SignUpToCheckDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
