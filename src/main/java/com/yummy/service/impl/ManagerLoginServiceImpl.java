package com.yummy.service.impl;

import com.yummy.dao.impl.DaoImpl;
import com.yummy.entity.Manager;
import com.yummy.service.ManagerService.ManagerLoginService;
import com.yummy.util.message.servicemessage.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerLoginServiceImpl implements ManagerLoginService {

    private DaoImpl<Manager> managerDao;

    @Autowired
    public ManagerLoginServiceImpl(DaoImpl<Manager> managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public LoginMessage login(String name, String password) {
        
        return null;
    }

    @Override
    public int getManagerIdByName(String name) {
        return 0;
    }
}
