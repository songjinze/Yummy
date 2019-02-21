package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/16
 */

import com.yummy.entity.Member;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;

public interface MemberLoginService {

    /**
     * 会员登录
     * @param member 会员bean
     * @return message
     */
    LoginMessage login(Member member);

    /**
     * 会员注册
     * @param member 会员bean
     * @return message
     */
    SignupMessage signUp(Member member);
}
