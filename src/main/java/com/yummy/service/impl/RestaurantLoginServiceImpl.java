package com.yummy.service.impl;

import com.yummy.dao.RestaurantDao;
import com.yummy.dao.SignUpToCheckDao;
import com.yummy.entity.Restaurant;
import com.yummy.entity.SignUpToCheck;
import com.yummy.service.RestaurantService.RestaurantLoginService;
import com.yummy.util.message.datamessage.UpdateDataMessage;
import com.yummy.util.message.servicemessage.LoginMessage;
import com.yummy.util.message.servicemessage.SignupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantLoginServiceImpl implements RestaurantLoginService {
    private final RestaurantDao restaurantDao;
    private final SignUpToCheckDao checkDao;
    @Autowired
    public RestaurantLoginServiceImpl(SignUpToCheckDao checkDao,RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
        this.checkDao=checkDao;
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
    public SignupMessage signUp(String email,String address, String type, String name) {
        Restaurant restaurant=restaurantDao.getRestaurantByNameAndAddress(name,address);
        if(restaurant!=null){
            return SignupMessage.DUPLICATED_USER;
        }
        SignUpToCheck signUpToCheck=new SignUpToCheck(email,address,type,name);
        UpdateDataMessage updateDataMessage=checkDao.save(signUpToCheck);
        if(updateDataMessage.equals(UpdateDataMessage.UPDATE_SUCCESS)){
            return SignupMessage.SIGNUP_SUCCESS;
        }else{
            return SignupMessage.SIGNUP_FAIL;
        }
    }
}
