package com.yummy.service.impl;

import com.yummy.dao.FinishedOrderDao;
import com.yummy.dao.OrderDao;
import com.yummy.dao.RestaurantDao;
import com.yummy.entity.FinishedOrder;
import com.yummy.entity.Order;
import com.yummy.entity.Restaurant;
import com.yummy.module.responsemodule.restaurantResponse.RestaurantFinishedOrderModule;
import com.yummy.module.responsemodule.restaurantResponse.RestaurantOrderModule;
import com.yummy.service.restaurantservice.RestaurantOrderService;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.DeleteMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantOrderServiceImpl implements RestaurantOrderService {

    private final RestaurantDao restaurantDao;
    private final OrderDao orderDao;
    private final FinishedOrderDao finishedOrderDao;

    @Autowired
    public RestaurantOrderServiceImpl(FinishedOrderDao finishedOrderDao,OrderDao orderDao,RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        this.orderDao=orderDao;
        this.finishedOrderDao=finishedOrderDao;
    }

    @Override
    public List<RestaurantOrderModule> getRestaurantOrders(String restaurantIdCode) {
        Restaurant restaurant= restaurantDao.getRestaurantByIdCode(restaurantIdCode);
        List<RestaurantOrderModule> restaurantOrderModules=new ArrayList<>();
        if(restaurant!=null){
            Set<Order> orders=restaurant.getOrders();
            for(Order order:orders){
                restaurantOrderModules.add(new RestaurantOrderModule(
                        order.getId(),
                        order.getTime(),
                        order.isPaied()+"",
                        order.getTotalPrice()
                ));
            }
        }
        return restaurantOrderModules;
    }

    @Override
    public List<RestaurantFinishedOrderModule> getRestaurantFinishedOrders(String restaurantIdCode) {
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(restaurantIdCode);
        List<RestaurantFinishedOrderModule> restaurantFinishedOrderModules=new ArrayList<>();
        if(restaurant!=null){
            Set<FinishedOrder> finishedOrders=restaurant.getFinishedOrders();
            for(FinishedOrder finishedOrder:finishedOrders){
                restaurantFinishedOrderModules.add(new RestaurantFinishedOrderModule(
                        finishedOrder.getId(),
                        finishedOrder.getFinishedTime(),
                        finishedOrder.getTotalPrice()
                ));
            }
        }
        return restaurantFinishedOrderModules;
    }

    @Override
    public DeleteMessage cancelOrder(int orderId) {
        Order order=orderDao.get(orderId);
        if(order==null){
            return DeleteMessage.SUCCESS;
        }
        UpdateDataMessage updateDataMessage=orderDao.delete(order);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return DeleteMessage.SUCCESS;
        }else{
            return DeleteMessage.DELETE_FAIL;
        }
    }

    @Override
    public ModifyMessage finishOrder(int orderId) {
        Order order=orderDao.get(orderId);
        if(order==null){
            return ModifyMessage.MODIFY_FAIL;
        }else{
            FinishedOrder finishedOrder=new FinishedOrder();
            finishedOrder.setFinishedTime(order.getTime());
            finishedOrder.setTotalPrice(order.getTotalPrice());
            finishedOrder.setRestaurant(order.getRestaurant());
            finishedOrder.setMember(order.getMember());
            UpdateDataMessage updateDataMessage=finishedOrderDao.save(finishedOrder);
            if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
                UpdateDataMessage updateDataMessage1=orderDao.delete(order);
                if(updateDataMessage1.equals(UpdateDataMessage.UPDATE_SUCCESS)){
                    return ModifyMessage.MODIFY_SUCCESS;
                }else{
                    return ModifyMessage.MODIFY_FAIL;
                }
            }else{
                finishedOrderDao.delete(finishedOrder);
                return ModifyMessage.MODIFY_FAIL;
            }
        }
    }
}
