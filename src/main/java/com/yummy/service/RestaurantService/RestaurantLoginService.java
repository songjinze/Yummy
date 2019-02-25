package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/2/24
 */

import com.yummy.entity.Restaurant;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;

public interface RestaurantLoginService {

    /**
     * 餐厅登录
     * @param restaurant 餐厅信息
     * @return loginmessage
     */
    LoginMessage login(Restaurant restaurant);

    /**
     * 餐厅注册
     * @param restaurant 餐厅信息
     * @return signupmessage
     */
    SignupMessage signUp(Restaurant restaurant);
}
