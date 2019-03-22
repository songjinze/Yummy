package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/3/22
 */

import com.yummy.module.responsemodule.restaurantResponse.RestaurantFinishedOrderModule;
import com.yummy.module.responsemodule.restaurantResponse.RestaurantOrderModule;
import com.yummy.util.message.servicemessage.DeleteMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantOrderServiceImpl implements RestaurantOrderService {
    @Override
    public List<RestaurantOrderModule> getRestaurantOrders(String restaurantIdCode) {
        return null;
    }

    @Override
    public List<RestaurantFinishedOrderModule> getRestaurantFinishedOrders(String restaurantIdCode) {
        return null;
    }

    @Override
    public DeleteMessage cancelOrder(int orderId) {
        return null;
    }

    @Override
    public ModifyMessage finishOrder(int orderId) {
        return null;
    }
}
