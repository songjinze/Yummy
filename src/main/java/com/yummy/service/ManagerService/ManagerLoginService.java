package com.yummy.service.ManagerService;
/*
 * author: SJZ
 * date: 2019/2/17
 */

import com.yummy.entity.Manager;
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

    /**
     * 通过经理名字获得经理id
     * @param name 经理name
     * @return 经理id，不存在则返回-1
     */
    int getManagerIdByName(String name);

}
