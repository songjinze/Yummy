package com.yummy.service.ManagerService;
/*
 * author: SJZ
 * date: 2019/2/17
 */

import com.yummy.pojo.Manager;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;

public interface ManagerLoginService {
    /**
     * 经理登录
     * @param manager 经理bean
     * @return LoginMessage
     */
    LoginMessage login(Manager manager);

    /**
     * 经理注册
     * @param manager 经理bean
     * @return SignupMessage
     */
    SignupMessage signUp(Manager manager);

}
