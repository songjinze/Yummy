package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.util.exception.ExceptionRecorder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoCommonImpl {

    protected final SessionFactory sessionFactory;
    protected final ExceptionRecorder exceptionRecorder;
    @Autowired
    public DaoCommonImpl(SessionFactory sessionFactory,ExceptionRecorder exceptionRecorder) {
        this.sessionFactory = sessionFactory;
        this.exceptionRecorder=exceptionRecorder;
    }

    public int insert(Object object){
        Transaction transaction=null;
        int id=-1;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            id=(int)session.save(object);
            transaction.commit();
        }catch (Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return id;
    }
}
