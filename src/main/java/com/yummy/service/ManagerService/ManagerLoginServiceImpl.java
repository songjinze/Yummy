package com.yummy.service.ManagerService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.dao.ManagerDao;
import com.yummy.entity.Manager;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
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
    public int getManagerIdByName(String name) {
        Manager manager=managerDao.getManagerByName(name);
        if(manager==null){
            return -1;
        }else{
            return manager.getId();
        }
    }
}
