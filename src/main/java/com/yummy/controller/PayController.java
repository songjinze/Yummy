package com.yummy.controller;

import com.yummy.module.responsemodule.Response;
import com.yummy.service.payservice.PayService;
import com.yummy.util.message.servicemessage.PayMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@RequestMapping("/pay")
@Controller
public class PayController {

    private final PayService payService;

    @Autowired
    public PayController(PayService payService) {
        this.payService = payService;
    }


    @PostMapping("/getMemberBalance")
    @ResponseBody
    public double getMemberBalance(@RequestBody Map map){
        String name=(String)map.get("name");
        return payService.getBalance(name);
    }

    @PostMapping("/payAndCancelBalance")
    @ResponseBody
    public Response payAndCancelBalance(@RequestBody Map map){
        String name=(String)map.get("name");
        String password=(String)map.get("password");
        double balance=(double) map.get("balance");
        PayMessage payMessage=payService.pay(name,password,balance);
        Response response=new Response();
        if(payMessage.equals(PayMessage.PAY_SUCCESS)){
            response.setResult("success");
        }else if(payMessage.equals(PayMessage.LESS_BALANCE)){
            response.setResult("lessBalance");
        }else{
            response.setResult("fail");
        }
        return response;
    }
}
