package com.yummy.dao.impl;
/*
 * author: SJZ
 * date: 2019/2/22
 */

import com.yummy.dao.MemberAddressDao;
import com.yummy.entity.MemberAddress;
import com.yummy.util.exception.ExceptionRecorder;
import com.yummy.util.message.UpdateDataMessage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MemberAddressDaoImpl extends DaoCommonImpl implements MemberAddressDao {
    @Autowired
    public MemberAddressDaoImpl(SessionFactory sessionFactory, ExceptionRecorder exceptionRecorder) {
        super(sessionFactory, exceptionRecorder);
    }

    @Override
    public int insertMemberAddress(MemberAddress memberAddress) {
        return super.insert(memberAddress);
    }

    @Override
    public UpdateDataMessage updateMemberAddress(MemberAddress memberAddress) {
        return super.update(memberAddress);
    }

    @Override
    public UpdateDataMessage deleteMemberAddress(MemberAddress memberAddress) {
        return super.delete(memberAddress);
    }

    @Override
    public List<MemberAddress> getMemberAddressByMid(int mid) {
        Transaction transaction=null;
        try(Session session=sessionFactory.openSession()){
            transaction=session.beginTransaction();
            Query query=session.createQuery("from MemberAddress where mid=:mid");
            query.setParameter("mid",mid);
            List<MemberAddress> memberAddresses=query.list();
            transaction.commit();
            return memberAddresses;
        }catch(Exception e){
            exceptionRecorder.recordException(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }
        return new ArrayList<>();
    }
}
