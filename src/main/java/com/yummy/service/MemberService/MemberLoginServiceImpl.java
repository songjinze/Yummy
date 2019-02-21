package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.entity.Member;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginServiceImpl implements MemberLoginService{
    @Override
    public LoginMessage login(Member member) {
        return null;
    }

    @Override
    public SignupMessage signUp(Member member) {
        return null;
    }
}
