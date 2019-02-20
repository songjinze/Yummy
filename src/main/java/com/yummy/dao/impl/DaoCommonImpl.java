package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.util.exception.ExceptionRecorder;
import com.yummy.util.message.UpdateDataMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoCommonImpl {

    final SessionFactory sessionFactory;
    final ExceptionRecorder exceptionRecorder;
    @Autowired
    public DaoCommonImpl(SessionFactory sessionFactory,ExceptionRecorder exceptionRecorder) {
        this.sessionFactory = sessionFactory;
        this.exceptionRecorder=exceptionRecorder;
    }

    int insert(Object object){
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

    UpdateDataMessage update(Object object){
        Transaction transaction=null;
        UpdateDataMessage res=UpdateDataMessage.UPDATE_FAIL;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            session.update(object);
            transaction.commit();
            res=UpdateDataMessage.UPDATE_SUCCESS;
        }catch (Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return res;
    }

    UpdateDataMessage delete(Object object){
        Transaction transaction=null;
        UpdateDataMessage res=UpdateDataMessage.UPDATE_FAIL;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            session.delete(object);
            transaction.commit();
            res=UpdateDataMessage.UPDATE_SUCCESS;
        }catch (Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return res;
    }
}
