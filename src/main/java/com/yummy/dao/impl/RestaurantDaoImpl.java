package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/20
 */

import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Restaurant;
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
public class RestaurantDaoImpl extends DaoCommonImpl implements RestaurantDao{

    @Autowired
    public RestaurantDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertRestaurant(Restaurant restaurant) {
        return super.insert(restaurant);
    }

    @Override
    public UpdateDataMessage updateRestaurant(Restaurant restaurant) {
        return super.update(restaurant);
    }

    @Override
    public UpdateDataMessage deleteRestaurant(Restaurant restaurant) {
        return super.delete(restaurant);
    }

    @Override
    public Restaurant getRestaurantByIdCode(String idCode) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("FROM Restaurant WHERE idCode=:IdCode");
            query.setParameter("IdCode",idCode);
            transaction.commit();
            List res=query.list();
            if(res.size()==1){
                return (Restaurant)res.get(0);
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
