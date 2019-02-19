package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.module.MemberBean;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginServiceImpl implements MemberLoginService{
    @Override
    public LoginMessage login(MemberBean memberBean) {
        return null;
    }

    @Override
    public SignupMessage signUp(MemberBean memberBean) {
        return null;
    }
}
