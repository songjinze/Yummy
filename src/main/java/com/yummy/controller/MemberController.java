package com.yummy.controller;

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

    @RequestMapping(value="/{user}", method= RequestMethod.GET)
    public String getLoginPage(@PathVariable Long user, ModelMap modelMap){
        modelMap.addAttribute("username",user);
        return "user";
    }

}
