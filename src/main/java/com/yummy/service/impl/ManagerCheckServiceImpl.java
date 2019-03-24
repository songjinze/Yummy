package com.yummy.service.impl;

import com.yummy.module.SignUpToCheckModule;
import com.yummy.service.ManagerService.ManagerCheckService;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerCheckServiceImpl implements ManagerCheckService {
    @Override
    public List<SignUpToCheckModule> getSignUpToCheckList() {
        return null;
    }

    @Override
    public ModifyMessage checkSignUp(SignUpToCheckModule signUpToCheckModule) {
        return null;
    }
}
