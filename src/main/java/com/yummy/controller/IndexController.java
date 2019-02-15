package com.yummy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * author: 73460
 * date: 2019/2/15
 */
@Controller
public class IndexController {
    /**
     *
     * @return 起始index界面
     */
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}