package com.yummy.service.impl;

import com.yummy.dao.MemberDao;
import com.yummy.dao.OrderDao;
import com.yummy.dao.RestaurantDao;
import com.yummy.entity.*;
import com.yummy.module.ProductModule;
import com.yummy.module.responsemodule.memberResponse.MemberFinishedOrderModule;
import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import com.yummy.module.responsemodule.memberResponse.RestaurantNameModule;
import com.yummy.service.MemberService.MemberOrderService;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.MemberOrderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MemberOrderServiceImpl implements MemberOrderService {

    private final MemberDao memberDao;
    private final RestaurantDao restaurantDao;
    private final OrderDao orderDao;

    @Autowired
    public MemberOrderServiceImpl(MemberDao memberDao, RestaurantDao restaurantDao, OrderDao orderDao) {
        this.memberDao = memberDao;
        this.restaurantDao=restaurantDao;
        this.orderDao = orderDao;
    }


    @Override
    public synchronized MemberOrderMessage createOrder(MemberOrderModule memberOrderModule) {
        Order order=new Order();
        Member member=memberDao.get(memberOrderModule.getMid());
        order.setMember(member);
        order.setTime(memberOrderModule.getDate());
        Restaurant restaurant=restaurantDao.getRestaurantByNameAndAddress(memberOrderModule.getRestaurantName(),memberOrderModule.getRestaurantAddress());
        order.setRestaurant(restaurant);
        order.setAddress(memberOrderModule.getMemberAddress());
        order.setPaied(false);
        order.setTotalPrice(memberOrderModule.getTotalPrice());
        UpdateDataMessage updateDataMessage=orderDao.save(order);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return MemberOrderMessage.ORDER_SUCCESS;
        }else{
            return MemberOrderMessage.ORDER_FAIL;
        }
    }

    @Override
    public synchronized MemberOrderMessage payOrder(MemberOrderModule memberOrderModule) {
        Order order=orderDao.get(memberOrderModule.getOid());
        if(order==null){
            return MemberOrderMessage.ORDER_FAIL;
        }
        order.setPaied(true);
        UpdateDataMessage updateDataMessage=orderDao.save(order);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return MemberOrderMessage.ORDER_SUCCESS;
        }else{
            return MemberOrderMessage.ORDER_FAIL;
        }
    }

    @Override
    public synchronized List<MemberOrderModule> getUnpaidOrders(int mid) {
        Member member=memberDao.get(mid);
        if(member==null){
            return new ArrayList<>();
        }
        Set<Order> orders=member.getOrders();
        List<MemberOrderModule> orderModules=new ArrayList<>();
        for(Order order:orders){
            if(!order.isPaied()){
                orderModules.add(new MemberOrderModule(
                        order.getId(),
                        mid,
                        order.getTime(),
                        order.getRestaurant().getName(),
                        "false",
                        order.getTotalPrice()
                ));
            }
        }
        return orderModules;
    }

    @Override
    public synchronized List<MemberOrderModule> getRunningOrders(int mid) {
        Member member=memberDao.get(mid);
        List<MemberOrderModule> orderModules=new ArrayList<>();
        Set<Order> orders=member.getOrders();
        for(Order order:orders){
            orderModules.add(new MemberOrderModule(
                    order.getTime(),
                    order.getRestaurant().getName(),
                    order.isPaied()+"",
                    order.getTotalPrice()
            ));
        }
        return orderModules;
    }

    @Override
    public synchronized List<MemberFinishedOrderModule> getFinishedOrders(int mid) {
        List<MemberFinishedOrderModule> memberFinishedOrderModules=new ArrayList<>();
        Set<FinishedOrder> finishedOrders=memberDao.get(mid).getFinishedOrders();
        for(FinishedOrder finishedOrder:finishedOrders){
            memberFinishedOrderModules.add(new MemberFinishedOrderModule(
                    finishedOrder.getRestaurant().getName(),
                    finishedOrder.getFinishedTime(),
                    finishedOrder.getTotalPrice()+""
            ));
        }
        return memberFinishedOrderModules;
    }

    @Override
    public synchronized List<RestaurantNameModule> getRestaurantNames(String memberAddress) {
        List<RestaurantNameModule> restaurantNameModules=new ArrayList<>();
        List<Restaurant> restaurants=restaurantDao.getAllRestaurant();
        for(Restaurant restaurant:restaurants){
            restaurantNameModules.add(new RestaurantNameModule(
                    restaurant.getName(),
                    restaurant.getAddress()
            ));
        }
        return restaurantNameModules;
    }

    @Override
    public synchronized List<ProductModule> getRestaurantProducts(String restaurantName, String restaurantAddress) {
        List<ProductModule> productModules=new ArrayList<>();
        Restaurant restaurant=restaurantDao.getRestaurantByNameAndAddress(restaurantName,restaurantAddress);
        Set<Product> products=restaurant.getProductSet();
        for(Product product:products){
            productModules.add(new ProductModule(
                    product.getId(),
                    product.getName(),
                    product.getLimitTime(),
                    product.getPrice(),
                    product.getLeftNum(),
                    product.getDescrip(),
                    null
            ));
        }
        return productModules;
    }
}
