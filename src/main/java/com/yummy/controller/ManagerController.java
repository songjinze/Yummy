package com.yummy.controller;
/*
 * author: SJZ
 * date: 2019/3/18
 */

import com.yummy.entity.SignUpToCheck;
import com.yummy.module.SignUpToCheckModule;
import com.yummy.module.responsemodule.Response;
import com.yummy.service.ManagerService.ManagerCheckService;
import com.yummy.service.ManagerService.ManagerLoginService;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager/")
public class ManagerController {

    private final ManagerLoginService managerLoginService;
    private final ManagerCheckService managerCheckService;

    @Autowired
    public ManagerController(ManagerLoginService managerLoginService, ManagerCheckService managerCheckService) {
        this.managerLoginService = managerLoginService;
        this.managerCheckService = managerCheckService;
    }

    @PostMapping("login")
    @ResponseBody
    public Response managerLogin(@RequestBody Map map){
        String uname= (String) map.get("username");
        String password= (String) map.get("password");
        LoginMessage loginMessage=managerLoginService.login(uname,password);
        Response response=new Response();
        if(loginMessage.equals(LoginMessage.SUCCESS)){
            response.setResult("success");
        }else if(loginMessage.equals(LoginMessage.NO_USER)){
            response.setResult("no-user");
        }else{
            response.setResult("password");
        }
        return response;
    }

    @PostMapping("getSignUpToCheckList")
    @ResponseBody
    public List<SignUpToCheckModule> signUpToCheckModules(@RequestBody Map map){
        return managerCheckService.getSignUpToCheckList();
    }

    @PostMapping("acceptSignUp")
    @ResponseBody
    public Response acceptSignUp(@RequestBody Map map){
        int id=(int)map.get("id");
        String address=(String)map.get("address");
        String name=(String)map.get("name");
        String type=(String)map.get("type");
        String email=(String)map.get("email");
        SignUpToCheckModule signUpToCheckModule=new SignUpToCheckModule(
                id,email,address,name,type
        );
        ModifyMessage modifyMessage=managerCheckService.checkSignUp(signUpToCheckModule);
        Response response=new Response();
        if(modifyMessage.equals(ModifyMessage.MODIFY_SUCCESS)){
            response.setResult("success");
        }else{
            response.setResult("fail");
        }
        return response;
    }
}
