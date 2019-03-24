package com.yummy.controller;

import com.yummy.module.MemberModule;
import com.yummy.module.ProductModule;
import com.yummy.module.requestmodule.MemberInfoModule;
import com.yummy.module.requestmodule.MemberLoginModule;
import com.yummy.module.requestmodule.MemberRestaurantListModule;
import com.yummy.module.responsemodule.*;
import com.yummy.module.responsemodule.memberResponse.*;
import com.yummy.service.MemberService.MemberInfoService;
import com.yummy.service.MemberService.MemberLoginService;
import com.yummy.service.MemberService.MemberOrderService;
import com.yummy.util.MemberCheckCodeContainer;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
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
    private final MemberCheckCodeContainer memberCheckCodeContainer;

    @Autowired
    public MemberController(MemberCheckCodeContainer memberCheckCodeContainer,MemberLoginService memberLoginService, MemberInfoService memberInfoService,MemberOrderService memberOrderService) {
        this.memberLoginService = memberLoginService;
        this.memberInfoService = memberInfoService;
        this.memberOrderService=memberOrderService;
        this.memberCheckCodeContainer=memberCheckCodeContainer;
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
     * @param map userVid
     * @return
     */
    @PostMapping("/member-getRunningOrder")
    @ResponseBody
    public List<MemberOrderModule> getRunningOrder(@RequestBody Map map){
        return memberOrderService.getRunningOrders(Integer.parseInt((String) map.get("userVId")));
    }

    /**
     * 获得已经结束的订单
     * @param map
     * @return
     */
    @PostMapping("/member-getFinishedOrder")
    @ResponseBody
    public List<MemberFinishedOrderModule> getFinishedOrder(@RequestBody Map map){
        return memberOrderService.getFinishedOrders(Integer.parseInt((String)map.get("userVId")));
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

    @PostMapping("/member-getCheckCode")
    public void getCheckCode(@RequestBody Map map){
        String memberEmail=(String)map.get("memberEmail");
        memberCheckCodeContainer.sendAndCreateCode(memberEmail);
    }

    @PostMapping("/member-signUp")
    @ResponseBody
    public MemberSignUpResultModule memberSignUp(@RequestBody Map map){
        String memberEmail=(String)map.get("memberEmail");
        String memberPassword=(String)map.get("memberPassword");
        String memberCheckCode=(String)map.get("checkCode");
        MemberSignUpResultModule memberSignUpResultModule =new MemberSignUpResultModule();
        if(!memberCheckCode.equals(memberCheckCodeContainer.getCodeByEmail(memberEmail))){
            memberSignUpResultModule.setResult("wrong-checkCode");
        }else{
            memberCheckCodeContainer.alreadySignUp(memberEmail);
        }
        SignupMessage signupMessage=memberLoginService.signUp(memberEmail,memberPassword);
        if(signupMessage.equals(SignupMessage.SIGNUP_SUCCESS)){
            memberSignUpResultModule.setResult("success");
        }else if(signupMessage.equals(SignupMessage.DUPLICATED_USER)){
            memberSignUpResultModule.setResult("duplicated-user");
        }else{
            memberSignUpResultModule.setResult("fail");
        }
        return memberSignUpResultModule;
    }


}