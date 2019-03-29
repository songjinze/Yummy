package com.yummy.dao.impl;

import com.yummy.dao.PayDao;
import com.yummy.entity.Pay;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PayDaoImpl extends DaoImpl<Pay> implements PayDao {
    public PayDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Pay getPayAccountByNameAndPassword(String name, String password) {
        List<Pay> payList=this.getByQuery("from Pay where name=\'"+name+"\' and password=\'"+password+'\'');
        if(payList.size()!=0){
            return payList.get(0);
        }else{
            return null;
        }
    }
}
