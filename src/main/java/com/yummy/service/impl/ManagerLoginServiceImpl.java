package com.yummy.service.impl;

import com.yummy.dao.ManagerDao;
import com.yummy.entity.Manager;
import com.yummy.service.ManagerService.ManagerLoginService;
import com.yummy.util.message.servicemessage.LoginMessage;
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
    public LoginMessage login(String name, String password) {
        Manager manager=managerDao.getManagerByName(name);
        if(manager==null){
            return LoginMessage.NO_USER;
        }else{
            if(manager.getPassword().equals(password)){
                return LoginMessage.SUCCESS;
            }else{
                return LoginMessage.WRONG_PASSWD;
            }
        }
    }

    @Override
    public void setManager(String name, String password) {
        Manager manager=new Manager();
        manager.setName(name);
        manager.setPassword(password);
        managerDao.save(manager);
    }
}
