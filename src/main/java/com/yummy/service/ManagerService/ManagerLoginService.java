package com.yummy.service.ManagerService;
/*
 * author: SJZ
 * date: 2019/2/17
 */

import com.yummy.util.message.servicemessage.LoginMessage;
import org.springframework.stereotype.Service;

@Service
public interface ManagerLoginService {

    /**
     * 经理登录
     * @param name 经理名
     * @param password 经理密码
     * @return 成功、失败、不存在用户
     */
    LoginMessage login(String name,String password);


    /**
     * 添加经理后门方法
     * @param name 经理名
     * @param password 经理密码
     *
     */
    void setManager(String name,String password);

}
