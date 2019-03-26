package com.yummy.service.impl;

import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Restaurant;
import com.yummy.module.RestaurantModule;
import com.yummy.service.RestaurantService.RestaurantInfoService;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

    private final RestaurantDao restaurantDao;

    @Autowired
    public RestaurantInfoServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public ModifyMessage modifyRestaurantMessage(RestaurantModule restaurantModule) {
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(restaurantModule.getIdCode());
        restaurant.setType(restaurantModule.getType());
        restaurant.setName(restaurantModule.getName());
        restaurant.setAddress(restaurantModule.getAddress());
        UpdateDataMessage updateDataMessage=restaurantDao.update(restaurant);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ModifyMessage.MODIFY_SUCCESS;
        }else{
            return ModifyMessage.MODIFY_FAIL;
        }
    }
}
