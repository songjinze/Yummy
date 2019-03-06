package com.yummy.controller;

import com.yummy.module.requestmodule.MemberLoginModule;
import com.yummy.module.responsemodule.RestaurantNameModule;
import com.yummy.module.responsemodule.Response;
import com.yummy.service.MemberService.MemberInfoService;
import com.yummy.service.MemberService.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
 * author: 73460
 * date: 2019/2/15
 */
@Controller
public class MemberController {

    private final MemberLoginService memberLoginService;
    private final MemberInfoService memberInfoService;

    @Autowired
    public MemberController(MemberLoginService memberLoginService, MemberInfoService memberInfoService) {
        this.memberLoginService = memberLoginService;
        this.memberInfoService = memberInfoService;
    }

    @PostMapping("/member-login")
    @ResponseBody
    public Response login(@RequestBody MemberLoginModule memberLoginModule){
        String username=memberLoginModule.getUsername();
        String password=memberLoginModule.getPassword();
        // TODO 连接后端
        Response response=new Response();
        response.setResult("success");
        return response;
    }

    @PostMapping("/member-getRestaurantList")
    @ResponseBody
    public RestaurantNameModule getRestaurantList(@RequestParam("memberEmail")String memberEmail, @RequestParam("memberAddress")String memberAddress){
        return null;
    }

}
