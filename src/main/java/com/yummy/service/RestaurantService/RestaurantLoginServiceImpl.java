package com.yummy.service.RestaurantService;
/*
 * author: SJZ
 * date: 2019/2/24
 */

import com.yummy.dao.RestaurantDao;
import com.yummy.entity.Restaurant;
import com.yummy.util.message.LoginMessage;
import com.yummy.util.message.SignupMessage;
import com.yummy.util.message.UpdateDataMessage;
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
    public LoginMessage login(Restaurant restaurant) {
        Restaurant restaurant1=restaurantDao.getRestaurantByIdCode(restaurant.getIdCode());
        if(restaurant1==null){
            return LoginMessage.NO_USER;
        }
        if(restaurant1.getIdCode().equals(restaurant.getIdCode())){
            return LoginMessage.SUCCESS;
        }else{
            return LoginMessage.WRONG_PASSWD;
        }
    }

    @Override
    public SignupMessage signUp(Restaurant restaurant) {
        Restaurant restaurant1=restaurantDao.getRestaurantByIdCode(restaurant.getIdCode());
        if(restaurant1!=null){
            return SignupMessage.DUPLICATED_USER;
        }
        int id=restaurantDao.insertRestaurant(restaurant);
        if(id==-1){
            return SignupMessage.SINGUP_FAIL;
        }else{
            return SignupMessage.SINGUP_SUCCESS;
        }
    }
}
