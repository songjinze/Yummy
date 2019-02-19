package com.yummy.controller;

import com.yummy.service.MemberService.MemberInfoService;
import com.yummy.service.MemberService.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value="/{user}", method= RequestMethod.GET)
    public String getLoginPage(@PathVariable Long user, ModelMap modelMap){
        modelMap.addAttribute("username",user);
        return "user";
    }

}
