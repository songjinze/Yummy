package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.dao.MemberDao;
import com.yummy.pojo.Member;
import com.yummy.util.exception.ExceptionRecorder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl extends DaoCommonImpl implements MemberDao {

    @Autowired
    public MemberDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertMember(Member member) {
        return super.insert(member);
    }

    @Override
    public boolean updateMember(Member member) {
        Transaction transaction=null;
        boolean result=false;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            session.update(member);
            transaction.commit();
            result=true;
        }catch(Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public boolean deleteMember(String email) {
        Transaction transaction=null;
        boolean result=false;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            session.delete(email);
            transaction.commit();
            result=true;
        }catch(Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return result;
    }


    @Override
    public Member getMemberByEmail(String email) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("FROM Member WHERE email=:email");
            query.setParameter("email",email);
            List res=query.list();
            if(res.size()==1){
                return (Member)res.get(0);
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
