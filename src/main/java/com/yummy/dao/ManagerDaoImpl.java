package com.yummy.dao;
/*
 * author: SJZ
 * date: 2019/2/18
 */

import com.yummy.module.ManagerBean;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerDaoImpl implements ManagerDao{
    @Override
    public ManagerBean getAllManager() {
        System.out.println("load success!");
        return null;
    }
}
