package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/21
 */

import com.yummy.entity.Discount;
import com.yummy.util.message.UpdateDataMessage;

import java.util.List;

public interface DiscountDao {
    int insertDiscount(Discount discount);
    UpdateDataMessage deleteDiscount(Discount dIscount);
    UpdateDataMessage updateDiscount(Discount discount);
    List<Discount> getDiscountByRid(int rid);
}
