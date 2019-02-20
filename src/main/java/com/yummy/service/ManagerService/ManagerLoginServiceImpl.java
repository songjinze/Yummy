package com.yummy.service.ManagerService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.dao.ManagerDao;
import com.yummy.pojo.Manager;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerLoginServiceImpl implements ManagerLoginService {

    private final ManagerDao managerDao;

    @Autowired
    public ManagerLoginServiceImpl(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public LoginMessage login(Manager manager) {

        return null;
    }

    @Override
    public SignupMessage signUp(Manager manager) {
        return null;
    }
}
