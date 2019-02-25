package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.entity.FinishedOrder;
import com.yummy.entity.Order;
import com.yummy.entity.Product;

import java.util.List;

public interface MemberOrderService {

    // TODO 添加新增订单的方法

    /**
     * 根据会员id得到所有未完成的订单
     * @param mid 会员id
     * @return 订单列表
     * 无订单则返回空列表
     */
    List<Order> getRunningOrders(int mid);

    /**
     * 根据会员id得到所有已完成的订单
     * @param mid 会员id
     * @return 订单列表
     * 无订单则返回空列表
     */
    List<FinishedOrder> getFinishedOrders(int mid);

}
