package com.yummy.service.impl;

import com.yummy.dao.PayDao;
import com.yummy.entity.Pay;
import com.yummy.service.payservice.PayService;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.PayMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    private PayDao payDao;

    @Autowired
    public PayServiceImpl(PayDao payDao) {
        this.payDao=payDao;
    }

    @Override
    public PayMessage pay(String name, String password, double balance) {
        Pay pay=payDao.getPayAccountByNameAndPassword(name,password);
        if(pay.getAccountBalance()<balance){
            return PayMessage.LESS_BALANCE;
        }else{
            pay.setAccountBalance(pay.getAccountBalance()-balance);
            UpdateDataMessage updateDataMessage=payDao.update(pay);
            if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
                return PayMessage.PAY_SUCCESS;
            }else{
                return PayMessage.PAY_FAIL;
            }
        }
    }

    @Override
    public double getBalance(String name) {
        List<Pay> payList=this.payDao.getByQuery("from Pay where name=\'"+name+'\'');
        if(payList.size()!=0){
            return payList.get(0).getAccountBalance();
        }else{
            return 0;
        }
    }
}
