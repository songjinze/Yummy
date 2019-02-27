package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.dao.MemberDao;
import com.yummy.entity.Member;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginServiceImpl implements MemberLoginService{

    private final MemberDao memberDao;

    @Autowired
    public MemberLoginServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public LoginMessage login(String email,String password) {
        Member member1=memberDao.getMemberByEmail(email);
        if(member1==null){
            return LoginMessage.NO_USER;
        }
        if(member1.getPassword().equals(password)){
            return LoginMessage.SUCCESS;
        }else{
            return LoginMessage.WRONG_PASSWD;
        }
    }

    @Override
    public SignupMessage signUp(String email,String password) {
        Member member1=memberDao.getMemberByEmail(email);
        if(member1!=null){
            return SignupMessage.DUPLICATED_USER;
        }
        Member member=new Member();
        member.setEmail(email);
        member.setPassword(password);
        if(memberDao.insertMember(member)!=-1){
            return SignupMessage.SIGNUP_SUCCESS;
        }else{
            return SignupMessage.SIGNUP_FAIL;
        }
    }

    @Override
    public int getMidByEmail(String email) {
        Member member=memberDao.getMemberByEmail(email);
        if(member==null){
            return -1;
        }else{
            return member.getId();
        }
    }
}
