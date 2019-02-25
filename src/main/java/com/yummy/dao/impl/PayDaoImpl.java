package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/22
 */

import com.yummy.dao.PayDao;
import com.yummy.entity.Pay;
import com.yummy.util.exception.ExceptionRecorder;
import com.yummy.util.message.UpdateDataMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PayDaoImpl extends DaoCommonImpl implements PayDao {
    @Autowired
    public PayDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertPay(PayDao payDao) {
        return super.insert(payDao);
    }

    @Override
    public UpdateDataMessage updatePay(PayDao payDao) {
        return super.update(payDao);
    }

    @Override
    public UpdateDataMessage deletePay(PayDao payDao) {
        return super.delete(payDao);
    }

    @Override
    public Pay getPayByName(String name) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("from Pay where name=:name");
            query.setParameter("name",name);
            List<Pay> pays=query.list();
            transaction.commit();
            if(pays.size()==1){
                return pays.get(0);
            }
        }catch (Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return null;
    }
}
