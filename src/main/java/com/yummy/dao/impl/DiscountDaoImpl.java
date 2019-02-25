package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.dao.DiscountDao;
import com.yummy.entity.Discount;
import com.yummy.util.exception.ExceptionRecorder;
import com.yummy.util.message.UpdateDataMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiscountDaoImpl extends DaoCommonImpl implements DiscountDao {

    @Autowired
    public DiscountDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertDiscount(Discount discount) {
        return super.insert(discount);
    }

    @Override
    public UpdateDataMessage deleteDiscount(Discount dIscount) {
        return super.delete(dIscount);
    }

    @Override
    public UpdateDataMessage updateDiscount(Discount discount) {
        return super.update(discount);
    }

    @Override
    public List<Discount> getDiscountByRid(int rid) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("from Discount where rid=:rid");
            query.setParameter("rid",rid);
            List<Discount> res=query.list();
            transaction.commit();
            return res;
        }catch (Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return new ArrayList<>();
    }
}
