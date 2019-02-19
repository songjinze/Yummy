package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/16
 */

import com.yummy.module.MemberBean;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;

public interface MemberLoginService {

    /**
     * 会员登录
     * @param memberBean 会员bean
     * @return message
     */
    LoginMessage login(MemberBean memberBean);

    /**
     * 会员注册
     * @param memberBean 会员bean
     * @return message
     */
    SignupMessage signUp(MemberBean memberBean);
}
