package com.yummy.service.impl;

import com.yummy.dao.MemberDao;
import com.yummy.dao.OrderDao;
import com.yummy.dao.ProductDao;
import com.yummy.dao.RestaurantDao;
import com.yummy.entity.*;
import com.yummy.module.DiscountModule;
import com.yummy.module.ProductModule;
import com.yummy.module.responsemodule.memberResponse.MemberFinishedOrderModule;
import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import com.yummy.module.responsemodule.memberResponse.RestaurantNameModule;
import com.yummy.service.memberservice.MemberOrderService;
import com.yummy.util.MyOwnDate;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.MemberOrderMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberOrderServiceImpl implements MemberOrderService {

    private final MemberDao memberDao;
    private final RestaurantDao restaurantDao;
    private final OrderDao orderDao;
    private final MyOwnDate myOwnDate;
    private final ProductDao productDao;
    @Autowired
    public MemberOrderServiceImpl(MemberDao memberDao, RestaurantDao restaurantDao, OrderDao orderDao, MyOwnDate myOwnDate, ProductDao productDao) {
        this.memberDao = memberDao;
        this.restaurantDao=restaurantDao;
        this.orderDao = orderDao;
        this.myOwnDate = myOwnDate;
        this.productDao = productDao;
    }


    private void unpaidOrderTimer(Order order){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if(!order.isPaied()){
                    orderDao.delete(order);
                }
            }
        },120000);
    }

    @Override
    public synchronized MemberOrderMessage createOrder(MemberOrderModule memberOrderModule, List<LinkedHashMap<String,Integer>> productAndNumModules) {
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
        unpaidOrderTimer(order);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            // TODO 此处需要考虑并发问题，先这么写之后一定要修改！
            for(LinkedHashMap<String,Integer> productAndNumModule:productAndNumModules){
                Product product=productDao.get(productAndNumModule.get("pId"));
                product.setLeftNum(product.getLeftNum()-productAndNumModule.get("num"));
                productDao.update(product);
            }
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
        UpdateDataMessage updateDataMessage=orderDao.update(order);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return MemberOrderMessage.ORDER_SUCCESS;
        }else{
            return MemberOrderMessage.ORDER_FAIL;
        }
    }

    @Override
    public MemberOrderMessage cancelOrder(int orderId) {
        Order order=orderDao.get(orderId);
        if(order==null){
            return MemberOrderMessage.NO_PRODUCT;
        }else{
            UpdateDataMessage updateDataMessage=orderDao.delete(order);
            return updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)?MemberOrderMessage.ORDER_SUCCESS
                    :MemberOrderMessage.ORDER_FAIL;
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
            if(!order.isPaied()&& myOwnDate.compareTo(order.getTime(), myOwnDate.getDate())<=0){
                orderModules.add(new MemberOrderModule(
                        order.getId(),
                        mid,
                        order.getTime(),
                        order.getRestaurant().getName(),
                        order.isPaied()+"",
                        order.getTotalPrice()
                ));
            }else if(order.isPaied()){
                orderModules.add(new MemberOrderModule(
                        order.getId(),
                        mid,
                        order.getTime(),
                        order.getRestaurant().getName(),
                        order.isPaied()+"",
                        order.getTotalPrice()
                ));
            }
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
            if(product.getLeftNum()>0&&
                myOwnDate.compareTo(myOwnDate.getDate(),product.getLimitTime())==-1) {
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
        }
        return productModules;
    }

    @Override
    public DiscountModule getRestaurantDiscount(String restaurantName, String restaurantAddress) {
        Restaurant restaurant=restaurantDao.getRestaurantByNameAndAddress(restaurantName,restaurantAddress);
        if(restaurant==null){
            return null;
        }else{
            Discount discount=restaurant.getDiscount();
            return new DiscountModule(discount.getLimitTime(),discount.getDiscount());
        }
    }

    @Override
    public MemberOrderModule getMemberOrder(int orderId) {
        Order order=orderDao.get(orderId);
        if(order==null){
            return null;
        }else{
            return new MemberOrderModule(
                    order.getId(),
                    order.getMember().getId(),
                    order.getTime(),
                    order.getRestaurant().getName(),
                    order.isPaied()?"true":"false",
                    order.getTotalPrice()
            );
        }
    }
}
