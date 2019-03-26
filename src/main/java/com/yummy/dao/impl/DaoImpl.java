package com.yummy.dao.impl;

import com.yummy.dao.Dao;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl<T> implements Dao<T> {

    private Class<T> entityClass;
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Autowired
    public DaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        ParameterizedType type=(ParameterizedType)(getClass().getGenericSuperclass());
        entityClass=(Class<T>)type.getActualTypeArguments()[0];
        System.out.println(entityClass);
    }

    @Override
    public T get(int id) {
        T res=null;
        Session session=sessionFactory.openSession();
        try{
            res=session.get(entityClass,id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return res;
    }

    @SuppressWarnings("all")
    @Override
    public List<T> getByQuery(String hql) {
        Session session=sessionFactory.openSession();
        List<T> res=new ArrayList<>();
        try{
            Query query=session.createQuery(hql);
            res=query.list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return res;
    }


    @Override
    public UpdateDataMessage save(T t) {
        Transaction ts=null;
        Session session=sessionFactory.openSession();
        try{
            ts=session.beginTransaction();
            session.save(t);
            ts.commit();
        }catch (Exception e){
            if(ts!=null){
                ts.rollback();
            }
            e.printStackTrace();
            return UpdateDataMessage.UPDATE_FAIL;
        }finally {
            session.close();
        }
        return UpdateDataMessage.UPDATE_SUCCESS;
    }

    @Override
    public UpdateDataMessage update(T t) {
        Transaction ts=null;
        Session session=sessionFactory.openSession();
        try{
            ts=session.beginTransaction();
            session.update(t);
            ts.commit();
        }catch (Exception e){
            if(ts!=null){
                ts.rollback();
            }
            e.printStackTrace();
            return UpdateDataMessage.UPDATE_FAIL;
        }finally {
            session.close();
        }
        return UpdateDataMessage.UPDATE_SUCCESS;

    }

    @Override
    public UpdateDataMessage delete(T t) {
        Transaction ts=null;
        Session session=sessionFactory.openSession();
        try{
            ts=session.beginTransaction();
            session.delete(t);
            ts.commit();

        }catch (Exception e){
            if(ts!=null){
                ts.rollback();
            }
            e.printStackTrace();
            return UpdateDataMessage.UPDATE_FAIL;
        }finally {
            session.close();
        }
        return UpdateDataMessage.UPDATE_SUCCESS;
    }
}
