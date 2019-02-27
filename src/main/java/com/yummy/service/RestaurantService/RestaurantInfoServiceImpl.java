package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/2/25
 */

import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Address;
import com.yummy.entity.Restaurant;
import com.yummy.module.RestaurantModule;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.ModifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService{

    private final
    RestaurantDao restaurantDao;

    @Autowired
    public RestaurantInfoServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public ModifyMessage modifyRestaurantMessage(RestaurantModule restaurantModule) {
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(restaurantModule.getIdCode());
        Address address=new Address();
        address.setAddress(restaurantModule.getAddress());
        restaurant.setAddress(address);
        restaurant.setType(restaurantModule.getType());
        restaurant.setName(restaurantModule.getName());
        UpdateDataMessage updateDataMessage=restaurantDao.updateRestaurant(restaurant);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return ModifyMessage.MODIFY_SUCCESS;
        }else{
            return ModifyMessage.MODIFY_FAIL;
        }
    }
}
