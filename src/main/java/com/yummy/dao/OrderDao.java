package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.entity.Order;
import com.yummy.util.message.UpdateDataMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderDao {
    int insertOrder(Order order);
    UpdateDataMessage updateOrder(Order order);
    UpdateDataMessage deleteOrder(Order order);

    List<Order> getOrdersByMid(int mid);
    List<Order> getOrdersByRid(int rid);

}
