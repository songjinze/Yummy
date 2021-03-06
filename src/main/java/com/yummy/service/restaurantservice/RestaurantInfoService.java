package com.yummy.service.restaurantservice;
/*
 * author: SJZ
 * date: 2019/2/25
 */

import com.yummy.module.RestaurantModule;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantInfoService {

    /**
     * 修改餐厅信息
     * @param restaurantModule
     * @return modifymessage
     */
    ModifyMessage modifyRestaurantMessage(RestaurantModule restaurantModule);
}
