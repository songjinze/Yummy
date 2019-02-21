package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.entity.Pay;
import com.yummy.util.message.UpdateDataMessage;

public interface PayDao {
    int insertPay(PayDao payDao);
    UpdateDataMessage updatePay(PayDao payDao);
    UpdateDataMessage deletePay(PayDao payDao);

    Pay getPayByName(String name);
}
