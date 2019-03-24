package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/16
 */

import com.yummy.entity.Member;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
import org.springframework.stereotype.Service;

@Service
public interface MemberLoginService {

    /**
     * 会员登录
     * @param email 会员邮箱
     * @param password 会员密码
     * @return 登录成功、无用户、密码错误
     */
    LoginMessage login(String email,String password);

    /**
     * 会员注册
     * @param email 会员邮箱
     * @param password 会员密码
     * @return 注册成功
     */
    SignupMessage signUp(String email,String password);

}
