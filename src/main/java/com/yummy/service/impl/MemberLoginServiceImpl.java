package com.yummy.service.impl;

import com.yummy.dao.MemberDao;
import com.yummy.entity.Member;
import com.yummy.service.memberservice.MemberLoginService;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginServiceImpl implements MemberLoginService {

    private MemberDao memberDaoImpl;

    @Autowired
    public MemberLoginServiceImpl(MemberDao memberDaoImpl) {
        this.memberDaoImpl = memberDaoImpl;
    }

    @Override
    public synchronized LoginMessage login(String email, String password) {
        Member member= memberDaoImpl.getMemberByEmail(email);
        if(member==null){
            return LoginMessage.NO_USER;
        }else{
            if(member.getPassword().equals(password)){
                return LoginMessage.SUCCESS;
            }else{
                return LoginMessage.WRONG_PASSWD;
            }
        }
    }

    @Override
    public synchronized SignupMessage signUp(String email, String password) {
        Member member=memberDaoImpl.getMemberByEmail(email);
        if(member!=null){
            return SignupMessage.DUPLICATED_USER;
        }else{
            member=new Member();
            member.setEmail(email);
            member.setPassword(password);
            UpdateDataMessage updateDataMessage= memberDaoImpl.save(member);
            if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
                return SignupMessage.SIGNUP_SUCCESS;
            }else{
                return SignupMessage.SIGNUP_FAIL;
            }
        }
    }

}
