package com.yummy.controller;

import com.yummy.module.MemberModule;
import com.yummy.module.ProductModule;
import com.yummy.module.RestaurantModule;
import com.yummy.module.requestmodule.MemberInfoModule;
import com.yummy.module.requestmodule.MemberLoginModule;
import com.yummy.module.requestmodule.MemberRestaurantListModule;
import com.yummy.module.responsemodule.*;
import com.yummy.module.responsemodule.memberResponse.*;
import com.yummy.service.MemberService.MemberInfoService;
import com.yummy.service.MemberService.MemberLoginService;
import com.yummy.service.MemberService.MemberOrderService;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*
 * author: 73460
 * date: 2019/2/15
 */
@Controller
public class MemberController {

    private final MemberLoginService memberLoginService;
    private final MemberInfoService memberInfoService;
    private final MemberOrderService memberOrderService;

    @Autowired
    public MemberController(MemberLoginService memberLoginService, MemberInfoService memberInfoService,MemberOrderService memberOrderService) {
        this.memberLoginService = memberLoginService;
        this.memberInfoService = memberInfoService;
        this.memberOrderService=memberOrderService;
    }

    /**
     * 登录
     *
     * @param memberLoginModule username password
     * @return Response result { success wrong-password no-user}
     */
    @PostMapping("/member-login")
    @ResponseBody
    public MemberLoginResultModule login(@RequestBody MemberLoginModule memberLoginModule){
        String username=memberLoginModule.getUsername();
        String password=memberLoginModule.getPassword();
        LoginMessage loginMessage=memberLoginService.login(username,password);
        MemberLoginResultModule memberLoginResultModule=new MemberLoginResultModule();
        int userId=memberInfoService.getMemberInfo(username).getId();
        memberLoginResultModule.setUserId(userId);
        if(loginMessage.equals(LoginMessage.SUCCESS)){
            memberLoginResultModule.setResult("success");
        }else if(loginMessage.equals(LoginMessage.NO_USER)){
            memberLoginResultModule.setResult("no-user");
        }else{
            memberLoginResultModule.setResult("wrong-password");
        }
        return memberLoginResultModule;
    }

    /**
     * 得到餐厅列表
     * @param memberRestaurantListModule memberEmail,memberAddress
     * @return RestaurantNameModule list
     */
    @PostMapping("/member-getRestaurantList")
    @ResponseBody
    public List<RestaurantNameModule> getRestaurantList(@RequestBody MemberRestaurantListModule memberRestaurantListModule){
        String memberAddress=memberRestaurantListModule.getMemberAddress();
        return memberOrderService.getRestaurantNames(memberAddress);
    }

    @PostMapping("/member-getRestaurantInfo")
    @ResponseBody
    public RestaurantDescriptionModule getRestaurantDescription(@RequestBody Map map ){
        // TODO 连接后端
        RestaurantDescriptionModule restaurantDescriptionModule=new RestaurantDescriptionModule();
        restaurantDescriptionModule.setRestaurantDescription("this is a restaurant");
        restaurantDescriptionModule.setRestaurantName((String)map.get("restaurantName"));
        return restaurantDescriptionModule;
    }

    /**
     * 修改用户信息
     * @param memberInfoModule email username password phone
     * @return response result:{success,fail}
     */
    @PostMapping("/member-saveUserInfo")
    @ResponseBody
    public Response saveUserInfo(@RequestBody MemberInfoModule memberInfoModule){
        String email=memberInfoModule.getEmail();
        String username=memberInfoModule.getUsername();
        String password=memberInfoModule.getPassword();
        String phone=memberInfoModule.getPhone();
        MemberModule memberModule=new MemberModule();
        memberModule.setEmail(email);
        memberModule.setName(username);
        memberModule.setPassword(password);
        memberModule.setPhone(phone);
        ModifyMessage modifyMessage=memberInfoService.modifyMemberInfo(memberModule);
        Response response=new Response();
        if(modifyMessage.equals(ModifyMessage.MODIFY_SUCCESS)){
            response.setResult("success");
        }else{
            response.setResult("fail");
        }
        return response;
    }

    /**
     * 获得正在进行的订单
     * @param map
     * @return
     */
    @PostMapping("/member-getRunningOrder")
    @ResponseBody
    public List<MemberOrderModule> getRunningOrder(@RequestBody Map map){
        //memberOrderService.getRunningOrders(map.get("memberEmail"));
        // TODO 连接后端
        List<MemberOrderModule> res=new ArrayList<>();
        for(int i=0;i<5;i++){
            MemberOrderModule memberOrderModule=new MemberOrderModule();
            memberOrderModule.setRestaurantName("汉堡王");
            memberOrderModule.setDate(new Date().toString());
            memberOrderModule.setIsPaid("true");
            memberOrderModule.setTotalPrice(100.01);
            res.add(memberOrderModule);
        }
        return res;
    }

    /**
     * 获得已经结束的订单
     * @param map
     * @return
     */
    @PostMapping("/member-getFinishedOrder")
    @ResponseBody
    public List<MemberFinishedOrderModule> getFinishedOrder(@RequestBody Map map){
        //memberOrderService.getFinishedOrders();
        // TODO 连接后端

        List<MemberFinishedOrderModule> res=new ArrayList<>();
        for(int i=0;i<5;i++){
            MemberFinishedOrderModule memberFinishedOrderModule=new MemberFinishedOrderModule();
            memberFinishedOrderModule.setRestaurantName("BurgerKing");
            memberFinishedOrderModule.setDate(new Date().toString());
            memberFinishedOrderModule.setTotalPrice("100.01");
            res.add(memberFinishedOrderModule);
        }
        return res;
    }

    @PostMapping("/member-getRestaurantProducts")
    @ResponseBody
    public List<RestaurantProducts> getRestaurantProducts(@RequestBody Map map){
        List<ProductModule> productModules=memberOrderService.getRestaurantProducts((String) map.get("restaurantName"),(String)map.get("restaurantAddress"));
        List<RestaurantProducts> res=new ArrayList<>();
        for(ProductModule productModule:productModules){
            RestaurantProducts restaurantProducts=new RestaurantProducts();
            restaurantProducts.setDate(productModule.getLimitTime());
            restaurantProducts.setLeftNum(productModule.getLeftNum()+"");
            restaurantProducts.setProductDescription(productModule.getDescrip());
            restaurantProducts.setProductName(productModule.getName());
            res.add(restaurantProducts);
        }
        return res;
    }



}
