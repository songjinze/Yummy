package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/24
 */

import com.yummy.dao.FinishedOrderDao;
import com.yummy.dao.OrderDao;
import com.yummy.dao.RestaurantDao;
import com.yummy.entity.FinishedOrder;
import com.yummy.entity.Order;
import com.yummy.module.ProductModule;
import com.yummy.module.responsemodule.memberResponse.MemberFinishedOrderModule;
import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import com.yummy.module.responsemodule.memberResponse.RestaurantNameModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberOrderServiceImpl implements MemberOrderService {

    private final OrderDao orderDao;
    private final FinishedOrderDao finishedOrderDao;

    @Autowired
    public MemberOrderServiceImpl(OrderDao orderDao, FinishedOrderDao finishedOrderDao) {
        this.orderDao = orderDao;
        this.finishedOrderDao = finishedOrderDao;
    }

    @Override
    public List<MemberOrderModule> getRunningOrders(int mid) {
        List<Order> runningOrders=orderDao.getOrdersByMid(mid);
        List<MemberOrderModule> res=new ArrayList<>();
        for(Order order:runningOrders){
            MemberOrderModule memberOrderModule=new MemberOrderModule();
            memberOrderModule.setDate(order.getTime());
            memberOrderModule.setIsPaid(order.isPaied()+"");
            memberOrderModule.setRestaurantName(order.getRestaurant().getName());
            memberOrderModule.setTotalPrice(order.getTotalPrice());
            res.add(memberOrderModule);
        }
        return res;
    }

    @Override
    public List<MemberFinishedOrderModule> getFinishedOrders(int mid) {
        List<FinishedOrder> finishedOrders=finishedOrderDao.getFinishedOrderByMid(mid);
        List<MemberFinishedOrderModule> res=new ArrayList<>();
        for(FinishedOrder finishedOrder:finishedOrders){
            MemberFinishedOrderModule memberFinishedOrderModule=new MemberFinishedOrderModule();
            memberFinishedOrderModule.setDate(finishedOrder.getFiniedTime());
            memberFinishedOrderModule.setRestaurantName(finishedOrder.getRestaurant().getName());
            memberFinishedOrderModule.setTotalPrice(finishedOrder.getTotalPrice()+"");
            res.add(memberFinishedOrderModule);
        }
        return res;
    }

    @Override
    public List<RestaurantNameModule> getRestaurantNames(String memberAddress) {
        // TODO
        return null;
    }

    @Override
    public List<ProductModule> getRestaurantProducts(String restaurantName, String restaurantAddress) {
        // TODO
        return null;
    }
}
