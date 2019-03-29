package com.yummy.service.payservice;

import com.yummy.util.message.servicemessage.PayMessage;

public interface PayService {
    PayMessage pay(String name,String password,double balance);

    double getBalance(String name);
}
