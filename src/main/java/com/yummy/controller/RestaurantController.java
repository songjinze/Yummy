package com.yummy.controller;
/*
 * author: SJZ
 * date: 2019/3/18
 */

import com.yummy.entity.Restaurant;
import com.yummy.module.responsemodule.restaurantResponse.RestaurantLoginResponseModule;
import com.yummy.service.RestaurantService.RestaurantLoginService;
import com.yummy.util.message.servicemessage.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class RestaurantController {

    private final RestaurantLoginService restaurantLoginService;

    @Autowired
    public RestaurantController(RestaurantLoginService restaurantLoginService) {
        this.restaurantLoginService = restaurantLoginService;
    }

    @PostMapping("/restaurant-login")
    @ResponseBody
    public RestaurantLoginResponseModule restaurantLogin(@RequestBody Map map){
        String restaurantIdCode=(String) map.get("restaurantId");
        RestaurantLoginResponseModule restaurantLoginResponseModule=new RestaurantLoginResponseModule();
        LoginMessage loginMessage=restaurantLoginService.login(restaurantIdCode);
        if(loginMessage.equals(LoginMessage.SUCCESS)){
            restaurantLoginResponseModule.setResult("success");
        }else{
            restaurantLoginResponseModule.setResult("no-user");
        }
        return restaurantLoginResponseModule;
    }
}
