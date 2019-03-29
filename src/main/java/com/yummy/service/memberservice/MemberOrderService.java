package com.yummy.service.memberservice;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.module.DiscountModule;
import com.yummy.module.ProductModule;
import com.yummy.module.responsemodule.memberResponse.MemberFinishedOrderModule;
import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import com.yummy.module.responsemodule.memberResponse.RestaurantNameModule;
import com.yummy.util.message.servicemessage.MemberOrderMessage;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public interface MemberOrderService {

    /**
     * 创建订单(未支付)
     * @param memberOrderModule
     * @return
     */
    MemberOrderMessage createOrder(MemberOrderModule memberOrderModule, List<LinkedHashMap<String,Integer>> productAndNumModules);

    /**
     * 对一个订单付款完成(改变订单状态为已支付),需填写订单id
     * @param memberOrderModule
     * @return
     */
    MemberOrderMessage payOrder(MemberOrderModule memberOrderModule);

    /**
     * 取消订单
     * @param orderId 订单编号
     * @return 取消成功、失败
     */
    MemberOrderMessage cancelOrder(int orderId);


    /**
     * 获得未付款的订单（只获得在时限之内的）
     * @param mid
     * @return
     */
    List<MemberOrderModule> getUnpaidOrders(int mid);

    /**
     * 根据会员id得到所有未完成的订单
     * @param mid 会员id
     * @return 订单列表
     * 无订单则返回空列表
     */
    List<MemberOrderModule> getRunningOrders(int mid);

    /**
     * 根据会员id得到所有已完成的订单
     * @param mid 会员id
     * @return 订单列表
     * 无订单则返回空列表
     */
    List<MemberFinishedOrderModule> getFinishedOrders(int mid);

    /**
     * 根据会员地址获得餐厅名列表
     * @param memberAddress 会员地址
     * @return 餐厅列表
     * 无餐厅则返回
     */
    List<RestaurantNameModule> getRestaurantNames(String memberAddress);

    /**
     * 根据餐厅名和餐厅地址得到餐厅所有商品
     * @param restaurantName 餐厅名
     * @param restaurantAddress 餐厅地址
     * @return 餐厅product的列表
     */
    List<ProductModule> getRestaurantProducts(String restaurantName,String restaurantAddress);

    /**
     * 根据餐厅名和餐厅地址得到餐厅的折扣
     * @param restaurantName 餐厅名
     * @param restaurantAddress 餐厅地址
     * @return 餐厅折扣
     */
    DiscountModule getRestaurantDiscount(String restaurantName,String restaurantAddress);

    /**
     * 根据订单编号得到订单信息
     * @param orderId 订单编号
     * @return 订单
     */
    MemberOrderModule getMemberOrder(int orderId);
}
