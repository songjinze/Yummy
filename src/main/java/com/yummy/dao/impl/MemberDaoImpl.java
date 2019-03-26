package com.yummy.dao.impl;

import com.yummy.dao.MemberDao;
import com.yummy.entity.Member;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl extends DaoImpl<Member> implements MemberDao {

    public MemberDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Member getMemberByEmail(String email) {
        List<Member> members=this.getByQuery("from Member where email=\'"+email+"\'");
       // System.out.println(members.get(0).getEmail());
        if(members.size()==0){
            return null;
        }
        return members.get(0);
    }
}
