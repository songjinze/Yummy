package com.yummy.service.ManagerService;

import com.yummy.module.SignUpToCheckModule;
import com.yummy.util.message.servicemessage.ModifyMessage;

import java.util.List;

public interface ManagerCheckService {

    List<SignUpToCheckModule> getSignUpToCheckList();

    /**
     * 审批餐厅注册并发邮件通知登录码
     * @return
     */
    ModifyMessage checkSignUp(SignUpToCheckModule signUpToCheckModule);
}
