package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/22
 */

import com.yummy.dao.OrderDao;
import com.yummy.entity.FinishedOrder;
import com.yummy.entity.Order;
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
public class OrderDaoImpl extends DaoCommonImpl implements OrderDao {
    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertOrder(Order order) {
        return super.insert(order);
    }

    @Override
    public UpdateDataMessage updateOrder(Order order) {
        return super.update(order);
    }

    @Override
    public UpdateDataMessage deleteOrder(Order order) {
        return super.delete(order);
    }

    @Override
    public List<Order> getOrdersByMid(int mid) {
        return getOrderById("mid",mid);
    }
    private List<Order> getOrderById(String idType, int id){
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query;
            switch (idType){
                case "rid":
                    query=session.createQuery("from Order where rid=:rid");
                    query.setParameter("rid",id);
                    return query.list();
                case "mid":
                    query=session.createQuery("from Order where mid=:mid");
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
    public List<Order> getOrdersByRid(int rid) {
        return getOrderById("rid",rid);
    }
}
