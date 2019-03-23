package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.entity.FinishedOrder;
import com.yummy.entity.Order;
import com.yummy.entity.Product;
import com.yummy.module.ProductModule;
import com.yummy.module.responsemodule.memberResponse.MemberFinishedOrderModule;
import com.yummy.module.responsemodule.memberResponse.MemberOrderModule;
import com.yummy.module.responsemodule.memberResponse.RestaurantNameModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberOrderService {

    // TODO 添加新增订单的方法

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

}
