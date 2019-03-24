package com.yummy.dao;

import com.yummy.entity.Manager;

public interface ManagerDao extends Dao<Manager>{
    Manager getManagerByName(String managerName);
}
