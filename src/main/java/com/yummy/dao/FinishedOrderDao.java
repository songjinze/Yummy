package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.entity.FinishedOrder;
import com.yummy.util.message.datamessage.UpdateDataMessage;

import java.util.List;

public interface FinishedOrderDao {

    int insertFinishedOrder(FinishedOrder finishedOrder);
    UpdateDataMessage deleteFInishedOrder(FinishedOrder finishedOrder);
    List<FinishedOrder> getFinishedOrderByRid(int rid);
    List<FinishedOrder> getFinishedOrderByMid(int mid);
}
