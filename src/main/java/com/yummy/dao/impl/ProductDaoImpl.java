package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/22
 */

import com.yummy.dao.ProductDao;
import com.yummy.entity.Product;
import com.yummy.util.exception.ExceptionRecorder;
import com.yummy.util.message.UpdateDataMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends DaoCommonImpl implements ProductDao {
    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertProduct(Product product) {
        return super.insert(product);
    }

    @Override
    public UpdateDataMessage updateProduct(Product product) {
        return super.update(product);
    }

    @Override
    public UpdateDataMessage deleteProduct(Product product) {
        return super.delete(product);
    }

    @Override
    public List<Product> getProductByRid(int rid) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("from Product where rid=:rid");
            query.setParameter("rid",rid);
            List<Product> res=query.list();
            transaction.commit();
            return res;
        }catch(Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public List<Product> getProductByName(String name) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("from Product where name=:name");
            query.setParameter("name",name);
            List<Product> res=query.list();
            transaction.commit();
            return res;
        }catch(Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return new ArrayList<>();
    }
}
