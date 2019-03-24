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
    }

    @Override
    public T get(int id) {
        Transaction t=null;
        try(Session session=sessionFactory.openSession()){
            t=session.beginTransaction();
            T res=session.get(entityClass,id);
            t.commit();
            session.close();
            return res;
        }catch (Exception e){
            if(t!=null){
                t.rollback();
            }
        }
        return null;
    }

    @SuppressWarnings("all")
    @Override
    public List<T> getByQuery(String hql) {
        Transaction t=null;
        try(Session session=sessionFactory.openSession()){
            t=session.beginTransaction();
            Query query=session.createQuery(hql);
            List<T> res=query.list();
            t.commit();
            session.close();
            return res;
        }catch (Exception e){
            if(t!=null){
                t.rollback();
            }
        }
        return new ArrayList<>();
    }


    @Override
    public UpdateDataMessage save(T t) {
        Transaction ts=null;
        try(Session session=sessionFactory.openSession()){
            ts=session.beginTransaction();
            session.save(t);
            ts.commit();
            session.close();
            return UpdateDataMessage.UPDATE_SUCCESS;
        }catch (Exception e){
            if(ts!=null){
                ts.rollback();
            }
        }
        return UpdateDataMessage.UPDATE_FAIL;
    }

    @Override
    public UpdateDataMessage update(T t) {
        Transaction ts=null;
        try(Session session=sessionFactory.openSession()){
            ts=session.beginTransaction();
            session.saveOrUpdate(t);
            ts.commit();
            session.close();
            return UpdateDataMessage.UPDATE_SUCCESS;
        }catch (Exception e){
            if(ts!=null){
                ts.rollback();
            }
        }
        return UpdateDataMessage.UPDATE_FAIL;
    }

    @Override
    public UpdateDataMessage delete(T t) {
        Transaction ts=null;
        try(Session session=sessionFactory.openSession()){
            ts=session.beginTransaction();
            session.delete(t);
            ts.commit();
            session.close();
            return UpdateDataMessage.UPDATE_SUCCESS;
        }catch (Exception e){
            if(ts!=null){
                ts.rollback();
            }
        }
        return UpdateDataMessage.UPDATE_FAIL;
    }
}
