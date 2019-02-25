package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.dao.FinishedOrderDao;
import com.yummy.entity.FinishedOrder;
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
public class FinishedOrderDaoImpl extends DaoCommonImpl implements FinishedOrderDao {
    @Autowired
    public FinishedOrderDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertFinishedOrder(FinishedOrder finishedOrder) {
        return super.insert(finishedOrder);
    }

    @Override
    public UpdateDataMessage deleteFInishedOrder(FinishedOrder finishedOrder) {
        return super.delete(finishedOrder);
    }

    @Override
    public List<FinishedOrder> getFinishedOrderByRid(int rid) {
        return getFinishedOrderById("rid",rid);
    }

    private List<FinishedOrder> getFinishedOrderById(String idType,int id){
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query;
            switch (idType){
                case "rid":
                    query=session.createQuery("from FinishedOrder where rid=:rid");
                    query.setParameter("rid",id);
                    return query.list();
                case "mid":
                    query=session.createQuery("from FinishedOrder where mid=:mid");
                    query.setParameter("mid",id);
                    return query.list();
            }
        }catch (Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public List<FinishedOrder> getFinishedOrderByMid(int mid) {
        return getFinishedOrderById("mid",mid);
    }
}
