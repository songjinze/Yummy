package com.yummy.dao;

import com.yummy.entity.Pay;
import com.yummy.util.message.datamessage.UpdateDataMessage;

public interface PayDao extends Dao<Pay> {
    Pay getPayAccountByNameAndPassword(String name,String password);
}
