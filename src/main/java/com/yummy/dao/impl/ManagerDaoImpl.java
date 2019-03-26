package com.yummy.dao.impl;

import com.yummy.dao.ManagerDao;
import com.yummy.entity.Manager;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerDaoImpl extends DaoImpl<Manager> implements ManagerDao {
    public ManagerDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Manager getManagerByName(String managerName) {
        List<Manager> managers=getByQuery("from Manager as m where m.name=\'"+managerName+"\'");
        if(managers.size()==0){
            return null;
        }else{
            return managers.get(0);
        }
    }
}
