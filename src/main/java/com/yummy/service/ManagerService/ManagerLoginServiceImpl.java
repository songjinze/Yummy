package com.yummy.service.ManagerService;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.dao.ManagerDao;
import com.yummy.entity.Manager;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;
import com.yummy.util.message.UpdateDataMessage;
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
        Manager manager1=managerDao.getManagerByName(manager.getName());
        if(manager1==null){
            return LoginMessage.NO_USER;
        }
        if(manager1.getPassword().equals(manager.getPassword())){
            return LoginMessage.SUCCESS;
        }else{
            return LoginMessage.WRONG_PASSWD;
        }
    }

    @Override
    public SignupMessage signUp(Manager manager) {
        Manager manager1=managerDao.getManagerByName(manager.getName());
        if(manager1!=null){
            return SignupMessage.DUPLICATED_USER;
        }
        if(managerDao.insertManager(manager)!=-1){
            return SignupMessage.SINGUP_SUCCESS;
        }else{
            return SignupMessage.SINGUP_FAIL;
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
