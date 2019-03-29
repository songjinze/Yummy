package com.yummy.service.restaurantservice;
/*
 * author: SJZ
 * date: 2019/2/24
 */

import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantLoginService {

    /**
     * 餐厅登录
     * @param idCode 餐厅信息
     * @return loginmessage
     */
    LoginMessage login(String idCode);

    /**
     * 餐厅注册，自动分配idCode
     * @param email 餐厅接收idCode邮箱
     * @param address 餐厅地址
     * @param type 餐厅类型
     * @param name 餐厅名字
     * @return 注册成功、注册失败
     */
    SignupMessage signUp(String email,String address, String type,String name);
}
