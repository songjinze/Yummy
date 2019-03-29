package com.yummy.service.impl;

import com.yummy.dao.MemberDao;
import com.yummy.dao.OrderDao;
import com.yummy.dao.ProductDao;
import com.yummy.module.ManagerStatisticModule;
import com.yummy.service.managerservice.ManagerStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerStatisticServiceImpl implements ManagerStatisticService {

    private final MemberDao memberDao;
    private final OrderDao orderDao;
    private final ProductDao productDao;
    @Autowired
    public ManagerStatisticServiceImpl(MemberDao memberDao, OrderDao orderDao, ProductDao productDao) {
        this.memberDao = memberDao;
        this.orderDao = orderDao;
        this.productDao = productDao;
    }

    @Override
    public ManagerStatisticModule getManagerStatisticModule() {
        ManagerStatisticModule managerStatisticModule=new ManagerStatisticModule();
        managerStatisticModule.setUserNum(memberDao.getByQuery("from Member").size());
        managerStatisticModule.setOrderNum(orderDao.getByQuery("from Order").size()+orderDao.getByQuery("from FinishedOrder").size());
        managerStatisticModule.setProductNum(productDao.getByQuery("from Product").size());
        return managerStatisticModule;
    }
}
