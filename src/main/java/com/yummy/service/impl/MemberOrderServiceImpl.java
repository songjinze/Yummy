package com.yummy.service.impl;

import com.yummy.dao.MemberDao;
import com.yummy.dao.RestaurantDao;
import com.yummy.entity.*;
import com.yummy.module.ProductModule;
import com.yummy.module.responsemodule.memberResponse.MemberFinishedOrderModule;
import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import com.yummy.module.responsemodule.memberResponse.RestaurantNameModule;
import com.yummy.service.MemberService.MemberOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MemberOrderServiceImpl implements MemberOrderService {

    private final MemberDao memberDao;
    private final RestaurantDao restaurantDao;

    @Autowired
    public MemberOrderServiceImpl(MemberDao memberDao,RestaurantDao restaurantDao) {
        this.memberDao = memberDao;
        this.restaurantDao=restaurantDao;
    }

    @Override
    public List<MemberOrderModule> getRunningOrders(int mid) {
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
    public List<MemberFinishedOrderModule> getFinishedOrders(int mid) {
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
    public List<RestaurantNameModule> getRestaurantNames(String memberAddress) {
        // TODO 添加对地址的判断
        List<RestaurantNameModule> restaurantNameModules=new ArrayList<>();
        List<Restaurant> restaurants=restaurantDao.getAllRestaurant();
        for(Restaurant restaurant:restaurants){
            restaurantNameModules.add(new RestaurantNameModule(
                    restaurant.getName(),
                    restaurant.getRestaurantAddress().getAddress()
            ));
        }
        return restaurantNameModules;
    }

    @Override
    public List<ProductModule> getRestaurantProducts(String restaurantName, String restaurantAddress) {
        List<ProductModule> productModules=new ArrayList<>();
        Restaurant restaurant=restaurantDao.getRestaurantByNameAndAddress(restaurantName,restaurantAddress);
        Set<Product> products=restaurant.getProductSet();
        for(Product product:products){
            productModules.add(new ProductModule(
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
