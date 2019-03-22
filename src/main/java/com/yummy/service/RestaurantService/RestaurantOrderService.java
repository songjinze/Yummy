package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/3/22
 */

import com.yummy.module.responsemodule.restaurantResponse.RestaurantFinishedOrderModule;
import com.yummy.module.responsemodule.restaurantResponse.RestaurantOrderModule;
import com.yummy.util.message.servicemessage.DeleteMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;

import java.util.List;

public interface RestaurantOrderService {

    public List<RestaurantOrderModule> getRestaurantOrders(String restaurantIdCode);

    public List<RestaurantFinishedOrderModule> getRestaurantFinishedOrders(String restaurantIdCode);

    public DeleteMessage cancelOrder(int orderId);

    public ModifyMessage finishOrder(int orderId);
}
