package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.entity.Manager;
import com.yummy.util.message.datamessage.UpdateDataMessage;

public interface ManagerDao {
    int insertManager(Manager manager);
    UpdateDataMessage updateManager(Manager manager);
    UpdateDataMessage deleteManager(Manager manager);

    Manager getManagerByName(String name);

}
