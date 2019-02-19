package com.yummy.service.ManagerService;
/*
 * author: SJZ
 * date: 2019/2/17
 */

import com.yummy.module.ManagerBean;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;

public interface ManagerLoginService {
    /**
     * 经理登录
     * @param managerBean 经理bean
     * @return LoginMessage
     */
    LoginMessage login(ManagerBean managerBean);

    /**
     * 经理注册
     * @param managerBean 经理bean
     * @return SignupMessage
     */
    SignupMessage signUp(ManagerBean managerBean);

}
