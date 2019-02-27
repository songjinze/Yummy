package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.dao.ManagerDao;
import com.yummy.entity.Manager;
import com.yummy.util.exception.ExceptionRecorder;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDaoImpl extends DaoCommonImpl implements ManagerDao {

    @Autowired
    public ManagerDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertManager(Manager manager) {
        return super.insert(manager);
    }

    @Override
    public UpdateDataMessage updateManager(Manager manager) {
        return super.update(manager);
    }

    @Override
    public UpdateDataMessage deleteManager(Manager manager) {
        return super.delete(manager);
    }

    @Override
    public Manager getManagerByName(String name) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("from Manager where name=:name");
            query.setParameter("name",name);
            List<Manager> res=query.list();
            transaction.commit();
            if(res.size()==1){
                return res.get(0);
            }
        }catch(Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return null;
    }
}
