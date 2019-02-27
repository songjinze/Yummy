package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/2/24
 */

import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Address;
import com.yummy.entity.Restaurant;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantLoginServiceImpl implements RestaurantLoginService {

    private final RestaurantDao restaurantDao;
    @Autowired
    public RestaurantLoginServiceImpl(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @Override
    public LoginMessage login(String idCode) {
        Restaurant restaurant=restaurantDao.getRestaurantByIdCode(idCode);
        if(restaurant==null){
            return LoginMessage.NO_USER;
        }else{
            return LoginMessage.SUCCESS;
        }
    }

    @Override
    public SignupMessage signUp(String address, String type, String name) {
        Restaurant restaurant=new Restaurant();
        Address address1=new Address();
        address1.setAddress(address);
        restaurant.setAddress(address1);
        restaurant.setType(type);
        restaurant.setName(name);
        int id=restaurantDao.insertRestaurant(restaurant);
        String idCode=createIdCode(id);
        if(idCode==null){
            return SignupMessage.SIGNUP_FAIL;
        }
        restaurant.setIdCode(idCode);
        restaurant.setId(id);
        UpdateDataMessage updateDataMessage=restaurantDao.updateRestaurant(restaurant);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return SignupMessage.SIGNUP_SUCCESS;
        }else{
            return SignupMessage.SIGNUP_FAIL;
        }
    }
    private String createIdCode(int id){
        int length=7;
        int total=id,cur,next;
        StringBuilder stringBuilder=new StringBuilder();
        while(length!=0){
            cur= total %26;
            next= total /26;
            stringBuilder.append('a'+cur);
            length--;
            total=next;
        }
        if(total!=0){
            return null;
        }
        return stringBuilder.toString();
    }
}
