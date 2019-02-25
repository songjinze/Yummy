package com.yummy.service.MemberService;
/*
 * author: SJZ
 * date: 2019/2/24
 */

import com.yummy.dao.FinishedOrderDao;
import com.yummy.dao.OrderDao;
import com.yummy.entity.FinishedOrder;
import com.yummy.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Order> getRunningOrders(int mid) {
        return orderDao.getOrdersByMid(mid);
    }

    @Override
    public List<FinishedOrder> getFinishedOrders(int mid) {
        return finishedOrderDao.getFinishedOrderByMid(mid);
    }
}
